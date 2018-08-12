package wnderful.imgannotator.publicData.response.MarkResponse;

import wnderful.imgannotator.publicData.reponseCode.markResponseCode.FindURLRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.markVo.ImgUrlVo;

public class FindURLRep extends Response {
    private int code;
    private String message;
    private ImgUrlVo data;

    public FindURLRep(FindURLRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public FindURLRep(FindURLRepCode repCode,ImgUrlVo data) {
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

    public ImgUrlVo getData() {
        return data;
    }
}
