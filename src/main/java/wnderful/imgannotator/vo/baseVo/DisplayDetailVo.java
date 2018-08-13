package wnderful.imgannotator.vo.baseVo;

public class DisplayDetailVo {
    private String taskname;
    private String imgURL;
    private String taskRequester;
    private String taskStartTime;
    private String taskDescription;
    private int numberOfImages;
    private int totalPoints;
    private int taskIsEnd;
    private int currentWorker;
    private String[] taskTag;

    public DisplayDetailVo() {
    }



    public DisplayDetailVo(String taskname, String imgURL, String taskRequester, String taskStartTime,
                           String taskDescription, int numberOfImages, int totalPoints, int taskIsEnd, int currentWorker) {
        this.taskname = taskname;
        this.imgURL = imgURL;
        this.taskRequester = taskRequester;
        this.taskStartTime = taskStartTime;
        this.taskDescription = taskDescription;
        this.numberOfImages = numberOfImages;
        this.totalPoints = totalPoints;
        this.taskIsEnd = taskIsEnd;
        this.currentWorker = currentWorker;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getTaskRequester() {
        return taskRequester;
    }

    public String getTaskStartTime() {
        return taskStartTime;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getTaskIsEnd() {
        return taskIsEnd;
    }

    public int getCurrentWorker() {
        return currentWorker;
    }

    public String[] getTaskTag() {
        return taskTag;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public void setTaskRequester(String taskRequester) {
        this.taskRequester = taskRequester;
    }

    public void setTaskStartTime(String taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setNumberOfImages(int numberOfImages) {
        this.numberOfImages = numberOfImages;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setTaskIsEnd(int taskIsEnd) {
        this.taskIsEnd = taskIsEnd;
    }

    public void setCurrentWorker(int currentWorker) {
        this.currentWorker = currentWorker;
    }

    public void setTaskTag(String[] taskTag) {
        this.taskTag = taskTag;
    }
}
