package com.gym.proj.korea.file.service.Impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gym.proj.common.bean.ResultMap;
import com.gym.proj.common.util.DateUtil;
import com.gym.proj.common.util.FileUtil;
import com.gym.proj.korea.file.bean.FileInfo;
import com.gym.proj.korea.file.dao.FileDAO;
import com.gym.proj.korea.file.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileDAO dao;
	
	private static final String PREFIX_PATH = "/gym/upload/";
	private static final String PROFILE_PATH = "/profile/";
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public ResultMap registerFile(MultipartFile multipartFile, String id) {
		logger.debug("register file start");
		ResultMap result = new ResultMap();
		try {
			String originFilename = multipartFile.getOriginalFilename();
			Long size = multipartFile.getSize();
			
			FileInfo info = new FileInfo();
			info.setFileName(FileUtil.getFileName(originFilename));
			info.setFileSize(size);
			info.setFileExtName(FileUtil.getFileExt(originFilename));
			
			String writeFileName = FileUtil.genSaveFileName(info.getFileName());
			if (!FileUtil.isImgFile(info.getFileName())) {
				// img 파일을 제외한 엑셀등 파일은  DB에 저장
				info.setFileCtx(multipartFile.getBytes());
				info.setFileSaveMthdCd("D");
			} else {
				// 업로드 파일 저장 img 파일 전용
				String savePath = PREFIX_PATH + id + PROFILE_PATH;
				writeFile(multipartFile, writeFileName, savePath);
				info.setFileSaveMthdCd("F");
				info.setFileSavePath(savePath + writeFileName);
			}
			//String fileNo = StringUtil.randomID(10);
			//info.setFileNo(fileNo);
			info.setFileUserId(id);
			info.setRegDate(DateUtil.getCurrentDateToKorea());
			// 파일 정보 DB 등록
			dao.insertFileInfo(info);
			result.put("fileNo", info.getFileUserId());
			result.put("filePath", info.getFileSavePath());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}
	
	// File write img 파일용
	private void writeFile(MultipartFile multipartFile, String saveFileName, String savePath) {
		FileOutputStream fos = null;
		
		try {
			byte[] data = multipartFile.getBytes();
			File folder = new File(savePath);
			// 해당 디렉토리가 없을경우 생성
			if (!folder.exists()) {
				System.out.println("not folder");
				if (folder.mkdirs()) {
					System.out.println("create failfolder");
				} else {
					System.out.println("create fail");
				}
			} else {
				System.out.println("Yes folder");
			}
			
			fos = new FileOutputStream(savePath + saveFileName);
			fos.write(data);
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fos != null) {
				try{fos.close();} catch (IOException e){}
			}
		}
		
	}

	@Override
	public int deleteFile(String fileNo) {
		// TODO Auto-generated method stub
		return dao.deleteFileInfo(fileNo);
	}
	
}
