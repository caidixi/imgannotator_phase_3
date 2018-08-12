package wnderful.imgannotator.publicData.reponseCode.draftRepCode;

public enum DeleteDraftRepCode {
    SUCCESS(0,"删除任务草稿成功"),
    FAIL(1,"删除任务草稿失败"),
    NOTASK(2,"未找到任务草稿"),
    NOFOUND(3,"未找到发布者"),
    WRONGREQUESTER(4,"无删除权限");

    private int code;
    private String message;

    DeleteDraftRepCode(int code, String message) {
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
