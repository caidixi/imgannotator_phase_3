package wnderful.imgannotator.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.imgannotator.dao.entity.Task;
import wnderful.imgannotator.dao.entity.user.*;
import wnderful.imgannotator.dao.entity.Process;
import wnderful.imgannotator.dao.repository.ProcessRepository;
import wnderful.imgannotator.dao.repository.TaskRepository;
import wnderful.imgannotator.dao.repository.userRepository.AdministratorRepository;
import wnderful.imgannotator.dao.repository.userRepository.RequesterRepository;
import wnderful.imgannotator.dao.repository.userRepository.WorkerRepository;
import wnderful.imgannotator.dataService.UserDataService;
import wnderful.imgannotator.vo.userVo.AllUserMessagesVo;
import wnderful.imgannotator.vo.userVo.RequesterMessageVo;
import wnderful.imgannotator.vo.userVo.UserMessageVo;
import wnderful.imgannotator.vo.userVo.WorkerMessageVo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {
    private WorkerRepository workerRepository;
    private RequesterRepository requesterRepository;
    private AdministratorRepository administratorRepository;
    private ProcessRepository processRepository;
    private TaskRepository taskRepository;

    @Autowired
    public UserDataServiceImpl(WorkerRepository workerRepository, RequesterRepository requesterRepository,
                               AdministratorRepository administratorRepository,ProcessRepository processRepository,TaskRepository taskRepository) {
        this.workerRepository = workerRepository;
        this.requesterRepository = requesterRepository;
        this.administratorRepository = administratorRepository;
        this.processRepository = processRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public boolean newUser(String username, String email, String password, String role) {
        switch (role) {
            case "worker":
                workerRepository.save(new Worker(username, password, email, 0));
                return true;
            case "requester":
                requesterRepository.save(new Requester(username, password, email, 100000, 5));
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean setWorkerMessage(String username, String email, String password) {
        Worker worker = workerRepository.findWorkerByUsername(username);
        worker.setEmail(email);
        worker.setPassword(password);
        workerRepository.save(worker);
        return true;
    }

    @Override
    public boolean setRequesterMessage(String username, String email, String password) {
        Requester requester = requesterRepository.findRequesterByUsername(username);
        requester.setEmail(email);
        requester.setPassword(password);
        requesterRepository.save(requester);
        return true;
    }

    @Override
    public boolean workerExist(String workername) {
        return workerRepository.findWorkerByUsername(workername) != null;
    }

    @Override
    public boolean requesterExist(String requestername) {
        return requesterRepository.findRequesterByUsername(requestername) != null;
    }

    @Override
    public boolean administratorExist(String username) {
        return administratorRepository.findAdministratorByUsername(username) != null;
    }

    @Override
    public boolean userExist(String username) {
        return workerExist(username) || requesterExist(username) || administratorExist(username);
    }

    @Override
    public int findUserPoints(String username, String role) {
        switch (role) {
            case "worker":
                return workerRepository.findWorkerByUsername(username).getPoints();
            case "requester":
                return requesterRepository.findRequesterByUsername(username).getPoints();
            default:
                return -1;
        }
    }

    @Override
    public String findUserPassword(String username) {
        String role = findUserRole(username);
        if(role!=null){
            switch (role){
                case "worker":
                    return workerRepository.findWorkerByUsername(username).getPassword();
                case "requester":
                    return requesterRepository.findRequesterByUsername(username).getPassword();
                case "administrator":
                    return administratorRepository.findAdministratorByUsername(username).getPassword();
                default:return null;
            }
        }else {
            return null;
        }
    }

    @Override
    public String findUserRole(String username) {
        if(workerExist(username)){
           return "worker";
        }else if(requesterExist(username)){
            return "requester";
        }else if(administratorExist(username)){
            return "administrator";
        }else {
            return null;
        }
    }

    @Override
    public WorkerMessageVo findWorker(String workername) {
        Worker worker = workerRepository.findWorkerByUsername(workername);
        if(worker!=null){
            WorkerMessageVo vo = new WorkerMessageVo(worker.getUsername(),worker.getEmail(),worker.getPoints());

            Process[] completedTasks = processRepository.findProcessByWorkerUsernameAndIsCompleted(workername,1);
            if(completedTasks!=null){
                vo.setCompletedTasks(completedTasks.length);
            }

            Process[] readyToCompleteTasks = processRepository.findProcessByWorkerUsernameAndIsCompletedAndTaskIsEnd(workername,0,0);
            if(readyToCompleteTasks!=null){
                vo.setReadyToCompleteTasks(readyToCompleteTasks.length);
            }

            vo.setCompletedImages(worker.getMarks().size());
            vo.setRewardTasks(worker.getRewards().size());
            return vo;
        }else {
            return null;
        }
    }

    @Override
    public RequesterMessageVo findRequester(String requestername) {
        Requester requester = requesterRepository.findRequesterByUsername(requestername);
        if(requester!=null){
            RequesterMessageVo vo = new RequesterMessageVo(requestername,requester.getEmail(),requester.getPoints(),
                    requester.getUsedPoints(),requester.getMaxReleasedTask());

            Task[] completedTasks = taskRepository.findTaskByRequesterUsernameAndIsEnd(requestername,1);
            if(completedTasks!=null){
                vo.setCompletedTasks(completedTasks.length);
            }

            Task[] unCompletedTasks = taskRepository.findTaskByRequesterUsernameAndIsDraftAndIsEnd(requestername,0,0);
            if(unCompletedTasks!=null){
                vo.setUncompletedTasks(unCompletedTasks.length);
            }

            Task[] drafts = taskRepository.findTaskByRequesterUsernameAndIsDraftAndIsEnd(requestername,1,0);
            if(drafts!=null){
                vo.setUnreleasedTasks(drafts.length);
            }

            vo.setReleasedTasks(requester.getTasks().size());

            return vo;
        }else {
            return null;
        }
    }

    @Override
    public AllUserMessagesVo findAllWorker(){
        List<Worker> workers= workerRepository.findAll();
        if(workers!=null&&workers.size()>0){
            UserMessageVo[] userMessageVos = new UserMessageVo[workers.size()];
            for(int i = 0;i < workers.size();i++){
                Worker worker = workers.get(i);
                UserMessageVo vo = new UserMessageVo(worker.getUsername(),worker.getEmail(),worker.getPoints(),"worker");
                userMessageVos[i] = vo;
            }
            return new AllUserMessagesVo(userMessageVos);
        }else {
            return null;
        }
    }

    @Override
    public AllUserMessagesVo findAllRequester(){
        List<Requester> requesters= requesterRepository.findAll();
        if(requesters!=null&&requesters.size()>0){
            UserMessageVo[] userMessageVos = new UserMessageVo[requesters.size()];
            for(int i = 0;i < requesters.size();i++){
                Requester requester = requesters.get(i);
                UserMessageVo vo = new UserMessageVo(requester.getUsername(),requester.getEmail(),requester.getPoints(),"requester");
                userMessageVos[i] = vo;
            }
            return new AllUserMessagesVo(userMessageVos);
        }else {
            return null;
        }
    }

}