package wnderful.imgannotator.publicData.response.taskResponse;

import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.ReceiptTaskRewardRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.baseVo.PointVo;

public class ReceiptTaskRewardRep extends Response {
    private int code;
    private String message;
    private PointVo data;

    public ReceiptTaskRewardRep(ReceiptTaskRewardRepCode resCode) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public ReceiptTaskRewardRep(ReceiptTaskRewardRepCode resCode, PointVo data) {
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

    public PointVo getData() {
        return data;
    }
}
