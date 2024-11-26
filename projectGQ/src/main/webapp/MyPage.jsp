<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.domain.User" %>
<%@ page import="model.dao.UserDAO" %>

<%
    // 데이터베이스에서 사용자 정보 가져오기
    UserDAO userDAO = new UserDAO();
    String loggedInUserId = "test1"; // 로그인된 사용자 ID (임시로 설정)
    User user = userDAO.getUserByUserId(loggedInUserId); // 사용자 정보 가져오기
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mygroup.css" type="text/css">
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
                    <% if (user != null) { %>
                        <div class="name">이름: <span id="display-username"><%= user.getUsername() %></span></div>
                        <div class="phone">전화번호: <span id="display-phone"><%= user.getPhone() %></span></div>
                        <div class="email">이메일: <span id="display-email"><%= user.getEmail() %></span></div>
                    <% } else { %>
                        <div class="name">사용자 정보를 불러올 수 없습니다.</div>
                    <% } %>
                </div>
            </div>
            <div class="profile-actions">
                <button id="edit-btn">수정하기</button>
            </div>
        </section>

        <!-- 수정 폼 -->
        <div class="edit-profile" style="display:none;">
            <form id="update-form">
                <label for="username">이름:</label>
                <input type="text" name="username" id="username" value="<%= user != null ? user.getUsername() : "" %>" required><br>

                <label for="phone">전화번호:</label>
                <input type="text" name="phone" id="phone" value="<%= user != null ? user.getPhone() : "" %>" required><br>

                <label for="email">이메일:</label>
                <input type="email" name="email" id="email" value="<%= user != null ? user.getEmail() : "" %>" required><br>

                <button type="submit">저장</button>
                <button type="button" id="cancel-btn">취소</button>
            </form>
        </div>

        <!-- 참여 중인 스터디 -->
        <section class="active-study">
            <h2>참여 중인 스터디</h2>
            <div class="study-box">
                <div class="study-item">
                    <div class="study-category">프로그래밍</div>
                    <div class="study-info">백준</div>
                    <div class="details">코딩테스트 준비해요</div>
                    <div class="participants">3/8</div>
                </div>
            </div>

            <div class="study-box">
                <div class="study-item">
                    <div class="study-category">프로그래밍</div>
                    <div class="study-info">백준 챌린지</div>
                    <div class="details">같이 코딩테스트 공부해요~!</div>
                    <div class="participants">3/8</div>
                </div>
            </div>
        </section>
    </div>

    <script>
        // 수정 버튼 클릭 시 폼 보이기
        document.getElementById("edit-btn").addEventListener("click", function() {
            document.querySelector(".edit-profile").style.display = "block";
            document.querySelector(".profile-box").style.display = "none";
        });

        // 취소 버튼 클릭 시 폼 숨기기
        document.getElementById("cancel-btn").addEventListener("click", function() {
            document.querySelector(".edit-profile").style.display = "none";
            document.querySelector(".profile-box").style.display = "flex";
        });

        // 폼 제출 시 AJAX로 데이터 전송
        document.getElementById("update-form").addEventListener("submit", function(e) {
            e.preventDefault(); // 기본 폼 제출 방지

            const formData = new FormData(this);
            fetch("${pageContext.request.contextPath}/updateProfile", {
                method: "POST",
                body: formData
            })
            .then(response => {
                if (response.ok) {
                    return response.text();
                }
                throw new Error("네트워크 응답에 문제가 있습니다.");
            })
            .then(data => {
                // 성공 시 폼 숨기고 업데이트된 데이터 표시
                document.querySelector(".edit-profile").style.display = "none";
                document.querySelector(".profile-box").style.display = "flex";
                document.getElementById("display-username").textContent = formData.get("username");
                document.getElementById("display-phone").textContent = formData.get("phone");
                document.getElementById("display-email").textContent = formData.get("email");
            })
            .catch(error => console.error("에러 발생:", error));
        });
    </script>
</body>
</html>