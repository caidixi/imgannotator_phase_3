package wnderful.imgannotator.publicData.reponseCode.baseResponseCode;

public enum SearchTaskRepCode {
    SUCCESS(0,"搜索任务成功"),
    FAIL(1,"搜索任务失败"),
    NOTYPE(2,"搜索类型不能为空"),
    NOCONTENT(2,"搜索内容不能为空");



    private int code;
    private String message;

    SearchTaskRepCode(int code, String message) {
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
