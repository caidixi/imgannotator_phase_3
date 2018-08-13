package wnderful.imgannotator.dataServiceImpl;

import org.springframework.stereotype.Service;
import wnderful.imgannotator.dataService.PointsDataService;
import wnderful.imgannotator.vo.baseVo.PointVo;
import wnderful.imgannotator.vo.userVo.CodeVo;

@Service
public class PointsDataServiceImpl implements PointsDataService {

    @Override
    public PointVo codeToPoints(String code, String username) {
        return null;
    }

    @Override
    public boolean modifyPoints(int points, String username,String role) {
        return false;
    }

    @Override
    public PointVo receiptReward(String workername, String taskname) {
        return null;
    }

    @Override
    public boolean settleTaskPoints(String taskname) {
        return false;
    }

    @Override
    public boolean rewardExist(String workername, String taskname) {
        return false;
    }

    @Override
    public CodeVo pointsToCode(int points) {
        return null;
    }

    @Override
    public int caculateImgPoints(int basic, int completedImg, int totalImg, boolean full, int markTime, int skipTime) {
        return 0;
    }

    @Override
    public PointVo getMarkReward(String username, String taskname, String imgID) {
        return null;
    }
}
