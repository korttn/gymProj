package com.gym.proj.korea.login.dao;

import org.springframework.stereotype.Repository;

import com.gym.proj.common.bean.ResultMap;
import com.gym.proj.common.mvc.dao.CommonDAO;
import com.gym.proj.korea.login.bean.Login;

@Repository
public class LoginDAO extends CommonDAO{

	public ResultMap checkLogin(Login login) {
		return selectOne("login.loginCk", login);
	}
	
	public int check(Login login) {
		return selectOne("login.check", login);
	}

	public ResultMap loginok(Login login) {
		return selectOne("login.loginOk", login);
	}
	
	
}
