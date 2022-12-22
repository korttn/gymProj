package com.gym.proj.korea.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gym.proj.common.bean.ResultMap;
import com.gym.proj.common.mvc.controller.CommonController;
import com.gym.proj.korea.user.bean.User;
import com.gym.proj.korea.user.service.UserService;

@RestController
@RequestMapping("/mes/user")
public class UserController extends CommonController {
	
	@Autowired
	private UserService service;

	@RequestMapping(value = {"/", ""}, method=RequestMethod.POST)
	public ResultMap createUser(@RequestParam("file") MultipartFile file, @RequestParam("id") String id
								, @RequestParam("password") String password, @RequestParam("name") String name
								, @RequestParam("auth") String authCode, @RequestParam("useYn") String useYn) throws Exception {
		User user = new User(id, password, name, authCode, useYn);
		
		return service.createUser(user, file);
	}
	
	@RequestMapping(value = {"/test/", "/test"}, method=RequestMethod.POST)
	public ResultMap createUserBody() {
		
		return null;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public User findUser(@PathVariable String id) {
		return service.findUser(id);
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<User> findUserAll() {
		return service.findUserAll();
	}
}
