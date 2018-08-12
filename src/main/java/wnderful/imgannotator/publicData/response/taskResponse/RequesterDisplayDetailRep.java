package wnderful.imgannotator.publicData.response.taskResponse;

import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.DisplayDetailRepCode;
import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.RequesterDisplayDetailRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.baseVo.DisplayDetailVo;
import wnderful.imgannotator.vo.taskVo.RequesterDisplayDetailVo;

public class RequesterDisplayDetailRep extends Response {
    private int code;
    private String message;
    private RequesterDisplayDetailVo data;

    public RequesterDisplayDetailRep(RequesterDisplayDetailRepCode resCode) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public RequesterDisplayDetailRep(RequesterDisplayDetailRepCode resCode, RequesterDisplayDetailVo data) {
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

    public RequesterDisplayDetailVo getData() {
        return data;
    }
}
