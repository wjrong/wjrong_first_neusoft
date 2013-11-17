package com.wjrong.dao.impl;

import org.springframework.stereotype.Repository;

import com.wjrong.dao.CategoryDao;
import com.wjrong.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends SuperDaoImpl<Category> implements CategoryDao {
}
