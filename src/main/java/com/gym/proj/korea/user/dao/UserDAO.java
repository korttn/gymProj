package com.gym.proj.korea.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gym.proj.common.mvc.dao.CommonDAO;
import com.gym.proj.korea.login.bean.Login;
import com.gym.proj.korea.user.bean.User;

@Repository
public class UserDAO extends CommonDAO {

	public int insertUser(User user) {
		return insert("user.insertUser", user);
	}
	
	public int newUser(User user) {
		return insert("user.newUser", user);
	}
	
	public User getUser(String id) {
		return selectOne("user.getUser", id);
	}
	
	public int idCheck(String id) {
		return selectOne("user.idCheck", id);
	}
	
	public List<User> getUserList() {
		return selectList("user.getUserList");
	}
	
	public User checkUser(Login login) {
		return selectOne("user.checkUser", login);
	}
}
