package wnderful.imgannotator.vo.taskVo;

public class RequesterDisplayDetailVo {
      private String taskname;
      private String taskStartTime;
      private String imgURL;
      private String taskDescription;
      private int numberOfImages;
      private int totalPoints;
      private int currentWorker;
      private int markTimes;
      private int releasedPoints;
      private int completedImgs;
      private int needImgs;
      private int taskIsEnd;
      private String[] taskTag;
      private WorkerVo[] currentWorkers;

    public RequesterDisplayDetailVo() {
        this.taskname = "";
        this.imgURL = "";
        this.taskStartTime = "";
        this.numberOfImages = -1;
        this.totalPoints = -1;
        this.taskDescription = "";
        this.taskIsEnd = -1;
        this.taskTag = new String[0];
        this.currentWorker = -1;
        this.markTimes = -1;
        this.currentWorkers = new WorkerVo[0];
    }

    public RequesterDisplayDetailVo(String taskname, String taskStartTime, String imgURL, String taskDescription,
                                    int numberOfImages, int totalPoints, int currentWorker, int markTimes, int releasedPoints,
                                    int completedImgs, int needImgs, int taskIsEnd, String[] taskTag, WorkerVo[] currentWorkers) {
        this.taskname = taskname;
        this.taskStartTime = taskStartTime;
        this.imgURL = imgURL;
        this.taskDescription = taskDescription;
        this.numberOfImages = numberOfImages;
        this.totalPoints = totalPoints;
        this.currentWorker = currentWorker;
        this.markTimes = markTimes;
        this.releasedPoints = releasedPoints;
        this.completedImgs = completedImgs;
        this.needImgs = needImgs;
        this.taskIsEnd = taskIsEnd;
        this.taskTag = taskTag;
        this.currentWorkers = currentWorkers;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getTaskStartTime() {
        return taskStartTime;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public String getTaskDescription() {
        return taskDescription;
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

    public int getMarkTimes() {
        return markTimes;
    }

    public WorkerVo[] getCurrentWorkers() {
        return currentWorkers;
    }

    public int getReleasedPoints() {
        return releasedPoints;
    }

    public int getCompletedImgs() {
        return completedImgs;
    }

    public int getNeedImgs() {
        return needImgs;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public void setTaskStartTime(String taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public void setNumberOfImages(int numberOfImages) {
        this.numberOfImages = numberOfImages;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
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

    public void setMarkTimes(int markTimes) {
        this.markTimes = markTimes;
    }

    public void setCurrentWorkers(WorkerVo[] currentWorkers) {
        this.currentWorkers = currentWorkers;
    }

    public void setReleasedPoints(int releasedPoints) {
        this.releasedPoints = releasedPoints;
    }

    public void setCompletedImgs(int completedImgs) {
        this.completedImgs = completedImgs;
    }

    public void setNeedImgs(int needImgs) {
        this.needImgs = needImgs;
    }
}
