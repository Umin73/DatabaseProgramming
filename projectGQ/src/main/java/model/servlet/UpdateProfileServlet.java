package model.servlet;

import model.dao.UserDAO;
import model.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateProfile") // URL 매핑 설정
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 폼 데이터 수집
        String userId = "test1"; // 로그인된 사용자의 ID (임시로 설정)
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        // 데이터베이스 업데이트
        UserDAO userDAO = new UserDAO();
        User user = new User(userId, null, username, email, phone); // 비밀번호는 null 처리
        int result = userDAO.updateUser(user);

        // 결과 확인 및 리디렉션
        if (result > 0) {
        	response.sendRedirect(request.getContextPath() + "/mypage.jsp"); // 성공 시 마이페이지로 이동
        } else {
            response.getWriter().write("업데이트 실패. 다시 시도해주세요.");
        }
    }
}