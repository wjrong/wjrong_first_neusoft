package com.wjrong.model;

import java.lang.reflect.Type;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 文章
 * @author wjrong
 *
 */
@Entity
@Table(name="t_article")
public class Article implements Type {
	private int id;
	private String title;			//标题
	private String author;			//作者
	private String categoryid;		//分类ID
	private int clickRate; 			//点击率量
	private Date createDate;		//发布时间
	private String content;			//内容
	private String tpicture;		//图片
	private int ttop;				//推荐等级
	private String intro;			//内容简介
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="title", nullable=true)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(name="categoryid", nullable=true)
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	
	@Column(name="click_rate", nullable=true)
	public int getClickRate() {
		return clickRate;
	}
	public void setClickRate(int clickRate) {
		this.clickRate = clickRate;
	}
	
	@Column(name="create_date")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(name="content",columnDefinition="text")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public String getTpicture() {
		return tpicture;
	}
	public void setTpicture(String tpicture) {
		this.tpicture = tpicture;
	}
	
	@Column(name="ttop")
	public int getTtop() {
		return ttop;
	}
	public void setTtop(int ttop) {
		this.ttop = ttop;
	}
	
	@Column(name="intro")
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
}
