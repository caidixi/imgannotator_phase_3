package wnderful.imgannotator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wnderful.imgannotator.blserviceImpl.RankingListServiceImpl;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.request.rankingList.TypeRequest;


@RestController
@RequestMapping(value = "/service/rankingList")
public class RankingLIstController {
    private final RankingListServiceImpl rankingListService;

    @Autowired
    public RankingLIstController(RankingListServiceImpl rankingListService) {
        this.rankingListService = rankingListService;
    }

    @RequestMapping(value = "/task/{username}", method = RequestMethod.POST)
    public Response taskRankingList(@PathVariable("username")String username, @RequestBody TypeRequest request) {
        return rankingListService.getTaskRankingList(username,request.getType());
    }

    @RequestMapping(value = "/requester/{username}", method = RequestMethod.POST)
    public Response requesterRankingList(@PathVariable("username")String username, @RequestBody TypeRequest request) {
        return rankingListService.getRequesterRankingList(username,request.getType());
    }

    @RequestMapping(value = "/worker/{username}", method = RequestMethod.POST)
    public Response workerRankingList(@PathVariable("username")String username, @RequestBody TypeRequest request) {
        return rankingListService.getWorkerRankingList(username,request.getType());
    }


}
