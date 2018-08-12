package wnderful.imgannotator.baseServiceTests;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import wnderful.imgannotator.blserviceImpl.BaseServiceImpl;
import wnderful.imgannotator.dataServiceImpl.NormalDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.LoginRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.baseResponse.LoginRep;
import wnderful.imgannotator.vo.baseVo.LoginVo;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class LoginTests {

    private BaseServiceImpl baseService = new BaseServiceImpl();

    @BeforeClass
    public static void prepare(){
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
    }

    @Before
    public void signUp(){
        baseService.signUp("caidixi","123456","caidixi@163.com","worker");
        baseService.signUp("caizhe","654321","caizhe@163.com","requester");
    }

    @Test
    public void test1() throws Exception{
        Response response = baseService.login("caidixi","123456");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new LoginRep(LoginRepCode.SUCCESS,new LoginVo("eyJhbGciOiJIUzI1NiI" +
                "sInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImNhaWRpeGkifQ.7SKD-S3p2_yMg4CaSZf2zJPeGOvAnZV6WoMYiiJVxKM","worker")));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test2() throws Exception{
        Response response = baseService.login("caizhe","654321");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new LoginRep(LoginRepCode.SUCCESS,new LoginVo("eyJhbGciOiJIUzI1NiI" +
                "sInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImNhaXpoZSJ9.fNAiIciVCM2cUgjGFJ0HFVjjczRh5Y2d4uMkiUQA7gc","requester")));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test3() throws Exception{
        Response response = baseService.login("caizhe","123456");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new LoginRep(LoginRepCode.WRONGPASSWORD));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test4() throws Exception{
        Response response = baseService.login("caiweilin","123456");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new LoginRep(LoginRepCode.NOTEXIST));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test5() throws Exception{
        Response response = baseService.login("","123456");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new LoginRep(LoginRepCode.EMPTYNAME));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test6() throws Exception{
        Response response = baseService.login("caidixi","");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new LoginRep(LoginRepCode.EMPTYPASSWORD));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test7() throws Exception{
        Response response = baseService.login("","");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new LoginRep(LoginRepCode.EMPTYNAME));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test8() throws Exception{
        Response response = baseService.login("caidixi","1234567");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new LoginRep(LoginRepCode.WRONGPASSWORD));
        assertEquals(repStr,hopeRepStr);
    }


}
