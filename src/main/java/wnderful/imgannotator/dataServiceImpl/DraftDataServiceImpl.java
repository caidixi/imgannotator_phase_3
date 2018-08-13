package wnderful.imgannotator.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.imgannotator.dao.entity.Task;
import wnderful.imgannotator.dao.entity.user.Requester;
import wnderful.imgannotator.dao.repository.TaskRepository;
import wnderful.imgannotator.dao.repository.userRepository.RequesterRepository;
import wnderful.imgannotator.dataService.DraftDataService;
import wnderful.imgannotator.util.FileHelper;
import wnderful.imgannotator.vo.taskVo.DraftVo;
import wnderful.imgannotator.vo.taskVo.TasknamesVo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


@Service
public class DraftDataServiceImpl implements DraftDataService {
    private TaskRepository taskRepository;
    private RequesterRepository requesterRepository;
    private TagDataServiceImpl tagDataService;
    private FileHelper fileHelper = new FileHelper();

    @Autowired
    public DraftDataServiceImpl(TaskRepository taskRepository, RequesterRepository requesterRepository, TagDataServiceImpl tagDataService) {
        this.taskRepository = taskRepository;
        this.requesterRepository = requesterRepository;
        this.tagDataService = tagDataService;
    }

    @Override
    public boolean draftExist(String taskname) {
        return  taskRepository.findTaskByNameAndIsDraft(taskname,1)!=null;
    }

    @Override
    public boolean newDraft(String username,String taskname) {
        Requester requester = requesterRepository.findRequesterByUsername(username);
        if(requester!=null){
            taskRepository.save(new Task(requester,taskname));
            return fileHelper.newTaskFolder(taskname);
        }else {
            return false;
        }
    }

    @Override
    public boolean newTask(String taskname){
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname,1);
        if(task!=null){
            int imgNum = task.getImgs().size();
            task.setNumberOfImages(imgNum);

            if(imgNum>0){
                String imgURL = task.getImgs().get(0).getImgURL();
                task.setImgURL(imgURL);
            }else {
                return false;
            }

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd hh:mm");
            task.setStartTime(now.format(formatter));

            task.setImgPoints(task.getCredits()/imgNum/task.getMarkTimes());

            task.setIsDraft(0);
            taskRepository.save(task);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean saveDraft( String taskname, String taskDescription, int markTimes, String[] taskTag, int credits, String taskType) {
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname,1);
        if(task!=null){
            task.setTaskDescription(taskDescription);
            task.setMarkTimes(markTimes);
            task.setCredits(credits);
            task.setType(taskType);
            taskRepository.save(task);
            tagDataService.saveTaskTags(task,taskTag);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteDraft(String taskname) {
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname,1);
        if(task!=null){
            taskRepository.delete(task);
            if(fileHelper.deleteTaskFolder(taskname)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public boolean isSave(String taskname, String requestername) {
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname,1);
        if(task!=null){
            return task.getRequester().getUsername().equals(requestername);
        }else {
            return false;
        }
    }

    @Override
    public DraftVo findDraft(String taskname) {
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname,1);
        if(task!=null){
            DraftVo vo = new DraftVo(taskname,task.getTaskDescription(),task.getCredits(),task.getType(),task.getMarkTimes(),task.getImgs().size());

            String[] tags = tagDataService.findTaskTag(taskname);
            if(tags!=null){
                vo.setTaskTag(tags);
            }

            return vo;
        }else {
            return null;
        }

    }

    @Override
    public TasknamesVo findAllDraft(String requestername) {
        Task[] tasks = taskRepository.findTaskByRequesterUsernameAndIsDraftAndIsEnd(requestername,1,0);
        if(tasks!=null&&tasks.length>0){
            String[] names = new String[tasks.length];
            for(int i = 0;i < tasks.length;i++){
                names[i] = tasks[i].getName();
            }
            return new TasknamesVo(names);
        }else {
            return null;
        }
    }
}
