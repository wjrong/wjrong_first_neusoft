package com.wjrong.dao.impl;

import org.springframework.stereotype.Repository;

import com.wjrong.dao.ArticleDao;
import com.wjrong.model.Article;

@Repository("articleDao")
public class ArticleDaoImpl extends SuperDaoImpl<Article> implements ArticleDao {
}
