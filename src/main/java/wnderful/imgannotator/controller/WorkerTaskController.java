package wnderful.imgannotator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wnderful.imgannotator.blserviceImpl.WorkerTaskServiceImpl;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.request.task.SimpleTaskRequest;

@RestController
@RequestMapping(value = "/service/taskManagement/worker")
public class WorkerTaskController {

    private final WorkerTaskServiceImpl taskService;

    @Autowired
    public WorkerTaskController(WorkerTaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/receiptTask/{username}", method = RequestMethod.POST)
    public Response receiptTask(@PathVariable("username") String username, @RequestBody SimpleTaskRequest request) {
        return taskService.receiptTask(username, request.getTaskname());
    }

    @RequestMapping(value = "/receiptTaskReward/{username}", method = RequestMethod.POST)
    public Response receiptTaskReward(@PathVariable("username") String username, @RequestBody SimpleTaskRequest request) {
        return taskService.receiptTaskReward(username,request.getTaskname());
    }

    @RequestMapping(value = "/display/detail/{username}", method = RequestMethod.POST)
    public Response workerDisplayDetail(@PathVariable("username") String username, @RequestBody SimpleTaskRequest request) {
        return taskService.displayDetail(username,request.getTaskname());
    }

    @RequestMapping(value = "/display/receiptTask/{username}", method = RequestMethod.GET)
    public Response displayReceiptTask(@PathVariable("username") String username) {
        return taskService.displayReceiptTask(username);
    }

    @RequestMapping(value = "/display/recommendTask/{username}", method = RequestMethod.GET)
    public Response displayRecommendTask(@PathVariable("username") String username) {
        return taskService.displayRecommendTask(username);
    }

    @RequestMapping(value = "/display/uncompletedTask/{username}", method = RequestMethod.GET)
    public Response displayUncompletedTaskTask(@PathVariable("username") String username) {
        return taskService.displayUncompletedTask(username);
    }

    @RequestMapping(value = "/display/rewardTask/{username}", method = RequestMethod.GET)
    public Response displayRewardTask(@PathVariable("username") String username) {
        return taskService.displayRewardTask(username);
    }

}
