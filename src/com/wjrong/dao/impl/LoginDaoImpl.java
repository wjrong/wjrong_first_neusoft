package com.wjrong.dao.impl;

import org.springframework.stereotype.Repository;

import com.wjrong.dao.LoginDao;
import com.wjrong.model.Login;

@Repository("loginDao")
public class LoginDaoImpl extends SuperDaoImpl<Login> implements LoginDao {

	@Override
	public boolean isLogin(int id) {
		String hql = "from Login l where l.id=?";
		Login login = (Login) this.getSession().createQuery(hql).setParameter(0, id).uniqueResult();
		if(login != null){
			return true;
		}
		return false;
	}

	@Override
	public Login checkLogin(String username, String password) {
		String hql = "from Login l where l.username=? and l.password=?";
		Login login = (Login)this.getSession().createQuery(hql)
							.setParameter(0, username)
							.setParameter(1, password)
							.uniqueResult();
		if(login != null){
			return login;
		}
		return null;
	}
}
