package wnderful.imgannotator.dao.entity.user;

import wnderful.imgannotator.dao.entity.Process;
import wnderful.imgannotator.dao.entity.Reward;
import wnderful.imgannotator.dao.entity.Work;
import wnderful.imgannotator.dao.entity.Mark;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int points;

    @OneToMany(mappedBy = "worker",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Process> processes= new ArrayList<>();

    @OneToMany(mappedBy = "worker",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Reward> rewards= new ArrayList<>();

    @OneToMany(mappedBy = "worker",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Work> works= new ArrayList<>();

    @OneToMany(mappedBy = "worker",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Mark> marks= new ArrayList<>();

    public Worker() {
    }

    public Worker(String username, String password, String email, int points) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getPoints() {
        return points;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public List<Work> getWorks() {
        return works;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
