package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum DeleteTaskRepCode {

    SUCCESS(0,"结束任务成功"),
    FAIL(1,"结束任务失败"),
    NOTFOUND(2,"无此发布者"),
    NOTASK(3,"无发布任务"),
    WRONGREQ(4,"无此操作权限"),
    HASEND(5,"任务已经结束"),
    POINTERROR(6,"任务结束成功，积分结算出错"),
    DATAERROR(7,"数据读取错误");

    private int code;
    private String message;

    DeleteTaskRepCode(int code, String message) {
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
