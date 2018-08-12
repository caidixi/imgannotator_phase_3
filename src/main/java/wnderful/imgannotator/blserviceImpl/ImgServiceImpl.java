package wnderful.imgannotator.blserviceImpl;

import wnderful.imgannotator.blservice.ImgService;
import wnderful.imgannotator.dataServiceImpl.DraftDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.ImgDataServiceImpl;
import wnderful.imgannotator.dataServiceImpl.UserDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.ImgResponseCode.CreatePackageRepCode;
import wnderful.imgannotator.publicData.reponseCode.ImgResponseCode.UploadRepCode;
import wnderful.imgannotator.publicData.response.ImgResponse.CreatePackageRep;
import wnderful.imgannotator.publicData.response.ImgResponse.UploadRep;

public class ImgServiceImpl implements ImgService {

    private ImgDataServiceImpl imgDataService = new ImgDataServiceImpl();
    private UserDataServiceImpl userDataService = new UserDataServiceImpl();
    private DraftDataServiceImpl draftDataService = new DraftDataServiceImpl();

    @Override
    public UploadRep uploadImg(byte[] bytes, String imgID, String taskname) {
        if (draftDataService.draftExist(taskname)) {
            if (!imgDataService.imgExist(taskname, imgID)) {
                if (imgDataService.uploadImg(taskname, imgID, bytes)) {
                    return new UploadRep(UploadRepCode.SUCCESS);
                } else {
                    return new UploadRep(UploadRepCode.FAIL);
                }
            } else {
                return new UploadRep(UploadRepCode.REPEAT);
            }
        } else {
            return new UploadRep(UploadRepCode.NOFOLDER);
        }
    }

    //创建图片文件夹
    @Override
    public CreatePackageRep createPackage(String username, String taskname) {
        if (userDataService.requesterExist(username)) {
            if  (!taskname.equals("")) {
                if (!draftDataService.draftExist(taskname)) {
                    if (draftDataService.newDraft(taskname)) {
                        return new CreatePackageRep(CreatePackageRepCode.SUCCESS);
                    } else {
                        return new CreatePackageRep(CreatePackageRepCode.FAIL);
                    }
                } else {
                    return new CreatePackageRep(CreatePackageRepCode.REPEAT);
                }
            } else {
                return new CreatePackageRep(CreatePackageRepCode.EMPTYTASKNAME);
            }
        } else {
            return new CreatePackageRep(CreatePackageRepCode.NOTFOUND);
        }
    }
}
