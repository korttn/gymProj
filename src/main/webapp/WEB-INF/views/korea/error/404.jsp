<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 9]> <html lang="ko" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="ko"> <!--<![endif]-->
<head>
	<meta charset="UTF-8">
	<meta http-equiv="x-ua-compatible" content="IE=edge, chrome=1">
	<meta charset="utf-8">
	<title>Error</title>

	<!-- <script src="${JS}/jquery-1.11.3.min.js" type="text/javascript"></script> -->
	<!-- <script type="text/javascript">
	
	</script> -->
</head>
<body class="error">
	<div id="wrap"> <!-- wrap s -->
		<div id="header" class="clearfix">
			<div class="header-in">
				<div class="header-right">
					<p>이용에 불편을 드려 죄송합니다.</p>
					<h2>요청하신 페이지를 찾을 수 없습니다.</h2>
				</div>
			</div>
		</div>
		<div id="contents">
			<p class="mb10">허용되지 않은 접근 입니다.
            	허용되지 않은 페이지로 접근하여 접속이 차단되었습니다.</p>
			<p>접근권한이 필요하신 분은 승인을 받아 접근하시기 바랍니다.</p>
		</div>
		<div class="back-page">
			<a href="javascript:history.back(1)">이전 페이지로 돌아가기</a>
		</div>
	</div> <!-- wrap e -->
</body>
</html>