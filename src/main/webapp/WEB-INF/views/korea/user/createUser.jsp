<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>회원가입</title>
  <!-- loader-->
  <link href="${path}/resources/css/pace.min.css" rel="stylesheet" />
  <script src="${path}/resources/js/pace.min.js"></script>
  <!--favicon-->
  <link rel="icon" href="${path}/resources/img/favicon.ico" type="image/x-icon">
  <!-- Bootstrap core CSS-->
  <link href="${path}/resources/css/bootstrap.css" rel="stylesheet" />
  <!-- animate CSS-->
  <link href="${path}/resources/css/animate.css" rel="stylesheet" type="text/css" />
  <!-- Icons CSS-->
  <link href="${path}/resources/css/icons.css" rel="stylesheet" type="text/css" />
  <!-- Custom Style-->
  <link href="${path}/resources/css/app-style.css" rel="stylesheet" />
  <style>
  	
  </style>
</head>

<body class="bg-theme bg-theme1">

  <!-- start loader -->
  <div id="pageloader-overlay" class="visible incoming">
    <div class="loader-wrapper-outer">
      <div class="loader-wrapper-inner">
        <div class="loader"></div>
      </div>
    </div>
  </div>
  <!-- end loader -->

  <!-- Start wrapper-->
  <div id="wrapper">

    <div class="card card-authentication1 mx-auto my-4">
      <div class="card-body">
        <div class="card-content p-2">
          <div class="text-center">
            <img src="${path}/resources/img/logo-icon.png" alt="logo icon">
          </div>
          <div class="card-title text-uppercase text-center py-3">회 원 가 입</div>
          <form>
            <div class="form-group">
            
            <div class="form-row mt-4">
              <div class="form-group mb-0 col-6">
                <input type="text" id="userId" class="form_userid" placeholder="ID를 입력하세요">
                  </input>
              </div>
              <div class="form-group mb-0 col-6 text-right">
                <button type="button" class="btn btn-light btn-block" onclick="checkId()"><i class="fa fa-twitter-square"></i>
                  ID 중복체크</button>
              </div>
            </div>
            
			<tr>
				<td>
					<input type="text" id="email_id" class="email_select" value="" title="이메일 아이디" placeholder="Email" maxlength="18" /> @ 
					<input type="text" id="email_domain" class="email_select" value="" title="이메일 도메인" placeholder="도메인" maxlength="18"/> 
					<select class="email_select" name="selectEmail" id="selectEmail">
						 <option value="1" selected>직접입력</option>
						 <option value="naver.com" >naver.com</option>
						 <option value="hanmail.net">hanmail.net</option>
						 <option value="hotmail.com">hotmail.com</option>
						 <option value="nate.com">nate.com</option>
						 <option value="yahoo.co.kr">yahoo.co.kr</option>
						 <option value="empas.com">empas.com</option>
						 <option value="dreamwiz.com">dreamwiz.com</option>
						 <option value="freechal.com">freechal.com</option>
						 <option value="lycos.co.kr">lycos.co.kr</option>
						 <option value="korea.com">korea.com</option>
						 <option value="gmail.com">gmail.com</option>
						 <option value="hanmir.com">hanmir.com</option>
						 <option value="paran.com">paran.com</option>
					</select>
				</td>
			</tr>
            
            <div class="form-group">
              <label for="userPassword" class="sr-only" >비밀번호</label>
              <div class="position-relative has-icon-right">
                <input type="password" id="userPassword" class="form-control input-shadow"
                  placeholder="Password를 입력 하세요">
                <div class="form-control-position">

                </div>
              </div>
            </div>
            
            <div class="form-group">
              <label for="userPasswordcheck" class="sr-only">비밀번호 확인</label>
              <div class="position-relative has-icon-right">
                <input type="password" id="userPasswordcheck" class="form-control input-shadow"
                  placeholder="Password를 재입력 하세요">
                <div class="form-control-position">

                </div>
              </div>
            </div>
            
            <div class="form-group">
              <label for="userName" class="sr-only">이  름</label>
              <div class="position-relative has-icon-right">
                <input type="text" id="userName" class="form-control input-shadow"
                  placeholder="이름을 입력 하세요">
                <div class="form-control-position">
                  
                </div>
              </div>
            </div>
            
            <div class="form-row mt-4">
              <div class="form-group mb-0 col-6">
                <input type="text" id="sample6_postcode" class="form_userid" placeholder="우편번호">
                  </input>
              </div>
              <div class="form-group mb-0 col-6 text-right">
                <button type="button" class="btn btn-light btn-block" onclick="sample6_execDaumPostcode()"><i class="fa fa-twitter-square"></i>
                  우편번호 찾기</button>
              </div>
            </div>

			<div class="form-group">
              <label for="sample6_address" class="sr-only">주소</label>
              <div class="position-relative has-icon-right">
                <input type="text" id="sample6_address" class="form-control input-shadow"
                  placeholder="주소">
                <div class="form-control-position">
                  
                </div>
              </div>
            </div>
            
			<div class="form-group">
              <label for="sample6_detailAddress" class="sr-only">상세주소</label>
              <div class="position-relative has-icon-right">
                <input type="text" id="sample6_detailAddress" class="form-control input-shadow"
                  placeholder="상세주소">
                <div class="form-control-position">
                  
                </div>
              </div>
            </div>
            
            <div class="form-group">
              <label for="sample6_extraAddress" class="sr-only">주소참고사항</label>
              <div class="position-relative has-icon-right">
                <input type="text" id="sample6_extraAddress" class="form-control input-shadow"
                  placeholder="주소참고사항">
                <div class="form-control-position">
                  
                </div>
              </div>
            </div>
            
            <div class="form-group">
              <label for="userGender" class="sr-only">성  별</label>
              <div class="position-relative has-icon-right">
              		<label>남자 <input checked type="radio" name="userGender" value="M"></label>
              		<label>여자 <input type="radio" name="userGender" value="W"></label>
                <div class="form-control-position">
                  
                </div>
              </div>
            </div>
            
            <div class="form-group">
              <label for="phoneNumber" class="sr-only">휴대폰 번호</label>
              <div class="position-relative has-icon-right">
                <input type="text" id="phoneNumber" class="form-control input-shadow"
                  placeholder="휴대폰번호를 입력 하세요">
                <div class="form-control-position">
                  
                </div>
              </div>
            </div>
            
            <button type="button" class="btn btn-light btn-block waves-effect waves-light" onclick="newUser()">가입 신청</button>

<!--             <div class="text-center mt-3">Sign Up With</div>
            <div class="form-row mt-4">
              <div class="form-group mb-0 col-6">
                <button type="button" class="btn btn-light btn-block"><i class="fa fa-facebook-square"></i>
                  Facebook</button>
              </div>
              <div class="form-group mb-0 col-6 text-right">
                <button type="button" class="btn btn-light btn-block"><i class="fa fa-twitter-square"></i>
                  Twitter</button>
              </div>
            </div> -->

          </form>
        </div>
      </div>
      <div class="card-footer text-center py-3">
        <p class="text-warning mb-0">Already have an account? <a href="login.html"> Sign In here</a></p>
      </div>
    </div>

    <!--Start Back To Top Button-->
    <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
    <!--End Back To Top Button-->

  <!--End wrapper-->
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="${path}/resources/js/jquery.min.js"></script>
  <script src="${path}/resources/js/popper.min.js"></script>
  <script src="${path}/resources/js/bootstrap.min.js"></script>

  <!-- sidebar-menu js -->
  <script src="${path}/resources/js/sidebar-menu.js"></script>

  <!-- Custom scripts -->
  <script src="${path}/resources/js/app-script.js"></script>
  <!-- 이메일 js -->
  <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
  <!-- 주소찾기(kakao) -->
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!-- newUser function -->
<script type="text/javascript">
  
function newUser(){
	var userId = $('#userId').val();

	if (userId == "") { 
	    alert("아이디를 입력하세요.");
	    return false; 
	};
	
	
	var regId = /^[a-z]+[a-z0-9]{5,15}$/g;
	
	if (!regId.test(userId)) {
		alert("아이디는 영문자+숫자 조합으로 8~16자리 사용해야 합니다.");
		return false;
	};
	
	
	var userEmail = $('#email_id').val() + '@' + $('#email_domain').val();
	
	if ($('#email_id').val() == "") {
		alert("이메일 아이디를 입력하세요.");
		return false;
	};
	
	if ($('#email_domain').val() == "") {
		alert("이메일 도메인을 입력하세요.");
		return false;
	};
	
	if (userEmail == "") {
		alert("이메일을 입력하세요.");
		return false;
	};
	

	var userPassword = $('#userPassword').val();
	
	if (userPassword == "") {
		   alert("비밀번호를 입력하세요.");
		   return false;
	};
		
	//비밀번호 영문자+숫자+특수조합(8~16자리 입력) 정규식
	//샘플용 비밀번호 - 12qweR#$34@!
  	let pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;

	if (!pwdCheck.test(userPassword)) {
		alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~16자리 사용해야 합니다.");
		return false;
	};
	
		
	var userPasswordcheck = $('#userPasswordcheck').val();
	
	if (userPasswordcheck !== userPassword) {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	};
	
	
	var userName = $('#userName').val();
	
	if (userName == "") {
		alert("이름을 입력하세요.");
		return false;
	};

	
	var userGender = $('input[name=userGender]:checked').val();
	
	var phoneNumber = $('#phoneNumber').val();
	
  	let reg = /^[0-9]+/g; //숫자만 입력하는 정규식

	if (!reg.test(phoneNumber)) {
		alert("전화번호는 숫자만 입력할 수 있습니다.");
		return false;
	}
  	
	
	var postCode = $('#sample6_postcode').val();
	
	var address = $('#sample6_address').val();
	
	var detailAddress = $('#sample6_detailAddress').val();
	
	var extraAddress = $('#sample6_extraAddress').val();
	
	console.log(userId);
	console.log(userEmail);
	console.log(userPassword);
	console.log(userPasswordcheck);
	console.log(userName);
	console.log(userGender);
	console.log(phoneNumber);
	console.log(postCode);
	console.log(address);
	console.log(detailAddress);
	console.log(extraAddress);
	
	let jsonData = {"userId" : userId, "userEmail" : userEmail, "userPassword" : userPassword, "userName" : userName,
			"userGender" : userGender, "phoneNumber" : phoneNumber, "postCode" : postCode, "address" : address,
			"detailAddress" : detailAddress, "extraAddress" : extraAddress};
	
	/* ajax 통신 - DB에 유저 정보 등록 */
 	$.ajax({
		type : "POST",
		url : "/korea/user/add",
		data: JSON.stringify(jsonData),
		contentType: "application/json; charset=utf-8",
		success : function (data){
			console.log(data);
			if(data){
				alert("회원가입 성공");
				location.href="/korea/login/";
			} else {
				alert("회원가입 실패");
			}
		}
	});
}

	
	//중복체크 버튼 눌렀을때 실행 - 아이디 중복 검사
	function checkId() {
		
		let userId = $('#userId').val();
		
	    //아이디 공백 확인
	    if($("#userId").val() == ""){
	      alert("아이디를 입력해주세요.");
	      $("#userId").focus();
	      return false;
	    }
		
		let jsonData = {"userId" : userId};
		console.log(jsonData);
		
		$.ajax({
			type : "POST",
			url : "/korea/user/checkid/",
			data: JSON.stringify(jsonData),
			contentType: "application/json; charset=utf-8",
			success : function (data){
				console.log(data);
				if(data){
					alert(data.msg);
				} else {
					alert(data.msg);
				}
			}
			
		});
	}
	
	// 이메일 입력방식 선택
    $('#selectEmail').change(function(){
 	   $("#selectEmail option:selected").each(function () {
 			
 			if($(this).val()== '1'){ //직접입력일 경우
 				 $("#email_domain").val('');                        //값 초기화
 				 $("#email_domain").attr("disabled",false); //활성화
 			}else{ //직접입력이 아닐경우
 				 $("#email_domain").val($(this).text());      //선택값 입력
 				 $("#email_domain").attr("disabled",true); //비활성화
 			}
 	   });
 	});
    
	/* 주소찾기 */
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
	
  </script>
  
</body>

</html>