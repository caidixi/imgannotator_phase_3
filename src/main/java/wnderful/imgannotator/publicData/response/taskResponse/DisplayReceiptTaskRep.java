package wnderful.imgannotator.publicData.response.taskResponse;

import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.DisplayReceiptedTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.taskVo.DisplayTaskVo;

public class DisplayReceiptTaskRep extends Response {
    private int code;
    private String message;
    private DisplayTaskVo data;

    public DisplayReceiptTaskRep(DisplayReceiptedTaskRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public DisplayReceiptTaskRep(DisplayReceiptedTaskRepCode repCode, DisplayTaskVo data) {
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

    public DisplayTaskVo getData() {
        return data;
    }
}
