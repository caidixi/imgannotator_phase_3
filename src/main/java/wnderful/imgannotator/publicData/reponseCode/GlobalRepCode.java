package wnderful.imgannotator.publicData.reponseCode;

public enum  GlobalRepCode {
    WrongCode(-99,"充值异常：错误的充值码"),
    SERVERFAIL(-100,"服务器异常"),
    TOKENERROR(-101,"token错误"),
    WRITEERROE(-102,"数据库读写异常"),
    DATAERROE(-103,"数据库异常：Insert或Update数据时违反了完整性");


    private int code;
    private String message;

    GlobalRepCode(int code, String message) {
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
