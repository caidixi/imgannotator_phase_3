package wnderful.imgannotator.publicData.reponseCode.ImgResponseCode;

public enum  DeletePackageRepCode {
    SUCCESS(0,"图片文件夹删除成功"),
    FAIL(1,"图片文件夹删除失败");

    private int code;
    private String message;

    DeletePackageRepCode(int code, String message) {
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
