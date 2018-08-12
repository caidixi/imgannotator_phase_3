package wnderful.imgannotator.blservice;

import wnderful.imgannotator.publicData.response.Response;

public interface RequesterTaskService {
    Response saveDraft(String username, String taskname, String taskDescription, int markTimes, String[] taskTag, int credits, String taskType);

    Response displayReleasedTask(String username);

    Response displayDraft(String username);

    Response deleteTask(String username, String taskName);

    Response loadDraft(String username,String taskname);

    Response releaseTask(String username,String taskname);

    Response deleteDraft(String username,String taskname);

    Response displayDetail(String username,String taskname);
}
