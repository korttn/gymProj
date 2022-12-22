package com.gym.proj.common.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSessionTemplate;
	}
	
	public <T> T selectOne(String sql) {
		return getSqlSession().selectOne(sql);
	}
	
	public <T> T selectOne(String sql, Object param) {
		return getSqlSession().selectOne(sql, param);
	}
	
	public <E> List<E> selectList(String sql) {
		return getSqlSession().selectList(sql);
	}
	
	public <E> List<E> selectList(String sql, Object param) {
		return getSqlSession().selectList(sql, param);
	}
	
	public int insert(String sql) {
		return getSqlSession().insert(sql);
	}
	
	public int insert(String sql, Object param) {
		return getSqlSession().insert(sql, param);
	}
	
	public int update(String sql) {
		return getSqlSession().update(sql);
	}
	
	public int update(String sql, Object param) {
		return getSqlSession().update(sql, param);
	}
	
	public int delete(String sql) {
		return getSqlSession().delete(sql);
	}
	
	public int delete(String sql, Object param) {
		return getSqlSession().delete(sql, param);
	}
}
