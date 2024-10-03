<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel=stylesheet
	href="${pageContext.request.contextPath}/css/index.css" type="text/css">
<link rel=stylesheet
	href="${pageContext.request.contextPath}/css/home.css" type="text/css">
<link rel="stylesheet" href="css/slide.css" />

<title>HOME</title>
</head>
<body>
	<jsp:include page="/html/Header.html" />
	<jsp:include page="/html/Sidebar.html" />
	<div class="void"></div>

	<div class="main-content">

		<!-- 광고 -->
		<section class="main-ad">
			<div class="slider">
				<div class="slide">
					<img src="img/dbp_mainpage_ad1.png" class="ad-img">
				</div>
				<div class="slide">
					<img src="img/dbp_mainpage_ad2.png" class="ad-img">
				</div>
				<div class="slide">
					<img src="img/dbp_mainpage_ad3.png" class="ad-img">
				</div>
			</div>
		</section>

		<div class="study-container">
			<!-- 참여 중인 스터디 -->
			<section class="active-study">
				<h2>참여 중인 스터디</h2>
				<div class="study-box">
					<div class="slidebox">
						<input type="radio" name="slide" id="slide01" checked> <input
							type="radio" name="slide" id="slide02"> <input
							type="radio" name="slide" id="slide03"> <input
							type="radio" name="slide" id="slide04">
						<ul class="slidelist">
							<li class="slideitem">
								<div class="study-item">
									<div class="taskset">
										<img src="img/groupimg.png" alt="스터디 이미지" class="study-image">

										<div class="tasks"><input type="checkbox" id="scales" name="scales" checked />과제 1	
										<div class="detail">수업 준비하기</div></div>
										<div class="tasks"><input type="checkbox" id="scales" name="scales" checked />과제 2	</div>
										<div class="quiz"><input type="checkbox" id="scales" name="scales" checked />퀴즈 1	</div>
										<div class="quiz"><input type="checkbox" id="scales" name="scales" checked />퀴즈 2	</div>
									</div>
									<div class="active-description">
										<div class="study-info">스터디 그룹명1</div>
										<div class="detail">꾸준한 노력으로 더 <br>나은 나를 만들어봅시다!</div>
									</div>
								</div>
							</li>
							<li class="slideitem">
								<div class="study-item">
									<div class="taskset">
										<img src="img/groupimg.png" alt="스터디 이미지" class="study-image">

										<div class="tasks"><input type="checkbox" id="scales" name="scales" checked />과제 1	
										<div class="detail">수업 준비하기</div></div>
										<div class="tasks"><input type="checkbox" id="scales" name="scales" checked />과제 2	</div>
										<div class="quiz"><input type="checkbox" id="scales" name="scales" checked />퀴즈 1	</div>
										<div class="quiz"><input type="checkbox" id="scales" name="scales" checked />퀴즈 2	</div>
									</div>
									<div class="active-description">
										<div class="study-info">스터디 그룹명2</div>
										<div class="detail">꾸준한 노력으로 더 <br>나은 나를 만들어봅시다!</div>
									</div>
								</div>
							</li>
							<li class="slideitem">
								<div class="study-item">
									<div class="taskset">
										<img src="img/groupimg.png" alt="스터디 이미지" class="study-image">

										<div class="tasks"><input type="checkbox" id="scales" name="scales" checked />과제 1	
										<div class="detail">수업 준비하기</div></div>
										<div class="tasks"><input type="checkbox" id="scales" name="scales" checked />과제 2	</div>
										<div class="quiz"><input type="checkbox" id="scales" name="scales" checked />퀴즈 1	</div>
										<div class="quiz"><input type="checkbox" id="scales" name="scales" checked />퀴즈 2	</div>
									</div>
									<div class="active-description">
										<div class="study-info">스터디 그룹명3</div>
										<div class="detail">꾸준한 노력으로 더 <br>나은 나를 만들어봅시다!</div>
									</div>
								</div>
							</li>
							<li class="slideitem">
								<div class="study-item">
									<div class="taskset">
										<img src="img/groupimg.png" alt="스터디 이미지" class="study-image">

										<div class="tasks"><input type="checkbox" id="scales" name="scales" checked />과제 1	
										<div class="detail">수업 준비하기</div></div>
										<div class="tasks"><input type="checkbox" id="scales" name="scales" checked />과제 2	</div>
										<div class="quiz"><input type="checkbox" id="scales" name="scales" checked />퀴즈 1	</div>
										<div class="quiz"><input type="checkbox" id="scales" name="scales" checked />퀴즈 2	</div>
									</div>
									<div class="active-description">
										<div class="study-info">스터디 그룹명4</div>
										<div class="detail">꾸준한 노력으로 더 <br>나은 나를 만들어봅시다!</div>
									</div>
								</div>
							</li>
							<!-- 추가 스터디 아이템 -->
						</ul>
						<div class="slide-control">
							<div class="control01">
								<label for="slide04" class="prev"></label> <label for="slide02"
									class="next"></label>
							</div>
							<div class="control02">
								<label for="slide01" class="prev"></label> <label for="slide03"
									class="next"></label>
							</div>
							<div class="control03">
								<label for="slide02" class="prev"></label> <label for="slide04"
									class="next"></label>
							</div>
							<div class="control04">
								<label for="slide03" class="prev"></label> <label for="slide01"
									class="next"></label>
							</div>
						</div>
					</div>
				</div>
			</section>

			<!-- 추가 스터디 아이템 -->


			<!-- 새로운 스터디 -->
			<section class="new-study">
				<h2>&nbsp&nbsp&nbsp&nbsp새로운 스터디</h2>
				<div class="study-box">
					<div class="study-item">
						<img src="img/groupimg.png" alt="스터디 이미지" class="study-image">
						<div class="description">
							<div class="study-info">Spring 김영한 강의 스터디</div>
							<div class="details">강의 듣고 리뷰하면서 스터디 하실 분 구해요~~</div>
						</div>
					</div>
					<div class="study-item">
						<img src="img/groupimg.png" alt="스터디 이미지" class="study-image">
						<div class="description">
							<div class="study-info">코테 스터디</div>
							<div class="details">백준 플레 수준정도까지 코테스터디 하실분 (백준 골드5 이상)</div>
						</div>
					</div>
					<div class="study-item">
						<img src="img/groupimg.png" alt="스터디 이미지" class="study-image">
						<div class="description">
							<div class="study-info">우테코 준비 스터디</div>
							<div class="details">우테코우테코</div>
						</div>
					</div>
					<div class="study-item">
						<img src="img/groupimg.png" alt="스터디 이미지" class="study-image">
						<div class="description">
							<div class="study-info">무슨무슨 면접스터디</div>
							<div class="details">면접면접면접~~~~~~~~~~</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
	<script>
        let currentSlide = 0;
        const slides = document.querySelectorAll('.slide');
        const slideCount = slides.length;
 
        function showSlide(n) {
            slides.forEach(slide => slide.style.display = 'none');
            slides[n].style.display = 'block';
        }
 
        function nextSlide() {
            currentSlide = (currentSlide + 1) % slideCount;
            showSlide(currentSlide);
        }
 
        function prevSlide() {
            currentSlide = (currentSlide - 1 + slideCount) % slideCount;
            showSlide(currentSlide);
        }
 
        document.addEventListener('DOMContentLoaded', () => {
            showSlide(currentSlide);
            setInterval(nextSlide, 3000); // 3초마다 자동 슬라이드
        });
    </script>
</body>
</html>