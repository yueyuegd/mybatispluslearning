package com.zhangyue.mybatispluslearning.common;

import lombok.Getter;
import lombok.Setter;

public enum CodeMsg {

    SUCCESS(0, "success");

    @Setter
    @Getter
    private Integer key;
    @Setter
    @Getter
    private String message;

    CodeMsg(Integer key, String message) {
        this.key = key;
        this.message = message;
    }
}
