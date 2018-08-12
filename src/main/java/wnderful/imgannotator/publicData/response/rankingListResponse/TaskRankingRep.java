package wnderful.imgannotator.publicData.response.rankingListResponse;

import wnderful.imgannotator.publicData.reponseCode.rankingListResponseCode.TaskRankingRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.rankingListVo.TaskRankingListVo;

public class TaskRankingRep extends Response {
    private int code;
    private String message;
    private TaskRankingListVo data;

    public TaskRankingRep(TaskRankingRepCode repCode) {
        this.code = repCode.getCode();
        this.message = repCode.getMessage();
    }

    public TaskRankingRep(TaskRankingRepCode repCode,TaskRankingListVo data) {
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

    public TaskRankingListVo getData() {
        return data;
    }
}
