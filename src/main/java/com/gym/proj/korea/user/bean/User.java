package com.gym.proj.korea.user.bean;


import com.google.gson.Gson;
import com.gym.proj.common.util.DateUtil;

import lombok.Data;

@Data
public class User {

	private String userId;			// 사용자 id
	private String userPassword;	// 패스워드
	private String userName;		// 이름
	private String authCode;		// 권한코드
	private String fileNo;			// 파일 no
	private String remark;			// 비고
	private String address;			// 주소 칼럼
	private String zipCode;			// 우편번호 칼럼
	private String email;			// email 칼럼
	private String phoneNumber;		// 전화번호 칼럼
	private String useYn;			// 사용유무
	private String regDate;			// 생성일시
	private String regBy;			// 생성자
	private String updateDate;		// 수정일시
	private String updateBy;		// 수정자
	
	public User () {
		
	}
	
	public User (String id, String password, String name, String authCode, String useYn) {
		this.userId = id;
		this.userPassword = password;
		this.userName = name;
		this.authCode = authCode;
		this.useYn = useYn;
	}
	
	// User Json 변환용
	public String toJson() {
        //
        return (new Gson()).toJson(this);
    }
	
	// String to Json 변환용
	public static User fromJson(String json) {
        //
        return (new Gson()).fromJson(json, User.class);
    }
	
	
	public static User sampleUser() {
		User user = new User();
		
		user.setUserId("11");
		user.setUserPassword("1234");
		user.setUserName("test model");
		user.setAuthCode("admin");
		user.setZipCode("13529");
		user.setFileNo("1234");
		user.setRemark("");
		user.setEmail("test@gmail.com");
		user.setPhoneNumber("01012341234");
		user.setUseYn("Y");
		user.setRegBy("test");
		user.setRegDate(DateUtil.getCurrentDateToKorea());
		return user;
	}
	

	public static void main(String[] args) {
        //
        System.out.println("User sample: " + (new Gson()).toJson(User.sampleUser()));
        
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", authCode="
				+ authCode + ", fileNo=" + fileNo + ", remark=" + remark + ", address=" + address + ", zipCode="
				+ zipCode + ", email=" + email + ", phoneNumber=" + phoneNumber + ", useYn=" + useYn + ", regDate="
				+ regDate + ", regBy=" + regBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + "]";
	}
}
