package wnderful.imgannotator.vo.taskVo;

public class WorkerVo {
    private String name;
    private int completedImgs;

    public WorkerVo() {
        name = "";
        completedImgs = -1;
    }

    public WorkerVo(String name, int completedImgs) {
        this.name = name;
        this.completedImgs = completedImgs;
    }

    public String getName() {
        return name;
    }

    public int getCompletedImgs() {
        return completedImgs;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCompletedImgs(int completedImgs) {
        this.completedImgs = completedImgs;
    }

}