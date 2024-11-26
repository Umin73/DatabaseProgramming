package model.dao;

import model.domain.StudyGroup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudyGroupDAO {

    // STUDYGROUP 테이블의 모든 데이터를 가져오는 메서드
    public List<StudyGroup> getAllStudyGroups() {
        List<StudyGroup> studyGroups = new ArrayList<>();
        String sql = "SELECT GROUP_ID, GROUPNAME, GROUPDESCRIPTION, CATEGORY, MAXMEMBER FROM STUDYGROUP";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                StudyGroup studyGroup = new StudyGroup(
                    rs.getLong("GROUP_ID"),               // groupId
                    rs.getString("GROUPNAME"),           // groupName
                    rs.getString("GROUPDESCRIPTION"),    // groupDescription
                    null,                                // goal
                    rs.getInt("MAXMEMBER"),              // maxMembers
                    rs.getString("CATEGORY"),           // category
                    null,                                // leader
                    null,                                // members
                    null,                                // schedules
                    null,                                // assignments
                    null                                 // announcements
                );
                studyGroups.add(studyGroup);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studyGroups;
    }
}
