package com.wilmar.tms.web.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页工具类")
public class PageUtil<T> implements Serializable {

    private static final long serialVersionUID = 1368060527204258745L;

    private List<T> data = new ArrayList<>();

    @ApiModelProperty("总条数")
    private int total;

    @ApiModelProperty("总页数")
    private int pageCount;

    @ApiModelProperty("每页大小")
    private int pageSize;

    @ApiModelProperty("当前第几页")
    private int current;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	/*
     * @return
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PageUtil [data=" + data + ", totalCount=" + total + ", pageCount=" + pageCount + ", pageSize=" + pageSize + ", currPage="
                + current + "]";
    }

}
