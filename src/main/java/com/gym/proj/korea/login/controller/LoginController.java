package com.gym.proj.korea.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gym.proj.common.bean.ResultMap;
import com.gym.proj.common.mvc.controller.CommonController;
import com.gym.proj.korea.login.bean.Login;
import com.gym.proj.korea.login.service.LoginService;

@Controller
@RequestMapping("/korea")
public class LoginController extends CommonController {
	
	@Autowired
	private LoginService service;
	
	@RequestMapping(value = {"/login/", "/login"}, method = RequestMethod.GET)
	public String loginView() {
		return "korea/login/login";
	}
	
	@RequestMapping(value = {"/index/", "/index"}, method = RequestMethod.GET)
	public String IndexView() {
		return "korea/index/index";
	}
	
	@RequestMapping(value = {"/login/", "/login"}, method = RequestMethod.POST)
	@ResponseBody
	public ResultMap login(@RequestBody Login login, HttpServletResponse response ) {
		return service.login(login);
	}
	
	@RequestMapping(value = "/login/test", method = RequestMethod.GET)
	@ResponseBody
	public ResultMap loginTest() {
		ResultMap result = new ResultMap();
		logger.debug("test login controller");
		result.setMsg("test api login");
		return result;
	}
	
	@RequestMapping(value = "/login/json", method = RequestMethod.GET)
	public ModelAndView loginJson(Model model, HttpServletRequest request) {
		ResultMap result = new ResultMap();
		logger.info("test login controller");
		result.setMsg("test api login");
		ModelAndView modelAndView = new ModelAndView("jsonView");
		modelAndView.addAllObjects(result);
		return modelAndView;
	}
}
