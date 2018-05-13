package com.github.rest.exception;

/**
 * Created by jiabin on 2018/5/13.
 */
public class TokenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;

    public TokenException(String msg) {
        super();
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
