<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel=stylesheet href="${pageContext.request.contextPath}/css/index.css" type="text/css">
<link rel=stylesheet href="${pageContext.request.contextPath}/css/myPage.css" type="text/css">
<title>MY PAGE</title>
</head>
<body>
	<jsp:include page="/html/Header.html" />
	<jsp:include page="/html/Sidebar.html" />
	
	<div class="main-content">
		
		<!-- 프로필 -->
		<section class="profile">
			<h2>마이 페이지</h2>
			<div class="profile-box">
				<img src="img/dbp_profile_sample.png" class="profile-img">
				<div class="profile-contents">
					<div class="name">이름</div>
					<div class="phone">010-1234-5678</div>
					<div class="email">example@gmail.com</div>
				</div>
			</div>
		</section>
		
		<!-- 참여 중인 스터디 -->
		<section class="active-study">
			<h2>참여 중인 스터디</h2>
			<div class="study-box">
				<div class="study-item">
					<img src="img/study_image.png" alt="스터디 이미지" class="study-image" onerror="this.style.display='none'">
					<div class="study-details">
						<div class="study-category">프로그래밍</div> <!-- 카테고리 -->
						<div class="study-info">백준 챌린지</div> <!-- 정보 -->
						<div class="details">같이 코뎅테스트 공부해요~!</div> <!-- 세부사항 -->
						<div class="participants">3/8</div> <!-- 참가자 수 -->
					</div>
				</div>
			</div>
			
			<div class="study-box">
				<div class="study-item">
					<img src="img/study_image.png" alt="스터디 이미지" class="study-image" onerror="this.style.display='none'">
					<div class="study-details">
						<div class="study-category">프로그래밍</div> <!-- 카테고리 -->
						<div class="study-info">백준 챌린지</div> <!-- 정보 -->
						<div class="details">같이 코뎅테스트 공부해요~!</div> <!-- 세부사항 -->
						<div class="participants">3/8</div> <!-- 참가자 수 -->
						
					</div>
					
				</div>
				
			</div>
		</section>
		
	</div>
	
</body>
</html>
