package wnderful.imgannotator.dao.entity.mark;

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

    @Column(nullable = false)
    private String wholeDesc;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="worker_id")
    private Worker worker;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="img_id")
    private Img img;

    @OneToMany(mappedBy = "mark",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<PolyMark> polyMarks;

    @OneToMany(mappedBy = "mark",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<RectMark> rectMarks;

    public Mark() {
    }

    public Mark(Worker worker, String wholeDesc, Img img) {
        this.worker = worker;
        this.wholeDesc = wholeDesc;
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

    public String getWholeDesc() {
        return wholeDesc;
    }

    public void setWholeDesc(String wholeDesc) {
        this.wholeDesc = wholeDesc;
    }

    public List<PolyMark> getPolyMarks() {
        return polyMarks;
    }

    public void setPolyMarks(ArrayList<PolyMark> polyMarks) {
        this.polyMarks = polyMarks;
    }

    public List<RectMark> getRectMarks() {
        return rectMarks;
    }

    public void setRectMarks(ArrayList<RectMark> rectMarks) {
        this.rectMarks = rectMarks;
    }
}
