package wnderful.imgannotator.vo.rankingListVo.simpleVo;

public class SimpleUserVo {

    private String username;
    private int data;

    public SimpleUserVo() {
    }

    public SimpleUserVo(String username, int data) {
        this.username = username;
        this.data = data;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
