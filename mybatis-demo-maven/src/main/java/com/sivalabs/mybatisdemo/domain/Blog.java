package com.sivalabs.mybatisdemo.domain;

import java.util.Date;

public class Blog {

	private Integer blogId;
	private String blogName;
	private Date createdOn;

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogName=" + blogName
				+ ", createdOn=" + createdOn + "]";
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
}