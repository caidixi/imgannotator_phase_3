package wnderful.imgannotator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wnderful.imgannotator.blserviceImpl.ImgServiceImpl;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.request.Img.CreatePackageRequest;
import wnderful.imgannotator.request.Img.DeletePackageRequest;


@RestController
@RequestMapping(value = "/service/images")
public class ImgController {

    private final ImgServiceImpl imgService;

    @Autowired
    public ImgController(ImgServiceImpl imgService) {
        this.imgService = imgService;
    }

    @RequestMapping(value = "/createPackage/{username}", method = RequestMethod.POST)
    public Response createPackage(@PathVariable("username")String username, @RequestBody CreatePackageRequest request) {
        return imgService.createPackage(username,request.getTaskname());
    }
}
