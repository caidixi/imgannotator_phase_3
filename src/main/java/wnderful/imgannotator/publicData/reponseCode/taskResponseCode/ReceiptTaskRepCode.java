package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum ReceiptTaskRepCode {

    SUCCESS(0,"接受任务成功"),
    FAIL(1,"接受任务失败"),
    NOTFOUND(2,"无此工人"),
    NOTASK(3,"无此任务"),
    FULL(4,"任务已满额"),
    HASRECEIPT(5,"任务已接受"),
    END(6,"任务已结束");

    private int code;
    private String message;

    ReceiptTaskRepCode(int code, String message) {
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
