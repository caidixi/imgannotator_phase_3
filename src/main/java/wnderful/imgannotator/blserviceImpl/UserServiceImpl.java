package wnderful.imgannotator.blserviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.imgannotator.blservice.UserService;
import wnderful.imgannotator.dataServiceImpl.PointsDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.TagDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.UserDataServiceImpl;
import wnderful.imgannotator.exception.RechargeException;
import wnderful.imgannotator.publicData.reponseCode.userResponseCode.*;
import wnderful.imgannotator.publicData.response.userResponse.*;
import wnderful.imgannotator.vo.baseVo.PointVo;
import wnderful.imgannotator.vo.userVo.AllUserMessagesVo;
import wnderful.imgannotator.vo.userVo.CodeVo;
import wnderful.imgannotator.vo.userVo.RequesterMessageVo;
import wnderful.imgannotator.vo.userVo.WorkerMessageVo;

@Service
public class UserServiceImpl implements UserService {
    private UserDataServiceImpl userDataService;
    private PointsDataServiceImpl pointsDataService;
    private TagDataServiceImpl tagDataService;

    @Autowired
    public UserServiceImpl(UserDataServiceImpl userDataService, PointsDataServiceImpl pointsDataService, TagDataServiceImpl tagDataService) {
        this.userDataService = userDataService;
        this.pointsDataService = pointsDataService;
        this.tagDataService = tagDataService;
    }

    @Override
    public GetUserMassageRep getUserMessage(String username, String role) {
        switch (role) {
            case "requester":
                RequesterMessageVo requester = userDataService.findRequester(username);
                if (requester != null) {
                    return new GetUserMassageRep(GetUserMassageRepCode.SUCCESS, requester);
                } else {
                    return new GetUserMassageRep(GetUserMassageRepCode.NOTFOUND);
                }
            case "worker":
                WorkerMessageVo worker = userDataService.findWorker(username);
                if (worker != null) {
                    return new GetUserMassageRep(GetUserMassageRepCode.SUCCESS, worker);
                } else {
                    return new GetUserMassageRep(GetUserMassageRepCode.NOTFOUND);
                }
            default:
                return new GetUserMassageRep(GetUserMassageRepCode.NOTFOUND);
        }
    }

    @Override
    public UpdateUserMessageRep updateUserMessage(String username, String newEmail, String oldPassword, String newPassword, String role) {
        if (userDataService.userExist(username)) {
            String password = userDataService.findUserPassword(username);
            if (password!=null&&password.equals(oldPassword)) {
                if ((!newEmail.equals("")) || (!newPassword.equals(""))) {
                    switch(role){
                        case "worker":
                            if(userDataService.setWorkerMessage(username,newEmail,newPassword)){
                                return new UpdateUserMessageRep(UpdateUserMessageRepCode.SUCCESS);
                            }
                        case"requester":
                            if(userDataService.setRequesterMessage(username,newEmail,newPassword)){
                                return new UpdateUserMessageRep(UpdateUserMessageRepCode.SUCCESS);
                            }
                            default:
                                return new UpdateUserMessageRep(UpdateUserMessageRepCode.FAIL);
                    }
                } else {
                    return new UpdateUserMessageRep(UpdateUserMessageRepCode.WRONGDATA);
                }
            } else {
                return new UpdateUserMessageRep(UpdateUserMessageRepCode.WRONGPASSWORD);
            }
        } else {
            return new UpdateUserMessageRep(UpdateUserMessageRepCode.NOTFOUND);
        }
    }

    @Override
    public AddPointsRep addPoints(String username, String code){
        if (userDataService.userExist(username)) {
            PointVo vo = pointsDataService.codeToPoints(code);
            if (vo!=null) {
                if (pointsDataService.modifyPoints(vo.getPoints(), username,userDataService.findUserRole(username))) {
                    return new AddPointsRep(AddPointsRepCode.SUCCESS);
                } else {
                    return new AddPointsRep(AddPointsRepCode.POINTERROR);
                }
            } else {
                return new AddPointsRep(AddPointsRepCode.UNPROPER);
            }
        } else {
            return new AddPointsRep(AddPointsRepCode.NOTFOUND);
        }
    }

    @Override
    public LostPointsRep lostPoints(String username, int points) {
        if (userDataService.userExist(username)) {
            if (points > 0) {
                CodeVo vo = pointsDataService.pointsToCode(points);
                if(vo!=null){
                    if (pointsDataService.modifyPoints(-points, username,userDataService.findUserRole(username))) {
                        return new LostPointsRep(LostPointsRepCode.SUCCESS,vo);
                    } else {
                        return new LostPointsRep(LostPointsRepCode.FAIL);
                    }
                }else {
                    return new LostPointsRep(LostPointsRepCode.UNPROPER);
                }
            } else {
                return new LostPointsRep(LostPointsRepCode.UNPROPER);
            }
        } else {
            return new LostPointsRep(LostPointsRepCode.NOTFOUND);
        }
    }

    @Override
    public GetUserInformationRep getWorkerInformation(String username) {
        if(userDataService.administratorExist(username)){
            AllUserMessagesVo vo = userDataService.findAllWorker();
            if(vo!=null){
                return new GetUserInformationRep(GetUserInformationRepCode.SUCCESS,vo);
            }else {
                return new GetUserInformationRep(GetUserInformationRepCode.FAIL);
            }
        }else {
            return new GetUserInformationRep(GetUserInformationRepCode.NOTFOUND);
        }
    }

    @Override
    public GetUserInformationRep getRequesterInformation(String username) {
        if(userDataService.administratorExist(username)){
            AllUserMessagesVo vo = userDataService.findAllRequester();
            if(vo!=null){
                return new GetUserInformationRep(GetUserInformationRepCode.SUCCESS,vo);
            }else {
                return new GetUserInformationRep(GetUserInformationRepCode.FAIL);
            }
        }else {
            return new GetUserInformationRep(GetUserInformationRepCode.NOTFOUND);
        }
    }

    @Override
    public GetCodeRep getCode(String username, int points) {
        if(userDataService.administratorExist(username)){
            if(points>0){
                CodeVo vo = pointsDataService.pointsToCode(points);
                if(vo!=null){
                    return new GetCodeRep(GetCodeRepCode.SUCCESS,vo);
                }else {
                    return new GetCodeRep(GetCodeRepCode.FAIL);
                }
            }else {
                return new GetCodeRep(GetCodeRepCode.WRONGDATA);
            }
        }else {
            return new GetCodeRep(GetCodeRepCode.NOTFOUND);
        }
    }

    @Override
    public AddTagRep addTag(String username, String tag) {
        if(userDataService.administratorExist(username)){
            if(!tagDataService.tagExist(tag)){
                if(tagDataService.addTag(tag)){
                    return new AddTagRep(AddTagRepCode.SUCCESS);
                }else {
                    return new AddTagRep(AddTagRepCode.FAIL);
                }
            }else {
                return new AddTagRep(AddTagRepCode.EXIST);
            }
        }else {
            return new AddTagRep(AddTagRepCode.NOTFOUND);
        }
    }

    @Override
    public DeleteTagRep deleteTag(String username, String tag) {
        if(userDataService.administratorExist(username)){
            if(tagDataService.tagExist(tag)){
                if(tagDataService.deleteTag(tag)){
                    return new DeleteTagRep(DeleteTagRepCode.SUCCESS);
                }else {
                    return new DeleteTagRep(DeleteTagRepCode.FAIL);
                }
            }else {
                return new DeleteTagRep(DeleteTagRepCode.NOTAG);
            }
        }else {
            return new DeleteTagRep(DeleteTagRepCode.NOTFOUND);
        }
    }
}
