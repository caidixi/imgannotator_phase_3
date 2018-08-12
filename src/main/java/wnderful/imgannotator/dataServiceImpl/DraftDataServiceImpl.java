package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dataService.DraftDataService;
import wnderful.imgannotator.vo.taskVo.DraftVo;
import wnderful.imgannotator.vo.taskVo.TasknamesVo;

public class DraftDataServiceImpl implements DraftDataService {
    @Override
    public boolean draftExist(String taskname) {
        return false;
    }

    @Override
    public boolean newDraft(String taskname) {
        return false;
    }

    @Override
    public boolean newTask(String taskname) {
        return false;
    }

    @Override
    public boolean saveDraft(String requester, String taskname, String taskDescription, int markTimes, String[] taskTag, int credits, String taskType) {
        return false;
    }

    @Override
    public boolean deleteDraft(String taskname) {
        return false;
    }

    @Override
    public boolean isSave(String taskname, String requestername) {
        return false;
    }

    @Override
    public DraftVo findDraft(String taskname) {
        return null;
    }

    @Override
    public TasknamesVo findAllDraft(String requestername) {
        return null;
    }
}
