package wnderful.imgannotator.publicData.reponseCode.taskResponseCode;

public enum DisplayRecommendedTaskRepCode {

    SUCCESS(0,"查询推荐任务成功"),
    FAIL(1,"查询推荐任务失败"),
    NOTFOUND(2,"无此工人");

    private int code;
    private String message;

    DisplayRecommendedTaskRepCode(int code, String message) {
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
