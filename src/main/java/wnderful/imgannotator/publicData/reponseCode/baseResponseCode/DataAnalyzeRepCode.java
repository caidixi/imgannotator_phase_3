package wnderful.imgannotator.publicData.reponseCode.baseResponseCode;

public enum DataAnalyzeRepCode {
    SUCCESS(0,"查看跳过率方差与均值成功"),
    FAIL(1,"查看跳过率方差与均值失败");

    private int code;
    private String message;

    DataAnalyzeRepCode(int code, String message) {
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
