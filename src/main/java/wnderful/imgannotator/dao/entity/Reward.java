package wnderful.imgannotator.dao.entity;

import wnderful.imgannotator.dao.entity.user.Worker;

import javax.persistence.*;

@Entity
public class Reward {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private int points;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="worker_id")
    private Worker worker;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="task_name")
    private Task task;

    public Reward() {
    }

    public Reward(int points, Worker worker, Task task) {
        this.points = points;
        this.worker = worker;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
