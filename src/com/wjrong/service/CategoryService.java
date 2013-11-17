package com.wjrong.service;

import com.wjrong.model.Category;
import com.wjrong.model.Pager;

/**
 * 文章分类的管理层
 * @author wjrong
 * @data 2013-11-4
 *
 */
public interface CategoryService {
	/**
	 * 添加分类
	 * @param article	文章对象
	 */
	public void add(Category category);
	
	/**
	 * 更新分类
	 * @param category 文章对象
	 */
	public void update(Category category);
	
	/**
	 * 删除某个分类
	 * @param id 分类id
	 */
	public void delete(int id);
	
	/**
	 * 删除一组分类
	 * @param ids  一组id
	 */
	public void deleteGroupCategory(Object[] ids);
	
	/**
	 * 查询某个分类信息
	 * @param id 分类id
	 * @return 返回查询出来的Category对象
	 */
	public Category load(int id);
	
	/**
	 * 分页查询
	 * @return 返回Pager<Category>对象
	 */
	public Pager<Category> findCategory();
}
