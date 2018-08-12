package wnderful.imgannotator.publicData.reponseCode.baseResponseCode;

public enum DisplayAllTaskRepCode {
    SUCCESS(0,"查看全部任务成功");

    private int code;
    private String message;

    DisplayAllTaskRepCode(int code, String message) {
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
