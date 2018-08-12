package wnderful.imgannotator.publicData.reponseCode.userResponseCode;

public enum UpdateUserMessageRepCode {
    SUCCESS(0,"更新用户信息成功"),
    FAIL(1,"更新用户信息失败"),
    NOTFOUND(2,"该用户不存在"),
    REPEAT(3,"密码重复"),
    WRONGPASSWORD(4,"原密码错误"),
    WRONGDATA(5,"错误数据格式");


    private int code;
    private String message;

    UpdateUserMessageRepCode(int code, String message) {
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
