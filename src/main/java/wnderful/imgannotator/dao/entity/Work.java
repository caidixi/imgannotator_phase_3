package wnderful.imgannotator.dao.entity;

import wnderful.imgannotator.dao.entity.user.Worker;

import javax.persistence.*;

@Entity
public class Work {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String  taskName;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="worker_id")
    private Worker worker;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="img_id")
    private Img img;


    public Work() {
    }

    public Work(String taskName, Worker worker, Img img) {
        this.taskName = taskName;
        this.worker = worker;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Img getImg() {
        return img;
    }

    public void setImg(Img img) {
        this.img = img;
    }
}
