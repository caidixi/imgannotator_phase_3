package wnderful.imgannotator.vo.rankingListVo;

public class SimpleVo {

    private String name;
    private int data;

    public SimpleVo() {
    }

    public SimpleVo(String name, int data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
