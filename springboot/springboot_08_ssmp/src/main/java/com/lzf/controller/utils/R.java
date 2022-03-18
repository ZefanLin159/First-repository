package com.lzf.controller.utils;

import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private Object data;

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Object data, Boolean flag) {
        this.flag = flag;
        this.data = data;
    }
}
