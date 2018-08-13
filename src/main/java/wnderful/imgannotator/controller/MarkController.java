package wnderful.imgannotator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wnderful.imgannotator.blserviceImpl.MarkServiceImpl;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.request.mark.*;
import wnderful.imgannotator.request.task.SimpleTaskRequest;

@RestController
@RequestMapping(value = "/service/mark")
public class MarkController {

    private final MarkServiceImpl markService;

    @Autowired
    public MarkController(MarkServiceImpl markService) {
        this.markService = markService;
    }

    @RequestMapping(value = "/setMark/{username}", method = RequestMethod.POST)
    public Response setMark(@PathVariable("username") String username, @RequestBody ImgMarkRequest request) {
        return markService.setMark(username,request.getTaskname(),request.getImgID(),request.getMarks());
    }

    @RequestMapping(value = "/findURL/{username}", method = RequestMethod.POST)
    public Response findURL(@PathVariable("username") String username,@RequestBody SimpleTaskRequest request) {
        return markService.findURL(username,request.getTaskname());
    }
    @RequestMapping(value = "/getURLs/{username}", method = RequestMethod.POST)
    public Response getURLs(@PathVariable("username") String username, @RequestBody SimpleTaskRequest request) {
        return markService.getURLs(username,request.getTaskname());
    }

    @RequestMapping(value = "/findMark/{username}",method = RequestMethod.POST)
    public Response findMark(@PathVariable("username") String username, @RequestBody SimpleImgRequest request){
        return markService.findMark(request.getTaskname(),request.getImgID(),username);
    }

    @RequestMapping(value = "/skip/{username}",method = RequestMethod.POST)
    public Response skipImg(@PathVariable("username") String username, @RequestBody SimpleImgRequest request){
        return markService.skipImg(request.getTaskname(),request.getImgID(),username);
    }
}
