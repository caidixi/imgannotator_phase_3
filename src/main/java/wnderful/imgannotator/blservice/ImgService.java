package wnderful.imgannotator.blservice;

import wnderful.imgannotator.publicData.response.Response;

public interface ImgService {
    Response uploadImg(byte[] bytes,String imgID,String taskname);

    Response createPackage(String username,String taskname);
}
