package wnderful.imgannotator.dataServiceImpl;

import org.springframework.stereotype.Service;
import wnderful.imgannotator.dataService.RankingListDataService;
import wnderful.imgannotator.vo.rankingListVo.TaskRankingListVo;
import wnderful.imgannotator.vo.rankingListVo.UserRankingListVo;

@Service
public class RankingListDataServiceImpl implements RankingListDataService {

    @Override
    public TaskRankingListVo rankByImg() {
        return null;
    }

    @Override
    public TaskRankingListVo rankByTotalPoints() {
        return null;
    }

    @Override
    public TaskRankingListVo rankByReceiptPeople() {
        return null;
    }

    @Override
    public TaskRankingListVo rankByAveragePoints() {
        return null;
    }

    @Override
    public UserRankingListVo rankByRequesterPoints(String username) {
        return null;
    }

    @Override
    public UserRankingListVo rankByReleaseTasks(String username) {
        return null;
    }

    @Override
    public UserRankingListVo rankByCompleteTasks(String username) {
        return null;
    }

    @Override
    public UserRankingListVo rankByWorkerPoints(String username) {
        return null;
    }

    @Override
    public UserRankingListVo rankByCompleteImgs(String username) {
        return null;
    }
}
