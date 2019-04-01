package com.zhangyue.mybatispluslearning.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
