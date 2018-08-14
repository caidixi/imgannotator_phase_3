package wnderful.imgannotator.dataService;

import wnderful.imgannotator.vo.taskVo.DraftVo;
import wnderful.imgannotator.vo.taskVo.TasknamesVo;

public interface DraftDataService {
    boolean draftExist(String taskname);

    boolean newDraft(String username,String taskname);

    boolean newTask(String taskname);

    boolean saveDraft(String taskname, String taskDescription, int markTimes, String[] taskTag, int credits, String taskType);

    boolean deleteDraft(String taskname);

    boolean isSave(String taskname,String requestername);

    boolean requesterDraftNotFull(String username);

    DraftVo findDraft(String taskname);

    TasknamesVo findAllDraft(String requestername);
}
