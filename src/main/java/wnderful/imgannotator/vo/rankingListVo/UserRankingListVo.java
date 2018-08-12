package wnderful.imgannotator.vo.rankingListVo;

import wnderful.imgannotator.vo.rankingListVo.simpleVo.SimpleUserVo;

public class UserRankingListVo {
    private SimpleUserVo[] rankingList;

    public UserRankingListVo(SimpleUserVo[] rankingList) {
        this.rankingList = rankingList;
    }

    public UserRankingListVo() {
    }

    public SimpleUserVo[] getRankingList() {
        return rankingList;
    }

    public void setRankingList(SimpleUserVo[] rankingList) {
        this.rankingList = rankingList;
    }
}
