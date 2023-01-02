package com.gym.proj.korea.login.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.proj.common.bean.ResultMap;
import com.gym.proj.common.util.CommonUtil;
import com.gym.proj.korea.login.bean.Login;
import com.gym.proj.korea.login.dao.LoginDAO;
import com.gym.proj.korea.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO dao;

	@Override
	public ResultMap login(Login login) {
		// TODO Auto-generated method stub
		System.out.println("첫 ResultMap 실행");
		ResultMap result = new ResultMap();
		// id, password 값 체크
		
		if (!CommonUtil.isNull(login.getUserId()) && !CommonUtil.isNull(login.getUserPassword())) {
			// Todo password 패턴 체크 및 id 패턴 체크 추가 예정
//			result = dao.checkLogin(login);
//			if (result == null) {
//				result.setStatus("220");
//				result.setMsg("ID와 PASSWORD를 잘못 입력하셨습니다."); 
//			}

			result = dao.loginok(login);
			
			if(result == null) {
				result.setStatus("220");
				result.setMsg("ID 또는 PASSWORD 를 잘못 입력하셨습니다 1");
			}
			
		} else {
			result.setStatus("220");
			result.setMsg("ID 또는 PASSWORD 를 잘못 입력하셨습니다 2");
		}
		
		return result;
	}

}
