package com.gym.proj.korea.file.service;

import org.springframework.web.multipart.MultipartFile;

import com.gym.proj.common.bean.ResultMap;

public interface FileService {

	public ResultMap registerFile(MultipartFile multipartFile, String id);
	public int deleteFile(String fileNo);
}
