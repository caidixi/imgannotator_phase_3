package wnderful.imgannotator.vo.taskVo;

public class DraftVo {
    private String taskname;
    private String taskDescription;
    private int credits;
    private String[] taskTag;
    private String taskType;
    private int markTimes;
    private int imgNum;

    public DraftVo() {
    }

    public DraftVo(String taskname, String taskDescription, int credits, String[] taskTag, String taskType, int markTimes, int imgNum) {
        this.taskname = taskname;
        this.taskDescription = taskDescription;
        this.credits = credits;
        this.taskTag = taskTag;
        this.taskType = taskType;
        this.markTimes = markTimes;
        this.imgNum = imgNum;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public int getCredits() {
        return credits;
    }

    public String[] getTaskTag() {
        return taskTag;
    }

    public String getTaskType() {
        return taskType;
    }

    public int getMarkTimes() {
        return markTimes;
    }

    public int getImgNum() {
        return imgNum;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setTaskTag(String[] taskTag) {
        this.taskTag = taskTag;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public void setMarkTimes(int markTimes) {
        this.markTimes = markTimes;
    }

    public void setImgNum(int imgNum) {
        this.imgNum = imgNum;
    }
}
