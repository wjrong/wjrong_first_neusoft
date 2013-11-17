package com.wjrong.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wjrong.action.LoginUserAction;

@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor {

	@SuppressWarnings("rawtypes")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		if(LoginUserAction.class == invocation.getAction().getClass()){
			return invocation.invoke();
		}
		
		Map map = invocation.getInvocationContext().getSession();
		if(map.get("userlogin") != null){
			return invocation.invoke();
		}
		return Action.LOGIN;
	}

	
}
