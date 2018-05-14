package com.github.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Created by jiabin on 2018/5/13.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response implements Serializable {
    private static final long serialVersionUID = 1L;

    private final static String SUCCESS_CODE = "200";
    private final static String SUCCESS_STRING = "请求成功";

    private String status;

    private String message;

    private Object data;

    private PageInfo page;


    public static String getSuccessCode() {
        return SUCCESS_CODE;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public PageInfo getPage() {
        return page;
    }

    private Response() {
        this.status = SUCCESS_CODE;
        this.message = "SUCCESS";
    }

    private Response(String status, String message) {
        this.status = status;
        this.message = message;
    }

    private Response(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    private Response(String status, String message, Object data, PageInfo pageInfo) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.page = pageInfo;
    }

    private Response(String status, String message, Object data, Long total, Integer pageNo, Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        this.status = status;
        this.message = message;
        this.data = data;
        this.page = pageInfo;
    }

    //快速返回成功
    public static Response success() {
        return new Response(SUCCESS_CODE, SUCCESS_STRING);
    }

    public static Response success(Object result) {
        return new Response(SUCCESS_CODE, SUCCESS_STRING, result);
    }

    public static Response success(String message, Object result) {
        return new Response(SUCCESS_CODE, message, result);
    }

    public static Response success(Object result, PageInfo pageInfo) {
        return new Response(SUCCESS_CODE, SUCCESS_STRING, result, pageInfo);
    }

    public static Response success(Object result, Long total, Integer pageNo, Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new Response(SUCCESS_CODE, SUCCESS_STRING, result, pageInfo);
    }


    public static Response success(String message, Object result, Long total, Integer pageNo, Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new Response(SUCCESS_CODE, message, result, pageInfo);
    }


    //快速返回失败状态
    public static Response fail() {
        return new Response(ErrorCode.SYSTEM_ERROR.getCode(), ErrorCode.SYSTEM_ERROR.getMessage());
    }

    public static Response fail(String message) {
        return new Response(ErrorCode.SYSTEM_ERROR.getCode(), message);
    }

    public Response fail(String message, Object result) {
        return new Response(ErrorCode.SYSTEM_ERROR.getCode(), message, result);
    }

    public static Response fail(ErrorCode errorCode) {
        return new Response(errorCode.getCode(), errorCode.getMessage());
    }

    //快速返回自定义状态码
    public static Response result(String statusCode, String message) {
        return new Response(statusCode, message);
    }

    public static Response result(String statusCode, String message, Object result) {
        return new Response(statusCode, message, result);
    }

    public static Response result(String statusCode, String message, Object result, PageInfo pageInfo) {
        return new Response(statusCode, message, result, pageInfo);
    }

    public static Response result(String statusCode, String message, Object result, Long total, Integer pageNo, Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new Response(statusCode, message, result, pageInfo);
    }

    //快速返回Http状态
    public static Response httpStatus(HttpStatus httpStatus) {
        return result(httpStatus.toString(), httpStatus.getReasonPhrase());
    }

    public static Response httpStatus(HttpStatus httpStatus, Object result) {
        return result(httpStatus.toString(), httpStatus.getReasonPhrase(), result);
    }

    public static Response httpStatus(HttpStatus httpStatus, Object result, PageInfo pageInfo) {
        return result(httpStatus.toString(), httpStatus.getReasonPhrase(), result, pageInfo);
    }

    public static Response httpStatus(HttpStatus httpStatus, Object result, Long total, Integer pageNo, Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return result(httpStatus.toString(), httpStatus.getReasonPhrase(), result, total, pageNo, pageSize);
    }
}
