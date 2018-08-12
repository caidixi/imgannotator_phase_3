package wnderful.imgannotator.publicData.reponseCode.userResponseCode;

public enum DeleteTagRepCode {
    SUCCESS(0,"删除标记成功"),
    FAIL(1,"删除标记失败"),
    NOTAG(2,"找不到标记"),
    NOTFOUND(3,"找不到该管理员");


    private int code;
    private String message;

    DeleteTagRepCode(int code, String message) {
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
