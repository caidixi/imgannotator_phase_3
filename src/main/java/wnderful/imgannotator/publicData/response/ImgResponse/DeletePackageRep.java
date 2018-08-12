package wnderful.imgannotator.publicData.response.ImgResponse;

import wnderful.imgannotator.publicData.reponseCode.ImgResponseCode.DeletePackageRepCode;
import wnderful.imgannotator.publicData.response.Response;

public class DeletePackageRep extends Response {
    private int code;
    private String message;

    public DeletePackageRep(DeletePackageRepCode repCode) {
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
