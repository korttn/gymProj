package com.gym.proj.korea.user.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.multipart.MultipartFile;

import com.gym.proj.common.bean.ResultMap;
import com.gym.proj.common.exception.LogicException;
import com.gym.proj.common.util.CommonUtil;
import com.gym.proj.common.util.DateUtil;
import com.gym.proj.korea.file.service.FileService;
import com.gym.proj.korea.user.bean.User;
import com.gym.proj.korea.user.dao.UserDAO;
import com.gym.proj.korea.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ResultMap createUser(User user, MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		ResultMap result = new ResultMap();
		TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			// 기존 ID 유무 확인
			logger.debug("id check");
			if (dao.idCheck(user.getUserId()) <= 0) {
				// 프로필 파일이 있는지 확인
				logger.debug("file check");
				if (!CommonUtil.isNull(file.getOriginalFilename())) {
					result = fileService.registerFile(file, user.getUserId());
					// 파일 등록 NO 확인 후 user에 셋팅
					logger.debug("file create");
					if (!CommonUtil.isNull(result.get("fileNo"))) {
						user.setFileNo((String)result.get("fileNo"));
					}
				}
				// user 등록
				logger.debug("user create");
				user.setRegBy(user.getUserId());
				user.setRegDate(DateUtil.getCurrentDateToKorea());
				dao.insertUser(user);
				transactionManager.commit(transactionStatus);
			} else {
				throw new LogicException("605", "사용중인 ID 입니다.");
			}
		} catch (Exception e) {
			transactionManager.rollback(transactionStatus);
			logger.error(e.getMessage());
			throw e;
		}
		return result;
	}

	@Override
	public User findUser(String id) {
		// TODO Auto-generated method stub
		return dao.getUser(id);
	}

	@Override
	public List<User> findUserAll() {
		// TODO Auto-generated method stub
		return dao.getUserList();
	}

}
