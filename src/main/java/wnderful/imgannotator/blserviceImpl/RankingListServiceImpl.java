package wnderful.imgannotator.blserviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.imgannotator.blservice.RankingListService;
import wnderful.imgannotator.dataServiceImpl.RankingListDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.UserDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.rankingListResponseCode.RequesterRankingRepCode;
import wnderful.imgannotator.publicData.reponseCode.rankingListResponseCode.TaskRankingRepCode;
import wnderful.imgannotator.publicData.reponseCode.rankingListResponseCode.WorkerRankingRepCode;
import wnderful.imgannotator.publicData.response.rankingListResponse.RequesterRankingRep;
import wnderful.imgannotator.publicData.response.rankingListResponse.TaskRankingRep;
import wnderful.imgannotator.publicData.response.rankingListResponse.WorkerRankingRep;

@Service
public class RankingListServiceImpl implements RankingListService {
    private UserDataServiceImpl userDataService;
    private RankingListDataServiceImpl rankingListDataService;

    @Autowired
    public RankingListServiceImpl(UserDataServiceImpl userDataService, RankingListDataServiceImpl rankingListDataService) {
        this.userDataService = userDataService;
        this.rankingListDataService = rankingListDataService;
    }

    @Override
    public TaskRankingRep getTaskRankingList(String username, String type) {
        if (userDataService.userExist(username)) {
            switch (type) {
                case "img":
                    return new TaskRankingRep(TaskRankingRepCode.SUCCESS, rankingListDataService.rankByImg());
                case "totalPoints":
                    return new TaskRankingRep(TaskRankingRepCode.SUCCESS, rankingListDataService.rankByTotalPoints());
                case "receiptPeople":
                    return new TaskRankingRep(TaskRankingRepCode.SUCCESS, rankingListDataService.rankByReceiptPeople());
                case "averagePoints":
                    return new TaskRankingRep(TaskRankingRepCode.SUCCESS, rankingListDataService.rankByAveragePoints());
                default:
                    return new TaskRankingRep(TaskRankingRepCode.FAIL);
            }
        } else {
            return new TaskRankingRep(TaskRankingRepCode.NOFOUND);
        }
    }

    @Override
    public RequesterRankingRep getRequesterRankingList(String username, String type) {
        if(userDataService.userExist(username)){
            switch (type) {
                case "points":
                    return new RequesterRankingRep(RequesterRankingRepCode.SUCCESS,rankingListDataService.rankByRequesterPoints(username));
                case "releaseTasks":
                    return new RequesterRankingRep(RequesterRankingRepCode.SUCCESS,rankingListDataService.rankByReleaseTasks(username));
                    default:
                        return new RequesterRankingRep(RequesterRankingRepCode.FAIL);

            }
        }else {
            return new RequesterRankingRep(RequesterRankingRepCode.NOFOUND);
        }
    }

    @Override
    public WorkerRankingRep getWorkerRankingList(String username, String type) {
        if(userDataService.userExist(username)){
            switch (type) {
                case "points":
                    return new WorkerRankingRep(WorkerRankingRepCode.SUCCESS,rankingListDataService.rankByWorkerPoints(username));
                case "completeTasks":
                    return new WorkerRankingRep(WorkerRankingRepCode.SUCCESS,rankingListDataService.rankByCompleteTasks(username));
                case "completeImgs":
                    return new WorkerRankingRep(WorkerRankingRepCode.SUCCESS,rankingListDataService.rankByCompleteImgs(username));
                    default:
                        return new WorkerRankingRep(WorkerRankingRepCode.FAIL);
            }
        }else {
            return new WorkerRankingRep(WorkerRankingRepCode.NOFOUND);
        }
    }
}
