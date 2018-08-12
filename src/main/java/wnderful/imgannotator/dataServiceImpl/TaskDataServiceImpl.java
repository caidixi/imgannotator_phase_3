package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dataService.TaskDataService;
import wnderful.imgannotator.vo.baseVo.DisplayDetailVo;
import wnderful.imgannotator.vo.taskVo.DisplayTaskVo;
import wnderful.imgannotator.vo.taskVo.RequesterDisplayDetailVo;
import wnderful.imgannotator.vo.taskVo.WorkerDisplayDetailVo;

public class TaskDataServiceImpl implements TaskDataService {

    public TaskDataServiceImpl() {
        super();
    }

    @Override
    public int findProcess(String taskname, String workername) {
        return 0;
    }

    @Override
    public boolean exist(String taskname) {
        return false;
    }

    @Override
    public boolean receiptTask(String workerName, String taskname) {
        return false;
    }

    @Override
    public boolean endTask(String taskname) {
        return false;
    }

    @Override
    public boolean isReceipt(String taskname, String workername) {
        return false;
    }

    @Override
    public boolean isEnd(String taskname) {
        return false;
    }

    @Override
    public boolean isComplete(String taskname, String workername) {
        return false;
    }

    @Override
    public boolean isRelease(String taskname, String requestername) {
        return false;
    }

    @Override
    public DisplayDetailVo visitorFindTaskDetail(String taskname) {
        return null;
    }

    @Override
    public RequesterDisplayDetailVo requesterFindTaskDetail(String taskname) {
        return null;
    }

    @Override
    public WorkerDisplayDetailVo workerFindTaskDetail(String taskname, String workername) {
        return null;
    }

    @Override
    public DisplayTaskVo findAllTask() {
        return null;
    }

    @Override
    public DisplayTaskVo searchTask(String content, String type) {
        return null;
    }

    @Override
    public DisplayTaskVo findReleasedTask(String requestername) {
        return null;
    }

    @Override
    public DisplayTaskVo findReceiptedTask(String workername) {
        return null;
    }

    @Override
    public DisplayTaskVo findRecommendedTask(String workername) {
        return null;
    }

    @Override
    public DisplayTaskVo findUncompletedTask(String workername) {
        return null;
    }

    @Override
    public DisplayTaskVo findReWardTask(String workername) {
        return null;
    }
}

