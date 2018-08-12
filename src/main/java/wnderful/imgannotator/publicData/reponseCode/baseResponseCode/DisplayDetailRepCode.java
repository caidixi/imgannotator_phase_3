package wnderful.imgannotator.publicData.reponseCode.baseResponseCode;

public enum DisplayDetailRepCode {
    SUCCESS(0,"查看任务详情成功"),
    FAIL(1,"查看任务详情失败"),
    NOTASK(2,"未找到任务");

    private int code;
    private String message;

    DisplayDetailRepCode(int code, String message) {
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
