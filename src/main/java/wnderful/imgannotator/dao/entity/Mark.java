package wnderful.imgannotator.dao.entity;

import wnderful.imgannotator.dao.entity.Img;
import wnderful.imgannotator.dao.entity.user.Worker;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Mark {
    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String content;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="worker_id")
    private Worker worker;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="img_id")
    private Img img;


    public Mark() {
    }

    public Mark( String content, Worker worker, Img img) {
        this.content = content;
        this.worker = worker;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
