package wnderful.imgannotator.publicData.response.userResponse;

import wnderful.imgannotator.publicData.reponseCode.userResponseCode.UpdateUserMessageRepCode;
import wnderful.imgannotator.publicData.response.Response;

public class UpdateUserMessageRep extends Response {
    private int code;
    private String message;

    public UpdateUserMessageRep(UpdateUserMessageRepCode repCode) {
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
