package wnderful.imgannotator.publicData.response.baseResponse;

import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.SearchTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.taskVo.DisplayTaskVo;

public class SearchTaskRep extends Response {
    private int code;
    private String message;
    private DisplayTaskVo data;

    public SearchTaskRep(SearchTaskRepCode resCode) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public SearchTaskRep(SearchTaskRepCode resCode, DisplayTaskVo data) {
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

    public DisplayTaskVo getData() {
        return data;
    }
}
