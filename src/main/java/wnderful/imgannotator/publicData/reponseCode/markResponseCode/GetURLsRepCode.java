package wnderful.imgannotator.publicData.reponseCode.markResponseCode;

public enum  GetURLsRepCode {
    SUCCESS(0,"获取图片成功"),
    FAIL(1,"获取图片失败"),
    NOTFOUND(2,"无此发布者"),
    NOTASK(3,"未找到该任务"),
    NOALLOW(4,"无查看权限");

    private int code;
    private String message;

    GetURLsRepCode(int code, String message) {
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
