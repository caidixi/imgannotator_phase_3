package wnderful.imgannotator.publicData.response;

import wnderful.imgannotator.publicData.reponseCode.GlobalRepCode;

public class GlobalResponse extends Response {
    private int code;
    private String message;

    public GlobalResponse(GlobalRepCode repCode) {
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
