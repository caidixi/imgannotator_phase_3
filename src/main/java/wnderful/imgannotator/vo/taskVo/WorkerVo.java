package wnderful.imgannotator.vo.taskVo;

public class WorkerVo {
    private String name;
    private int completedImgs;
    private int needImgs;

    public WorkerVo() {
        name = "";
        completedImgs = -1;
    }

    public WorkerVo(String name, int completedImgs, int needImgs) {
        this.name = name;
        this.completedImgs = completedImgs;
        this.needImgs = needImgs;
    }

    public String getName() {
        return name;
    }

    public int getCompletedImgs() {
        return completedImgs;
    }

    public int getNeedImgs() {
        return needImgs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompletedImgs(int completedImgs) {
        this.completedImgs = completedImgs;
    }

    public void setNeedImgs(int needImgs) {
        this.needImgs = needImgs;
    }
}