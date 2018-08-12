package wnderful.imgannotator.publicData.response.ImgResponse;

import wnderful.imgannotator.publicData.reponseCode.ImgResponseCode.UploadRepCode;
import wnderful.imgannotator.publicData.response.Response;

public class UploadRep extends Response {
    private int code;
    private String message;

    public UploadRep(UploadRepCode repCode) {
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
