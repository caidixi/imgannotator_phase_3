package wnderful.imgannotator.vo.markVo;

import com.alibaba.fastjson.JSONObject;

public class MarkVo {
    private JSONObject[] allMarks;

    public MarkVo() {
        allMarks = new JSONObject[1];
        allMarks[0] = new JSONObject();
    }

    public MarkVo(JSONObject[] allMarks) {
        this.allMarks = allMarks;
    }

    public JSONObject[] getAllMarks() {
        return allMarks;
    }

    public void setAllMarks(JSONObject[] allMarks) {
        this.allMarks = allMarks;
    }
}
