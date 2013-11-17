package com.wjrong.dao;

import java.util.List;

import com.wjrong.model.Pager;

public interface SuperDao<T> {
	public void add(T t);
	public void delete(int id);
	public void update(T t);
	/**
	 * 查询一个
	 * @param id id
	 * @return return该对象
	 */
	public T load(int id);
	
	/**
	 * 执行一组hql的信息(增删改)
	 * @param hql 语句
	 * @param args	一组数据
	 */
	public void executeByHql(String hql, Object[] args);
	/**
	 * 执行一个hql的信息(增删改)
	 * @param hql 语句
	 * @param obj	某个参数
	 */
	public void executeByHql(String hql, Object obj);
	/**
	 * 执行hql的信息(增删改)
	 * @param hql 语句
	 */
	public void executeByHql(String hql);
	
	/**
	 * 查询hql的信息(查)
	 * @param hql	hql语句
	 * @param args	一组数据
	 * @return	放回List<T>
	 */
	public List<T> queryByHql(String hql, Object[] args);
	/**
	 * 查询hql的信息(查)
	 * @param hql	hql语句
	 * @param obj	某个参数
	 * @return	放回List<T>
	 */
	public List<T> queryByHql(String hql, Object obj);
	/**
	 * 查询hql的信息(查)
	 * @param hql	hql语句
	 * @return	放回List<T>
	 */
	public List<T> queryByHql(String hql);
	
	/**
	 * 分页查询
	 * @param hql	hql语句
	 * @param args	一组参数
	 * @return	一组数据
	 */
	public Pager<T> find(String hql, Object[] args);
	/**
	 * 分页查询
	 * @param hql	hql语句
	 * @param obj	一个参数
	 * @return	一组数据
	 */
	public Pager<T> find(String hql, Object obj);
	/**
	 * 分页查询
	 * @param hql	hql语句
	 * @return	一组数据
	 */
	public Pager<T> find(String hql);
	
	/**
	 * 使用原生态sql查询 (查)
	 * @param sql 原生态sql语句
	 * @return	返回List<Object>
	 */
	public List<Object> querySQL(String sql);
}
