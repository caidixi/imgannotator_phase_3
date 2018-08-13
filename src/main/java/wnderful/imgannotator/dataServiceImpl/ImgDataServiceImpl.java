package wnderful.imgannotator.dataServiceImpl;

import org.springframework.stereotype.Service;
import wnderful.imgannotator.dao.entity.Img;
import wnderful.imgannotator.dataService.ImgDataService;
import wnderful.imgannotator.vo.markVo.ImgUrlVo;
import wnderful.imgannotator.vo.markVo.ImgUrlsVo;

import java.util.ArrayList;

@Service
public class ImgDataServiceImpl implements ImgDataService {
    public ImgDataServiceImpl() {
        super();
    }

    @Override
    public ImgUrlVo findAImgURL(String taskname, String workername) {
        return null;
    }

    @Override
    public ImgUrlsVo findImgURLs(String taskname) {
        return null;
    }

    @Override
    public boolean imgExist(String taskname, String imgID) {
        return false;
    }

    @Override
    public boolean uploadImg(String taskname, String imgID, byte[] bytes) {
        return false;
    }

    @Override
    public boolean isComplete(String taskname, String imgID) {
        return false;
    }

    @Override
    public boolean skipImg(String username, String taskname, String ImgID) {
        return false;
    }

    @Override
    public int findTaskImgNum(String taskname) {
        return 0;
    }

    @Override
    public int findMarkedImgNum(String taskname) {
        return 0;
    }

    @Override
    public ArrayList<Img> readyToMarkImg(String username, String taskname) {
        ArrayList<Img> imgs = new ArrayList<>();
        return imgs;
    }

    public ArrayList<Img> readyToCompleteImg(String taskname){
        return null;
    }
}
