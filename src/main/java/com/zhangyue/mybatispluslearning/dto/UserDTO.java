package com.zhangyue.mybatispluslearning.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -8782333365744933352L;

    private String name;
    private Integer age;
    private String email;

}
