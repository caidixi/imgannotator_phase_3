package wnderful.imgannotator.publicData.reponseCode.rankingListResponseCode;

public enum RequesterRankingRepCode {
    SUCCESS(0,"查找发起者排行榜成功"),
    FAIL(1,"查找发起者排行榜失败"),
    NOFOUND(5,"用户不存在");

    private int code;
    private String message;

    RequesterRankingRepCode(int code, String message) {
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
