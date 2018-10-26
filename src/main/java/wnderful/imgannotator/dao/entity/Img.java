package wnderful.imgannotator.dao.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Img {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String imgName;

    @Column(nullable = false,unique = true,columnDefinition = "varchar(255) character set utf8")
    private String imgURL;


    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="task_name")
    private Task task;

    @OneToMany(mappedBy = "img",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Work> works;

    @OneToMany(mappedBy = "img",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Mark> marks;


    public Img() {
    }

    public Img(String imgName, String imgURL, Task task) {
        this.imgName = imgName;
        this.imgURL = imgURL;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(ArrayList<Work> works) {
        this.works = works;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Mark> marks) {
        this.marks = marks;
    }
}
