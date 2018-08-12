package wnderful.imgannotator.publicData.response.taskResponse;

import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.WorkerDisplayDetailRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.taskVo.WorkerDisplayDetailVo;

public class WorkerDisplayDetailRep extends Response {
    private int code;
    private String message;
    private WorkerDisplayDetailVo data;

    public WorkerDisplayDetailRep(WorkerDisplayDetailRepCode resCode) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public WorkerDisplayDetailRep(WorkerDisplayDetailRepCode resCode, WorkerDisplayDetailVo data) {
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

    public WorkerDisplayDetailVo getData() {
        return data;
    }
}
