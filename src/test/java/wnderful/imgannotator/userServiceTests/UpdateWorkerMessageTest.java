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
import wnderful.imgannotator.blserviceImpl.UserServiceImpl;
import wnderful.imgannotator.dataServiceImpl.NormalDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.userResponseCode.UpdateUserMessageRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.userResponse.UpdateUserMessageRep;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UpdateWorkerMessageTest {
    private UserServiceImpl userService= new UserServiceImpl();

    @BeforeClass
    public static void prepare(){
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caidixi","123456789","caidixi@163.com","worker");
        baseService.signUp("caizhe","987654321","caizhe@163.com","requester");
        baseService.signUp("caiweilin","111111","caiweilin@163.com","worker");
        baseService.signUp("caojiawei","666666","caojiawei@163.com","requester");
    }

    @Test
    public void test1(){
        Response response = userService.updateUserMessage("caidixi","729195690@qq.com","123456789","111111","worker");
        String repStr = JSON.toJSONString(response);
        String hopRep = JSON.toJSONString(new UpdateUserMessageRep(UpdateUserMessageRepCode.SUCCESS));
        assertEquals(hopRep,repStr);
    }

    @Test
    public void test2(){
        Response response = userService.updateUserMessage("","729195690@qq.com","123456789","111111","worker");
        String repStr = JSON.toJSONString(response);
        String hopRep = JSON.toJSONString(new UpdateUserMessageRep(UpdateUserMessageRepCode.NOTFOUND));
        assertEquals(hopRep,repStr);
    }

    @Test
    public void test3(){
        Response response = userService.updateUserMessage("caojiawei","729195690@qq.com","123456789","111111","requester");
        String repStr = JSON.toJSONString(response);
        String hopRep = JSON.toJSONString(new UpdateUserMessageRep(UpdateUserMessageRepCode.WRONGPASSWORD));
        assertEquals(hopRep,repStr);
    }

    @Test
    public void test4(){
        Response response = userService.updateUserMessage("caojiawei","","666666","","requester");
        String repStr = JSON.toJSONString(response);
        String hopRep = JSON.toJSONString(new UpdateUserMessageRep(UpdateUserMessageRepCode.WRONGDATA));
        assertEquals(hopRep,repStr);
    }

    @Test
    public void test5(){
        Response response = userService.updateUserMessage("caojiawei","caocaocao@126.com","666666","","requester");
        String repStr = JSON.toJSONString(response);
        String hopRep = JSON.toJSONString(new UpdateUserMessageRep(UpdateUserMessageRepCode.SUCCESS));
        assertEquals(hopRep,repStr);
    }

    @Test
    public void test6(){
        Response response = userService.updateUserMessage("caiweilin","","111111","111111","worker");
        String repStr = JSON.toJSONString(response);
        String hopRep = JSON.toJSONString(new UpdateUserMessageRep(UpdateUserMessageRepCode.REPEAT));
        assertEquals(hopRep,repStr);
    }

    @Test
    public void test7(){
        Response response = userService.updateUserMessage("caiweilin","","111111","222222","worker");
        String repStr = JSON.toJSONString(response);
        String hopRep = JSON.toJSONString(new UpdateUserMessageRep(UpdateUserMessageRepCode.SUCCESS));
        assertEquals(hopRep,repStr);
    }

    @Test
    public void test8(){
        Response response = userService.updateUserMessage("caizhe","","987654321","111111","worker");
        String repStr = JSON.toJSONString(response);
        String hopRep = JSON.toJSONString(new UpdateUserMessageRep(UpdateUserMessageRepCode.FAIL));
        assertEquals(hopRep,repStr);
    }
}
