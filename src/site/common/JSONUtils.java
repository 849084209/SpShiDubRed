package com.wilmar.itm.web.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.List;
import java.util.Map;

/** 
 * <p>Description: [描述该类概要功能介绍]</p>
 * Created on 2016年3月16日
 * @author   
 * @version 1.0 
 * Copyright (c) 2016 北京柯莱特科技有限公司  
 */
public class JSONUtils {
	
	/**
	 * <p>Discription:[把JSON文本parse为JSONObject或者JSONArray]</p>
	 * Created on 2016年3月18日
	 * @param text JSON文本
	 * @return
	 * @author:[ ]
	 */
	public static Object parse(String text){		
		return JSON.parse(text);
	}

	/**
	 * <p>Discription:[把JSON文本parse为JavaBean]</p>
	 * Created on 2016年3月18日
	 * @param text JSON文本
	 * @param clazz JavaBean 类
	 * @return
	 * @author:[ ]
	 */
	public static final <T> T parseObject(String text, Class<T> clazz) {
        return (T) JSON.parseObject(text, clazz);
    }

	/**
	 * <p>Discription:[把JSON文本parse为MAP类型对象]</p>
	 * Created on 2016年3月18日
	 * @param text JSON文本
	 * @return Map类型实体
	 * @author:[ ]
	 */
	@SuppressWarnings("unchecked")
    public static <V extends Object> Map<String, V> parseMap(String text) {
        Map<String, V> map = JSON.parseObject(text, Map.class);
        return map;
    }
	
	/**
	 * <p>Discription:[把JSON文本parse成JSONArray]</p>
	 * Created on 2016年3月18日
	 * @param text JSON文本
	 * @return JSONArray
	 * @author:[ ]
	 */
	public static JSONArray parseArray(String text){
		return JSON.parseArray(text);
	}

	/**
	 * <p>Discription:[把JSON文本parse成JavaBean集合 ]</p>
	 * Created on 2016年3月18日
	 * @param text JSON文本
	 * @param clazz JavaBean 类
	 * @return JavaBean List 集合
	 * @author:[ ]
	 */
	public static <T> List<T> parseArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }
	
	/**
	 * <p>Discription:[将JavaBean序列化为JSON文本 ]</p>
	 * Created on 2016年3月18日
	 * @param object JavaBean实体
	 * @return
	 * @author:[ ]
	 */
	public static String toJSONString(Object object){
		return JSON.toJSONString(object);
	}
	
	/**
	 * <p>Discription:[实体Bean转换成Map对象]</p>
	 * Created on 2016年3月25日
	 * @param object 实体Bean
	 * @return 实体转换的Map对象
	 * @author:[ ]
	 */
	@SuppressWarnings("unchecked")
	public static  <V extends Object> Map<String, V> toJSONMap(Object object){
		String text = JSON.toJSONString(object);
		return JSON.parseObject(text, Map.class);
	}
	
	/**
	 * <p>Discription:[将JavaBean序列化为带格式的JSON文本]</p>
	 * Created on 2016年3月18日
	 * @param object JavaBean实体
	 * @param prettyFormat 是否开启格式化
	 * @return JSON文本
	 * @author:[ ]
	 */
	public static String toJSONString(Object object, boolean prettyFormat){
		return JSON.toJSONString(object, prettyFormat);
	}
	
	/**
	 * <p>Discription:[将JavaBean转换为JSONObject或者JSONArray]</p>
	 * Created on 2016年3月18日
	 * @param object JavaBean实体
	 * @return JSONObject或者JSONArray
	 * @author:[ ]
	 */
	public static Object toJSON(Object object){
		return JSON.toJSON(object);
	}
	
	/**
	 * <p>Discription:[把JSON文本parse成JSONObject]</p>
	 * Created on 2016年3月18日
	 * @param text JSON文本
	 * @return JSONObject
	 * @author:[ ]
	 */
	public static JSONObject parseObject(String text){
		return JSON.parseObject(text);
	}
	

    /**
     * <p>Discription:[JSON中日期类型的数据处理]</p>
     * Created on 2016年3月18日
     * @param obj 日期对象
     * @param dateFormat 转换的格式
     * @return JSON 文本
     * @author:[ ]
     */
    public static String toJSONStringWithDateFormat(Object obj, String dateFormat){
    	return JSON.toJSONStringWithDateFormat(obj,dateFormat,SerializerFeature.WriteDateUseDateFormat);
    }
    
    /**
     * <p>Discription:[JSON增加字段过滤]</p>
     * Created on 2016年3月18日
     * @param obj 转换对象
     * @param obj 对象
     * @return JSON 文本
     * @author:[ ]
     */
    public static String toJSONStringFilter(Object obj, SimplePropertyPreFilter filter){
    	return JSON.toJSONString(obj,filter);
    }
    
    /**
     * <p>Discription:[根据KEY获取Json对象中对应的值]</p>
     * Created on 2016年4月1日
     * @param jsonObject JSON对象
     * @param key 指定KEY
     * @return 根据KEY返回数据，无所对应的key值返回 空""
     * @author:[ ]
     */
    public static String getStrByKey(JSONObject jsonObject, String key){
    	return jsonObject.containsKey(key)?jsonObject.getString(key):"";
    }
    
    /**
     * <p>Discription:[根据KEY获取Json对象中对应的值]</p>
     * Created on 2016年4月1日
     * @param jsonObject JSON对象
     * @param key 指定KEY
     * @param defaultValue 缺省值
     * @return 根据KEY返回数据，无所对应的key值返回 缺省值defaultValue
     * @author:[ ]
     */
    public static String getStrByKey(JSONObject jsonObject, String key, String defaultValue){
    	return jsonObject.containsKey(key)?jsonObject.getString(key):defaultValue;
    }
    
    /**
     * <p>Discription:[根据KEY获取Json对象中对应的值]</p>
     * Created on 2016年4月1日
     * @param jsonObject JSON对象
     * @param key 指定KEY
     * @return 根据KEY返回数据，无所对应的key值返回 缺省值0
     * @author:[ ]
     */
    public static long getLongByKey(JSONObject jsonObject, String key){
    	return jsonObject.containsKey(key)?jsonObject.getLongValue(key):0L;
    }
    
    /**
     * <p>Discription:[根据KEY获取Json对象中对应的值]</p>
     * Created on 2016年4月1日
     * @param jsonObject JSON对象
     * @param key 指定KEY
     * @param defaultValue
     * @return 根据KEY返回数据，无所对应的key值返回 缺省值defaultValue
     * @author:[ ]
     */
    public static long getLongByKey(JSONObject jsonObject, String key, long defaultValue){
    	return jsonObject.containsKey(key)?jsonObject.getLongValue(key):defaultValue;
    }
    
    /**
     * <p>Discription:[根据KEY获取Json对象中对应的值]</p>
     * Created on 2016年4月1日
     * @param jsonObject JSON对象
     * @param key 指定KEY
     * @return 根据KEY返回数据，无所对应的key值返回 缺省值0
     * @author:[ ]
     */
    public static double getDubboByKey(JSONObject jsonObject, String key){
    	return jsonObject.containsKey(key)?jsonObject.getDoubleValue(key):0d;
    }
    
    /**
     * <p>Discription:[根据KEY获取Json对象中对应的值]</p>
     * Created on 2016年4月1日
     * @param jsonObject JSON对象
     * @param key 指定KEY
     * @param defaultValue
     * @return 根据KEY返回数据，无所对应的key值返回 缺省值defaultValue
     * @author:[ ]
     */
    public static double getDubboByKey(JSONObject jsonObject, String key, double defaultValue){
    	return jsonObject.containsKey(key)?jsonObject.getDoubleValue(key):defaultValue;
    }
    
    /**
     * <p>Discription:[根据KEY获取Json对象中对应的值]</p>
     * Created on 2016年4月1日
     * @param jsonObject JSON对象
     * @param key 指定KEY
     * @return 根据KEY返回数据，无所对应的key值返回 缺省值0
     * @author:[ ]
     */
    public static int getIntByKey(JSONObject jsonObject, String key){
    	return jsonObject.containsKey(key)?jsonObject.getIntValue(key):0;
    }
    
    /**
     * <p>Discription:[根据KEY获取Json对象中对应的值]</p>
     * Created on 2016年4月1日
     * @param jsonObject JSON对象
     * @param key 指定KEY
     * @param defaultValue
     * @return 根据KEY返回数据，无所对应的key值返回 缺省值defaultValue
     * @author:[ ]
     */
    public static int getIntByKey(JSONObject jsonObject, String key, int defaultValue){
    	return jsonObject.containsKey(key)?jsonObject.getIntValue(key):defaultValue;
    }
    
    /**
     * <p>Discription:[根据KEY获取Json对象中对应的值]</p>
     * Created on 2016年4月1日
     * @param jsonObject JSON对象
     * @param key 指定KEY
     * @return 根据KEY返回数据，无所对应的key值返回 缺省值false
     * @author:[ ]
     */
    public static Boolean getBooleanByKey(JSONObject jsonObject, String key){
    	return jsonObject.containsKey(key)?jsonObject.getBoolean(key):false;
    }
    
    /**
     * <p>Discription:[根据KEY获取Json对象中对应的值]</p>
     * Created on 2016年4月1日
     * @param jsonObject JSON对象
     * @param key 指定KEY
     * @param defaultValue
     * @return 根据KEY返回数据，无所对应的key值返回 缺省值defaultValue
     * @author:[ ]
     */
    public static Boolean getBooleanByKey(JSONObject jsonObject, String key, Boolean defaultValue){
    	return jsonObject.containsKey(key)?jsonObject.getBoolean(key):defaultValue;
    }
    
    
    
}

