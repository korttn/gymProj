package com.gym.proj.korea.user.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gym.proj.common.bean.ResultMap;
import com.gym.proj.korea.user.bean.User;

public interface UserService {

	public ResultMap createUser(User user, MultipartFile file) throws Exception;
	public ResultMap createUser(User user);
	public ResultMap newUser(User user);
	public User findUser(String id);
	public List<User> findUserAll();
	public ResultMap checkId(User user);
	
}
