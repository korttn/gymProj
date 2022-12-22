package com.gym.proj.common.util;

import java.util.Calendar;
import java.util.UUID;

public class FileUtil {
	

	public static String getFilePath(String fileLocation) {
    	return fileLocation.substring(0, fileLocation.lastIndexOf("/"));
    }
 
	/**
   	 * 파일 확장자 추출
   	 * @param String file path 및 file 이름 형태 (ex: pgadmin4-4.14-x86.exe)
   	 * @return String exe, jpg, txt 등      
   	 * @since 2019. 10. 23.
   	 */
    public static String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".")+1);
    }
 
    /**
   	 * 파일명 추출
   	 * @param String file path 및 file 이름 형태 (ex: pgadmin4-4.14-x86.exe)
   	 * @return String pgadmin, kakaotalk 등      
   	 * @since 2019. 11. 8.
   	 */
    public static String getFileName(String fileName) {
		return fileName.substring(fileName.lastIndexOf("/")+1);
    }
    
    /**
   	 * 그림파일 체크
   	 * @param String file path 및 file 이름 형태 (ex: 1234.jpg, 2014-11-10.bmp )
   	 * @return boolean 이미지 파일이면 true, 아니면 false 
   	 * @since 2019. 11. 8.
   	 */
    public static boolean isImgFile(String fileName) {
    	String imgExt = "(^[\\S]+(\\.(?i)(jpg|png|gif|bmp|jpeg))$)";
    	return fileName.matches(imgExt);
    }
    
    /**
   	 * 서버에 파일저장할 이름 만들기
   	 * @param String 입력된 이름 (ex: kakao, pgadmin )
   	 * @return 현제 시간 + 입력된 이름 (ex : 20181130112233kakao.exe)
   	 * @since 2019. 11. 8.
   	 */
    public static String genSaveFileName(String extName) {
 		String fileName = "";
 		
 		Calendar calendar = Calendar.getInstance();
 		fileName += calendar.get(Calendar.YEAR);
 		fileName += calendar.get(Calendar.MONTH);
 		fileName += calendar.get(Calendar.DATE);
 		fileName += calendar.get(Calendar.HOUR);
 		fileName += calendar.get(Calendar.MINUTE);
 		fileName += calendar.get(Calendar.SECOND);
 		fileName += "_" + extName;
 		
 		return fileName;
 	}
    
    public static void main(String[] args) {
    	String file = "C:/Users/korttn/Downloads/KakaoTalk_Setup.exe";
    	String fileName = getFileName(file);
    	String path = getFilePath(file);
    	System.out.println("file img match : " + isImgFile(fileName));
    	System.out.println("file path :" + path);
    	System.out.println("file ext :" + getFileExt(file));
    	System.out.println("file name :" + getFileName(file));
    	System.out.println("UUID : " + UUID.randomUUID().toString());
    	
    }
}
