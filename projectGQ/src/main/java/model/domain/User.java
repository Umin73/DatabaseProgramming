package model.domain;

public class User {
    private String userId; // 사용자 ID
    private String password; // 비밀번호
    private String username; // 이름
    private String email; // 이메일
    private String phone; // 전화번호

    // 생성자
    public User(String userId, String password, String username, String email, String phone) {
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    // Getter와 Setter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", password=" + password + ", username=" + username
                + ", email=" + email + ", phone=" + phone + "]";
    }
}
