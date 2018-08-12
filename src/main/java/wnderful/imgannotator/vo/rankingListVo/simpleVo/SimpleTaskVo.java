package wnderful.imgannotator.vo.rankingListVo.simpleVo;

public class SimpleTaskVo {
    private String taskname;
    private int data;

    public SimpleTaskVo(String taskname) {
        this.taskname = taskname;
    }

    public SimpleTaskVo() {
    }

    public String getTaskname() {
        return taskname;
    }

    public int getData() {
        return data;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public void setData(int data) {
        this.data = data;
    }
}
