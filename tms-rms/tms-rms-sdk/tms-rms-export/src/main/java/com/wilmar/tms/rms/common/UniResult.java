package com.wilmar.tms.rms.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author libowen1
 * 通用返回结果
 * @param <T>
 */
public class UniResult<T> {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Integer STATUS_OK = 200;
    public static Integer STATUS_ERROR = 500;

    public static String MESSAGE_OK = "message.result.ok";
    public static String MESSAGE_ERROR = "message.result.error";

    /**
     * 业务状态
     */
    private Integer status;

    /**
     * 业务异常代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 结果数据
     */
    private T data;

    public UniResult() {
    }

    public UniResult(Integer status) {
        this.status = status;
    }

    public UniResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    
    public UniResult(Integer status, String code,String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public UniResult(T data) {
        this.status = STATUS_OK;
        this.msg = MESSAGE_OK;
        this.data = data;
    }

    public UniResult(T data, String msg) {
        this.status = STATUS_OK;
        this.msg = msg;
        this.data = data;
    }

    public String toJson() throws JsonProcessingException {
        return MAPPER.writeValueAsString(this);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
