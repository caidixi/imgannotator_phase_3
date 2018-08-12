package wnderful.imgannotator.publicData.reponseCode.userResponseCode;

public enum GetCodeRepCode {
    SUCCESS(0,"积分充值码获取成功"),
    FAIL(1,"积分充值码获取失败"),
    NOTFOUND(2,"找不到管理员"),
    WRONGDATA(3,"格式错误");

    private int code;
    private String message;

    GetCodeRepCode(int code, String message) {
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
