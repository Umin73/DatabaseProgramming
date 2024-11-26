package model.dao;

import model.domain.User;
import java.sql.*;

public class UserDAO {

    // 사용자 ID로 사용자 정보 조회
    public User getUserByUserId(String userId) {
        String sql = "SELECT USER_ID, PASSWORD, USERNAME, EMAIL, PHONE FROM USERS WHERE USER_ID = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getString("USER_ID"),
                        rs.getString("PASSWORD"),
                        rs.getString("USERNAME"),
                        rs.getString("EMAIL"),
                        rs.getString("PHONE")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 사용자 삽입
    public int insertUser(User user) {
        String sql = "INSERT INTO USERS (USER_ID, PASSWORD, USERNAME, EMAIL, PHONE) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPhone());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

 // 사용자 업데이트
    public int updateUser(User user) {
        String sql = "UPDATE USERS SET USERNAME = ?, EMAIL = ?, PHONE = ? WHERE USER_ID = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getUserId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 사용자 삭제
    public int deleteUser(String userId) {
        String sql = "DELETE FROM USERS WHERE USER_ID = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
