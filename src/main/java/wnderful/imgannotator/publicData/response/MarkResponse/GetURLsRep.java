package wnderful.imgannotator.publicData.response.MarkResponse;

import wnderful.imgannotator.publicData.reponseCode.markResponseCode.GetURLsRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.markVo.ImgUrlsVo;

public class GetURLsRep extends Response {
    private int code;
    private String message;
    private ImgUrlsVo data;

    public GetURLsRep(GetURLsRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public GetURLsRep(GetURLsRepCode repCode,ImgUrlsVo data) {
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

    public ImgUrlsVo getData() {
        return data;
    }
}
