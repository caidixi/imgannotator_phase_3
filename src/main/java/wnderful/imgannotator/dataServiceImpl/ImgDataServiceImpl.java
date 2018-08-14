package wnderful.imgannotator.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.imgannotator.dao.entity.Img;
import wnderful.imgannotator.dao.entity.Process;
import wnderful.imgannotator.dao.entity.Task;
import wnderful.imgannotator.dao.entity.Work;
import wnderful.imgannotator.dao.entity.user.Worker;
import wnderful.imgannotator.dao.repository.ImgRepository;
import wnderful.imgannotator.dao.repository.ProcessRepository;
import wnderful.imgannotator.dao.repository.TaskRepository;
import wnderful.imgannotator.dao.repository.WorkRepository;
import wnderful.imgannotator.dao.repository.userRepository.WorkerRepository;
import wnderful.imgannotator.dataService.ImgDataService;
import wnderful.imgannotator.util.FileHelper;
import wnderful.imgannotator.util.SortHelper;
import wnderful.imgannotator.vo.baseVo.PointVo;
import wnderful.imgannotator.vo.markVo.ImgUrlVo;
import wnderful.imgannotator.vo.markVo.ImgUrlsVo;

import java.util.ArrayList;

@Service
public class ImgDataServiceImpl implements ImgDataService {
    private WorkerRepository workerRepository;
    private TaskRepository taskRepository;
    private ImgRepository imgRepository;
    private ProcessRepository processRepository;
    private WorkRepository workRepository;
    private FileHelper fileHelper = new FileHelper();
    private SortHelper sortHelper = new SortHelper();

    @Autowired
    public ImgDataServiceImpl(WorkerRepository workerRepository, TaskRepository taskRepository, ImgRepository imgRepository,
                              ProcessRepository processRepository, WorkRepository workRepository) {
        this.workerRepository = workerRepository;
        this.taskRepository = taskRepository;
        this.imgRepository = imgRepository;
        this.processRepository = processRepository;
        this.workRepository = workRepository;
    }

    @Override
    public ImgUrlVo findAImgURL(String taskname, String workername) {
        Process process = processRepository.findProcessByWorkerUsernameAndTaskName(workername,taskname);
        ArrayList<Img> imgs = readyToMarkImg(workername,taskname);
        if(imgs.size()>0&&process!=null){
            Img img = sortHelper.findRecommendImg(imgs);
            String imgURL = img.getImgURL();
            int gotPoints = process.getGotPoints();
            int restImgNum = imgs.size();
            int probablyPoints = calculateImgPoints(process,img);
            String type = process.getTask().getType();
            return new ImgUrlVo(imgURL,gotPoints,restImgNum,type,probablyPoints);
        }else {
            return null;
        }
    }

    @Override
    public ImgUrlsVo findImgURLs(String taskname) {
        Img[] imgs = imgRepository.findImgByTaskName(taskname);
        if(imgs!=null&&imgs.length>0){
            int length = imgs.length;
            String[] URLs = new String[length];
            for(int i = 0 ;i<length;i++){
                URLs[i] = imgs[i].getImgURL();
            }
            return new ImgUrlsVo(URLs);
        }else {
            return null;
        }
    }

    @Override
    public boolean imgExist(String taskname, String imgID) {
        return imgRepository.findImgByTaskNameAndImgName(taskname,imgID)!=null;
    }

    @Override
    public boolean uploadImg(String taskname, String imgID, byte[] bytes) {
        Task task = taskRepository.findTaskByNameAndIsEndAndIsDraft(taskname,0,1);
        if(task!=null){
            String URL = "/"+taskname+"/"+imgID;
            if(fileHelper.savePicture(taskname,imgID,bytes)){
                imgRepository.save(new Img(imgID,URL,task));
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    private boolean imgIsComplete(Img img) {
        if(img!=null){
            return img.getMarks().size()>=img.getTask().getMarkTimes();
        }else {
            return false;
        }
    }

    @Override
    public boolean skipImg(String username, String taskname, String imgID) {
        Worker worker = workerRepository.findWorkerByUsername(username);
        Process process = processRepository.findProcessByWorkerUsernameAndTaskName(username,taskname);
        if(worker!=null&&process!=null){
            Img img = imgRepository.findImgByTaskNameAndImgName(taskname,imgID);
            if(img!=null){
                workRepository.save(new Work(taskname,worker,img));
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public boolean taskIsCompleted(String taskname,String username) {
        ArrayList<Img> imgs = readyToMarkImg(username,taskname);
        return imgs.size()==0;
    }

    @Override
    public int findTaskImgNum(String taskname) {
        Img[] imgs = imgRepository.findImgByTaskName(taskname);
        if(imgs!=null){
            return imgs.length;
        }else {
            return 0;
        }
    }

    @Override
    public int findMarkedImgNum(String taskname) {
        Img[] imgs = imgRepository.findImgByTaskName(taskname);
        if(imgs!=null){
            int completedImg = 0;
            for(Img img:imgs){
                if(imgIsComplete(img)){
                    completedImg++;
                }
            }
            return completedImg;
        }else {
            return 0;
        }
    }

    private int calculateImgPoints(Process process, Img img) {
        Task task = img.getTask();
        double basic = task.getImgPoints();
        double markTime = img.getMarks().size();
        double skipTime = img.getWorks().size()-markTime;
        double totalImg = task.getImgs().size();
        double completedImg = process.getMarkedImg();
        double points = (0.2*(completedImg/totalImg)+0.3+0.5*((2+markTime+3*skipTime)/(5+5*markTime+3*skipTime)))*basic;
        return (int)Math.floor(points);
    }

    @Override
    public PointVo getMarkReward(String username, String taskname, String imgID) {
        Worker worker = workerRepository.findWorkerByUsername(username);
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname,0);
        if(worker!=null&&task!=null){
            Img img = imgRepository.findImgByTaskNameAndImgName(taskname,imgID);
            Process process = processRepository.findProcessByWorkerUsernameAndTaskName(username,taskname);

            if(process!=null&&img!=null){
                int markTime = img.getMarks().size();
                if(markTime<task.getMarkTimes()*1.5){
                    int getPoints = calculateImgPoints(process,img);
                     if (markTime>=task.getMarkTimes()){
                         getPoints = getPoints/2;
                    }

                    worker.setPoints(worker.getPoints()+getPoints);
                     workerRepository.save(worker);

                    process.setGotPoints(process.getGotPoints()+getPoints);
                    processRepository.save(process);

                    return new PointVo(getPoints);
                }else {
                    return new PointVo(0);
                }
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Img> readyToMarkImg(String username, String taskname) {
        ArrayList<Img> result = new ArrayList<>();
        Img[] imgs = imgRepository.findImgByTaskName(taskname);
        if(imgs!=null){
            for(Img img : imgs){
                if(!imgIsComplete(img)){
                    if(workRepository.findWorkByWorkerUsernameAndImgImgName(username,img.getImgName())==null){
                        result.add(img);
                    }
                }
            }
            return result;
        }else {
            return result;
        }
    }

}
