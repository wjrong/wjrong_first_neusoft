package com.wjrong.service;

import com.wjrong.model.Login;
import com.wjrong.model.Pager;

/**
 * 用户的管理层
 * @author hugo
 * @data 2013-9-2
 *
 */
public interface LoginService {
	/**
	 * 添加用户
	 * @param login	用户对象
	 */
	public void add(Login login);
	
	/**
	 * 修改用户
	 * @param login	用户对象
	 */
	public void update(Login login);
	
	/**
	 * 删除用户
	 * @param id 用户ID
	 */
	public void delete(int id);
	
	/**
	 * 用户页面（带分页）
	 * @return	返回Pager<Login>对象
	 */
	public Pager<Login> findLogin();
	
	/**
	 * 登录
	 * @param username	用户名
	 * @param password	密码
	 * @return	查询到就返回Login对象，否则就null
	 */
	public Login checkLogin(String username, String password);
	
	/**
	 * 查询某个用户的信息
	 * @param id	某个用户的ID
	 * @return 返回该用户的对象Login
	 */
	public Login load(int id);
}
