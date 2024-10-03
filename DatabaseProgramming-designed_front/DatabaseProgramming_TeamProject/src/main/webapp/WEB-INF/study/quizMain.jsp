<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quiz Page</title>
<link rel=stylesheet
	href="${pageContext.request.contextPath}/css/index.css" type="text/css">
<link rel=stylesheet
	href="${pageContext.request.contextPath}/css/index.css" type="text/css">
<link rel=stylesheet
	href="${pageContext.request.contextPath}/css/quiz.css" type="text/css">

</head>
<body>
	<jsp:include page="/html/Sidebar.html" />
	<div class="void"></div>
	<div class="main-content">

		<div class="top-bar">
			<a href="#">스터디 일정 관리</a> <a href="#">멤버 관리</a> <a href="#">멤버 목록</a>
			<a href="#">과제 목록</a> <a href="#">퀴즈</a>
		</div>

		<!-- 퀴즈 메인 -->
		<div class="quiz-main">
			<!-- 회차 선택 -->
			<div class="quiz-round-dropdown">
				<label for="rounds" class="round-label">회차 선택</label> <select
					id="rounds">
					<option value="1">1회차</option>
					<option value="2">2회차</option>
					<option value="3">3회차</option>
					<!-- 필요하면 추가 -->
				</select>
			</div>

			<!-- 생성 -->
			<div class="create-quiz-button">
				<a href="createQuiz.html"> <img src="img/makeQuiz.png"
					alt="퀴즈 생성" class="quiz-create-image">

				</a>
			</div>
			<div class="void"></div>
			<div class="quiz-list-container">
				<!-- 퀴즈 헤더 바 -->
				<div class="quiz-header">
					<div>회차</div>
					<div>문제 제목</div>
					<div>출제자</div>
					<div>푼 사람</div>
					<div>정답 비율</div>
					<div>제출</div>
				</div>

				<!-- 퀴즈 목록 -->
				<div class="quiz-item">
					<div>1</div>
					<div>레이어 계층</div>
					<div>황다현</div>
					<div>2명</div>
					<div>50%</div>
					<div>O</div>
				</div>
				<div class="quiz-item">
					<div>1</div>
					<div>서브 쿼리</div>
					<div>최유경</div>
					<div>1명</div>
					<div>100%</div>
					<div>O</div>
				</div>
				<!-- 필요시 추가 -->
			</div>
		</div>
	</div>
</body>
</html>