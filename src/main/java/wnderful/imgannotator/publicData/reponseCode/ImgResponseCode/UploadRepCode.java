package wnderful.imgannotator.publicData.reponseCode.ImgResponseCode;

public enum UploadRepCode {
    SUCCESS(0,"图片上传成功"),
    FAIL(1,"图片上传失败"),
    REPEAT(2,"图片重名"),
    NOFOLDER(3,"无任务文件夹"),
    BADFORMAT(4,"错误的文件格式");

    private int code;
    private String message;

    UploadRepCode(int code, String message) {
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
