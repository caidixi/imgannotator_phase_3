package wnderful.imgannotator.publicData.response.userResponse;

import wnderful.imgannotator.publicData.reponseCode.userResponseCode.GetUserInformationRepCode;
import wnderful.imgannotator.publicData.reponseCode.userResponseCode.GetUserMassageRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.userVo.AllUserMessagesVo;
import wnderful.imgannotator.vo.userVo.RequesterMessageVo;
import wnderful.imgannotator.vo.userVo.UserMessageVo;
import wnderful.imgannotator.vo.userVo.WorkerMessageVo;

public class GetUserInformationRep extends Response {
    private int code;
    private String message;
    private AllUserMessagesVo data;

    public GetUserInformationRep(GetUserInformationRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public GetUserInformationRep(GetUserInformationRepCode repCode, AllUserMessagesVo data) {
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

    public AllUserMessagesVo getData() {
        return data;
    }
}
