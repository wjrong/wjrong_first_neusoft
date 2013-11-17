package com.wjrong.action.wap;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wjrong.model.Article;
import com.wjrong.model.Pager;
import com.wjrong.service.ArticleService;


/**
 * 图片(手机前台)
 * @author wjrong
 * @data 2013-10-23
 *
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class JsonArticleAction extends ActionSupport implements ModelDriven<Article> {
	private Article article;
	private ArticleService articleService;
	private Pager<Article> list;
	
	
	
	/**
	 * 分页查询
	 * @param categoryid 
	 * @throws IOException 
	 */
	public String list() throws IOException{
		//ActionContext.getContext().put("pages", this.articleService.findArticle());
		//String cid=request.getParameter("categoryid");
		//String cid=article.getCategoryid();
		list=this.articleService.findArticle();
		List<Article> n=list.getDatas();

		
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<Article>>() {}.getType();  
		String result = gson.toJson(n,type);  
		System.out.println(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("cache-control", "no-cache"); 
		
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		out.flush();
		out.close();
		
		return null;
	}
	
	
	/**
	 * 分类分页查询
	 * @param categoryid 
	 * @throws IOException 
	 */
	public String listcid() throws IOException{
		//ActionContext.getContext().put("pages", this.articleService.findArticle());
		//String cid=request.getParameter("categoryid");
		String cid=article.getCategoryid();
		list=this.articleService.findArticle(cid);
		List<Article> n=list.getDatas();

		
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<Article>>() {}.getType();  
		String result = gson.toJson(n,type);  
		System.out.println(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("cache-control", "no-cache"); 
		
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		out.flush();
		out.close();
		
		return null;
	}
	
	
	/**
	 * 分页查询有图片的前5条数据
	 * @param categoryid 
	 * @throws IOException 
	 */
	public String listNoNull() throws IOException{
		//ActionContext.getContext().put("pages", this.articleService.findArticle());
		//String cid=request.getParameter("categoryid");
		//String cid=article.getCategoryid();
		list=this.articleService.findArticleNoNull();
		List<Article> n=list.getDatas();

		
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<Article>>() {}.getType();  
		String result = gson.toJson(n,type);  
		System.out.println(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("cache-control", "no-cache"); 
		
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		out.flush();
		out.close();
		
		return null;
	}
	
	
	/**
	 * 查询前几条数据
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public String listNumber() throws IOException{
		//ActionContext.getContext().put("pages", this.articleService.findArticle());
		//String cid=request.getParameter("categoryid");
		//String cid=article.getCategoryid();
		list=(Pager<Article>) this.articleService.queryNumber(5);
		List<Article> n=list.getDatas();

		
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<Article>>() {}.getType();  
		String result = gson.toJson(n,type);  
		System.out.println(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("cache-control", "no-cache"); 
		
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		out.flush();
		out.close();
		
		return null;
	}
	
	
	/**
	 * 查看某个信息
	 * @throws IOException 
	 */
	public String show() throws IOException{
		Article n = this.articleService.updateCheckArticle(article.getId());
		article.setId(n.getId());
		article.setTitle(n.getTitle());
		article.setContent(n.getContent());
		article.setCreateDate(n.getCreateDate());
		article.setClickRate(n.getClickRate());
		article.setTpicture(n.getTpicture());
		article.setAuthor(n.getAuthor());
		article.setCategoryid(n.getCategoryid());
		article.setTtop(n.getTtop());

		Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		
		String result = gson.toJson(article);
		System.out.println(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("cache-control", "no-cache"); 
		
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		out.flush();
		out.close();
		
		return null;

	}
		
	
	
	@Override
	public Article getModel() {
		if(article == null) article = new Article();
		return article;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	@Resource
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}
