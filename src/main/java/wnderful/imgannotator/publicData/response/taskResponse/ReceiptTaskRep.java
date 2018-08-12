package wnderful.imgannotator.publicData.response.taskResponse;

import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.ReceiptTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;

public class ReceiptTaskRep extends Response {
    private int code;
    private String message;

    public ReceiptTaskRep(ReceiptTaskRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
