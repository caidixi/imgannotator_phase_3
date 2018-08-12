package wnderful.imgannotator.publicData.response.baseResponse;

import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.LoginRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.baseVo.LoginVo;

public class LoginRep extends Response {
    private int code;
    private String message;
    private LoginVo data;

    public LoginRep(LoginRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }


    public LoginRep(LoginRepCode repCode,LoginVo data) {
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

    public LoginVo getData() {
        return data;
    }


}
