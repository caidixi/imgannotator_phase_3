package wnderful.imgannotator.request.task;

public class SimpleTaskRequest {

    private String taskname;

    public SimpleTaskRequest() {
    }

    public SimpleTaskRequest(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskname() {
        return taskname;
    }
}
