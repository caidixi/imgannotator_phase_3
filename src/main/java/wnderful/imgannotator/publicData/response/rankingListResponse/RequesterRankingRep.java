package wnderful.imgannotator.publicData.response.rankingListResponse;

import wnderful.imgannotator.publicData.reponseCode.rankingListResponseCode.RequesterRankingRepCode;
import wnderful.imgannotator.publicData.reponseCode.rankingListResponseCode.WorkerRankingRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.rankingListVo.UserRankingListVo;

public class RequesterRankingRep extends Response {
    private int code;
    private String message;
    private UserRankingListVo data;

    public RequesterRankingRep(RequesterRankingRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public RequesterRankingRep(RequesterRankingRepCode repCode, UserRankingListVo data) {
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

    public UserRankingListVo getData() {
        return data;
    }
}
