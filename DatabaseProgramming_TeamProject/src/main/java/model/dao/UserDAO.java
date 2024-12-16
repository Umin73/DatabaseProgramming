package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.domain.User;

public class UserDAO {
    private JDBCUtil jdbcUtil = null;

    
    public UserDAO() {
        jdbcUtil = new JDBCUtil();
    }

    // 사용자 ID로 사용자 정보 조회
    public User getUserByUserId(String userId) {
        String sql = "SELECT USER_ID, PASSWORD, USERNAME, EMAIL, PHONE FROM USERS WHERE USER_ID = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                    	null,
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
    public int createUser(User user) throws SQLException {
        String sql = "INSERT INTO USERINFO (userId, password, username, phone, email) VALUES (?, ?, ?, ?, ?)";
        Object[] param = new Object[] {
                user.getUserId(), user.getPassword(), user.getUsername(), user.getPhone(), user.getEmail()};
        jdbcUtil.setSqlAndParameters(sql, param);
        
        try {               
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();
        }       
        return 0;   
    }
    
    public int updateUser(User user) throws SQLException {
        String sql = "UPDATE USERS SET password = ?, username = ?, phone = ?, email = ? WHERE userId = ?";
        try (Connection conn = new ConnectionManager().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false); // 트랜잭션 시작
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getUserId());
            int result = pstmt.executeUpdate();
            conn.commit(); // 커밋
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
    
    public int deleteUser(String userId) throws SQLException {
        String sql = "DELETE FROM USERINFO WHERE userId=?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});
        
        try {               
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }       
        return 0;
    }
    
    public User findUserById(String userId) throws SQLException {
        String sql = "SELECT password, username, phone, email FROM USERINFO WHERE userId=?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});
            
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if (rs.next()) {
                User user = new User(
                        rs.getLong("id"),
                        userId,
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("email"),
                        rs.getString("phone"));
                return user;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }
    
    public List<User> findAllUser() throws SQLException {
        String sql = "SELECT userId, password, username, email, phone " 
                   + "FROM USERINFO "
                   + "ORDER BY id";
        jdbcUtil.setSqlAndParameters(sql, null);
                    
        try {
            ResultSet rs = jdbcUtil.executeQuery();      
            List<User> userList = new ArrayList<User>();
            while (rs.next()) {
                User user = new User(
                    rs.getLong("id"),
                    rs.getString("userId"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone")); 
                userList.add(user);
            }       
            return userList;                    
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }
    
    public User loginUser(String userId, String password) throws SQLException {
        String sql = "SELECT id, username, phone, email FROM USERINFO WHERE userId=? AND password=?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId, password});

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getLong("id"),
                        userId,
                        password,
                        rs.getString("username"),
                        rs.getString("phone"),
                        rs.getString("email"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }
    
    
    
    public boolean existingUser(String userId) throws SQLException {
        String sql = "SELECT count(*) FROM USERINFO WHERE userId=?";      
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return (count == 1 ? true : false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return false;
    }
}