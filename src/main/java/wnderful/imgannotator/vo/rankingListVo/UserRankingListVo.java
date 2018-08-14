package wnderful.imgannotator.vo.rankingListVo;

public class UserRankingListVo {
    private SimpleVo[] rankingList;
    private int yourRank;

    public UserRankingListVo(SimpleVo[] rankingList, int yourRank) {
        this.rankingList = rankingList;
        this.yourRank = yourRank;
    }

    public UserRankingListVo(SimpleVo[] rankingList) {
        this.rankingList = rankingList;
    }

    public UserRankingListVo() {
    }

    public SimpleVo[] getRankingList() {
        return rankingList;
    }

    public void setRankingList(SimpleVo[] rankingList) {
        this.rankingList = rankingList;
    }


    public int getYourRank() {
        return yourRank;
    }

    public void setYourRank(int yourRank) {
        this.yourRank = yourRank;
    }
}
