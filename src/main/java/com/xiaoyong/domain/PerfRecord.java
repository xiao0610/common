package com.xiaoyong.domain;

import java.util.Date;

public class PerfRecord {
	private String fileName;
	private Integer id;
	private Date startTime;
	private Date endTime;
	private Date useTime;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getUseTime() {
		return useTime;
	}
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}
	@Override
	public String toString() {
		return "PerfRecord [fileName=" + fileName + ", id=" + id + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", useTime=" + useTime + "]";
	}
	
	
}
