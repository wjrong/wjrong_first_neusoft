package com.wjrong.model;

import java.util.List;

/**
 * 分页类
 * @author wjrong
 * @data 2013-10-20
 *
 * @param <类型>
 */
public class Pager<T> {
	private List<T> datas;	//查询了的分页数据
	private int pageOffset;	//当前位置
	private int pageSize;	//每页显示数
	private long totalRecord;	//页面的记录
	
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getPageOffset() {
		return pageOffset;
	}
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}
}
