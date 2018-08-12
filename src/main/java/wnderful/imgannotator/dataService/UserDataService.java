package wnderful.imgannotator.dataService;

import wnderful.imgannotator.vo.userVo.AllUserMessagesVo;
import wnderful.imgannotator.vo.userVo.RequesterMessageVo;
import wnderful.imgannotator.vo.userVo.WorkerMessageVo;

public interface UserDataService {
    boolean newUser(String username,String email,String password,String role);

    boolean setWorkerMessage(String username,String email,String password);

    boolean setRequesterMessage(String username,String email,String password);

    boolean workerExist(String workername);

    boolean requesterExist(String requestername);

    boolean administratorExist(String username);

    boolean userExist(String username);

    int findUserPoints(String username,String role);

    String findUserPassword(String username);

    String findUserRole(String username);

    WorkerMessageVo findWorker(String workername);

    RequesterMessageVo findRequester(String requestername);

    AllUserMessagesVo findAllUser();

}
