package model.dao;

import model.domain.StudyGroup;
import model.dao.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupMemberDAO {
	

    /**
     * 특정 사용자가 속한 그룹 정보를 가져오는 메서드
     *
     * @param userId 사용자의 ID
     * @return 사용자가 속한 그룹 리스트
     * @throws SQLException 데이터베이스 처리 중 발생한 예외
     */
    public List<StudyGroup> getUserGroups(String userId) throws SQLException {
        List<StudyGroup> userGroups = new ArrayList<>();
        String sql = "SELECT g.GROUP_ID, g.GROUPNAME, g.GROUPDESCRIPTION, g.GOAL, g.MAXMEMBER " +
                     "FROM STUDYGROUP g " +
                     "JOIN GROUPMEMBER gm ON g.GROUP_ID = gm.GROUP_ID " +
                     "WHERE gm.USER_ID = ?";



        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    StudyGroup group = new StudyGroup();
                    group.setGroupId(rs.getString("GROUP_ID")); // String 타입으로 처리
                    group.setGroupName(rs.getString("GROUPNAME"));
                    group.setGroupDescription(rs.getString("GROUPDESCRIPTION"));
                    group.setGoal(rs.getString("GOAL"));
                    group.setMaxMembers(rs.getInt("MAXMEMBER"));
                    userGroups.add(group);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // 예외를 호출한 쪽으로 전달
        }

        return userGroups;
    }
}
