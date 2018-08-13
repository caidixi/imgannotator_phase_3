package wnderful.imgannotator.blservice;

import wnderful.imgannotator.publicData.response.Response;

public interface UserService {
    Response getUserMessage(String username, String role);

    Response updateUserMessage(String username, String newEmail, String oldPassword, String newPassword, String role);

    Response addPoints(String username, String code);

    Response lostPoints(String username, int points);

    Response getWorkerInformation(String username);

    Response getRequesterInformation(String username);

    Response getCode(String username,int points);

    Response addTag(String username,String tag);

    Response deleteTag(String username,String tag);
}
