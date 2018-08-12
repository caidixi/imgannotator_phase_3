package wnderful.imgannotator.request.Img;

public class DeletePackageRequest {
    private String taskname;

    public DeletePackageRequest() {
    }

    public DeletePackageRequest(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskname() {
        return taskname;
    }
}
