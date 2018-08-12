package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum WorkerDisplayDetailRepCode {
    SUCCESS(0,"查看任务详情成功"),
    FAIL(1,"查看任务详情失败"),
    NOTASK(2,"未找到任务"),
    NOTFOUND(3,"未找到工人"),
    NORECEIPT(4,"未接受该任务");

    private int code;
    private String message;

    WorkerDisplayDetailRepCode(int code, String message) {
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
