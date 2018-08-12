package wnderful.imgannotator.publicData.reponseCode.draftRepCode;

public enum SaveDraftRepCode {
    SUCCESS(0,"保存任务草稿成功"),
    FAIL(1,"保存任务草稿失败"),
    NOTASK(2,"未找到任务草稿"),
    NOFOUND(3,"未找到发布者"),
    WRONGDATA(4,"错误的数据");

    private int code;
    private String message;

    SaveDraftRepCode(int code, String message) {
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
