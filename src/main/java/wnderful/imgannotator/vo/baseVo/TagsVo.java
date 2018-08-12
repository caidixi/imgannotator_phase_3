package wnderful.imgannotator.vo.baseVo;

public class TagsVo {
    private String[] tags;

    public TagsVo(String[] tags) {
        this.tags = tags;
    }

    public TagsVo() {
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
