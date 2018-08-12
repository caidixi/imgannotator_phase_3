package wnderful.imgannotator.publicData.reponseCode.markResponseCode;

public enum SkipImgRepCode {
    SUCCESS(0,"跳过图片成功"),
    FAIL(1,"跳过图片失败"),
    NOTFOUND(2,"无此工人"),
    NOTASK(3,"无此任务"),
    END(4,"任务已结束"),
    NOIMG(5,"无此图片"),
    NORECEIPT(5,"任务未接受");

    private int code;
    private String message;

    SkipImgRepCode(int code, String message) {
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
