package com.wjrong.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wjrong.dao.ArticleDao;
import com.wjrong.model.Article;
import com.wjrong.model.Pager;
import com.wjrong.model.PhotoFile;
import com.wjrong.service.ArticleService;
import com.wjrong.util.FileUpLoadUtil;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao;
	
	public ArticleDao getArticleDao() {
		return articleDao;
	}
	@Resource
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public void add(Article article) {
		article.setCreateDate(new Date());
		this.articleDao.add(article);
	}
	
	@Override
	public void add(Article article, PhotoFile photoFile, String uploadUrl,String uploadUrl2) {
		StringBuffer buffer = new StringBuffer();		
		for(int i=0; i<photoFile.getPhoto().length; i++){
			String oldName = photoFile.getPhotoFileName()[i];
			String newName = FileUpLoadUtil.updateFileName(oldName);
			FileUpLoadUtil.UploadFile(uploadUrl + newName, photoFile.getPhoto()[i]);
			buffer.append(newName).append("?");
		}
		
		article.setTpicture(uploadUrl2+buffer.substring(0, buffer.length()-1));
		article.setCreateDate(new Date());
		this.articleDao.add(article);
	}

	@Override
	public void update(Article article) {
		this.articleDao.update(article);
	}
	
	@Override
	public void update(Article article, PhotoFile photoFile, String uploadUrl,String uploadUrl2) {
		StringBuffer buffer = new StringBuffer();		
		for(int i=0; i<photoFile.getPhoto().length; i++){
			String oldName = photoFile.getPhotoFileName()[i];
			String newName = FileUpLoadUtil.updateFileName(oldName);
			FileUpLoadUtil.UploadFile(uploadUrl + newName, photoFile.getPhoto()[i]);
			buffer.append(newName).append("?");
		}
		article.setTpicture(uploadUrl2+buffer.substring(0, buffer.length()-1));
		
		this.articleDao.update(article);
	}
	
	@Override
	public void delete(int id) {
		
		this.articleDao.delete(id);
	}

	@Override
	public Article load(int id) {
		return this.articleDao.load(id);
	}
	
	@Override
	public Pager<Article> findArticle() {
		//return this.articleDao.find("select Article,c.name from Article as a,category as c where c.categoryid = a.categoryid order by a.createDate desc");
		//return this.articleDao.find("from Article a left join a.categoryid c where a.categoryid=1");	//from Student s left join s.course c where s.sname='李晓梅'";
		//return this.articleDao.find("from Article a,Category c where a.categoryid=1 order by a.createDate desc");
		return this.articleDao.find("from Article n order by n.createDate desc");
		//return this.articleDao.find("select new con.wjrong.model.Artcatall(a.Title,c.Categoryname,a.Id,a.Author) from Article a,Category c where c.Categoryidid=a.Categoryidid");
	}
	
	@Override
	public Pager<Article> findArticleNoNull() {
		//return this.articleDao.find("select Article,c.name from Article as a,category as c where c.categoryid = a.categoryid order by a.createDate desc");
		//return this.articleDao.find("from Article a left join a.categoryid c where a.categoryid=1");	//from Student s left join s.course c where s.sname='李晓梅'";
		//return this.articleDao.find("from Article a,Category c where a.categoryid=1 order by a.createDate desc");
		return this.articleDao.find("from Article n where n.categoryid=2 AND n.tpicture IS NOT NULL ORDER BY n.createDate DESC LIMIT 5");
		//return this.articleDao.find("select new con.wjrong.model.Artcatall(a.Title,c.Categoryname,a.Id,a.Author) from Article a,Category c where c.Categoryidid=a.Categoryidid");
	}
	
	@Override
	public Pager<Article> findArticle(String categoryid) {
		return this.articleDao.find("from Article n where n.categoryid=" + categoryid + " order by n.createDate desc");
	}
	
	@Override
	public void deleteGroupArticle(Object[] ids) {
		String hql = "delete Article n where n.id=?";
		
		for(Object obj: ids){
			this.articleDao.executeByHql(hql, obj);
		}
	}
	
	@Override
	public Article updateCheckArticle(int id) {
		Article n = this.load(id);
		if(n != null){
			int clickRate = n.getClickRate();
			clickRate += 1;
			n.setClickRate(clickRate);
			this.articleDao.update(n);
		}
		return n;
	}
	
	@Override
	public List<Article> queryNumber(int number) {
		List<Article> listArticle = new ArrayList<Article>();
		String sql = "select id,title " +
				"from t_article t ORDER BY t.create_date DESC LIMIT " + number ;
		
		List<Object> list = this.articleDao.querySQL(sql);
		
		for (Iterator<Object> iter=list.iterator(); iter.hasNext();) {
			Object[] obj = (Object[])iter.next();
			Article n = new Article();
			n.setId((Integer) obj[0]);
			n.setTitle((String) obj[1]);
			listArticle.add(n);
		}
		return listArticle;
	}
}
