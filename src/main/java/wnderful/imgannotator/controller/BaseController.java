package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import wnderful.imgannotator.blserviceImpl.BaseServiceImpl;
import wnderful.imgannotator.blserviceImpl.ImgServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.ImgResponseCode.UploadRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.ImgResponse.UploadRep;
import wnderful.imgannotator.request.base.*;

@RestController
@RequestMapping(value = "/base")
public class BaseController {

    private final BaseServiceImpl baseService = new BaseServiceImpl();
    private final ImgServiceImpl imgService = new ImgServiceImpl();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login (@RequestBody LoginRequest request) throws Exception{
        return baseService.login(request.getName(), request.getPassword());
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public Response signUp(@RequestBody SignUpRequest request) {
        return baseService.signUp(request.getUsername(), request.getPassword(), request.getEmail(),request.getRole());
    }

    @RequestMapping(value = "/search/task", method = RequestMethod.POST)
    public Response searchTask(@RequestBody SearchRequest request) {
        return baseService.searchTask(request.getType(),request.getContent());
    }

    @RequestMapping(value = "/display/detail/{taskName}", method = RequestMethod.GET)
    public Response displayDetail(@PathVariable("taskName") String taskName) {
        return baseService.displayDetail(taskName);
    }

    @RequestMapping(value = "/display/allTask", method = RequestMethod.GET)
    public Response displayAllTask() {
        return baseService.displayAllTask();
    }

    @RequestMapping(value = "/display/allTag", method = RequestMethod.GET)
    public Response displayAllTag() {
        return baseService.displayAllTag();
    }

    @RequestMapping(value = "/images/upload/{taskname}",method = RequestMethod.POST)
    public Response uploadImg(@PathVariable("taskname") String taskname, MultipartFile imageObject){
        try {
            return imgService.uploadImg(imageObject.getBytes(),imageObject.getOriginalFilename(),taskname);
        } catch (Exception e) {
            e.printStackTrace();
            return new UploadRep(UploadRepCode.FAIL);
        }
    }
}
