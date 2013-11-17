package com.wjrong.util;

import com.opensymphony.xwork2.ActionContext;

public class ActionUtil {
	/**
	 * 设置返回值
	 */
	public static final String REDIRECT = "redirect";
	
	/**
	 * 跳转页面
	 * @param url
	 */
	public static void setURL(String url){
		ActionContext.getContext().put("url", url);
	}
	/**
	 * 设置request的值
	 * @param key 存放的名字
	 * @param value 存放的值
	 */
	public static void setRequest(String key, Object value){
		ActionContext.getContext().put(key, value);
	}
	/**
	 * 设置session的值
	 * @param key 存放的名字
	 * @param value 存放的值
	 */
	public static void setSession(String key, Object value){
		ActionContext.getContext().getSession().put(key, value);
	}
	
	/**
	 * 判断是否为空
	 * @param username	用户名
	 * @param password	密码
	 * @return 	空返回true   否则 false
	 */
	public static boolean isCheckNull(String str){
		if(str == null || "".equals(str.trim())){
			return true;
		}
		return false;
	}
	
	public static Object getSession(String key){
		return ActionContext.getContext().getSession().get(key);
	}
}
