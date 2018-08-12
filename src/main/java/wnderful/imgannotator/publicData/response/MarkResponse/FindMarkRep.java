package wnderful.imgannotator.publicData.response.MarkResponse;

import wnderful.imgannotator.publicData.reponseCode.markResponseCode.FindMarkRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.markVo.MarkVo;

public class FindMarkRep extends Response {
    private int code;
    private String message;
    private MarkVo data;

    public FindMarkRep(FindMarkRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public FindMarkRep(FindMarkRepCode repCode,MarkVo data) {
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

    public MarkVo getData() {
        return data;
    }
}
