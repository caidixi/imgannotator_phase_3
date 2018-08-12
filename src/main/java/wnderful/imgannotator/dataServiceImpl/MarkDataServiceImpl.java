package wnderful.imgannotator.dataServiceImpl;

import com.alibaba.fastjson.JSONObject;
import wnderful.imgannotator.dataService.MarkDataService;
import wnderful.imgannotator.vo.markVo.MarkVo;

public class MarkDataServiceImpl implements MarkDataService {

    @Override
    public boolean addMark(String workername, String taskname, String imgID, JSONObject marks) {
        return false;
    }

    @Override
    public MarkVo findAllMark(String taskname, String imgID) {
        return null;
    }
}
