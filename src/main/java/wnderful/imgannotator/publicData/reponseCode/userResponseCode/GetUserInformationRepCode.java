package wnderful.imgannotator.publicData.reponseCode.userResponseCode;

public enum GetUserInformationRepCode {

    SUCCESS(0,"获取用户信息成功"),
    FAIL(1,"获取用户信息失败"),
    NOTFOUND(2,"找不到该管理员");

    private int code;
    private String message;

    GetUserInformationRepCode(int code, String message) {
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
