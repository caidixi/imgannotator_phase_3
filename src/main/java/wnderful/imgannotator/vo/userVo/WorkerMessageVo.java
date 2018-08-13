package wnderful.imgannotator.vo.userVo;

public class WorkerMessageVo extends UserMessageVo {
    private String username;
    private String email;
    private int points;
    private int completedTasks;
    private int completedImages;
    private int readyToCompleteTasks;
    private int rewardTasks;
    private String role = "worker";

    public WorkerMessageVo() {
        this.username = "";
        this.email = "";
        this.points = -1;
        this.completedTasks = -1;
        this.completedImages = -1;
    }

    public WorkerMessageVo(String username, String email, int points) {
        this.username = username;
        this.email = email;
        this.points = points;
        this.completedTasks = 0;
        this.completedImages = 0;
        this.rewardTasks = 0;
        this.readyToCompleteTasks = 0;
    }

    public WorkerMessageVo(String username, String email, int points, int completedTasks, int completedImages, int readyToCompleteTasks, int rewardTasks) {
        this.username = username;
        this.email = email;
        this.points = points;
        this.completedTasks = completedTasks;
        this.completedImages = completedImages;
        this.readyToCompleteTasks = readyToCompleteTasks;
        this.rewardTasks = rewardTasks;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getPoints() {
        return points;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public int getCompletedImages() {
        return completedImages;
    }

    @Override
    public String getRole() {
        return role;
    }

    public int getReadyToCompleteTasks() {
        return readyToCompleteTasks;
    }

    public int getRewardTasks() {
        return rewardTasks;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setCompletedTasks(int completedTasks) {
        this.completedTasks = completedTasks;
    }

    public void setCompletedImages(int completedImages) {
        this.completedImages = completedImages;
    }

    public void setReadyToCompleteTasks(int readyToCompleteTasks) {
        this.readyToCompleteTasks = readyToCompleteTasks;
    }

    public void setRewardTasks(int rewardTasks) {
        this.rewardTasks = rewardTasks;
    }
}
