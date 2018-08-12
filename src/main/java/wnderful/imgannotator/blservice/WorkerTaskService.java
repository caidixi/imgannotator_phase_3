package wnderful.imgannotator.blservice;

import wnderful.imgannotator.publicData.response.Response;

public interface WorkerTaskService {

    Response displayReceiptTask(String username);

    Response displayRecommendTask(String username);

    Response displayUncompletedTask(String username);

    Response displayRewardTask(String username);

    Response receiptTask(String username, String taskname);

    Response receiptTaskReward(String username, String taskname);

    Response displayDetail(String username,String taskname);

}
