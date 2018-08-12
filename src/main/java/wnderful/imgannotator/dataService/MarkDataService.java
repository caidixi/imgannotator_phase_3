package wnderful.imgannotator.dataService;

import com.alibaba.fastjson.JSONObject;
import wnderful.imgannotator.vo.markVo.MarkVo;

public interface MarkDataService {

    boolean addMark(String workername, String taskname,String imgID, JSONObject mark);

    MarkVo findAllMark(String taskname, String imgID);
}
