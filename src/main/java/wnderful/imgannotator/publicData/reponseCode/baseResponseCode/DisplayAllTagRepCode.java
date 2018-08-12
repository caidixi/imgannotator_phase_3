package wnderful.imgannotator.publicData.reponseCode.baseResponseCode;

public enum DisplayAllTagRepCode {
    SUCCESS(0,"查看全部标签成功");

    private int code;
    private String message;

    DisplayAllTagRepCode(int code, String message) {
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
