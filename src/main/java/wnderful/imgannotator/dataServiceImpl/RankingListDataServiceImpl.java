package wnderful.imgannotator.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.imgannotator.dao.entity.Task;
import wnderful.imgannotator.dao.entity.user.Requester;
import wnderful.imgannotator.dao.entity.user.Worker;
import wnderful.imgannotator.dao.repository.ProcessRepository;
import wnderful.imgannotator.dao.repository.TaskRepository;
import wnderful.imgannotator.dao.repository.userRepository.RequesterRepository;
import wnderful.imgannotator.dao.repository.userRepository.WorkerRepository;
import wnderful.imgannotator.dataService.RankingListDataService;
import wnderful.imgannotator.util.SortHelper;
import wnderful.imgannotator.vo.rankingListVo.SimpleVo;
import wnderful.imgannotator.vo.rankingListVo.TaskRankingListVo;
import wnderful.imgannotator.vo.rankingListVo.UserRankingListVo;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankingListDataServiceImpl implements RankingListDataService {
    private TaskRepository taskRepository;
    private WorkerRepository workerRepository;
    private RequesterRepository requesterRepository;
    private ProcessRepository processRepository;
    private SortHelper sortHelper = new SortHelper();

    @Autowired
    public RankingListDataServiceImpl(TaskRepository taskRepository, WorkerRepository workerRepository, RequesterRepository requesterRepository,ProcessRepository processRepository) {
        this.taskRepository = taskRepository;
        this.workerRepository = workerRepository;
        this.requesterRepository = requesterRepository;
        this.processRepository = processRepository;
    }

    @Override
    public TaskRankingListVo rankByImg() {
        Task[] tasks = taskRepository.findTaskByIsDraft(0);
        if(tasks!=null&&tasks.length>0){
            ArrayList<SimpleVo> vos = new ArrayList<>();
            for(Task task:tasks){
                vos.add(new SimpleVo(task.getName(),task.getImgs().size()));
            }

            return new TaskRankingListVo(listToArray(sortHelper.selectSort(vos)));
        }else {
            return null;
        }
    }

    @Override
    public TaskRankingListVo rankByTotalPoints() {
        Task[] tasks = taskRepository.findTaskByIsDraft(0);
        if(tasks!=null&&tasks.length>0){
            ArrayList<SimpleVo> vos = new ArrayList<>();
            for(Task task:tasks){
                vos.add(new SimpleVo(task.getName(),task.getCredits()));
            }
            return new TaskRankingListVo(listToArray(sortHelper.selectSort(vos)));
        }else {
            return null;
        }
    }

    @Override
    public TaskRankingListVo rankByReceiptPeople() {
        Task[] tasks = taskRepository.findTaskByIsDraft(0);
        if(tasks!=null&&tasks.length>0){
            ArrayList<SimpleVo> vos = new ArrayList<>();
            for(Task task:tasks){
                vos.add(new SimpleVo(task.getName(),task.getProcesses().size()));
            }
            return new TaskRankingListVo(listToArray(sortHelper.selectSort(vos)));
        }else {
            return null;
        }
    }

    @Override
    public TaskRankingListVo rankByAveragePoints() {
        Task[] tasks = taskRepository.findTaskByIsDraft(0);
        if(tasks!=null&&tasks.length>0){
            ArrayList<SimpleVo> vos = new ArrayList<>();
            for(Task task:tasks){
                vos.add(new SimpleVo(task.getName(),task.getImgPoints()));
            }
            return new TaskRankingListVo(listToArray(sortHelper.selectSort(vos)));
        }else {
            return null;
        }
    }

    @Override
    public UserRankingListVo rankByRequesterPoints(String username) {
        List<Requester> requesters = requesterRepository.findAll();
        if(requesters.size()>0){
            ArrayList<SimpleVo> vos = new ArrayList<>();
            for(Requester requester:requesters){
                vos.add(new SimpleVo(requester.getUsername(),requester.getPoints()));
            }
            ArrayList<SimpleVo> simpleVos = sortHelper.selectSort(vos);
            return new UserRankingListVo(listToArray(simpleVos),sortHelper.getRank(simpleVos,username));
        }else {
            return null;
        }
    }

    @Override
    public UserRankingListVo rankByReleaseTasks(String username) {
        List<Requester> requesters = requesterRepository.findAll();
        if(requesters.size()>0){
            ArrayList<SimpleVo> vos = new ArrayList<>();
            for(Requester requester:requesters){
                vos.add(new SimpleVo(requester.getUsername(),requester.getTasks().size()));
            }
            ArrayList<SimpleVo> simpleVos = sortHelper.selectSort(vos);
            return new UserRankingListVo(listToArray(simpleVos),sortHelper.getRank(simpleVos,username));
        }else {
            return null;
        }
    }

    @Override
    public UserRankingListVo rankByCompleteTasks(String username) {
        List<Worker> workers = workerRepository.findAll();
        if(workers.size()>0){
            ArrayList<SimpleVo> vos = new ArrayList<>();
            for(Worker worker:workers){
                int completeTaskNum = processRepository.findProcessByWorkerUsernameAndIsCompleted(username,1).length;
                vos.add(new SimpleVo(worker.getUsername(),completeTaskNum));
            }
            ArrayList<SimpleVo> simpleVos = sortHelper.selectSort(vos);
            return new UserRankingListVo(listToArray(simpleVos),sortHelper.getRank(simpleVos,username));
        }else {
            return null;
        }
    }

    @Override
    public UserRankingListVo rankByWorkerPoints(String username) {
        List<Worker> workers = workerRepository.findAll();
        if(workers.size()>0){
            ArrayList<SimpleVo> vos = new ArrayList<>();
            for(Worker worker:workers){
                vos.add(new SimpleVo(worker.getUsername(),worker.getPoints()));
            }
            ArrayList<SimpleVo> simpleVos = sortHelper.selectSort(vos);
            return new UserRankingListVo(listToArray(simpleVos),sortHelper.getRank(simpleVos,username));
        }else {
            return null;
        }
    }

    @Override
    public UserRankingListVo rankByCompleteImgs(String username) {
        List<Worker> workers = workerRepository.findAll();
        if(workers.size()>0){
            ArrayList<SimpleVo> vos = new ArrayList<>();
            for(Worker worker:workers){
                vos.add(new SimpleVo(worker.getUsername(),worker.getMarks().size()));
            }
            ArrayList<SimpleVo> simpleVos = sortHelper.selectSort(vos);
            return new UserRankingListVo(listToArray(simpleVos),sortHelper.getRank(simpleVos,username));
        }else {
            return null;
        }
    }

    private SimpleVo[] listToArray(ArrayList<SimpleVo> vos){
        SimpleVo[] simpleVos = new SimpleVo[vos.size()];
        for(int i = 0;i < vos.size();i++){
            simpleVos[i] = vos.get(i);
        }
        return simpleVos;
    }
}
