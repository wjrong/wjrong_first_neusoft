package com.wjrong.dao;

import com.wjrong.model.Login;

public interface LoginDao extends SuperDao<Login> {

	/**
	 * 判断用户ID是有值
	 * @param id	login对象ID
	 * @return	有返回true or false
	 */
	public boolean isLogin(int id);
	
	public Login checkLogin(String username, String password);
	
}
