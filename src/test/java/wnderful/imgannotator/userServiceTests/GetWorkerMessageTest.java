package wnderful.imgannotator.userServiceTests;

import com.alibaba.fastjson.JSON;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import wnderful.imgannotator.blserviceImpl.BaseServiceImpl;
import wnderful.imgannotator.blserviceImpl.RequesterTaskServiceImpl;
import wnderful.imgannotator.blserviceImpl.UserServiceImpl;
import wnderful.imgannotator.dataServiceImpl.NormalDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.userResponseCode.GetUserMassageRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.userResponse.GetUserMassageRep;
import wnderful.imgannotator.vo.userVo.WorkerMessageVo;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class GetWorkerMessageTest {
    private UserServiceImpl userService = new UserServiceImpl();
    private RequesterTaskServiceImpl taskService = new RequesterTaskServiceImpl();

    @BeforeClass
    public static void prepare() {
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caidixi", "123456", "caidixi@163.com", "worker");
        baseService.signUp("caiweilin", "111111", "caiweilin@163.com", "worker");
    }

    @Test
    public void test1(){
        Response response = userService.getUserMessage("caidixi","worker");
        String repStr = JSON.toJSONString(response);
        WorkerMessageVo vo = new WorkerMessageVo("caidixi","caidixi@163.com",1000,0,0);
        String hopoeRep = JSON.toJSONString(new GetUserMassageRep(GetUserMassageRepCode.SUCCESS,vo));
        assertEquals(hopoeRep,repStr);
    }


    @Test
    public void test3(){
        Response response = userService.getUserMessage("caidixi","worke");
        String repStr = JSON.toJSONString(response);
        String hopoeRep = JSON.toJSONString(new GetUserMassageRep(GetUserMassageRepCode.NOTFOUND));
        assertEquals(hopoeRep,repStr);
    }

    @Test
    public void test4(){
        Response response = userService.getUserMessage("cai","worker");
        String repStr = JSON.toJSONString(response);
        String hopoeRep = JSON.toJSONString(new GetUserMassageRep(GetUserMassageRepCode.FAIL));
        assertEquals(hopoeRep,repStr);
    }
}
