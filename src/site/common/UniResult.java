package com.wilmar.itm.web.common;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回实体定义
 */
@ApiModel(value = "UniResult", description = "通用返回结果")
public class UniResult<T> {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Integer STATUS_OK = 200;
    public static Integer STATUS_ERROR = 400;
    public static Integer SIGN_ERROR = 402;

    public static String MESSAGE_OK = "message.result.ok";
    public static String MESSAGE_ERROR = "message.result.error";

    @ApiModelProperty(value = "业务异常代码", name = "code")
    private String code;

    @ApiModelProperty(value = "响应消息", name = "msg")
    private String msg;

    @ApiModelProperty(value = "结果数据", name = "data")
    private T data;

    public UniResult() {
    }

    public UniResult(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }
    
    public UniResult( String code,String msg, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public UniResult(T data) {
        this.msg = MESSAGE_OK;
        this.data = data;
    }

    public UniResult(T data, String msg) {
        this.msg = msg;
        this.data = data;
    }

    /**
     * 将json结果集转化为TaotaoResult对象
     * 
     * @param jsonData json数据
     * @param clazz TaotaoResult中的object类型
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static UniResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, UniResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return new UniResult<Object>(jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     * 
     * @param json
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static UniResult format(String json) {
        try {
            return MAPPER.readValue(json, UniResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     * 
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static UniResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(), MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return new UniResult<Object>(jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    public String toJson() throws JsonProcessingException {
        return MAPPER.writeValueAsString(this);
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
