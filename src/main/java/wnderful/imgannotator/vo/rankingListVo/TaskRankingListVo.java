package wnderful.imgannotator.vo.rankingListVo;


public class TaskRankingListVo {
    private SimpleVo[] rankingList;

    public TaskRankingListVo(SimpleVo[] rankingList) {
        this.rankingList = rankingList;
    }

    public TaskRankingListVo() {
    }

    public SimpleVo[] getRankingList() {
        return rankingList;
    }

    public void setRankingList(SimpleVo[] rankingList) {
        this.rankingList = rankingList;
    }
}
