package wnderful.imgannotator.controller;

import org.springframework.web.bind.annotation.*;
import wnderful.imgannotator.blserviceImpl.UserServiceImpl;
import wnderful.imgannotator.request.user.CodeRequest;
import wnderful.imgannotator.request.user.PointRequest;
import wnderful.imgannotator.request.user.TagRequest;
import wnderful.imgannotator.request.user.UpdateUserRequest;
import wnderful.imgannotator.publicData.response.Response;

@RestController
@RequestMapping(value = "/service/user")
public class UserController {

    private final UserServiceImpl userService = new UserServiceImpl();

    @RequestMapping(value = "/updateUserMessage/{username}", method = RequestMethod.POST)
    public Response updateUserMessage(@PathVariable("username") String username,@RequestBody UpdateUserRequest request) {
        return userService.updateUserMessage(username,request.getNewEmail(),request.getOldPassword(),request.getNewPassword(),request.getRole());
    }

    @RequestMapping(value = "/worker/getUserMessage/{username}", method = RequestMethod.GET)
    public Response getWorkerMessage(@PathVariable("username") String username) {
        return userService.getUserMessage(username,"worker");
    }

    @RequestMapping(value = "/worker/lostPoints/{username}",method = RequestMethod.POST)
    public Response lostPoints(@PathVariable("username") String username, @RequestBody PointRequest request){
        return userService.lostPoints(username,request.getPoints());
    }

    @RequestMapping(value = "/requester/getUserMessage/{username}", method = RequestMethod.GET)
    public Response getRequesterMessage(@PathVariable("username") String username) {
        return userService.getUserMessage(username,"requester");
    }

    @RequestMapping(value = "/requester/addPoints/{username}",method = RequestMethod.POST)
    public Response addPoints(@PathVariable("username") String username, @RequestBody CodeRequest request){
        return userService.addPoints(username,request.getCode());
    }

    @RequestMapping(value = "/administrator/getCode/{username}",method = RequestMethod.POST)
    public Response getCode(@PathVariable("username") String username, @RequestBody PointRequest request){
        return userService.getCode(username,request.getPoints());
    }

    @RequestMapping(value = "/administrator/addTag/{username}",method = RequestMethod.POST)
    public Response addTag(@PathVariable("username") String username, @RequestBody TagRequest request){
        return userService.addTag(username,request.getTag());
    }

    @RequestMapping(value = "/administrator/deleteTag/{username}",method = RequestMethod.POST)
    public Response deleteTag(@PathVariable("username") String username, @RequestBody TagRequest request){
        return userService.deleteTag(username,request.getTag());
    }

    @RequestMapping(value = "/administrator/getUserInformation/{username}", method = RequestMethod.GET)
    public Response getUserInformation(@PathVariable("username") String username) {
        return userService.getUserInformation(username);
    }

}
