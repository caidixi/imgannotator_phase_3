package wnderful.imgannotator.userServiceTests;

import com.alibaba.fastjson.JSON;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import wnderful.imgannotator.blserviceImpl.BaseServiceImpl;
import wnderful.imgannotator.blserviceImpl.UserServiceImpl;
import wnderful.imgannotator.dataServiceImpl.NormalDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.userResponseCode.LostPointsRepCode;
import wnderful.imgannotator.publicData.response.userResponse.LostPointsRep;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class LostPointsTest {
    private UserServiceImpl userService = new UserServiceImpl();

    @BeforeClass
    public static void prepare(){
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caojiawei","666666","caojiawei@163.com","requester");
        baseService.signUp("caiweilin","111111","caiweilin@163.com","worker");
    }

    @Test
    public void test1(){
        String rep = JSON.toJSONString(userService.lostPoints("caojiawei",123));
        String hopeRep = JSON.toJSONString(new LostPointsRep(LostPointsRepCode.SUCCESS));
        assertEquals(hopeRep,rep);
    }

    @Test
    public void test2(){
        String rep = JSON.toJSONString(userService.lostPoints("caiweilin",1234));
        String hopeRep = JSON.toJSONString(new LostPointsRep(LostPointsRepCode.FAIL));
        assertEquals(hopeRep,rep);
    }

    @Test
    public void test3(){
        String rep = JSON.toJSONString(userService.lostPoints("cai",123));
        String hopeRep = JSON.toJSONString(new LostPointsRep(LostPointsRepCode.NOTFOUND));
        assertEquals(hopeRep,rep);
    }

    @Test
    public void test4(){
        String rep = JSON.toJSONString(userService.lostPoints("caojiawei",-4321));
        String hopeRep = JSON.toJSONString(new LostPointsRep(LostPointsRepCode.UNPROPER));
        assertEquals(hopeRep,rep);
    }
}
