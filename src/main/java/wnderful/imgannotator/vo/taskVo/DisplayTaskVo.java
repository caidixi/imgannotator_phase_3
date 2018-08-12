package wnderful.imgannotator.vo.taskVo;

public class DisplayTaskVo {
    private TaskVo[] tasks;

    public DisplayTaskVo() {
        tasks = new TaskVo[]{};
    }

    public DisplayTaskVo(TaskVo[] tasks) {
        this.tasks = tasks;
    }

    public void setTasks(TaskVo[] tasks) {
        this.tasks = tasks;
    }

    public TaskVo[] getTasks() {
        return tasks;
    }
}
