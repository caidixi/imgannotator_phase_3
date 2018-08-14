package wnderful.imgannotator.dataService;

import wnderful.imgannotator.exception.RechargeException;
import wnderful.imgannotator.vo.baseVo.PointVo;
import wnderful.imgannotator.vo.userVo.CodeVo;

public interface PointsDataService {
    PointVo codeToPoints(String code ) ;

    boolean modifyPoints(int points,String username,String role);

    PointVo receiptReward(String workername,String taskname );

    boolean settleTaskPoints(String taskname);

    boolean rewardExist(String workername,String taskname);

    CodeVo pointsToCode(int points);

}
