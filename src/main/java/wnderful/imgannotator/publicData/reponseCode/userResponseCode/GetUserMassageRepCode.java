package wnderful.imgannotator.publicData.reponseCode.userResponseCode;

public enum GetUserMassageRepCode {

    SUCCESS(0,"获取用户信息成功"),
    FAIL(1,"获取用户信息失败"),
    NOTFOUND(2,"该用户不存在");

    private int code;
    private String message;

    GetUserMassageRepCode(int code, String message) {
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
