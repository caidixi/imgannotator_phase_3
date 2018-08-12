package wnderful.imgannotator.blserviceImpl;

import com.alibaba.fastjson.JSONObject;
import wnderful.imgannotator.blservice.MarkService;
import wnderful.imgannotator.dataServiceImpl.*;
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.*;
import wnderful.imgannotator.publicData.response.MarkResponse.*;
import wnderful.imgannotator.vo.baseVo.PointVo;
import wnderful.imgannotator.vo.markVo.ImgUrlVo;
import wnderful.imgannotator.vo.markVo.ImgUrlsVo;
import wnderful.imgannotator.vo.markVo.MarkVo;

public class MarkServiceImpl implements MarkService {

    private UserDataServiceImpl userDataService = new UserDataServiceImpl();
    private MarkDataServiceImpl markDataService = new MarkDataServiceImpl();
    private TaskDataServiceImpl taskDataService = new TaskDataServiceImpl();
    private ImgDataServiceImpl imgDataService = new ImgDataServiceImpl();
    private PointsDataServiceImpl pointsDataService = new PointsDataServiceImpl();

    @Override
    public SetMarkRep setMark(String username, String taskname, String imgID, JSONObject marks) {
        if (userDataService.workerExist(username)) {
            if (taskDataService.findProcess(taskname, username) >= 0) {
                if (!taskDataService.isEnd(taskname)) {
                    if (imgDataService.imgExist(taskname, imgID)) {
                        if (markDataService.addMark(username, taskname, imgID, marks)) {
                            PointVo vo = pointsDataService.getMarkReward(username, taskname, imgID);
                            if (vo != null) {
                                return new SetMarkRep(SetMarkRepCode.SUCCESS);
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
                    if (taskDataService.findProcess(taskname, username) >= 0) {
                        if (!taskDataService.isComplete(taskname, username)) {
                            ImgUrlVo vo = imgDataService.findAImgURL(taskname, username);
                            if (vo != null) {
                                return new FindURLRep(FindURLRepCode.SUCCESS, vo);
                            } else {
                                return new FindURLRep(FindURLRepCode.FAIL);
                            }
                        } else {
                            return new FindURLRep(FindURLRepCode.COMPLETE);
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
                            return new FindMarkRep(FindMarkRepCode.FAIL);
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
                    if (taskDataService.findProcess(taskname, username) >= 0) {
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