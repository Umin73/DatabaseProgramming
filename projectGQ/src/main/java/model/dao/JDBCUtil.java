package model.dao;

import java.sql.*;

public class JDBCUtil {
    private static ConnectionManager connMan = new ConnectionManager();  
    private String sql = null;              // 실행할 query
    private Object[] parameters = null;    // PreparedStatement 의 매개변수 값을 저장하는 배열
    private static Connection conn = null;
    private PreparedStatement pstmt = null;
    private CallableStatement cstmt = null;
    private ResultSet rs = null;
    private int resultSetType = ResultSet.TYPE_FORWARD_ONLY,
                resultSetConcurrency = ResultSet.CONCUR_READ_ONLY;

    // 기본 생성자
    public JDBCUtil() { }

    // 데이터베이스 연결 반환
    public static Connection getConnection() {
        try {
            String DB_URL = "jdbc:oracle:thin:@dblab.dongduk.ac.kr:1521/orclpdb"; // 변경 가능한 DB URL
            String DB_USER = "dbp240102"; // DB 사용자
            String DB_PASSWORD = "73841"; // DB 비밀번호

            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("데이터베이스 연결 실패");
        }
    }

    // sql 변수 getter
    public String getSql() {
        return this.sql;
    }

    // 매개변수 배열에서 특정위치의 매개변수를 반환하는 메소드
    private Object getParameter(int index) throws Exception {
        if (index >= getParameterSize())
            throw new Exception("INDEX 값이 파라미터의 갯수보다 많습니다.");
        return parameters[index];
    }

    // 매개변수의 개수를 반환하는 메소드
    private int getParameterSize() {
        return parameters == null ? 0 : parameters.length;
    }

    // sql 및 Object[] 변수 setter
    public void setSqlAndParameters(String sql, Object[] parameters) {
        this.sql = sql;
        this.parameters = parameters;
        this.resultSetType = ResultSet.TYPE_FORWARD_ONLY;
        this.resultSetConcurrency = ResultSet.CONCUR_READ_ONLY;
    }

    // sql 및 Object[], resultSetType, resultSetConcurrency 변수 setter
    public void setSqlAndParameters(String sql, Object[] parameters, int resultSetType, int resultSetConcurrency) {
        this.sql = sql;
        this.parameters = parameters;
        this.resultSetType = resultSetType;
        this.resultSetConcurrency = resultSetConcurrency;
    }

    // 현재의  PreparedStatement를 반환
    private PreparedStatement getPreparedStatement() throws SQLException {
        if (conn == null) {
            conn = getConnection();
            conn.setAutoCommit(false);
        }
        if (pstmt != null) pstmt.close();
        pstmt = conn.prepareStatement(sql, resultSetType, resultSetConcurrency);
        return pstmt;
    }

    // JDBCUtil의 쿼리와 매개변수를 이용해  executeQuery를 수행하는 메소드
    public ResultSet executeQuery() {
        try {
            pstmt = getPreparedStatement();
            for (int i = 0; i < getParameterSize(); i++) {
                pstmt.setObject(i + 1, getParameter(i));
            }
            rs = pstmt.executeQuery();
            return rs;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // JDBCUtil의 쿼리와 매개변수를 이용해 executeUpdate를 수행하는 메소드
    public int executeUpdate() throws SQLException, Exception {
        pstmt = getPreparedStatement();
        int parameterSize = getParameterSize();
        for (int i = 0; i < parameterSize; i++) {
            if (getParameter(i) == null) {
                pstmt.setString(i + 1, null);
            } else {
                pstmt.setObject(i + 1, getParameter(i));
            }
        }
        return pstmt.executeUpdate();
    }

    // 현재의  CallableStatement를 반환
    private CallableStatement getCallableStatement() throws SQLException {
        if (conn == null) {
            conn = getConnection();
            conn.setAutoCommit(false);
        }
        if (cstmt != null) cstmt.close();
        cstmt = conn.prepareCall(sql);
        return cstmt;
    }

    // 자원 반환
    public void close() {
        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
                pstmt = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (cstmt != null) {
            try {
                cstmt.close();
                cstmt = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void commit() {
        try {
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void rollback() {
        try {
            conn.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
