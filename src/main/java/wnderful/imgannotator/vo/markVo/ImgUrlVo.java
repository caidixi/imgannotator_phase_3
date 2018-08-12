package wnderful.imgannotator.vo.markVo;

public class ImgUrlVo {
    private String imgURL = "";
    private int totalPoints;
    private int restImgs;
    private String taskType;
    private int probablyPoints;

    public ImgUrlVo() {
    }

    public ImgUrlVo(String imgURL, int totalPoints, int restImgs, String taskType, int probablyPoints) {
        this.imgURL = imgURL;
        this.totalPoints = totalPoints;
        this.restImgs = restImgs;
        this.taskType = taskType;
        this.probablyPoints = probablyPoints;
    }

    public String getImgURL() {
        return imgURL;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getRestImgs() {
        return restImgs;
    }

    public String getTaskType() {
        return taskType;
    }

    public int getProbablyPoints() {
        return probablyPoints;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setRestImgs(int restImgs) {
        this.restImgs = restImgs;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public void setProbablyPoints(int probablyPoints) {
        this.probablyPoints = probablyPoints;
    }
}
