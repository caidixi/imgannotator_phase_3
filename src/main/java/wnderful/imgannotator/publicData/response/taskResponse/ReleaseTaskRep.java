package wnderful.imgannotator.publicData.response.taskResponse;

import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.ReleaseTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;

public class ReleaseTaskRep extends Response {
    private int code;
    private String message;

    public ReleaseTaskRep(ReleaseTaskRepCode repCode) {
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
