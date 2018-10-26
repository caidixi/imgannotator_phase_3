package wnderful.imgannotator.request.base;

import java.io.Serializable;

public class ImgNameRequest implements Serializable {
    private String taskname;

    public ImgNameRequest() {
    }

    public ImgNameRequest(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }
}
