package com.wjrong.service;

import java.util.List;

import com.wjrong.model.Article;
import com.wjrong.model.Pager;
import com.wjrong.model.PhotoFile;

/**
 * 文章的管理层
 * @author wjrong
 * @data 2013-10-20
 *
 */
public interface ArticleService {
	/**
	 * 添加文章（不带上传图片）
	 * @param article	文章对象
	 */
	public void add(Article article);
	
	/**
	 * 添加文章（带上传）
	 * @param article 文章对象
	 * @param photoFile	上传的类
	 * @param uploadUrl	上传到的路径
	 */
	public void add(Article article, PhotoFile photoFile, String uploadUrl,String uploadUrl2);
	
	/**
	 * 更新数据（不带上传图片）
	 * @param article 文章对象
	 */
	public void update(Article article);
	
	/**
	 * 更新数据（带上传）
	 * @param article 文章对象
	 * @param photoFile	上传的类
	 * @param uploadUrl	上传到的路径
	 */
	public void update(Article article, PhotoFile photoFile, String uploadUrl,String uploadUrl2);
	
	/**
	 * 删除某个文章
	 * @param id 文章id
	 */
	public void delete(int id);
	
	/**
	 * 删除一组文章
	 * @param ids  一组id
	 */
	public void deleteGroupArticle(Object[] ids);
	
	/**
	 * 查询某个文章信息
	 * @param id 文章id
	 * @return 返回查询出来的Article对象
	 */
	public Article load(int id);
	
	/**
	 * 分页查询
	 * @return 返回Pager<Article>对象
	 */
	public Pager<Article> findArticle();
	
	/**
	 * 查询某个文章信息（带添加点击率量）
	 * @param id 文章id
	 * @return 返回查询出来的Article对象
	 */
	public Article updateCheckArticle(int id);
	
	/**
	 * 查询前几条数据
	 * @param number 需要查询的数目
	 * @return	返回List<Article>
	 */
	public List<Article> queryNumber(int number);


	/**
	 * 分类分页查询
	 * @param categoryid 分类ID
	 * @return 返回Pager<Article>对象
	 */
	Pager<Article> findArticle(String categoryid);
	
	/**
	 * 分类分页查询
	 * @param categoryid 分类ID
	 * @return 返回Pager<Article>对象
	 */
	Pager<Article> findArticleNoNull();
}
