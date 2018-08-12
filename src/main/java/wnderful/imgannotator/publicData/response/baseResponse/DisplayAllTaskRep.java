package wnderful.imgannotator.publicData.response.baseResponse;

import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.DisplayAllTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.taskVo.DisplayTaskVo;

public class DisplayAllTaskRep extends Response {
    private int code;
    private String message;
    private DisplayTaskVo data;

    public DisplayAllTaskRep(DisplayAllTaskRepCode resCode) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public DisplayAllTaskRep(DisplayAllTaskRepCode repCode,DisplayTaskVo data) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
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

    public DisplayTaskVo getData() {
        return data;
    }
}
