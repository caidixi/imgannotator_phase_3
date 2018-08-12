package wnderful.imgannotator.vo.rankingListVo;

import wnderful.imgannotator.vo.rankingListVo.simpleVo.SimpleTaskVo;

public class TaskRankingListVo {
    private SimpleTaskVo[] rankingList;

    public TaskRankingListVo(SimpleTaskVo[] rankingList) {
        this.rankingList = rankingList;
    }

    public TaskRankingListVo() {
    }

    public SimpleTaskVo[] getRankingList() {
        return rankingList;
    }

    public void setRankingList(SimpleTaskVo[] rankingList) {
        this.rankingList = rankingList;
    }
}
