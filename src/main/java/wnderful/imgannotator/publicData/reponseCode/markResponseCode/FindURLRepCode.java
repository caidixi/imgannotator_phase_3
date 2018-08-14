package wnderful.imgannotator.publicData.reponseCode.markResponseCode;

public enum FindURLRepCode {
    ENDERROE(-2,"任务已完成，任务结束错误"),
    POINTERROE(-1,"任务已完成，任务已结束，任务奖励发放失败"),
    SUCCESS(0,"查找图片成功"),
    FAIL(1,"查找图片失败"),
    COMPLETE(2,"任务已完成,任务奖励已发放"),
    NOTFOUND(3,"无此工人"),
    NOTASK(4,"任务未接受"),
    END(5,"任务已结束"),
    NOTEXIST(6,"任务不存在"),
    COMPLETENOTEND6(7,"任务已完成，尚未结束，奖励待发放");


    private int code;
    private String message;

    FindURLRepCode(int code, String message) {
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
