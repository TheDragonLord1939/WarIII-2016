package com.dragon.warIII.service.blog.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @description 功能描述: 博客数据库访问实体类
 * @author 作 者: L.D
 * @createdate 建立日期：2016-10-8
 * @projectname 项目名称: warIII_service
 * @packageclass 包及类名: com.dragon.warIII.service.blog.entity  Blog.java
 */
public class Blog implements Serializable{

	private static final long serialVersionUID = -3478244403357313938L;
	
	
	@Field 
	private String id;				//博客ID
	@Field 
	private String author;			//博客作者
	@Field 
	private String city;				//作者所在城市
	@Field 
	private String title;			//博客标题
	@Field 
	private String content;			//博客内容
	@Field 
	private Timestamp createDate;	//博客创建时间
	
	public Blog() {
		super();
	}

	public Blog(String id, String author, String city, String title,
			String content, Timestamp createDate) {
		super();
		this.id = id;
		this.author = author;
		this.city = city;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", author=" + author + ", city=" + city
				+ ", title=" + title + ", content=" + content + ", createDate="
				+ createDate + "]";
	}
	
}
