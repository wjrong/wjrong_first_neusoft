package com.wjrong.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wjrong.dao.SuperDao;
import com.wjrong.model.Pager;
import com.wjrong.model.SystemContext;

public class SuperDaoImpl<T> extends HibernateDaoSupport implements SuperDao<T> {

	private Class<T> clz;
	
	@SuppressWarnings("unchecked")
	private Class<T> getClz() {
		if(clz==null) {
			clz = ((Class<T>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}
	
	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	
	/**
	 * 执行hql语句
	 * @param hql  语句
	 * @param args	一组参数 or 无参数null
	 * @return 返回 Query对象 
	 */
	private Query setParamterQuery(String hql, Object[] args){
		Query q = this.getSession().createQuery(hql);
		if(args != null){
			for(int i=0; i<args.length; i++){
				q.setParameter(i, args[i]);
			}
		}
		return q;
	}
	/**
	 * 修改hql语句 		select cout(*) from 对象
	 * @param hql	语句
	 * @param args	一组参数 or 无参数null
	 * @return	返回新的hql语句
	 */
	private String getCountHql(String hql, Object[] args){
		String s = hql.substring(0, hql.indexOf("from"));
		if(s==null || s.trim().equals("")){
			hql = "select count(*)" + hql;
		}else{
			hql = hql.replace(s, "select count(*)");
		}
		return hql;
	}
	
	@Override
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void delete(int id) {
		this.getHibernateTemplate().delete(this.load(id));
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public T load(int id) {
		return this.getHibernateTemplate().get(getClz(), id);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Pager<T> find(String hql, Object[] args) {
		//从页面获取相应的参数
		int pageSize = SystemContext.getPageSize();
		int pageOffset = SystemContext.getOffSet();
		//设置默认值
		if(pageSize <=0 ) pageSize = 10;
		if(pageOffset <0) pageOffset = 0;
		
		//分页查询
		Query pages = this.setParamterQuery(hql, args);
		pages.setFirstResult(pageOffset).setMaxResults(pageSize);
		
		//查询总条数
		String countHql = this.getCountHql(hql,null);
		Query countQuery = this.setParamterQuery(countHql, args);
		
		//把值存进去对象中
		Pager<T> pager = new Pager<T>();
		pager.setPageSize(pageSize);
		pager.setPageOffset(pageOffset);
		pager.setDatas(pages.list());
		pager.setTotalRecord((Long)countQuery.uniqueResult());
		return pager;
	}

	@Override
	public Pager<T> find(String hql, Object obj) {
		return this.find(hql, new Object[]{obj});
	}

	@Override
	public Pager<T> find(String hql) {
		return this.find(hql,null);
	}

	@Override
	public void executeByHql(String hql, Object[] args) {
		Query q = this.setParamterQuery(hql, args);
		q.executeUpdate();
	}

	@Override
	public void executeByHql(String hql, Object obj) {
		this.executeByHql(hql, new Object[]{obj});
	}

	@Override
	public void executeByHql(String hql) {
		this.executeByHql(hql, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryByHql(String hql, Object[] args) {
		return this.setParamterQuery(hql, args).list();
	}

	@Override
	public List<T> queryByHql(String hql, Object obj) {
		return this.queryByHql(hql, new Object[]{obj});
	}

	@Override
	public List<T> queryByHql(String hql) {
		return this.queryByHql(hql, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> querySQL(String sql) {
		return this.getSession().createSQLQuery(sql).list();
	}

}
