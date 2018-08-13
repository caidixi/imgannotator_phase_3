package wnderful.imgannotator.blserviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.imgannotator.blservice.RequesterTaskService;
import wnderful.imgannotator.dataServiceImpl.*;
import wnderful.imgannotator.publicData.reponseCode.draftRepCode.DeleteDraftRepCode;
import wnderful.imgannotator.publicData.reponseCode.draftRepCode.DisplayDraftRepCode;
import wnderful.imgannotator.publicData.reponseCode.draftRepCode.LoadDraftRepCode;
import wnderful.imgannotator.publicData.reponseCode.draftRepCode.SaveDraftRepCode;
import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.*;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.draftResponse.DeleteDraftRep;
import wnderful.imgannotator.publicData.response.draftResponse.DisplayDraftRep;
import wnderful.imgannotator.publicData.response.draftResponse.LoadDraftRep;
import wnderful.imgannotator.publicData.response.draftResponse.SaveDraftRep;
import wnderful.imgannotator.publicData.response.taskResponse.*;
import wnderful.imgannotator.vo.taskVo.*;

@Service
public class RequesterTaskServiceImpl implements RequesterTaskService {

    private UserDataServiceImpl userDataService;
    private TaskDataServiceImpl taskDataService;
    private ImgDataServiceImpl imgDataService;
    private DraftDataServiceImpl draftDataService;
    private PointsDataServiceImpl pointsDataService;

    @Autowired
    public RequesterTaskServiceImpl(UserDataServiceImpl userDataService, TaskDataServiceImpl taskDataService,
                                    ImgDataServiceImpl imgDataService, DraftDataServiceImpl draftDataService, PointsDataServiceImpl pointsDataService) {
        this.userDataService = userDataService;
        this.taskDataService = taskDataService;
        this.imgDataService = imgDataService;
        this.draftDataService = draftDataService;
        this.pointsDataService = pointsDataService;
    }

    @Override
    public ReleaseTaskRep releaseTask(String username, String taskname) {
        if(userDataService.requesterExist(username)){
            if(draftDataService.draftExist(taskname)){
                if(draftDataService.isSave(taskname,username)){
                    int imgNum = imgDataService.findTaskImgNum(taskname);
                    if(imgNum>0){
                        DraftVo vo = draftDataService.findDraft(taskname);
                        int points = userDataService.findUserPoints(username,"requester");
                        int lostPoints = points-imgNum*vo.getCredits();
                        if(points-lostPoints>=0){
                            if(draftDataService.newTask(taskname)){
                                if(pointsDataService.modifyPoints(-lostPoints,username,userDataService.findUserRole(username))){
                                    return new ReleaseTaskRep(ReleaseTaskRepCode.SUCCESS);
                                }else {
                                    return new ReleaseTaskRep(ReleaseTaskRepCode.ALREADYUPLOAD);
                                }
                            }else {
                                return new ReleaseTaskRep(ReleaseTaskRepCode.FAIL);
                            }
                        }else {
                            return new ReleaseTaskRep(ReleaseTaskRepCode.NOPOINT);
                        }
                    }else {
                        return new ReleaseTaskRep(ReleaseTaskRepCode.NOIMG);
                    }
                }else {
                    return new ReleaseTaskRep(ReleaseTaskRepCode.WRONGREQUESTER);
                }
            }else {
                return new ReleaseTaskRep(ReleaseTaskRepCode.NODRAFT);
            }
        }else {
            return new ReleaseTaskRep(ReleaseTaskRepCode.NOTFOUND);
        }
    }

    @Override
    public RequesterDisplayDetailRep displayDetail(String username, String taskname) {
        if(userDataService.requesterExist(username)){
            if(taskDataService.exist(taskname)){
                if(taskDataService.isRelease(taskname,username)){
                    RequesterDisplayDetailVo vo = taskDataService.requesterFindTaskDetail(taskname);
                    if(vo!=null){
                        return new RequesterDisplayDetailRep(RequesterDisplayDetailRepCode.SUCCESS,vo);
                    }else {
                        return new RequesterDisplayDetailRep(RequesterDisplayDetailRepCode.FAIL);
                    }
                }else {
                    return new RequesterDisplayDetailRep(RequesterDisplayDetailRepCode.WRONGREQUEESTER);
                }
            }else {
                return new RequesterDisplayDetailRep(RequesterDisplayDetailRepCode.NOTASK);
            }
        }else {
            return new RequesterDisplayDetailRep(RequesterDisplayDetailRepCode.NOTFOUND);
        }
    }

    @Override
    public DeleteTaskRep deleteTask(String username, String taskname) {
        if (userDataService.requesterExist(username)) {
            if(taskDataService.exist(taskname)){
                if(taskDataService.isRelease(taskname,username)){
                    if(!taskDataService.isEnd(taskname)){
                        if (taskDataService.endTask(taskname)) {
                            if(pointsDataService.settleTaskPoints(taskname)){
                                return new DeleteTaskRep(DeleteTaskRepCode.SUCCESS);
                            }else {
                                return  new DeleteTaskRep(DeleteTaskRepCode.POINTERROR);
                            }
                        } else {
                            return new DeleteTaskRep(DeleteTaskRepCode.FAIL);
                        }
                    }else {
                        return new DeleteTaskRep((DeleteTaskRepCode.HASEND));
                    }
                }else {
                    return new DeleteTaskRep(DeleteTaskRepCode.WRONGREQ);
                }
            }else {
                return new DeleteTaskRep(DeleteTaskRepCode.NOTASK);
            }
        } else {
            return new DeleteTaskRep(DeleteTaskRepCode.NOTFOUND);
        }
    }

    @Override
    public DisplayReleasedTaskRep displayReleasedTask(String username) {
        if (userDataService.requesterExist(username)) {
            DisplayTaskVo vo = taskDataService.findReleasedTask(username);
            if(vo!=null){
                return new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.SUCCESS,vo);
            }else {
                return new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.SUCCESS);
            }
        } else {
            return new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.NOTFOUND);
        }
    }

    @Override
    public LoadDraftRep loadDraft(String username, String taskname) {
        if(userDataService.requesterExist(username)){
            if(draftDataService.draftExist(taskname)){
                if(draftDataService.isSave(taskname,username)){
                    DraftVo vo = draftDataService.findDraft(taskname);
                    if(vo !=null){
                        return new LoadDraftRep(LoadDraftRepCode.SUCCESS,vo);
                    }else {
                        return new LoadDraftRep(LoadDraftRepCode.FAIL);
                    }
                }else {
                    return new LoadDraftRep(LoadDraftRepCode.WRONGREQUESTER);
                }
            }else {
                return new LoadDraftRep(LoadDraftRepCode.NOTASK);
            }
        }else {
            return new LoadDraftRep(LoadDraftRepCode.NOFOUND);
        }
    }

    @Override
    public Response saveDraft(String username, String taskname, String taskDescription, int markTimes, String[] taskTag, int credits, String taskType) {
        if(userDataService.requesterExist(username)){
            if(draftDataService.draftExist(taskname)){
                if(markTimes>0){
                    if(draftDataService.saveDraft(taskname,taskDescription,markTimes,taskTag,credits,taskType)){
                        return new SaveDraftRep(SaveDraftRepCode.SUCCESS);
                    }else {
                        return new SaveDraftRep(SaveDraftRepCode.FAIL);
                    }
                }else {
                    return new SaveDraftRep(SaveDraftRepCode.WRONGDATA);
                }
            }else {
                return new SaveDraftRep(SaveDraftRepCode.NOTASK);
            }
        }else {
            return new SaveDraftRep(SaveDraftRepCode.NOFOUND);
        }
    }

    @Override
    public DeleteDraftRep deleteDraft(String username, String taskname) {
        if(userDataService.requesterExist(username)){
            if(draftDataService.draftExist(taskname)){
                if(draftDataService.isSave(taskname,username)){
                    if(draftDataService.deleteDraft(taskname)){
                        return new DeleteDraftRep(DeleteDraftRepCode.SUCCESS);
                    }else {
                        return new DeleteDraftRep(DeleteDraftRepCode.FAIL);
                    }
                }else {
                    return new DeleteDraftRep(DeleteDraftRepCode.WRONGREQUESTER);
                }
            }else {
                return new DeleteDraftRep(DeleteDraftRepCode.NOTASK);
            }
        }else {
            return new DeleteDraftRep(DeleteDraftRepCode.NOFOUND);
        }
    }

    @Override
    public Response displayDraft(String username) {
        if(userDataService.requesterExist(username)){
            TasknamesVo vo = draftDataService.findAllDraft(username);
            if(vo!=null){
                return new DisplayDraftRep(DisplayDraftRepCode.SUCCESS,vo);
            }else {
                return new DisplayDraftRep(DisplayDraftRepCode.SUCCESS);
            }
        }else {
            return new DisplayDraftRep(DisplayDraftRepCode.NOFOUND);
        }
    }

}
