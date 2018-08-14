package wnderful.imgannotator.blserviceImpl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.imgannotator.blservice.MarkService;
import wnderful.imgannotator.dataServiceImpl.*;
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.*;
import wnderful.imgannotator.publicData.response.MarkResponse.*;
import wnderful.imgannotator.vo.baseVo.PointVo;
import wnderful.imgannotator.vo.markVo.ImgUrlVo;
import wnderful.imgannotator.vo.markVo.ImgUrlsVo;
import wnderful.imgannotator.vo.markVo.MarkVo;

@Service
public class MarkServiceImpl implements MarkService {

    private UserDataServiceImpl userDataService;
    private MarkDataServiceImpl markDataService;
    private TaskDataServiceImpl taskDataService;
    private ImgDataServiceImpl imgDataService;
    private PointsDataServiceImpl pointsDataService;

    @Autowired
    public MarkServiceImpl(UserDataServiceImpl userDataService, MarkDataServiceImpl markDataService, TaskDataServiceImpl taskDataService,
                           ImgDataServiceImpl imgDataService, PointsDataServiceImpl pointsDataService) {
        this.userDataService = userDataService;
        this.markDataService = markDataService;
        this.taskDataService = taskDataService;
        this.imgDataService = imgDataService;
        this.pointsDataService = pointsDataService;
    }

    @Override
    public SetMarkRep setMark(String username, String taskname, String imgID, JSONObject marks) {
        if (userDataService.workerExist(username)) {
            if (taskDataService.isReceipt(taskname, username)) {
                if (!taskDataService.isEnd(taskname)) {
                    if (imgDataService.imgExist(taskname, imgID)) {
                        PointVo vo = imgDataService.getMarkReward(username, taskname, imgID);
                        if (vo != null) {
                            if (markDataService.addMark(username, taskname, imgID, marks)) {
                                return new SetMarkRep(SetMarkRepCode.SUCCESS, vo);
                            } else {
                                return new SetMarkRep(SetMarkRepCode.GETPOINTFAIL);
                            }
                        } else {
                            return new SetMarkRep(SetMarkRepCode.FAIL);
                        }
                    } else {
                        return new SetMarkRep(SetMarkRepCode.NOIMG);
                    }
                } else {
                    return new SetMarkRep(SetMarkRepCode.END);
                }
            } else {
                return new SetMarkRep(SetMarkRepCode.NOTASK);
            }
        } else {
            return new SetMarkRep(SetMarkRepCode.NOTFOUND);
        }
    }

    @Override
    public FindURLRep findURL(String username, String taskname) {
        if (userDataService.workerExist(username)) {
            if (taskDataService.exist(taskname)) {
                if (!taskDataService.isEnd(taskname)) {
                    if (taskDataService.isReceipt(taskname, username)) {
                        if (!imgDataService.taskIsCompleted(taskname, username)) {
                            ImgUrlVo vo = imgDataService.findAImgURL(taskname, username);
                            if (vo != null) {
                                return new FindURLRep(FindURLRepCode.SUCCESS, vo);
                            } else {
                                return new FindURLRep(FindURLRepCode.FAIL);
                            }
                        } else {
                            taskDataService.completeTask(taskname, username);
                            if (taskDataService.isFinished(taskname)) {
                                if (taskDataService.endTask(taskname)) {
                                    if (pointsDataService.settleTaskPoints(taskname)) {
                                        return new FindURLRep(FindURLRepCode.COMPLETE);
                                    }else {
                                        return new FindURLRep(FindURLRepCode.POINTERROE);
                                    }
                                }else {
                                    return new FindURLRep(FindURLRepCode.ENDERROE);
                                }
                            }else {
                                return new FindURLRep(FindURLRepCode.COMPLETENOTEND6);
                            }
                        }
                    } else {
                        return new FindURLRep(FindURLRepCode.NOTASK);
                    }
                } else {
                    return new FindURLRep(FindURLRepCode.END);
                }
            } else {
                return new FindURLRep(FindURLRepCode.NOTEXIST);
            }
        } else {
            return new FindURLRep(FindURLRepCode.NOTFOUND);
        }
    }

    @Override
    public GetURLsRep getURLs(String username, String taskname) {
        if (userDataService.requesterExist(username)) {
            if (taskDataService.exist(taskname)) {
                if (taskDataService.isRelease(taskname, username)) {
                    ImgUrlsVo vo = imgDataService.findImgURLs(taskname);
                    if (vo != null) {
                        return new GetURLsRep(GetURLsRepCode.SUCCESS, vo);
                    } else {
                        return new GetURLsRep(GetURLsRepCode.FAIL);
                    }
                } else {
                    return new GetURLsRep(GetURLsRepCode.NOALLOW);
                }
            } else {
                return new GetURLsRep(GetURLsRepCode.NOTASK);
            }
        } else {
            return new GetURLsRep(GetURLsRepCode.NOTFOUND);
        }
    }

    @Override
    public FindMarkRep findMark(String taskname, String imgID, String username) {
        if (userDataService.requesterExist(username)) {
            if (taskDataService.exist(taskname)) {
                if (taskDataService.isRelease(taskname, username)) {
                    if (imgDataService.imgExist(taskname, imgID)) {
                        MarkVo vo = markDataService.findAllMark(taskname, imgID);
                        if (vo != null) {
                            return new FindMarkRep(FindMarkRepCode.SUCCESS, vo);
                        } else {
                            return new FindMarkRep(FindMarkRepCode.SUCCESS);
                        }
                    } else {
                        return new FindMarkRep(FindMarkRepCode.NOIMG);
                    }
                } else {
                    return new FindMarkRep(FindMarkRepCode.NOTALLOW);
                }
            } else {
                return new FindMarkRep(FindMarkRepCode.NOTASK);
            }
        } else {
            return new FindMarkRep(FindMarkRepCode.NOTFOUND);
        }
    }

    @Override
    public SkipImgRep skipImg(String taskname, String imgID, String username) {
        if (userDataService.workerExist(username)) {
            if (taskDataService.exist(taskname)) {
                if (taskDataService.isEnd(taskname)) {
                    if (taskDataService.isReceipt(taskname, username)) {
                        if (imgDataService.imgExist(taskname, imgID)) {
                            if (imgDataService.skipImg(username, taskname, imgID)) {
                                return new SkipImgRep(SkipImgRepCode.SUCCESS);
                            } else {
                                return new SkipImgRep(SkipImgRepCode.FAIL);
                            }
                        } else {
                            return new SkipImgRep(SkipImgRepCode.NOIMG);
                        }
                    } else {
                        return new SkipImgRep(SkipImgRepCode.NORECEIPT);
                    }
                } else {
                    return new SkipImgRep(SkipImgRepCode.END);
                }
            } else {
                return new SkipImgRep(SkipImgRepCode.NOTASK);
            }
        } else {
            return new SkipImgRep(SkipImgRepCode.NOTFOUND);
        }
    }
}