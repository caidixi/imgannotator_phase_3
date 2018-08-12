package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.WorkerTaskService;
import wnderful.imgannotator.dataServiceImpl.ImgDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.PointsDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.TaskDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.UserDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.*;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.taskResponse.*;
import wnderful.imgannotator.vo.baseVo.PointVo;
import wnderful.imgannotator.vo.taskVo.DisplayTaskVo;
import wnderful.imgannotator.vo.taskVo.WorkerDisplayDetailVo;

public class WorkerTaskServiceImpl implements WorkerTaskService {

    private UserDataServiceImpl userDataService = new UserDataServiceImpl();
    private TaskDataServiceImpl taskDataService = new TaskDataServiceImpl();
    private ImgDataServiceImpl imgDataService = new ImgDataServiceImpl();
    private PointsDataServiceImpl pointsDataService = new PointsDataServiceImpl();

    @Override
    public ReceiptTaskRep receiptTask(String username, String taskname) {
        if (userDataService.workerExist(username)) {
            if (taskDataService.exist(taskname)) {
                if (!taskDataService.isReceipt(taskname, username)) {
                    if (!taskDataService.isEnd(taskname)) {
                        int markedImgNum = imgDataService.findMarkedImgNum(taskname);
                        int unmarkedImgNum = imgDataService.findTaskImgNum(taskname) - markedImgNum;
                        if (markedImgNum <= unmarkedImgNum) {
                            if (taskDataService.receiptTask(username, taskname)) {
                                return new ReceiptTaskRep(ReceiptTaskRepCode.SUCCESS);
                            } else {
                                return new ReceiptTaskRep(ReceiptTaskRepCode.FAIL);
                            }
                        } else {
                            return new ReceiptTaskRep(ReceiptTaskRepCode.FULL);
                        }
                    } else {
                        return new ReceiptTaskRep(ReceiptTaskRepCode.END);
                    }
                } else {
                    return new ReceiptTaskRep(ReceiptTaskRepCode.HASRECEIPT);
                }
            } else {
                return new ReceiptTaskRep(ReceiptTaskRepCode.NOTASK);
            }
        } else {
            return new ReceiptTaskRep(ReceiptTaskRepCode.NOTFOUND);
        }
    }

    @Override
    public ReceiptTaskRewardRep receiptTaskReward(String username, String taskname) {
        if (userDataService.workerExist(username)) {
            if (pointsDataService.rewardExist(username, taskname)) {
                PointVo vo = pointsDataService.receiptReward(username, taskname);
                if (vo != null) {
                    return new ReceiptTaskRewardRep(ReceiptTaskRewardRepCode.SUCCESS, vo);
                } else {
                    return new ReceiptTaskRewardRep(ReceiptTaskRewardRepCode.FAIL);
                }
            } else {
                return new ReceiptTaskRewardRep(ReceiptTaskRewardRepCode.NOREWARD);
            }
        } else {
            return new ReceiptTaskRewardRep(ReceiptTaskRewardRepCode.NOTFOUND);
        }
    }

    @Override
    public WorkerDisplayDetailRep displayDetail(String username, String taskname) {
        if (userDataService.workerExist(username)) {
            if (taskDataService.exist(taskname)) {
                if (taskDataService.isReceipt(taskname, username)) {
                    WorkerDisplayDetailVo vo = taskDataService.workerFindTaskDetail(taskname, username);
                    if (vo != null) {
                        return new WorkerDisplayDetailRep(WorkerDisplayDetailRepCode.SUCCESS, vo);
                    } else {
                        return new WorkerDisplayDetailRep(WorkerDisplayDetailRepCode.FAIL);
                    }
                } else {
                    return new WorkerDisplayDetailRep(WorkerDisplayDetailRepCode.NORECEIPT);
                }
            } else {
                return new WorkerDisplayDetailRep(WorkerDisplayDetailRepCode.NOTASK);
            }
        } else {
            return new WorkerDisplayDetailRep(WorkerDisplayDetailRepCode.NOTFOUND);
        }
    }

    @Override
    public DisplayReceiptTaskRep displayReceiptTask(String username) {
        if (userDataService.workerExist(username)) {
            DisplayTaskVo vo = taskDataService.findReceiptedTask(username);
            if (vo != null) {
                return new DisplayReceiptTaskRep(DisplayReceiptedTaskRepCode.SUCCESS, vo);
            } else {
                return new DisplayReceiptTaskRep(DisplayReceiptedTaskRepCode.SUCCESS);
            }
        } else {
            return new DisplayReceiptTaskRep(DisplayReceiptedTaskRepCode.NOTFOUND);
        }
    }

    @Override
    public Response displayRecommendTask(String username) {
        if (userDataService.workerExist(username)) {
            DisplayTaskVo vo = taskDataService.findRecommendedTask(username);
            if (vo != null) {
                return new DisplayRecommendedTaskRep(DisplayRecommendedTaskRepCode.SUCCESS, vo);
            } else {
                return new DisplayRecommendedTaskRep(DisplayRecommendedTaskRepCode.SUCCESS);
            }
        } else {
            return new DisplayRecommendedTaskRep(DisplayRecommendedTaskRepCode.NOTFOUND);
        }
    }

    @Override
    public Response displayUncompletedTask(String username) {
        if (userDataService.workerExist(username)) {
            DisplayTaskVo vo = taskDataService.findUncompletedTask(username);
            if (vo != null) {
                return new DisplayUncompletedTaskRep(DisplayUncompletedTaskRepCode.SUCCESS, vo);
            } else {
                return new DisplayUncompletedTaskRep(DisplayUncompletedTaskRepCode.SUCCESS);
            }
        } else {
            return new DisplayUncompletedTaskRep(DisplayUncompletedTaskRepCode.FAIL);
        }
    }

    @Override
    public Response displayRewardTask(String username) {
        if (userDataService.workerExist(username)) {
            DisplayTaskVo vo = taskDataService.findReWardTask(username);
            if (vo != null) {
                return new DisplayRewardTaskRep(DisplayRewardTaskRepCode.SUCCESS, vo);
            } else {
                return new DisplayRewardTaskRep(DisplayRewardTaskRepCode.SUCCESS);
            }
        } else {
            return new DisplayRewardTaskRep(DisplayRewardTaskRepCode.FAIL);
        }
    }

}
