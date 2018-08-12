package wnderful.imgannotator.vo.userVo;

public class RequesterMessageVo extends UserMessageVo{
    private String username;
    private String email;
    private int points;
    private int releasedTasks;
    private int unreleasedTasks;
    private int completedTasks;
    private int uncompletedTasks;
    private int usedPoints;
    private int maxUnreleasedTasks;
    private String role = "requester";

    public RequesterMessageVo() {
        this.username = "";
        this.email = "";
        this.points = -1;
        this.releasedTasks = -1;
    }

    public RequesterMessageVo(String username, String email, int points, int releasedTasks) {
        this.username = username;
        this.email = email;
        this.points = points;
        this.releasedTasks = releasedTasks;
    }

    public RequesterMessageVo(String username, String email, int points, int releasedTasks, int unreleasedTasks, int completedTasks, int uncompletedTasks, int usedPoints, int maxUnreleasedTasks) {
        this.username = username;
        this.email = email;
        this.points = points;
        this.releasedTasks = releasedTasks;
        this.unreleasedTasks = unreleasedTasks;
        this.completedTasks = completedTasks;
        this.uncompletedTasks = uncompletedTasks;
        this.usedPoints = usedPoints;
        this.maxUnreleasedTasks = maxUnreleasedTasks;
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

    public int getReleasedTasks() {
        return releasedTasks;
    }

    public int getUnreleasedTasks() {
        return unreleasedTasks;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public int getUncompletedTasks() {
        return uncompletedTasks;
    }

    public int getUsedPoints() {
        return usedPoints;
    }

    public int getMaxUnreleasedTasks() {
        return maxUnreleasedTasks;
    }

    @Override
    public String getRole() {
        return role;
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

    public void setReleasedTasks(int releasedTasks) {
        this.releasedTasks = releasedTasks;
    }

    public void setUnreleasedTasks(int unreleasedTasks) {
        this.unreleasedTasks = unreleasedTasks;
    }

    public void setCompletedTasks(int completedTasks) {
        this.completedTasks = completedTasks;
    }

    public void setUncompletedTasks(int uncompletedTasks) {
        this.uncompletedTasks = uncompletedTasks;
    }

    public void setUsedPoints(int usedPoints) {
        this.usedPoints = usedPoints;
    }

    public void setMaxUnreleasedTasks(int maxUnreleasedTasks) {
        this.maxUnreleasedTasks = maxUnreleasedTasks;
    }
}
