package wnderful.imgannotator.publicData.reponseCode.userResponseCode;

public enum AddTagRepCode {
    SUCCESS(0,"增加标记成功"),
    FAIL(1,"增加标记失败"),
    EXIST(2,"标记已存在"),
    NOTFOUND(3,"找不到该管理员");


    private int code;
    private String message;

    AddTagRepCode(int code, String message) {
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
