package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum DisplayUncompletedTaskRepCode {

    SUCCESS(0,"查询待完成任务成功"),
    FAIL(1,"查询待完成任务失败"),
    NOTFOUND(2,"无此工人");

    private int code;
    private String message;

    DisplayUncompletedTaskRepCode(int code, String message) {
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
