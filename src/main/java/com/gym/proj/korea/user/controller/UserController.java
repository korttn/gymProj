package com.gym.proj.korea.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gym.proj.common.bean.ResultMap;
import com.gym.proj.common.mvc.controller.CommonController;
import com.gym.proj.korea.login.bean.Login;
import com.gym.proj.korea.user.bean.User;
import com.gym.proj.korea.user.service.UserService;

@Controller
@RequestMapping("/korea/user")
public class UserController extends CommonController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value = {"/add/", "/add"}, method = RequestMethod.GET)
	public String createUserView() {
		return "korea/user/createUser";
	}

	@RequestMapping(value = {"/add/", "/add"}, method = RequestMethod.POST)
	@ResponseBody
	public ResultMap newUser(@RequestBody User user, HttpServletResponse response ) {
		return service.newUser(user);
	}
	
	@RequestMapping(value = {"/checkid/", "/checkid"}, method = RequestMethod.POST)
	@ResponseBody
	public ResultMap checkId(@RequestBody User user, HttpServletResponse response ) {
		return service.checkId(user);
	}
	
/*	@RequestMapping(value = {"/", ""}, method=RequestMethod.POST)
	public ResultMap createUser(@RequestParam("file") MultipartFile file, @RequestParam("id") String id
								, @RequestParam("password") String password, @RequestParam("name") String name
								, @RequestParam("auth") String authCode, @RequestParam("useYn") String useYn) throws Exception {
		User user = new User(id, password, name, authCode, useYn);
		
		return service.createUser(user, file);
	} */
	
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
