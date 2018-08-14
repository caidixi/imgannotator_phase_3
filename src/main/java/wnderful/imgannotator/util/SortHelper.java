package wnderful.imgannotator.util;

import wnderful.imgannotator.dao.entity.Img;
import wnderful.imgannotator.vo.rankingListVo.SimpleVo;

import java.util.ArrayList;

public class SortHelper {

    public Img findRecommendImg(ArrayList<Img> imgs){
        if(imgs.size()>0){
            return imgs.get(0);
        }else {
            return null;
        }
    }

    public ArrayList<SimpleVo> selectSort(ArrayList<SimpleVo> list){
        int length = list.size();
        ArrayList<SimpleVo> result = new ArrayList<>();
        for(int i = 0;i < length;i++){
            SimpleVo max = list.get(0);
            int index = 0;
            for(int j = 1;j < list.size();j++){
                SimpleVo vo = list.get(j);
                if(max.getData()<vo.getData()){
                    max = vo;
                    index = j;
                }
            }
            result.add(max);
            list.remove(index);
        }
        return result;
    }

    public int getRank(ArrayList<SimpleVo> list,String name){
        int result = 1;
        for(SimpleVo simpleVo:list){
            if(simpleVo.getName().equals(name)){
                return result;
            }else {
                result++;
            }
        }
        return 0;
    }
}
