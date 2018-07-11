package top.bowenlee.notes.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页工具类")
public class PageUtil<T> implements Serializable {

    private static final long serialVersionUID = 1368060527204258745L;

    private List<T> data = new ArrayList<T>();

    @ApiModelProperty("总条数")
    private Long total;

    @ApiModelProperty("总页数")
    private Long pageCount;

    @ApiModelProperty("每页大小")
    private Long pageSize;

    @ApiModelProperty("当前第几页")
    private Long current;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getPageCount() {
		return pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getCurrent() {
		return current;
	}

	public void setCurrent(Long current) {
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
