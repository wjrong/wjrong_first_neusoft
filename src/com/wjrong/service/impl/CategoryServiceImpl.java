package com.wjrong.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wjrong.dao.CategoryDao;
import com.wjrong.model.Category;
import com.wjrong.model.Pager;
import com.wjrong.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	@Resource
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@Override
	public void add(Category category) {
		
		this.categoryDao.add(category);
	}

	@Override
	public void update(Category category) {
		this.categoryDao.update(category);

	}

	@Override
	public void delete(int id) {
		this.categoryDao.delete(id);

	}

	@Override
	public void deleteGroupCategory(Object[] ids) {
		String hql = "delete Category n where n.id=?";
		
		for(Object obj: ids){
			this.categoryDao.executeByHql(hql, obj);
		}

	}

	@Override
	public Category load(int id) {
		
		return this.categoryDao.load(id);
	}

	@Override
	public Pager<Category> findCategory() {
		return this.categoryDao.find("from Category n order by n.categoryid ASC");
	}

}
