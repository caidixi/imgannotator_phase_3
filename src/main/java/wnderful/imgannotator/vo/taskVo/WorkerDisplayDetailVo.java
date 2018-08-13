package wnderful.imgannotator.vo.taskVo;

public class WorkerDisplayDetailVo {
      private String taskname;
      private String taskStartTime;
      private String imgURL;
      private String taskDescription;
      private String taskRequester;
      private int numberOfImages;
      private int totalPoints;
      private int currentWorker;
      private int needImgs;
      private int completedImgs;
      private int gotPoints;
      private int taskIsEnd;
      private int taskIsComplete;
      private int haveReward;
      private String[] taskTag;

    public WorkerDisplayDetailVo() {
    }

    public WorkerDisplayDetailVo(String taskname, String taskStartTime, String imgURL, String taskDescription,
                                 String taskRequester, int numberOfImages, int totalPoints, int currentWorker, int taskIsEnd) {
        this.taskname = taskname;
        this.taskStartTime = taskStartTime;
        this.imgURL = imgURL;
        this.taskDescription = taskDescription;
        this.taskRequester = taskRequester;
        this.numberOfImages = numberOfImages;
        this.totalPoints = totalPoints;
        this.currentWorker = currentWorker;
        this.taskIsEnd = taskIsEnd;
    }

    public WorkerDisplayDetailVo(String taskname, String taskStartTime, String imgURL, String taskDescription,
                                 String taskRequester, int numberOfImages, int totalPoints, int currentWorker,
                                 int needImgs, int completedImgs, int gotPoints, int taskIsEnd,
                                 int taskIsComplete, int haveReward, String[] taskTag) {
        this.taskname = taskname;
        this.taskStartTime = taskStartTime;
        this.imgURL = imgURL;
        this.taskDescription = taskDescription;
        this.taskRequester = taskRequester;
        this.numberOfImages = numberOfImages;
        this.totalPoints = totalPoints;
        this.currentWorker = currentWorker;
        this.needImgs = needImgs;
        this.completedImgs = completedImgs;
        this.gotPoints = gotPoints;
        this.taskIsEnd = taskIsEnd;
        this.taskIsComplete = taskIsComplete;
        this.haveReward = haveReward;
        this.taskTag = taskTag;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getTaskStartTime() {
        return taskStartTime;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskRequester() {
        return taskRequester;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getCurrentWorker() {
        return currentWorker;
    }

    public int getNeedImgs() {
        return needImgs;
    }

    public int getCompletedImgs() {
        return completedImgs;
    }

    public int getGotPoints() {
        return gotPoints;
    }

    public int getTaskIsEnd() {
        return taskIsEnd;
    }

    public int getTaskIsComplete() {
        return taskIsComplete;
    }

    public int getHaveReward() {
        return haveReward;
    }

    public String[] getTaskTag() {
        return taskTag;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public void setTaskStartTime(String taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskRequester(String taskRequester) {
        this.taskRequester = taskRequester;
    }

    public void setNumberOfImages(int numberOfImages) {
        this.numberOfImages = numberOfImages;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setCurrentWorker(int currentWorker) {
        this.currentWorker = currentWorker;
    }

    public void setNeedImgs(int needImgs) {
        this.needImgs = needImgs;
    }

    public void setCompletedImgs(int completedImgs) {
        this.completedImgs = completedImgs;
    }

    public void setGotPoints(int gotPoints) {
        this.gotPoints = gotPoints;
    }

    public void setTaskIsEnd(int taskIsEnd) {
        this.taskIsEnd = taskIsEnd;
    }

    public void setTaskIsComplete(int taskIsComplete) {
        this.taskIsComplete = taskIsComplete;
    }

    public void setHaveReward(int haveReward) {
        this.haveReward = haveReward;
    }

    public void setTaskTag(String[] taskTag) {
        this.taskTag = taskTag;
    }
}
