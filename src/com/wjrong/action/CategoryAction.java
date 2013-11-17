package com.wjrong.action;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wjrong.model.Category;
import com.wjrong.service.CategoryService;
import com.wjrong.util.ActionUtil;

/**
 * 分类(后台)
 * @author wjrong
 * @data 2013-11-4
 *
 */
@SuppressWarnings("serial")
@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends ActionSupport implements ModelDriven<Category> {
	private Category category;
	private CategoryService categoryService;
	private Integer[] delid;	//一组id
	
	/**
	 * 分页查询
	 */
	public String list(){
		ActionContext.getContext().put("pages", this.categoryService.findCategory());
		return SUCCESS;
	}
	
	/**
	 * 进入添加页面
	 */
	public String addInput(){
		return SUCCESS;
	}
	
	/**
	 *	添加分类
	 */
	public String add(){
		this.categoryService.add(category);
		ActionUtil.setURL("category_list.action");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * 删除分类
	 */
	public String delete(){
		this.categoryService.delete(category.getId());
		ActionUtil.setURL("category_list.action");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * 删除一组数据
	 */
	public String checkboxDelete(){
		this.categoryService.deleteGroupCategory(delid);
		ActionUtil.setURL("category_list.action");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * 进入修改页面
	 */
	public String updateInput(){
		Category n = this.categoryService.load(category.getId());
		category.setId(n.getId());
		category.setCategoryid(n.getCategoryid());
		category.setCategoryname(n.getCategoryname());
		category.setLevel(n.getLevel());
		category.setOrderid(n.getOrderid());
		category.setIntro(n.getIntro());
		return SUCCESS;
	}
	
	/**
	 * 修改文章
	 */
	public String update(){
		Category n = new Category();
		n.setId(category.getId());
		n.setCategoryid(category.getCategoryid());
		n.setCategoryname(category.getCategoryname());
		n.setLevel(category.getLevel());
		n.setOrderid(category.getOrderid());
		n.setIntro(category.getIntro());

		this.categoryService.update(n);
		ActionUtil.setURL("category_list.action");
		return ActionUtil.REDIRECT;

	}
	
	/**
	 * 查看某个信息
	 */
	public String check(){
		Category n = this.categoryService.load(category.getId());
		category.setId(n.getId());
		category.setCategoryid(n.getCategoryid());
		category.setCategoryname(n.getCategoryname());
		category.setLevel(n.getLevel());
		category.setOrderid(n.getOrderid());
		category.setIntro(n.getIntro());
		
		return SUCCESS;
	}
	
	@Override
	public Category getModel() {
		if(category == null) category = new Category();
		return category;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	@Resource
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public Integer[] getDelid() {
		return delid;
	}
	public void setDelid(Integer[] delid) {
		this.delid = delid;
	}
}
