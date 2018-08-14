package wnderful.imgannotator.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.imgannotator.dao.entity.*;
import wnderful.imgannotator.dao.entity.Process;
import wnderful.imgannotator.dao.entity.user.Requester;
import wnderful.imgannotator.dao.entity.user.Worker;
import wnderful.imgannotator.dao.repository.*;
import wnderful.imgannotator.dao.repository.userRepository.RequesterRepository;
import wnderful.imgannotator.dao.repository.userRepository.WorkerRepository;
import wnderful.imgannotator.dataService.PointsDataService;
import wnderful.imgannotator.exception.RechargeException;
import wnderful.imgannotator.util.JwtHelper;
import wnderful.imgannotator.vo.baseVo.PointVo;
import wnderful.imgannotator.vo.userVo.CodeVo;

@Service
public class PointsDataServiceImpl implements PointsDataService {
    private WorkerRepository workerRepository;
    private RequesterRepository requesterRepository;
    private TaskRepository taskRepository;
    private ProcessRepository processRepository;
    private CodeRepository codeRepository;
    private RewardRepository rewardRepository;
    private JwtHelper jwtHelper = new JwtHelper();

    @Autowired
    public PointsDataServiceImpl(WorkerRepository workerRepository, RequesterRepository requesterRepository, TaskRepository taskRepository,
                                 ProcessRepository processRepository, CodeRepository codeRepository, RewardRepository rewardRepository) {
        this.workerRepository = workerRepository;
        this.requesterRepository = requesterRepository;
        this.taskRepository = taskRepository;
        this.processRepository = processRepository;
        this.codeRepository = codeRepository;
        this.rewardRepository = rewardRepository;
    }

    @Override
    public PointVo codeToPoints(String content)  {
        try {
            Code code = codeRepository.findCodeByContent(content);
            if(code!=null){
                int points = jwtHelper.verifyCode(content,"recharge");
                codeRepository.delete(code);
                return new PointVo(points);
            }else {
                return null;
            }
        }catch(RechargeException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean modifyPoints(int points, String username,String role) {
        switch (role){
            case "worker":
                Worker worker = workerRepository.findWorkerByUsername(username);
                if(worker.getPoints()+points>=0){
                    worker.setPoints(worker.getPoints()+points);
                    workerRepository.save(worker);
                    return true;
                }else {
                    return false;
                }
            case "requester":
                Requester requester = requesterRepository.findRequesterByUsername(username);
                int newPoints = requester.getPoints()+points;
                if(newPoints>=0){
                    requester.setPoints(newPoints);
                    requesterRepository.save(requester);
                    return true;
                }else {
                    return false;
                }
                default:
                    return false;
        }
    }

    @Override
    public PointVo receiptReward(String workername, String taskname) {
        Reward reward = rewardRepository.findRewardByTaskNameAndWorkerUsername(taskname,workername);
        Worker worker = workerRepository.findWorkerByUsername(workername);
        if(worker!=null&&reward!=null){
            PointVo vo = new PointVo(reward.getPoints());
            worker.setPoints(worker.getPoints()+reward.getPoints());
            workerRepository.save(worker);
            rewardRepository.delete(reward);
            return vo;
        }else {
            return null;
        }
    }

    @Override
    public boolean settleTaskPoints(String taskname) {
        Task task = taskRepository.findTaskByNameAndIsEndAndIsDraft(taskname,1,0);
        Process[] processes = processRepository.findProcessByTaskNameAndIsCompleted(taskname,1);
        if(task!=null){
            if(processes!=null){
                int restPoints = task.getCredits();
                double allProcesses = 0;
                for(Process process:processes){
                    restPoints = restPoints - process.getGotPoints();
                    allProcesses = allProcesses+Math.pow(process.getMarkedImg(),2);
                }

                if(allProcesses!=0){
                    for(Process process:processes){
                        double aReward = restPoints * (Math.pow(process.getMarkedImg(),2)/allProcesses);
                        rewardRepository.save(new Reward((int) Math.floor(aReward),process.getWorker(),task));
                    }
                }
                return true;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }

    @Override
    public boolean rewardExist(String workername, String taskname) {
        return rewardRepository.findRewardByTaskNameAndWorkerUsername(taskname,workername)!=null;
    }

    @Override
    public CodeVo pointsToCode(int points) {
        try {
            String content = jwtHelper.createCode(points);
            codeRepository.save(new Code(content));
            return new CodeVo(content);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
