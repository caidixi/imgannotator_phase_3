package wnderful.imgannotator.request.mark;

import com.alibaba.fastjson.JSONObject;

public class ImgMarkRequest {
    private String taskname;
    private String imgID;
    private JSONObject marks;

    public ImgMarkRequest() {
    }

    public ImgMarkRequest(String taskname, String imgID, JSONObject marks) {
        this.taskname = taskname;
        this.imgID = imgID;
        this.marks = marks;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getImgID() {
        return imgID;
    }

    public JSONObject getMarks() {
        return marks;
    }
}
