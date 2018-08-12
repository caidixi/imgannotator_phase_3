package wnderful.imgannotator.publicData.response.baseResponse;

import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.DisplayAllTagRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.baseVo.TagsVo;

public class DisplayAllTagRep extends Response {
    private int code;
    private String message;
    private TagsVo data;

    public DisplayAllTagRep(DisplayAllTagRepCode resCode) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public DisplayAllTagRep(DisplayAllTagRepCode repCode, TagsVo data) {
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

    public TagsVo getData() {
        return data;
    }
}
