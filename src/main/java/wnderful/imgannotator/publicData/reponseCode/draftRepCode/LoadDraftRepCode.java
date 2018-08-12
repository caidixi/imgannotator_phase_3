package wnderful.imgannotator.publicData.reponseCode.draftRepCode;

public enum LoadDraftRepCode {
    SUCCESS(0,"加载任务草稿成功"),
    FAIL(1,"加载任务草稿失败"),
    NOTASK(2,"未找到任务草稿"),
    NOFOUND(3,"未找到发布者"),
    WRONGREQUESTER(4,"无查看权限");

    private int code;
    private String message;

    LoadDraftRepCode(int code, String message) {
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
