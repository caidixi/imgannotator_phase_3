package wnderful.imgannotator.request.base;

public class SearchRequest {
    private String type;
    private String content;

    public SearchRequest() {
    }

    public SearchRequest(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
