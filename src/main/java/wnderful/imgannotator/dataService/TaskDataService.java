package wnderful.imgannotator.dataService;

import wnderful.imgannotator.vo.baseVo.DisplayDetailVo;
import wnderful.imgannotator.vo.taskVo.DisplayTaskVo;
import wnderful.imgannotator.vo.taskVo.RequesterDisplayDetailVo;
import wnderful.imgannotator.vo.taskVo.WorkerDisplayDetailVo;

public interface TaskDataService {
    int findProcess(String taskname,String workername);

    boolean exist(String taskname);

    boolean receiptTask(String workerName,String taskname);

    boolean endTask(String taskname);

    boolean isReceipt(String taskname,String workername);

    boolean isEnd(String taskname);

    boolean isComplete(String taskname,String workername);

    boolean isRelease(String taskname,String requestername);

    DisplayDetailVo visitorFindTaskDetail(String taskname);

    RequesterDisplayDetailVo requesterFindTaskDetail(String taskname);

    WorkerDisplayDetailVo workerFindTaskDetail(String taskname,String workername);

    DisplayTaskVo findAllTask();

    DisplayTaskVo searchTask(String content,String type);

    DisplayTaskVo findReleasedTask(String requestername);

    DisplayTaskVo findReceiptedTask(String workername);

    DisplayTaskVo findRecommendedTask(String workername);

    DisplayTaskVo findUncompletedTask(String workername);

    DisplayTaskVo findReWardTask(String workername);
}
