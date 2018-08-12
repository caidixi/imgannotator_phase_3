package wnderful.imgannotator.publicData.reponseCode.userResponseCode;

public enum  LostPointsRepCode {
    SUCCESS(0,"积分扣除成功"),
    FAIL(1,"积分扣除失败"),
    NOTFOUND(2,"用户不存在"),
    UNPROPER(3,"扣除积分格式错误");


    private int code;
    private String message;

    LostPointsRepCode(int code, String message) {
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
