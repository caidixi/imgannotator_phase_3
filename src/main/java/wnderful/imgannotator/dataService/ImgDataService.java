package wnderful.imgannotator.dataService;

import wnderful.imgannotator.dao.entity.Img;
import wnderful.imgannotator.vo.baseVo.PointVo;
import wnderful.imgannotator.vo.markVo.ImgUrlVo;
import wnderful.imgannotator.vo.markVo.ImgUrlsVo;

import java.util.ArrayList;

public interface ImgDataService {

    ImgUrlVo findAImgURL(String taskname, String workername);

    ImgUrlsVo findImgURLs(String taskname);

    boolean imgExist(String taskname,String imgID);

    boolean uploadImg(String taskname,String imgID ,byte[] bytes);

    boolean skipImg(String username,String taskname,String imgID);

    boolean taskIsCompleted(String taskname,String username);

    int findTaskImgNum(String taskname);

    int findMarkedImgNum(String taskname);

    ArrayList<Img> readyToMarkImg(String username, String taskname);

    PointVo getMarkReward(String username, String taskname, String imgID);
}
