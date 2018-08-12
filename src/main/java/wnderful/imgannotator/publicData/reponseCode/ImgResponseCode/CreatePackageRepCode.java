package wnderful.imgannotator.publicData.reponseCode.ImgResponseCode;

public enum  CreatePackageRepCode {
    SUCCESS(0,"图片文件夹创建成功"),
    FAIL(1,"图片文件夹创建失败"),
    NOTFOUND(2,"用户不存在"),
    EMPTYTASKNAME(3,"任务名不能为空"),
    REPEAT(4,"文件夹重名");

    private int code;
    private String message;

    CreatePackageRepCode(int code, String message) {
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
