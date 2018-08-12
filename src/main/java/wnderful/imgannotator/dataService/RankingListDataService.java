package wnderful.imgannotator.dataService;

import wnderful.imgannotator.vo.rankingListVo.TaskRankingListVo;
import wnderful.imgannotator.vo.rankingListVo.UserRankingListVo;

public interface RankingListDataService {
    TaskRankingListVo rankByImg();

    TaskRankingListVo rankByTotalPoints();

    TaskRankingListVo rankByReceiptPeople();

    TaskRankingListVo rankByAveragePoints();

    UserRankingListVo rankByRequesterPoints(String username);

    UserRankingListVo rankByReleaseTasks(String username);

    UserRankingListVo rankByCompleteTasks(String username);

    UserRankingListVo rankByWorkerPoints(String username);

    UserRankingListVo rankByCompleteImgs(String username);
}
