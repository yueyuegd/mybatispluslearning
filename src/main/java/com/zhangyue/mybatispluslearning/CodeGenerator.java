package com.zhangyue.mybatispluslearning;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.zhangyue.mybatispluslearning.config.*;
import com.zhangyue.mybatispluslearning.config.po.TableInfo;
import com.zhangyue.mybatispluslearning.config.rules.NamingStrategy;
import com.zhangyue.mybatispluslearning.engine.FreemarkerTemplateEngine;
import com.zhangyue.mybatispluslearning.generator.AutoGenerator;
import com.zhangyue.mybatispluslearning.generator.InjectionConfig;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 */
public class CodeGenerator {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("请输入：" + tip + "：");
        System.out.println(stringBuilder.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!StringUtils.isEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip +"!");
    }

    public static void main(String[] args) {
        //代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor("zhangyue");
        globalConfig.setOpen(false);
        globalConfig.setSwagger2(true);
        autoGenerator.setGlobalConfig(globalConfig);
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mybatisplus?Unicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("990921");
        autoGenerator.setDataSource(dataSourceConfig);

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(scanner("模块名"));
        packageConfig.setParent("com.zhangyue.mybatispluslearning");
        autoGenerator.setPackageInfo(packageConfig);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        //如果模板引擎是freemaker
        String templatePath = "/templates/mapper.java.ftl";

        //自定义输出配置
        List<FileOutConfig> fileOutConfigs = new ArrayList<>();
        //自定义配置会被优先输出
        fileOutConfigs.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(fileOutConfigs);
        autoGenerator.setCfg(cfg);
        //配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        /*templateConfig.setEntity("templates/entity.java");
        templateConfig.setController("templates/controller.java");
        templateConfig.setService("templates/service.java");
        templateConfig.setServiceImpl("templates/serviceImpl.java");
        templateConfig.setMapper("templates/mapper.java");*/
        autoGenerator.setTemplate(templateConfig);
        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategyConfig.setSuperEntityClass("com.zhangyue.mybatispluslearning.domain");
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        //strategyConfig.setSuperControllerClass("com.zhangyue.mybatispluslearning.controller");
        strategyConfig.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategyConfig.setSuperEntityColumns("id");
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setTablePrefix(packageConfig.getModuleName() + "_");
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();

    }
}
