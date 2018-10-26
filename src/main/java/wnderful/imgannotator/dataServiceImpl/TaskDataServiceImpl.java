package wnderful.imgannotator.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.imgannotator.dao.entity.Img;
import wnderful.imgannotator.dao.entity.Reward;
import wnderful.imgannotator.dao.entity.Task;
import wnderful.imgannotator.dao.entity.user.Worker;
import wnderful.imgannotator.dao.entity.Process;
import wnderful.imgannotator.dao.repository.ImgRepository;
import wnderful.imgannotator.dao.repository.ProcessRepository;
import wnderful.imgannotator.dao.repository.RewardRepository;
import wnderful.imgannotator.dao.repository.TaskRepository;
import wnderful.imgannotator.dao.repository.userRepository.WorkerRepository;
import wnderful.imgannotator.dataService.TaskDataService;
import wnderful.imgannotator.vo.baseVo.DataAnalyzeVo;
import wnderful.imgannotator.vo.baseVo.DisplayDetailVo;
import wnderful.imgannotator.vo.taskVo.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskDataServiceImpl implements TaskDataService {
    private TaskRepository taskRepository;
    private ProcessRepository processRepository;
    private WorkerRepository workerRepository;
    private RewardRepository rewardRepository;
    private ImgRepository imgRepository;
    private TagDataServiceImpl tagDataService;
    private ImgDataServiceImpl imgDataService;

    @Autowired
    public TaskDataServiceImpl(TaskRepository taskRepository, ProcessRepository processRepository, WorkerRepository workerRepository,
                               RewardRepository rewardRepository,ImgRepository imgRepository, TagDataServiceImpl tagDataService, ImgDataServiceImpl imgDataService) {
        this.taskRepository = taskRepository;
        this.processRepository = processRepository;
        this.workerRepository = workerRepository;
        this.rewardRepository = rewardRepository;
        this.tagDataService = tagDataService;
        this.imgDataService = imgDataService;
        this.imgRepository = imgRepository;
    }

    @Override
    public void completeTask(String taskname, String username) {
        Process process = processRepository.findProcessByWorkerUsernameAndTaskName(username, taskname);
        if (process != null) {
            process.setIsCompleted(1);
            processRepository.save(process);
        }
    }

    //不是草稿
    @Override
    public boolean exist(String taskname) {
        return taskRepository.findTaskByNameAndIsDraft(taskname, 0) != null;
    }

    @Override
    public boolean receiptTask(String workerName, String taskname) {
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname, 0);
        Worker worker = workerRepository.findWorkerByUsername(workerName);
        if (task != null && worker != null) {
            Process process = new Process(worker, task);
            processRepository.save(process);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean endTask(String taskname) {
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname, 0);
        if (task != null) {
            task.setIsEnd(1);
            taskRepository.save(task);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFinished(String taskname) {
        return imgDataService.findTaskImgNum(taskname) == imgDataService.findMarkedImgNum(taskname);
    }

    @Override
    public boolean isReceipt(String taskname, String workername) {
        return processRepository.findProcessByWorkerUsernameAndTaskName(workername, taskname) != null;
    }

    @Override
    public boolean isEnd(String taskname) {
        System.out.println("in");
        return taskRepository.findTaskByNameAndIsEndAndIsDraft(taskname, 1, 0) != null;
    }

    @Override
    public boolean isRelease(String taskname, String requestername) {
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname, 0);
        if (task != null) {
            return task.getRequester().getUsername().equals(requestername);
        } else {
            return false;
        }
    }

    @Override
    public DisplayDetailVo visitorFindTaskDetail(String taskname) {
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname, 0);
        if (task != null) {
            DisplayDetailVo vo = new DisplayDetailVo(taskname, task.getImgURL(), task.getRequester().getUsername(),

                    task.getStartTime(), task.getTaskDescription(), task.getImgs().size(), task.getCredits(), task.getIsEnd(), task.getProcesses().size());
            String[] tags = tagDataService.findTaskTag(taskname);
            if (tags != null) {
                vo.setTaskTag(tags);
            }

            return vo;
        } else {
            return null;
        }
    }

    @Override
    public RequesterDisplayDetailVo requesterFindTaskDetail(String taskname) {
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname, 0);
        if (task != null) {
            RequesterDisplayDetailVo vo = new RequesterDisplayDetailVo(taskname, task.getStartTime(), task.getImgURL(),
                    task.getTaskDescription(), task.getImgs().size(), task.getCredits(), task.getProcesses().size(), task.getMarkTimes(), task.getIsEnd());

            List<Process> processes = task.getProcesses();
            WorkerVo[] workerVos = new WorkerVo[processes.size()];
            int releasedPoints = 0;
            for (int i = 0; i < processes.size(); i++) {
                Process process = processes.get(i);
                releasedPoints = +process.getGotPoints();
                workerVos[i] = new WorkerVo(process.getWorker().getUsername(), process.getMarkedImg());
            }
            vo.setCurrentWorkers(workerVos);
            vo.setReleasedPoints(releasedPoints);

            int readyToCompleteImg = task.getImgs().size() - imgDataService.findMarkedImgNum(taskname);
            vo.setNeedImgs(readyToCompleteImg);
            vo.setCompletedImgs(task.getImgs().size() - readyToCompleteImg);

            String[] tags = tagDataService.findTaskTag(taskname);
            if (tags != null) {
                vo.setTaskTag(tags);
            }

            return vo;
        } else {
            return null;
        }
    }

    @Override
    public WorkerDisplayDetailVo workerFindTaskDetail(String taskname, String workername) {
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname, 0);
        if (task != null) {
            WorkerDisplayDetailVo vo = new WorkerDisplayDetailVo(taskname, task.getStartTime(), task.getImgURL(), task.getTaskDescription(),
                    task.getRequester().getUsername(), task.getImgs().size(), task.getCredits(), task.getProcesses().size(), task.getIsEnd());

            Process process = processRepository.findProcessByWorkerUsernameAndTaskName(workername, taskname);
            vo.setCompletedImgs(process.getMarkedImg());
            vo.setGotPoints(process.getGotPoints());
            vo.setTaskIsComplete(process.getIsCompleted());
            vo.setNeedImgs(imgDataService.readyToMarkImg(workername, taskname).size());
            if (rewardRepository.findRewardByTaskNameAndWorkerUsername(taskname, workername) != null) {
                vo.setHaveReward(1);
            }

            String[] tags = tagDataService.findTaskTag(taskname);
            if (tags != null) {
                vo.setTaskTag(tags);
            }

            return vo;
        } else {
            return null;
        }
    }

    @Override
    public DisplayTaskVo findAllTask() {
        Task[] tasks = taskRepository.findTaskByIsDraft(0);
        if (tasks != null && tasks.length > 0) {
            return tasksToTaskVos(tasks);
        } else {
            return null;
        }
    }

    @Override
    public DisplayTaskVo searchTask(String content, String type) {
        switch (type) {
            case "name":
                return searchTaskByName(content);
            case "requester":
                return findReleasedTask(content);
            case "tag":
                return searchTaskByTag(content);
            default:
                return null;
        }
    }

    @Override
    public DisplayTaskVo findReleasedTask(String requestername) {
        Task[] tasks = taskRepository.findTaskByRequesterUsernameAndIsDraft(requestername, 0);
        if (tasks != null && tasks.length > 0) {
            return tasksToTaskVos(tasks);
        } else {
            return null;
        }
    }

    @Override
    public DisplayTaskVo findReceiptedTask(String workername) {
        Process[] processes = processRepository.findProcessByWorkerUsername(workername);
        if (processes != null && processes.length > 0) {
            Task[] tasks = new Task[processes.length];
            for (int i = 0; i < processes.length; i++) {
                tasks[i] = processes[i].getTask();
            }
            return tasksToTaskVos(tasks);
        } else {
            return null;
        }
    }

    @Override
    public DisplayTaskVo findRecommendedTask(String workername) {
        Process[] processes = processRepository.findProcessByWorkerUsername(workername);
        Task[] tasks = taskRepository.findTaskByIsDraftAndIsEnd(0, 0);
        if (tasks.length > 0 && processes.length == 0) {
            return tasksToTaskVos(tasks);
        } else if (tasks.length > 0) {
            String[] taskNames = new String[processes.length];
            for (int i = 0; i < processes.length; i++) {
                taskNames[i] = processes[i].getTask().getName();
            }
            Task[] recommendTasks = taskRepository.findTaskByIsDraftAndIsEndAndNameNotIn(0, 0, taskNames);
            return tasksToTaskVos(recommendTasks);
        } else {
            return null;
        }
    }

    @Override
    public DisplayTaskVo findUncompletedTask(String workername) {
        Process[] processes = processRepository.findProcessByWorkerUsernameAndIsCompleted(workername, 0);
        if (processes != null) {
            Task[] tasks = new Task[processes.length];
            for (int i = 0; i < processes.length; i++) {
                tasks[i] = processes[i].getTask();
            }
            return tasksToTaskVos(tasks);
        } else {
            return null;
        }
    }

    @Override
    public DisplayTaskVo findReWardTask(String workername) {
        Reward[] rewards = rewardRepository.findRewardByWorkerUsername(workername);
        if (rewards != null) {
            int size = rewards.length;
            Task[] tasks = new Task[size];
            for (int i = 0; i < size; i++) {
                tasks[i] = rewards[i].getTask();
            }
            return tasksToTaskVos(tasks);
        } else {
            return null;
        }
    }

    @Override
    public DisplayTaskVo searchTaskByName(String taskname) {
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname, 0);
        if (task != null) {
            Task[] tasks = new Task[]{task};
            return tasksToTaskVos(tasks);
        } else {
            return null;
        }
    }

    @Override
    public DisplayTaskVo searchTaskByTag(String tag) {
        Task[] tasks = tagDataService.findTagTask(tag);
        if (tasks != null && tasks.length > 0) {
            return tasksToTaskVos(tasks);
        } else {
            return null;
        }
    }


    private DisplayTaskVo tasksToTaskVos(Task[] tasks) {
        if (tasks != null && tasks.length > 0) {
            TaskVo[] taskVos = new TaskVo[tasks.length];
            for (int i = 0; i < tasks.length; i++) {
                Task task = tasks[i];
                taskVos[i] = new TaskVo(task.getName(), task.getImgURL(), task.getIsEnd(), task.getImgs().size());

                String[] tags = tagDataService.findTaskTag(task.getName());
                if (tags != null && tags.length > 0) {
                    taskVos[i].setTaskTag(tags);
                }
                taskVos[i].setCurrentWorker(task.getProcesses().size());
            }
            return new DisplayTaskVo(taskVos);
        } else {
            return null;
        }
    }

    @Override
    public DataAnalyzeVo analyzeTaskData(String taskname) {
        Task task = taskRepository.findTaskByNameAndIsEnd(taskname, 1);
        assert (task != null && task.getImgs() != null&&task.getImgs().size()>0);
        List<Img> imgs = task.getImgs();
        List<Img>  allImgs = imgRepository.findImgByIdIsNotNull();
        assert (allImgs.size()>0);
        ArrayList<Double> skipRates = getImgSkipRate(imgs);
        ArrayList<Double> allSkipRates = getImgSkipRate(allImgs);
        System.out.println("imgSize:"+imgs.size()+"allImgSize"+allImgs.size());

        //求样本均值
        double mean = getMean(skipRates);
        System.out.println("mean:" + mean);

        //求总体均值
        double allMean = getMean(allSkipRates);
        System.out.println("all mean:" + allMean);

        //求样本方差
        double allVarience = getVarience(allSkipRates,allMean);
        System.out.println("varience:" + allVarience);

        //计算标志量
        assert(allVarience!=0&&skipRates.size()!=0);
        if(mean==allMean){
            return new DataAnalyzeVo("normal");
        }else{
            double z = (mean-allMean)/(allVarience/Math.sqrt(skipRates.size()));
            double Z005 = 1.645;
            System.out.println("Z:" + z);

            if(z >= Z005){
                return new DataAnalyzeVo("high");
            }else if (z <= -Z005){
                return new DataAnalyzeVo("low");
            }else {
                return new DataAnalyzeVo("normal");
            }
        }
    }

    private ArrayList<Double> getImgSkipRate(List<Img> imgs){
        ArrayList<Double> skipRates = new ArrayList<>();

        for (Img img : imgs) {
            double workTimes = img.getWorks().size();
            double markTimes = img.getMarks().size();
            double skipRate = 0;
            System.out.println("img:"+img.getImgName());
            System.out.println("worktime:"+workTimes+" marktimes:"+markTimes);

            assert (workTimes >= markTimes);
            if(workTimes > 0){
                if(markTimes>0){
                    skipRate = (workTimes - markTimes) / workTimes;
                }else{
                    skipRate = 1;
                }
            }
            skipRates.add(skipRate);
        }
        return skipRates;
    }

    private double getMean(ArrayList<Double> numbers){
        double firstMoment = 0;
        int size = numbers.size();
        assert (size!=0);
        for (Double number : numbers) {
            firstMoment = firstMoment + number;
        }
        return firstMoment/size;
    }

    private double getVarience(ArrayList<Double> numbers,double mean){
        double secondMoment = 0;
        int size = numbers.size();
        assert (size!=0);
        for(Double num:numbers){
            secondMoment = secondMoment + Math.pow(num-mean,2);
        }
        return secondMoment/size;
    }
}

