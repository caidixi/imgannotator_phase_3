package wnderful.imgannotator.dao.entity.user;

import wnderful.imgannotator.dao.entity.Task;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Requester {
    @Id
    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int points;

    @Column(nullable = false)
    private int usedPoints;

    @Column(nullable = false)
    private int maxReleasedTask;

    @OneToMany(mappedBy = "requester",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Task> tasks;

    public Requester() {
    }

    public Requester(String username, String password, String email, int points, int maxReleasedTask) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.points = points;
        this.maxReleasedTask = maxReleasedTask;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getUsedPoints() {
        return usedPoints;
    }

    public void setUsedPoints(int usedPoints) {
        this.usedPoints = usedPoints;
    }

    public int getMaxReleasedTask() {
        return maxReleasedTask;
    }

    public void setMaxReleasedTask(int maxReleasedTask) {
        this.maxReleasedTask = maxReleasedTask;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
