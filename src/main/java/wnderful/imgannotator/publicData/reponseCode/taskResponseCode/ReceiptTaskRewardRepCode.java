package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum ReceiptTaskRewardRepCode {
    SUCCESS(0,"领取任务啊奖励成功"),
    FAIL(1,"领取任务奖励失败"),
    NOREWARD(2,"无可领取任务奖励"),
    NOTFOUND(3,"未找到工人");

    private int code;
    private String message;

    ReceiptTaskRewardRepCode(int code, String message) {
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
