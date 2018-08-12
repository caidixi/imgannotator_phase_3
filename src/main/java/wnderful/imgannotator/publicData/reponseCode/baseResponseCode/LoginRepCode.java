package wnderful.imgannotator.publicData.reponseCode.baseResponseCode;

public enum LoginRepCode {

    SUCCESS(0,"登陆成功"),
    FAIL(1,"登录失败"),
    EMPTYNAME(2,"用户名不能为空"),
    EMPTYPASSWORD(3,"密码不能为空"),
    NOTEXIST(4,"用户不存在"),
    WRONGPASSWORD(5,"密码不正确");

    private int code;
    private String message;

    LoginRepCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
