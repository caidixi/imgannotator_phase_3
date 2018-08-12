package wnderful.imgannotator.publicData.response.baseResponse;

import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.DisplayDetailRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.baseVo.*;

public class DisplayDetailRep extends Response {
    private int code;
    private String message;
    private DisplayDetailVo data;

    public DisplayDetailRep(DisplayDetailRepCode resCode) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public DisplayDetailRep(DisplayDetailRepCode resCode,DisplayDetailVo data) {
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

    public DisplayDetailVo getData() {
        return data;
    }
}
