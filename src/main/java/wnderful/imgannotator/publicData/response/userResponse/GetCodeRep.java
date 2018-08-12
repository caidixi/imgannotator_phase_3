package wnderful.imgannotator.publicData.response.userResponse;

import wnderful.imgannotator.publicData.reponseCode.userResponseCode.GetCodeRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.userVo.CodeVo;

public class GetCodeRep extends Response {
    private int code;
    private String message;
    private CodeVo data;

    public GetCodeRep(GetCodeRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public GetCodeRep(GetCodeRepCode repCode,CodeVo data) {
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

    public CodeVo getData() {
        return data;
    }
}
