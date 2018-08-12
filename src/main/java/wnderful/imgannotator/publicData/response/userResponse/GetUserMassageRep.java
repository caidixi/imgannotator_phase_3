package wnderful.imgannotator.publicData.response.userResponse;

import wnderful.imgannotator.publicData.reponseCode.userResponseCode.GetUserMassageRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.userVo.RequesterMessageVo;
import wnderful.imgannotator.vo.userVo.UserMessageVo;
import wnderful.imgannotator.vo.userVo.WorkerMessageVo;

public class GetUserMassageRep extends Response {
    private int code;
    private String message;
    private UserMessageVo data;

    public GetUserMassageRep(GetUserMassageRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public GetUserMassageRep(GetUserMassageRepCode repCode, WorkerMessageVo data) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
        this.data = data;
    }
    public GetUserMassageRep(GetUserMassageRepCode repCode,RequesterMessageVo data) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public UserMessageVo getData() {
        return data;
    }
}
