package com.wilmar.itm.web.common;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author libowen1
 *
 */
@ApiModel(value = "分页")
public class PageParam {
    @ApiModelProperty(value = "当前页 ",required = true)
    private int current = 1;
    @ApiModelProperty(value = "每页显示的记录数 ",required = true)
    private int pageSize = 10;
    @ApiModelProperty(value = "查询条件",required = false)
    private Map<String, Object> condition = new HashMap<String,Object>();
    @ApiModelProperty(value = "排序字段（如有多个字段  例 'cod,des desc')",required = true)
    private String sort = "";
    @ApiModelProperty(value = "asc/desc",required = true)
    private String order = "";
    
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Map<String, Object> getCondition() {
		return condition;
	}
	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
    
}
