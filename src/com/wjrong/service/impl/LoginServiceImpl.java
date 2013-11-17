package com.wjrong.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wjrong.dao.LoginDao;
import com.wjrong.exception.DException;
import com.wjrong.model.Login;
import com.wjrong.model.Pager;
import com.wjrong.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao; 
	
	public LoginDao getLoginDao() {
		return loginDao;
	}
	@Resource
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	
	
	
	
	@Override
	public void add(Login login) {
		String hql = "from Login l where l.username=?";
		List<Login> list = this.loginDao.queryByHql(hql, login.getUsername());
		
		for(Login lo : list){
			if(lo.getUsername().equals(login.getUsername())){
				throw new DException("该用户名以存在");
			}
		}
		
		login.setCreateDate(new Date());
		this.loginDao.add(login);
	}

	@Override
	public void update(Login login) {
		login.setCreateDate(new Date());
		this.loginDao.update(login);
	}
	
	
	@Override
	public void delete(int id) {
		if(this.loginDao.isLogin(id) != true){
			throw new DException("ID不存在");
		}
		this.loginDao.delete(id);
	}
	
	@Override
	public Pager<Login> findLogin() {
		return this.loginDao.find("from Login");
	}
	
	@Override
	public Login checkLogin(String username, String password) {
		return this.loginDao.checkLogin(username, password);
	}
	
	@Override
	public Login load(int id) {
		if(this.loginDao.isLogin(id) != true){
			throw new DException("ID不存在");
		}
		return this.loginDao.load(id);
	}
}









