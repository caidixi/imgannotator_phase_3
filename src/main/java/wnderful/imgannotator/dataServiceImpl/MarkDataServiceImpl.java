package wnderful.imgannotator.dataServiceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.imgannotator.dao.entity.*;
import wnderful.imgannotator.dao.entity.Process;
import wnderful.imgannotator.dao.entity.user.Worker;
import wnderful.imgannotator.dao.repository.*;
import wnderful.imgannotator.dao.repository.userRepository.WorkerRepository;
import wnderful.imgannotator.dataService.MarkDataService;
import wnderful.imgannotator.vo.markVo.MarkVo;

import java.util.List;

@Service
public class MarkDataServiceImpl implements MarkDataService {
    private TaskRepository taskRepository;
    private WorkerRepository workerRepository;
    private ProcessRepository processRepository;
    private ImgRepository imgRepository;
    private MarkRepository markRepository;
    private WorkRepository workRepository;

    @Autowired
    public MarkDataServiceImpl(TaskRepository taskRepository, WorkerRepository workerRepository, ProcessRepository processRepository,
                               ImgRepository imgRepository, MarkRepository markRepository, WorkRepository workRepository) {
        this.taskRepository = taskRepository;
        this.workerRepository = workerRepository;
        this.processRepository = processRepository;
        this.imgRepository = imgRepository;
        this.markRepository = markRepository;
        this.workRepository = workRepository;
    }

    @Override
    public boolean addMark(String workername, String taskname, String imgID, JSONObject marks) {
        Worker worker = workerRepository.findWorkerByUsername(workername);
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname,0);
        Process process = processRepository.findProcessByWorkerUsernameAndTaskName(workername,taskname);
        if(worker!=null&&task!=null&&process!=null){
            Img img = imgRepository.findImgByTaskNameAndImgName(taskname,imgID);
            if(img!=null){
                String content = JSON.toJSONString(marks);
                markRepository.save(new Mark(content,worker,img));
                workRepository.save(new Work(taskname,worker,img));
                process.addMarkedImg();
                processRepository.save(process);
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public MarkVo findAllMark(String taskname, String imgID) {
        Task task = taskRepository.findTaskByNameAndIsDraft(taskname,0);
        if(task!=null){
            Img img = imgRepository.findImgByTaskNameAndImgName(taskname,imgID);
            if(img!=null){
                List<Mark> marks = img.getMarks();
                int size = marks.size();
                if(size>0){
                    JSONObject[] jsonObjects = new JSONObject[size];
                    for(int i = 0;i < size;i++){
                        jsonObjects[i] = JSON.parseObject(marks.get(i).getContent());
                    }
                    return new MarkVo(jsonObjects);
                }else {
                    return null;
                }
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
}
