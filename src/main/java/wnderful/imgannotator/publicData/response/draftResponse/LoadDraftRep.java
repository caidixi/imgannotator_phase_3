package wnderful.imgannotator.publicData.response.draftResponse;

import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.DisplayDetailRepCode;
import wnderful.imgannotator.publicData.reponseCode.draftRepCode.LoadDraftRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.baseVo.DisplayDetailVo;
import wnderful.imgannotator.vo.taskVo.DraftVo;

public class LoadDraftRep extends Response {
    private int code;
    private String message;
    private DraftVo data;

    public LoadDraftRep(LoadDraftRepCode resCode) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public LoadDraftRep(LoadDraftRepCode resCode, DraftVo data) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
        this.data = data;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public DraftVo getData() {
        return data;
    }
}
