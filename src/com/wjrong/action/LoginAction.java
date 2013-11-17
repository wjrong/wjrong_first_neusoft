package com.wjrong.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wjrong.model.Login;
import com.wjrong.service.LoginService;
import com.wjrong.util.ActionUtil;

/**
 * 用户页面(后台)
 * @author wjrong
 * @data 2013-10-20
 *
 */
@SuppressWarnings("serial")
@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven<Login> {
	private Login login;
	private LoginService loginService;
	private String passwordTwo;
	private String rand;

	/**
	 * 分页查询
	 * @return
	 */
	public String list(){
		ActionUtil.setRequest("pager", this.loginService.findLogin());
		return SUCCESS;
	}
	
	/**
	 * 进入添加页面
	 */
	public String addInput(){
		return SUCCESS;
	}
	
	/**
	 * 添加
	 */
	public String add(){
		Login lo = new Login();
		lo.setUsername(login.getUsername());
		lo.setPassword(login.getPassword());
		lo.setType(1);
		this.loginService.add(lo);
		ActionUtil.setURL("login_list.action");
		return ActionUtil.REDIRECT;
	}
	/**
	 * 添加验证
	 */
	public void validateAdd() {
		if(ActionUtil.isCheckNull(login.getUsername()) == true){
			this.addFieldError("username", "用户名不能为空");
		}
		if(ActionUtil.isCheckNull(login.getPassword()) == true){
			this.addFieldError("password", "密码不能为空");
		}
		if(!login.getPassword().equals(passwordTwo)){
			this.addFieldError("password", "两个密码不一致");
		}
		if(this.hasFieldErrors()){
			addInput();
		}
	}
	
	/**
	 * 	删除
	 */
	public String delete(){
		this.loginService.delete(login.getId());
		ActionUtil.setURL("login_list.action");
		return ActionUtil.REDIRECT;
	}
	
	
	/**
	 * 修改查询
	 */
	public String updateInput() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		Login update = this.loginService.checkLogin(login.getUsername(), login.getPassword());
		
		if (!rand.equals(ActionUtil.getSession("rand"))){
			out.print("2");
		}else if(update!=null){
			ActionUtil.setSession("updateInput", update);
			out.print("3");
		}else{
			out.print("1");
		}
		return null;
	}
	
	/**
	 * 更新
	 */
	public String update(){
		Login l = this.loginService.load(login.getId());
		l.setPassword(login.getPassword());
		
		this.loginService.update(l);
		ActionUtil.setURL("login_list.action");
		return ActionUtil.REDIRECT;
	}
	
	
	
	@Override
	public Login getModel() {
		if(login == null) login = new Login();
		return login;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	@Resource
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public String getPasswordTwo() {
		return passwordTwo;
	}
	public void setPasswordTwo(String passwordTwo) {
		this.passwordTwo = passwordTwo;
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}
}
