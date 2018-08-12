package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum ModifyTaskRepCode {

    POINTSERROR(-1,"修改任务成功,积分未扣除"),
    SUCCESS(0,"修改任务成功"),
    FAIL(1,"修改任务失败"),
    NOTFOUND(2,"无此发布者"),
    NOTASK(3,"无发布任务"),
    NORIGHT(4,"无修改权限"),
    WRONGTIME(5,"任务剩余时间至少为1"),
    NOPOINTS(6,"积分不足"),
    WRONGMAXWORKER(7,"工人数只能增加");

    private int code;
    private String message;

    ModifyTaskRepCode(int code, String message) {
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
