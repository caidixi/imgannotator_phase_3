package wnderful.imgannotator.dao.entity;

import wnderful.imgannotator.dao.entity.user.Requester;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private String taskDescription;

    @Column(nullable = false,unique = true)
    private String imgURL;

    @Column(nullable = false)
    private  String type;

    @Column(nullable = false)
    private String startTime;

    @Column(nullable = false)
    private int credits;

    @Column(nullable = false)
    private int imgPoints;

    @Column(nullable = false)
    private int markTimes;

    @Column(nullable = false)
    private int isEnd;

    @Column(nullable = false)
    private int isDraft;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="requester_id")
    private Requester requester;

    @OneToMany(mappedBy = "task",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "task",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Process> processes = new ArrayList<>();

    @OneToMany(mappedBy = "task",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Reward> rewards = new ArrayList<>();

    @OneToMany(mappedBy = "task",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Img> imgs = new ArrayList<>();

    public Task() {
    }

    public Task(Requester requester, String name) {
        this.name = name;
        this.requester = requester;
        this.isDraft = 1;
        this.taskDescription = "";
        this.startTime = "";
        this.imgURL = "";
        this.type = "";
    }

    public Task(String name, String taskDescription, String imgURL, String type, String startTime, int credits,
                int imgPoints, int markTimes, int isEnd, int isDraft,Requester requester) {
        this.name = name;
        this.taskDescription = taskDescription;
        this.imgURL = imgURL;
        this.type = type;
        this.startTime = startTime;
        this.credits = credits;
        this.imgPoints = imgPoints;
        this.markTimes = markTimes;
        this.isEnd = isEnd;
        this.isDraft = isDraft;
        this.requester = requester;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getCredits() {
        return credits;
    }

    public List<Img> getImgs() {
        return imgs;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getImgPoints() {
        return imgPoints;
    }

    public void setImgPoints(int imgPoints) {
        this.imgPoints = imgPoints;
    }

    public int getMarkTimes() {
        return markTimes;
    }

    public void setMarkTimes(int markTimes) {
        this.markTimes = markTimes;
    }

    public int getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(int isEnd) {
        this.isEnd = isEnd;
    }

    public int getIsDraft() {
        return isDraft;
    }

    public void setIsDraft(int isDraft) {
        this.isDraft = isDraft;
    }

    public Requester getRequester() {
        return requester;
    }

    public void setRequester(Requester requester) {
        this.requester = requester;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(ArrayList<Process> processes) {
        this.processes = processes;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(ArrayList<Reward> rewards) {
        this.rewards = rewards;
    }


}
