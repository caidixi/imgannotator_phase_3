package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dataService.UserDataService;
import wnderful.imgannotator.vo.userVo.AllUserMessagesVo;
import wnderful.imgannotator.vo.userVo.RequesterMessageVo;
import wnderful.imgannotator.vo.userVo.WorkerMessageVo;

public class UserDataServiceImpl implements UserDataService {
    @Override
    public boolean newUser(String username, String email, String password, String role) {
        return false;
    }

    @Override
    public boolean setWorkerMessage(String username, String email, String password) {
        return false;
    }

    @Override
    public boolean setRequesterMessage(String username, String email, String password) {
        return false;
    }

    @Override
    public boolean workerExist(String workername) {
        return false;
    }

    @Override
    public boolean requesterExist(String requestername) {
        return false;
    }

    @Override
    public boolean userExist(String username) {
        return false;
    }

    @Override
    public boolean administratorExist(String username) {
        return false;
    }

    @Override
    public int findUserPoints(String username, String role) {
        return 0;
    }

    @Override
    public String findUserPassword(String username) {
        return null;
    }

    @Override
    public String findUserRole(String username) {
        return null;
    }

    @Override
    public WorkerMessageVo findWorker(String workername) {
        return null;
    }

    @Override
    public RequesterMessageVo findRequester(String requestername) {
        return null;
    }

    @Override
    public AllUserMessagesVo findAllUser() {
        return null;
    }
}