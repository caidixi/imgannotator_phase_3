package wnderful.imgannotator.request.mark;

public class SimpleImgRequest {
    private String taskname;
    private String imgID;

    public SimpleImgRequest(String taskname, String imgID) {
        this.taskname = taskname;
        this.imgID = imgID;
    }

    public SimpleImgRequest() {
    }

    public String getTaskname() {
        return taskname;
    }

    public String getImgID() {
        return imgID;
    }
}
