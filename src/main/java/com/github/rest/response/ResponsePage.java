package com.github.rest.response;

import java.io.Serializable;

/**
 * Created by jiabin on 2018/5/13.
 */
public class ResponsePage implements Serializable {
    private static final long serialVersionUID = 1L;

    private Meta meta;
    private Object data;
    private PageInfo page;

    public ResponsePage success() {
        this.meta = new Meta(true, Meta.OK);
        return this;
    }

    public ResponsePage success(Object data, PageInfo page) {
        this.meta = new Meta(true, Meta.OK);
        this.data = data;
        this.page = page;
        return this;
    }

    public ResponsePage failure() {
        this.meta = new Meta(false, Meta.ERROR);
        return this;
    }

    public ResponsePage failure(String message) {
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
