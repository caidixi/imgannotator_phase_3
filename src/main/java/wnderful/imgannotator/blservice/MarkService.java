package wnderful.imgannotator.blservice;

import com.alibaba.fastjson.JSONObject;
import wnderful.imgannotator.publicData.response.Response;

public interface MarkService {
    Response setMark(String username, String taskname, String imgID, JSONObject marks);

    Response findURL(String username, String taskname);

    Response getURLs(String username,String taskname);

    Response findMark(String taskname,String imgID,String username);

    Response skipImg(String taskname,String imgID,String username);

}
