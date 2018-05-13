package com.github.rest.response;

import java.io.Serializable;

/**
 * Created by jiabin on 2018/5/13.
 */
public class Response implements Serializable {
    private static final long serialVersionUID = 1L;

    private Meta meta;
    private Object data;

    public Response success() {
        this.meta = new Meta(true, Meta.OK);
        return this;
    }

    public Response success(Object data) {
        this.meta = new Meta(true, Meta.OK);
        this.data = data;
        return this;
    }

    public Response failure() {
        this.meta = new Meta(false, Meta.ERROR);
        return this;
    }

    public Response failure(String message) {
        this.meta = new Meta(false, message);
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }

}
