package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.*;
import wnderful.imgannotator.blserviceImpl.RequesterTaskServiceImpl;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.request.task.*;

@RestController
@RequestMapping(value = "/service/taskManagement/requester")
public class RequesterTaskController {

    private final RequesterTaskServiceImpl taskService = new RequesterTaskServiceImpl();

    @RequestMapping(value = "/add/{username}", method = RequestMethod.POST)
    public Response releaseTask(@PathVariable("username") String username, @RequestBody SimpleTaskRequest request) {
        return taskService.releaseTask(username,request.getTaskname());
    }

    @RequestMapping(value = "/delete/{username}", method = RequestMethod.POST)
    public Response deleteTask(@PathVariable("username") String username, @RequestBody SimpleTaskRequest request) {
        return taskService.deleteTask(username, request.getTaskname());
    }

    @RequestMapping(value = "/load/{username}", method = RequestMethod.POST)
    public Response loadDraft(@PathVariable("username") String username, @RequestBody SimpleTaskRequest request) {
        return taskService.loadDraft(username,request.getTaskname());
    }

    @RequestMapping(value = "/display/detail/{username}", method = RequestMethod.POST)
    public Response requesterDisplayDetail(@PathVariable("username") String username, @RequestBody SimpleTaskRequest request) {
        return taskService.displayDetail(username,request.getTaskname());
    }

    @RequestMapping(value = "/giveUp/{username}", method = RequestMethod.POST)
    public Response deleteDraft(@PathVariable("username") String username, @RequestBody SimpleTaskRequest request) {
        return taskService.deleteDraft(username,request.getTaskname());
    }

    @RequestMapping(value = "/save/{username}", method = RequestMethod.POST)
    public Response saveDraft(@PathVariable("username") String username, @RequestBody SaveTaskRequest request) {
        return taskService.saveDraft(username,request.getTaskname(),request.getTaskDescription(),request.getMarkTimes(),
                request.getTaskTag(),request.getCredits(),request.getTaskType());
    }

    @RequestMapping(value = "/display/releasedTask/{username}", method = RequestMethod.GET)
    public Response displayReleasedTask(@PathVariable("username") String username) {
        return taskService.displayReleasedTask(username);
    }

    @RequestMapping(value = "/display/draft/{username}", method = RequestMethod.GET)
    public Response displayDraft(@PathVariable("username") String username) {
        return taskService.displayDraft(username);
    }
}
