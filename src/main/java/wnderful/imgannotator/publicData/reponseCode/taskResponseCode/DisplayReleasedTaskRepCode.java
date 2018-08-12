package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum DisplayReleasedTaskRepCode {

    SUCCESS(0,"查看已发布任务成功"),
    FAIL(1,"查看已发布任务失败"),
    NOTFOUND(2,"无此发布者");

    private int code;
    private String message;

    DisplayReleasedTaskRepCode(int code, String message) {
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
