package com.github.rest.response;

import java.io.Serializable;

/**
 * Created by jiabin on 2018/5/13.
 */
public class Meta implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String OK = "ok";
    public static final String ERROR = "error";

    private boolean success;
    private String message;

    public Meta(boolean success) {
        this.success = success;
    }

    public Meta(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
