package com.gym.proj.korea.file.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gym.proj.common.mvc.dao.CommonDAO;
import com.gym.proj.korea.file.bean.FileInfo;

@Repository
public class FileDAO extends CommonDAO {

	public int insertFileInfo(FileInfo info) {
		return insert("fileInfo.insertFileInfo", info);
	}
	
	public FileInfo getFileInfo(String id) {
		return selectOne("fileInfo.getFileInfo", id);
	}
	
	public List<FileInfo> getFileInfoList() {
		return selectList("fileInfo.getFileInfoList");
	}
	
	public int deleteFileInfo(String fileNo) {
		return delete("fileInfo.deleteFileInfo", fileNo);
	}
}
