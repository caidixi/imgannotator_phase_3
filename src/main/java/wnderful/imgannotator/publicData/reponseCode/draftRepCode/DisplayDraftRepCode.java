package wnderful.imgannotator.publicData.reponseCode.draftRepCode;

public enum DisplayDraftRepCode {
    SUCCESS(0,"加载草稿列表成功"),
    FAIL(1,"加载草稿列表失败"),
    NOFOUND(3,"未找到发布者");

    private int code;
    private String message;

    DisplayDraftRepCode(int code, String message) {
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
