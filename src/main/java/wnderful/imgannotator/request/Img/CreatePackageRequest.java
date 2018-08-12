package wnderful.imgannotator.request.Img;

public class CreatePackageRequest {
    private String taskname;

    public CreatePackageRequest() {
    }

    public CreatePackageRequest(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskname() {
        return taskname;
    }
}
