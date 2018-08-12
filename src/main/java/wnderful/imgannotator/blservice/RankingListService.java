package wnderful.imgannotator.blservice;

import wnderful.imgannotator.publicData.response.Response;

public interface RankingListService {
    Response getTaskRankingList(String username,String type);

    Response getWorkerRankingList(String username,String type);

    Response getRequesterRankingList(String username,String type);
}
