package com.wjrong.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wjrong.model.Login;
import com.wjrong.service.LoginService;
import com.wjrong.util.ActionUtil;

/**
 * 登陆(后台)
 * @author wjrong
 * @data 2013-10-20
 *
 */
@SuppressWarnings("serial")
@Controller("loginUserAction")
@Scope("prototype")
public class LoginUserAction extends ActionSupport implements ModelDriven<Login> {
	private Login login;
	private LoginService loginService;
	private String rand;	//从页面存来的验证码
	
	
	/**
	 * 登陆
	 */
	public String islogin() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		Login admin= this.loginService.checkLogin(login.getUsername(), login.getPassword());
		if(!rand.equals(ActionUtil.getSession("rand"))){
			out.print("2");
		}else if(admin != null){
			ActionUtil.setSession("userlogin", admin);
			out.print("3");
		}else{
			out.print("1");
		}
		return null;
	}
	
	public String logout() throws IOException{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		ActionContext.getContext().getSession().clear();
		out.print("1");
		return null;
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

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

}
