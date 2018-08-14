package wnderful.imgannotator.publicData.reponseCode.userResponseCode;

public enum AddPointsRepCode {
    POINTERROR(-1,"积分已经兑换，积分未充值成功，请联系系统管理员"),
    SUCCESS(0,"积分增加成功"),
    FAIL(1,"积分增加失败"),
    NOTFOUND(2,"用户不存在"),
    UNPROPER(3,"错误的积分充值码");

    private int code;
    private String message;

    AddPointsRepCode(int code, String message) {
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
