package wnderful.imgannotator.publicData.response.draftResponse;

import wnderful.imgannotator.publicData.reponseCode.draftRepCode.SaveDraftRepCode;
import wnderful.imgannotator.publicData.response.Response;

public class SaveDraftRep extends Response {
    private int code;
    private String message;

    public SaveDraftRep(SaveDraftRepCode resCode) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
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
