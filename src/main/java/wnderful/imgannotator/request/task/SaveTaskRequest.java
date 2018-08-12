package wnderful.imgannotator.request.task;

public class SaveTaskRequest {
    private String taskname;
    private String taskDescription;
    private String[] taskTag;
    private int credits;
    private int markTimes;
    private String taskType;

    public SaveTaskRequest() {
    }

    public SaveTaskRequest(String taskname, String taskDescription, String[] taskTag, int credits, int markTimes, String taskType) {
        this.taskname = taskname;
        this.taskDescription = taskDescription;
        this.taskTag = taskTag;
        this.credits = credits;
        this.markTimes = markTimes;
        this.taskType = taskType;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String[] getTaskTag() {
        return taskTag;
    }

    public int getCredits() {
        return credits;
    }

    public int getMarkTimes() {
        return markTimes;
    }

    public String getTaskType() {
        return taskType;
    }
}
