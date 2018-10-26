package wnderful.imgannotator.publicData.response.baseResponse;

import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.DataAnalyzeRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.baseVo.DataAnalyzeVo;

public class DataAnalyzeRep extends Response {
    private int code;
    private String message;
    private DataAnalyzeVo data;

    public DataAnalyzeRep(DataAnalyzeRepCode resCode) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public DataAnalyzeRep(DataAnalyzeRepCode repCode, DataAnalyzeVo data) {
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

    public DataAnalyzeVo getData() {
        return data;
    }
}
