package wnderful.imgannotator.publicData.response.MarkResponse;

import wnderful.imgannotator.publicData.reponseCode.markResponseCode.FindURLRepCode;
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.SkipImgRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.markVo.ImgUrlVo;

public class SkipImgRep extends Response {
    private int code;
    private String message;

    public SkipImgRep(SkipImgRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
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
