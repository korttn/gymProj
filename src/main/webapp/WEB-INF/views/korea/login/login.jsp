<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
  <meta name="description" content=""/>
  <meta name="author" content=""/>
  <title>Dashtreme Admin - Free Dashboard for Bootstrap 4 by Codervent</title>
  <!-- loader-->
  <link href="${path}/resources/css/pace.min.css" rel="stylesheet"/>
  <script src="${path}/resources/js/pace.min.js"></script>
  <!--favicon-->
  <link rel="icon" href="${path}/resources/img/favicon.ico" type="image/x-icon">
  <!-- Bootstrap core CSS-->
  <link href="${path}/resources/css/bootstrap.min.css" rel="stylesheet"/>
  <!-- animate CSS-->
  <link href="${path}/resources/css/animate.css" rel="stylesheet" type="text/css"/>
  <!-- Icons CSS-->
  <link href="${path}/resources/css/icons.css" rel="stylesheet" type="text/css"/>
  <!-- Custom Style-->
  <link href="${path}/resources/css/app-style.css" rel="stylesheet"/>
  
</head>

<body class="bg-theme bg-theme1">

<!-- start loader -->
   <div id="pageloader-overlay" class="visible incoming"><div class="loader-wrapper-outer"><div class="loader-wrapper-inner" ><div class="loader"></div></div></div></div>
   <!-- end loader -->

<!-- Start wrapper-->
 <div id="wrapper">

 <div class="loader-wrapper"><div class="lds-ring"><div></div><div></div><div></div><div></div></div></div>
	<div class="card card-authentication1 mx-auto my-5">
		<div class="card-body">
		 <div class="card-content p-2">
		 	<div class="text-center">
		 		<img src="${path}/resources/img/logo-icon.png" alt="logo icon">
		 	</div>
		  <div class="card-title text-uppercase text-center py-3">Sign In</div>
		    <form>
			  <div class="form-group">
			  <label for="exampleInputUsername" class="sr-only">Username</label>
			   <div class="position-relative has-icon-right">
				  <input type="text" id="userId" class="form-control input-shadow" placeholder="Enter UserID">
				  <div class="form-control-position">
					  <i class="icon-user"></i>
				  </div>
			   </div>
			  </div>
			  <div class="form-group">
			  <label for="exampleInputPassword" class="sr-only">Password</label>
			   <div class="position-relative has-icon-right">
				  <input type="password" id="userPassword" class="form-control input-shadow" placeholder="Enter Password">
				  <div class="form-control-position">
					  <i class="icon-lock"></i>
				  </div>
			   </div>
			  </div>
			<div class="form-row">
			 <div class="form-group col-6">
			   <div class="icheck-material-white">
                <input type="checkbox" id="user-checkbox" checked="" />
                <label for="user-checkbox">Remember me</label>
			  </div>
			 </div>
			 <div class="form-group col-6 text-right">
			  <a href="reset-password.html">Reset Password</a>
			 </div>
			</div>
			 <button type="button" class="btn btn-light btn-block" onclick="login02()">Sign In</button>
			  <div class="text-center mt-3">Sign In With</div>
			  
			 <div class="form-row mt-4">
			  <div class="form-group mb-0 col-6">
			   <button type="button" class="btn btn-light btn-block"><i class="fa fa-facebook-square"></i> Facebook</button>
			 </div>
			 <div class="form-group mb-0 col-6 text-right">
			  <button type="button" class="btn btn-light btn-block"><i class="fa fa-twitter-square"></i> Twitter</button>
			 </div>
			</div>
			 
			 </form>
		   </div>
		  </div>
		  <div class="card-footer text-center py-3">
		    <p class="text-warning mb-0">Do not have an account? <a href="register.html"> Sign Up here</a></p>
		    <button type="button" class="btn btn-light btn-block" onclick="CreateUserView()">회원가입</button>
		  </div>
	     </div>
    
     <!--Start Back To Top Button-->
    <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
    <!--End Back To Top Button-->
	
	<!--start color switcher-->
   <div class="right-sidebar">
    <div class="switcher-icon">
      <i class="zmdi zmdi-settings zmdi-hc-spin"></i>
    </div>
    <div class="right-sidebar-content">

      <p class="mb-0">Gaussion Texture</p>
      <hr>
      
      <ul class="switcher">
        <li id="theme1"></li>
        <li id="theme2"></li>
        <li id="theme3"></li>
        <li id="theme4"></li>
        <li id="theme5"></li>
        <li id="theme6"></li>
      </ul>

      <p class="mb-0">Gradient Background</p>
      <hr>
      
      <ul class="switcher">
        <li id="theme7"></li>
        <li id="theme8"></li>
        <li id="theme9"></li>
        <li id="theme10"></li>
        <li id="theme11"></li>
        <li id="theme12"></li>
		<li id="theme13"></li>
        <li id="theme14"></li>
        <li id="theme15"></li>
      </ul>
      
     </div>
   </div>
  <!--end color switcher-->
	
	</div><!--wrapper-->
	
  <!-- Bootstrap core JavaScript-->
  <script src="${path}/resources/js/jquery.min.js"></script>
  <script src="${path}/resources/js/popper.min.js"></script>
  <script src="${path}/resources/js/bootstrap.min.js"></script>
	
  <!-- sidebar-menu js -->
  <script src="${path}/resources/js/sidebar-menu.js"></script>
  
  <!-- Custom scripts -->
  <script src="${path}/resources/js/app-script.js"></script>
  
  <!-- login function -->
  <script type="text/javascript">
  /* function login(){
	var userId = $('#userId').val();
	var userPw = $('#userPw').val();
	var jsonData = {"userId" : userId, "userPw" : userPw};
	$.ajax({
		type : "POST",
		url : "/korea/login",
		data: JSON.stringify(jsonData),
		contentType: "application/json; charset=utf-8",
		success : function (data){
			console.log(data);
			if(data){
				alert("로그인 성공");
			} else {
				alert("로그인 실패");
			}
		}
		
	});
  } */
  </script>
  
  <script>
  function login02(){
	  var userId = $('#userId').val();
	  var userPassword = $('#userPassword').val();
	  var jsonData = {"userId" : userId, "userPassword" : userPassword};
	  
	  console.log(userId);
	  console.log(userPassword);
	  
	  $.ajax({
		 type : "POST",
		 url : "/korea/login",
		 data : JSON.stringify(jsonData),
		 contentType : "application/json; charset=utf-8",
		 success : function(data){
			 
			 console.log(data);
			 
			 if(userId === data.userId){
				 alert(data.userId + "님 어서오세요~");
				 location.href="/korea/index"
			 } else {
				 alert("ID 또는 Password 를 잘못입력하셨습니다.");
			 }
			 
		 }
		 
	  });
  }
  
  function CreateUserView(){
	  location.href = "/korea/user/add";
  }
  
  </script>
  
</body>
</html>