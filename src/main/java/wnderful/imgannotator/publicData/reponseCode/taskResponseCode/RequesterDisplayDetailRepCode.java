package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum RequesterDisplayDetailRepCode {
    SUCCESS(0,"查看任务详情成功"),
    FAIL(1,"查看任务详情失败"),
    NOTASK(2,"未找到任务"),
    NOTFOUND(3,"未找到发起者"),
    WRONGREQUEESTER(4,"无查看权限");

    private int code;
    private String message;

    RequesterDisplayDetailRepCode(int code, String message) {
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
