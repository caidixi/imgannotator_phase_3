package wnderful.imgannotator.publicData.response.draftResponse;

import wnderful.imgannotator.publicData.reponseCode.draftRepCode.DisplayDraftRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.taskVo.TasknamesVo;

public class DisplayDraftRep extends Response {
    private int code;
    private String message;
    private TasknamesVo data;

    public DisplayDraftRep(DisplayDraftRepCode resCode) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public DisplayDraftRep(DisplayDraftRepCode resCode, TasknamesVo data) {
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

    public TasknamesVo getData() {
        return data;
    }
}
