package wnderful.imgannotator.publicData.reponseCode.baseResponseCode;

public enum SignUpRepCode {
    SUCCESS(0,"注册成功"),
    FAIL(1,"注册失败"),
    NAMEREPEAT(2,"用户名重复"),
    EMPTYNAME(3,"用户名不能为空"),
    EMPTYPASSWORD(4,"密码不能为空"),
    EMPTYEMAIL(5,"邮箱不能为空");


    private int code;
    private String message;

    SignUpRepCode(int code, String message) {
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
