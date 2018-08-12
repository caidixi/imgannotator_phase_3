package wnderful.imgannotator.vo.taskVo;

public class TaskVo {
    private String taskname;
    private String imgURL;
    private int taskIsEnd;
    private String[] taskTag;
    private int currentWorker;
    private int numberOfImages;

    public TaskVo() {
        this.taskname = "";
        this.imgURL = "";
        this.taskIsEnd = 1;
        this.taskTag = new String[0];
        this.currentWorker = 0;
        this.numberOfImages = 0;
    }

    public TaskVo(String taskname, String imgURL, int taskIsEnd, String[] taskTag, int currentWorker, int numberOfImages) {
        this.taskname = taskname;
        this.imgURL = imgURL;
        this.taskIsEnd = taskIsEnd;
        this.taskTag = taskTag;
        this.currentWorker = currentWorker;
        this.numberOfImages = numberOfImages;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getImgURL() {
        return imgURL;
    }

    public int getTaskIsEnd() {
        return taskIsEnd;
    }

    public String[] getTaskTag() {
        return taskTag;
    }

    public int getCurrentWorker() {
        return currentWorker;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public void setTaskIsEnd(int taskIsEnd) {
        this.taskIsEnd = taskIsEnd;
    }

    public void setTaskTag(String[] taskTag) {
        this.taskTag = taskTag;
    }

    public void setCurrentWorker(int currentWorker) {
        this.currentWorker = currentWorker;
    }

    public void setNumberOfImages(int numberOfImages) {
        this.numberOfImages = numberOfImages;
    }
}
