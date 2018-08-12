package wnderful.imgannotator.publicData.reponseCode.markResponseCode;

public enum FindURLRepCode {
    SUCCESS(0,"查找图片成功"),
    FAIL(1,"查找图片失败"),
    COMPLETE(2,"任务已完成"),
    NOTFOUND(3,"无此工人"),
    NOTASK(4,"任务未接受"),
    END(5,"任务已结束"),
    NOTEXIST(6,"任务不存在");


    private int code;
    private String message;

    FindURLRepCode(int code, String message) {
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
