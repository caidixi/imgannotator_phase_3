package wnderful.imgannotator.baseServiceTests;

import com.alibaba.fastjson.JSON;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import wnderful.imgannotator.blserviceImpl.BaseServiceImpl;
import wnderful.imgannotator.dataServiceImpl.NormalDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.SignUpRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.baseResponse.SignUpRep;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SignUpTests {
    private BaseServiceImpl baseService = new BaseServiceImpl();

    @BeforeClass
    public static void prepare(){
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
    }

    @Test
    public void test1(){
        Response response = baseService.signUp("caidixi","123456","caidixi@163.com","worker");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new SignUpRep(SignUpRepCode.SUCCESS));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test2(){
        Response response = baseService.signUp("caizhe","654321","caizhe@163.com","requester");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new SignUpRep(SignUpRepCode.SUCCESS));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test3(){
        Response response = baseService.signUp("caizhe","654321","caizhe@163.com","requester");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new SignUpRep(SignUpRepCode.NAMEREPEAT));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test4(){
        Response response = baseService.signUp("caizhe","654321","caizhe@163.com","worker");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new SignUpRep(SignUpRepCode.NAMEREPEAT));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test5(){
        Response response = baseService.signUp("caiweilin","1111111","caiweilin@126.com","boss");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new SignUpRep(SignUpRepCode.FAIL));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test6(){
        Response response = baseService.signUp("caiweilin","","caiweilin@126.com","worker");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new SignUpRep(SignUpRepCode.EMPTYPASSWORD));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test7(){
        Response response = baseService.signUp("caiweilin","111111","","worker");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new SignUpRep(SignUpRepCode.EMPTYEMAIL));
        assertEquals(repStr,hopeRepStr);
    }

    @Test
    public void test8(){
        Response response = baseService.signUp("","111111","caiweilin@126.com","worker");
        String repStr = JSON.toJSONString(response);
        String hopeRepStr = JSON.toJSONString(new SignUpRep(SignUpRepCode.EMPTYNAME));
        assertEquals(repStr,hopeRepStr);
    }
}