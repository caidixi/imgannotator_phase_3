package wnderful.imgannotator.blserviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.imgannotator.blservice.BaseService;
import wnderful.imgannotator.dataServiceImpl.TagDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.TaskDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.UserDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.*;
import wnderful.imgannotator.publicData.response.baseResponse.*;
import wnderful.imgannotator.util.JwtHelper;
import wnderful.imgannotator.vo.baseVo.DisplayDetailVo;
import wnderful.imgannotator.vo.baseVo.LoginVo;
import wnderful.imgannotator.vo.taskVo.DisplayTaskVo;

import java.io.UnsupportedEncodingException;

@Service
public class BaseServiceImpl implements BaseService {
    private UserDataServiceImpl userDataService;
    private TaskDataServiceImpl taskDataService;
    private JwtHelper jwtHelper = new JwtHelper();
    private TagDataServiceImpl tagDataService;

    @Autowired
    public BaseServiceImpl(UserDataServiceImpl userDataService, TaskDataServiceImpl taskDataService, TagDataServiceImpl tagDataService) {
        this.userDataService = userDataService;
        this.taskDataService = taskDataService;
        this.tagDataService = tagDataService;
    }

    //登陆
    @Override
    public LoginRep login(String username, String password) throws UnsupportedEncodingException {
        if (!username.equals("")) {
            if (userDataService.userExist(username)) {
                if (!password.equals("")) {
                    String realPassword = userDataService.findUserPassword(username);
                    if (realPassword!=null&&realPassword.equals(password)) {
                        String token = jwtHelper.createToken(username);
                        String role = userDataService.findUserRole(username);
                        if (role != null) {
                            return new LoginRep(LoginRepCode.SUCCESS, new LoginVo(token, role));
                        } else {
                            return new LoginRep(LoginRepCode.FAIL);
                        }
                    } else {
                        return new LoginRep(LoginRepCode.WRONGPASSWORD);
                    }
                } else {
                    return new LoginRep(LoginRepCode.EMPTYPASSWORD);
                }
            } else {
                return new LoginRep(LoginRepCode.NOTEXIST);
            }
        } else {
            return new LoginRep(LoginRepCode.EMPTYNAME);
        }
    }

    //注册
    @Override
    public SignUpRep signUp(String username, String password, String email, String role) {
        if (!userDataService.userExist(username)) {
            if (!username.equals("")) {
                if (!password.equals("")) {
                    if (!email.equals("")) {
                        if (userDataService.newUser(username, email, password, role)) {
                            return new SignUpRep(SignUpRepCode.SUCCESS);
                        } else {
                            return new SignUpRep(SignUpRepCode.FAIL);
                        }
                    }
                    return new SignUpRep(SignUpRepCode.EMPTYEMAIL);
                } else {
                    return new SignUpRep(SignUpRepCode.EMPTYPASSWORD);
                }
            } else {
                return new SignUpRep(SignUpRepCode.EMPTYNAME);
            }
        } else {
            return new SignUpRep(SignUpRepCode.NAMEREPEAT);
        }
    }

    //查看任务详情
    @Override
    public DisplayDetailRep displayDetail(String taskname) {
        if (taskDataService.exist(taskname)) {
            DisplayDetailVo vo = taskDataService.visitorFindTaskDetail(taskname);
            if(vo!=null){
                return new DisplayDetailRep(DisplayDetailRepCode.SUCCESS,vo);
            }else {
                return new DisplayDetailRep(DisplayDetailRepCode.FAIL);
            }
        } else {
            return new DisplayDetailRep(DisplayDetailRepCode.NOTASK);
        }
    }

    @Override
    public DisplayAllTaskRep displayAllTask() {
        return new DisplayAllTaskRep(DisplayAllTaskRepCode.SUCCESS, taskDataService.findAllTask());
    }

    @Override
    public SearchTaskRep searchTask(String type, String content) {
        if (!type.equals("")) {
            if (!content.equals("")) {
                DisplayTaskVo vo = taskDataService.searchTask(content,type);
                if(vo !=null){
                    return new SearchTaskRep(SearchTaskRepCode.SUCCESS,vo);
                }else {
                    return new SearchTaskRep(SearchTaskRepCode.FAIL);
                }
            }else {
                return new SearchTaskRep(SearchTaskRepCode.NOCONTENT);
            }
        }else {
            return new SearchTaskRep(SearchTaskRepCode.NOTYPE);
        }
    }

    @Override
    public DisplayAllTagRep displayAllTag() {
        return new DisplayAllTagRep(DisplayAllTagRepCode.SUCCESS, tagDataService.findAllTags());
    }
}
