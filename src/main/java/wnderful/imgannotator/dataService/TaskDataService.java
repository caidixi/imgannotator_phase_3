package wnderful.imgannotator.dataService;

import wnderful.imgannotator.vo.baseVo.DataAnalyzeVo;
import wnderful.imgannotator.vo.baseVo.DisplayDetailVo;
import wnderful.imgannotator.vo.taskVo.DisplayTaskVo;
import wnderful.imgannotator.vo.taskVo.RequesterDisplayDetailVo;
import wnderful.imgannotator.vo.taskVo.WorkerDisplayDetailVo;

public interface TaskDataService {

    void completeTask(String taskname,String username);

    boolean exist(String taskname);

    boolean receiptTask(String workername,String taskname);

    boolean endTask(String taskname);

    boolean isFinished(String taskname);

    boolean isReceipt(String taskname,String workername);

    boolean isEnd(String taskname);

    boolean isRelease(String taskname,String requestername);

    DataAnalyzeVo analyzeTaskData(String taskname);

    DisplayDetailVo visitorFindTaskDetail(String taskname);

    RequesterDisplayDetailVo requesterFindTaskDetail(String taskname);

    WorkerDisplayDetailVo workerFindTaskDetail(String taskname,String workername);

    DisplayTaskVo findAllTask();

    DisplayTaskVo searchTask(String content,String type);

    DisplayTaskVo searchTaskByName(String taskname);

    DisplayTaskVo searchTaskByTag(String tag);

    DisplayTaskVo findReleasedTask(String requestername);

    DisplayTaskVo findReceiptedTask(String workername);

    DisplayTaskVo findRecommendedTask(String workername);

    DisplayTaskVo findUncompletedTask(String workername);

    DisplayTaskVo findReWardTask(String workername);
}
