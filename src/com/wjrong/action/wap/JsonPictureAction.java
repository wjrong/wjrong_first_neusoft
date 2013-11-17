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
import com.wjrong.model.Picture;
import com.wjrong.model.Pager;
import com.wjrong.service.PictureService;


/**
 * 图片(手机前台)
 * @author wjrong
 * @data 2013-10-23
 *
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class JsonPictureAction extends ActionSupport implements ModelDriven<Picture> {
	private Picture picture;
	private PictureService pictureService;
	private Pager<Picture> list;
	
	
	
	/**
	 * 分页查询
	 * @param categoryid 
	 * @throws IOException 
	 */
	public String list() throws IOException{
		//ActionContext.getContext().put("pages", this.pictureService.findPicture());
		//String cid=request.getParameter("categoryid");
		//String cid=picture.getCategoryid();
		list=this.pictureService.findPicture();
		List<Picture> n=list.getDatas();

		
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<Picture>>() {}.getType();  
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
		//ActionContext.getContext().put("pages", this.pictureService.findPicture());
		//String cid=request.getParameter("categoryid");
		String cid=picture.getCategoryid();
		list=this.pictureService.findPicture(cid);
		List<Picture> n=list.getDatas();

		
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<Picture>>() {}.getType();  
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
		//ActionContext.getContext().put("pages", this.pictureService.findPicture());
		//String cid=request.getParameter("categoryid");
		//String cid=picture.getCategoryid();
		list=(Pager<Picture>) this.pictureService.queryNumber(5);
		List<Picture> n=list.getDatas();

		
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<Picture>>() {}.getType();  
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
		Picture n = this.pictureService.updateCheckPicture(picture.getId());
		picture.setId(n.getId());
		picture.setTitle(n.getTitle());
		picture.setCreateDate(n.getCreateDate());
		picture.setClickRate(n.getClickRate());
		picture.setTpicture(n.getTpicture());
		picture.setAuthor(n.getAuthor());
		picture.setCategoryid(n.getCategoryid());
		picture.setTtop(n.getTtop());

		Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		
		String result = gson.toJson(picture);
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
	public Picture getModel() {
		if(picture == null) picture = new Picture();
		return picture;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	public PictureService getPictureService() {
		return pictureService;
	}
	@Resource
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

}
