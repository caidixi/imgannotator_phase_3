package wnderful.imgannotator.publicData.response.MarkResponse;

import wnderful.imgannotator.publicData.reponseCode.markResponseCode.SetMarkRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.baseVo.PointVo;

public class SetMarkRep extends Response {
    private int code;
    private String message;
    private PointVo data;

    public SetMarkRep(SetMarkRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public SetMarkRep(SetMarkRepCode repCode,PointVo data) {
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

    public PointVo getData() {
        return data;
    }
}
