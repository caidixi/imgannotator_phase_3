package wnderful.imgannotator.vo.baseVo;

import java.io.Serializable;

public class LoginVo implements Serializable {
    private String token = "";
    private String role = "";

    public LoginVo() {
    }

    public LoginVo(String token, String role) {
        this.token = token;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public String getRole() {
        return role;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
