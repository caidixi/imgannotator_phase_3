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
import wnderful.imgannotator.vo.userVo.RequesterMessageVo;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class GetRequesterMessageTest {
    private UserServiceImpl userService = new UserServiceImpl();
    private RequesterTaskServiceImpl taskService = new RequesterTaskServiceImpl();

    @BeforeClass
    public static void prepare() {
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caojiawei", "666666", "caojaiwei@163.com", "requester");
        baseService.signUp("caizhe", "654321", "caizhe@163.com", "requester");
    }

    @Test
    public void test1() {
        Response response = userService.getUserMessage("caizhe", "requester");
        String repStr = JSON.toJSONString(response);
        RequesterMessageVo vo = new RequesterMessageVo("caizhe", "caizhe@163.com", 1000, 0);
        String hopeRep = JSON.toJSONString(new GetUserMassageRep(GetUserMassageRepCode.SUCCESS, vo));
        assertEquals(hopeRep, repStr);
    }


    @Test
    public void test3() {
        Response response = userService.getUserMessage("caizhe", "requester");
        String repStr = JSON.toJSONString(response);
        RequesterMessageVo vo = new RequesterMessageVo("caizhe", "caizhe@163.com", 2100, 1);
        String hopeRep = JSON.toJSONString(new GetUserMassageRep(GetUserMassageRepCode.SUCCESS, vo));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test4() {
        userService.updateUserMessage("caizhe", "caicaicai@163.com", "654321", "", "requester");
        Response response = userService.getUserMessage("caizhe", "requester");
        String repStr = JSON.toJSONString(response);
        RequesterMessageVo vo = new RequesterMessageVo("caizhe", "caicaicai@163.com", 2100, 1);
        String hopeRep = JSON.toJSONString(new GetUserMassageRep(GetUserMassageRepCode.SUCCESS, vo));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test5() {
        Response response = userService.getUserMessage("cai", "requester");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new GetUserMassageRep(GetUserMassageRepCode.FAIL));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test6() {
        Response response = userService.getUserMessage("caojiawei", "user");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new GetUserMassageRep(GetUserMassageRepCode.NOTFOUND));
        assertEquals(hopeRep, repStr);
    }
}
