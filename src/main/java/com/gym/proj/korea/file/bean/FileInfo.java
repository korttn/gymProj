package com.gym.proj.korea.file.bean;

import com.google.gson.Gson;
import com.gym.proj.common.util.DateUtil;

import lombok.Data;

@Data
public class FileInfo {

	//private String fileNo;			// 파일 번호
	private String fileUserId;		// 프로필 파일 user id 
	private String fileAttCode;		// 첨부코드
	private String fileName;		// 파일 이름
	private String fileExtName;		// 파일 확장자
	private byte[] fileCtx;			// 파일 내용
	private long fileSize;			// 파일 크기
	private String fileUploadDate;	// 업로드 일시
	private String fileSavePath;	// 파일 저장 경로
	private String fileSaveMthdCd;	// 파일 저장 방식
	private String remark;			// 비고
	private String xlsRowCnt;		// 엑셀 Row 카운트
	private String useYn;
	private String regBy;
	private String regDate;
	private String updateBy;
	private String updateDate;
	
	// FileInfo Json 변환용
	public String toJson() {
        //
        return (new Gson()).toJson(this);
    }
	
	// String to Json 변환용
	public static FileInfo fromJson(String json) {
        //
        return (new Gson()).fromJson(json, FileInfo.class);
    }
	
	public static FileInfo sample() {
		FileInfo info = new FileInfo();
		
		info.setFileUserId("");
		info.setFileAttCode("");
		info.setFileName("");
		info.setFileExtName("");
		//info.setFileCtx("");
		info.setFileSize(0);
		info.setFileUploadDate(DateUtil.getCurrentDateToKorea());
		info.setRemark("");
		info.setUseYn("Y");
		info.setRegBy("");
		info.setRegDate(DateUtil.getCurrentDateToKorea());
		
		return info;
	}

	@Override
	public String toString() {
		return "FileInfo [fileUserId=" + fileUserId + ", fileAttCode=" + fileAttCode + ", fileName=" + fileName
				+ ", fileExtName=" + fileExtName + ", fileCtx=" + fileCtx + ", fileSize=" + fileSize
				+ ", fileUploadDate=" + fileUploadDate + ", remark=" + remark + ", useYn=" + useYn + ", regBy=" + regBy
				+ ", regDate=" + regDate + ", updateBy=" + updateBy + ", updateDate=" + updateDate + "]";
	}
	
	public static void main(String[] args) {
        //
        System.out.println("FileInfo sample: " + (new Gson()).toJson(FileInfo.sample()));
        
    }
}
