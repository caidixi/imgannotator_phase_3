package wnderful.imgannotator.dao.entity;

import javax.persistence.*;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String content;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="task_name",nullable = true)
    private Task task;

    public Tag() {
    }


    public Tag(String content, Task task) {
        this.content = content;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
