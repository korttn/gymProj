package com.gym.proj.korea.user.bean;


import com.google.gson.Gson;
import com.gym.proj.common.util.DateUtil;

import lombok.Data;

@Data
public class User {
	
//	디자인 및 유저생성 27일 숙제

	private String userId;			// 사용자 id
	private String userEmail;		// Email
	private String userPassword;	// 패스워드
	private String userName;		// 이름
	private String userGender;		// 성별
	private String authCode;		// 권한코드 admin 관리자   user 일반회원
//	private String fileNo;			// 파일 no
	private String remark;			// 관리자용 비고
	private String postCode;		// 우편번호 칼럼
	private String address;			// 주소 칼럼
	private String detailAddress;	// 상세주소 칼럼
	private String extraAddress;	// 주소참고사항 칼럼

	private String email;			// email 칼럼
	private String phoneNumber;		// 전화번호 칼럼
	private String useYn;			// 사용유무
	private String regDate;			// 생성일시
	private String regBy;			// 생성자
	private String updateDate;		// 수정일시
	private String updateBy;		// 수정자

	public User () {
		
	}
	
	public User (String id) {
		this.userId = id;
	}
	
	public User (String id, String password, String name, String authCode, String useYn) {
		this.userId = id;
		this.userPassword = password;
		this.userName = name;
		this.authCode = authCode;
		this.useYn = useYn;
	}
	
	public User (String userid, String userEmail, String userPassword, String userName, String userGender,
			String phoneNumber, String postCode, String address, String detailAddress, String extraAddress) {
		this.userId = userid;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userGender = userGender;
		this.phoneNumber = phoneNumber;
		this.postCode = postCode;
		this.address = address;
		this.detailAddress = detailAddress;
		this.extraAddress = extraAddress;
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
		user.setPostCode("13529");
//		user.setFileNo("1234");
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
				+ authCode + ", remark=" + remark + ", address=" + address + ", postCode="
				+ postCode + ", email=" + email + ", phoneNumber=" + phoneNumber + ", useYn=" + useYn + ", regDate="
				+ regDate + ", regBy=" + regBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + "]";
	}
}
