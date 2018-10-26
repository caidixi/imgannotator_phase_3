package wnderful.imgannotator.dao.entity;

import wnderful.imgannotator.dao.entity.user.Worker;

import javax.persistence.*;

@Entity
public class Process {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private int markedImg;

    @Column(nullable = false)
    private int gotPoints;

    @Column(nullable = false)
    private int isCompleted;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="worker_id")
    private Worker worker;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="task_name")
    private Task task;

    public Process() {
    }

    public Process( Worker worker, Task task) {
        this.markedImg = 0;
        this.gotPoints = 0;
        this.isCompleted = 0;
        this.worker = worker;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMarkedImg() {
        return markedImg;
    }

    public void setMarkedImg(int markedImg) {
        this.markedImg = markedImg;
    }

    public int getGotPoints() {
        return gotPoints;
    }

    public void setGotPoints(int gotPoints) {
        this.gotPoints = gotPoints;
    }

    public int getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(int isCompleted) {
        this.isCompleted = isCompleted;
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

    public void addMarkedImg(){
        markedImg++;
    }
}
