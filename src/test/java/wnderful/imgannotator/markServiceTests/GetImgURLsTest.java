package wnderful.imgannotator.markServiceTests;

import com.alibaba.fastjson.JSON;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import wnderful.imgannotator.blserviceImpl.BaseServiceImpl;
import wnderful.imgannotator.blserviceImpl.MarkServiceImpl;
import wnderful.imgannotator.blserviceImpl.RequesterTaskServiceImpl;
import wnderful.imgannotator.dataServiceImpl.NormalDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.GetURLsRepCode;
import wnderful.imgannotator.publicData.response.MarkResponse.GetURLsRep;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.markVo.ImgUrlsVo;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class GetImgURLsTest {
    private MarkServiceImpl markService = new MarkServiceImpl();

    @BeforeClass
    public static void prepare() {
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caizhe", "654321", "caizhe@163.com", "requester");
        baseService.signUp("caojiawei", "123456", "caojiawei@163.com", "requester");
        RequesterTaskServiceImpl taskService1 = new RequesterTaskServiceImpl();
    }

    @Test
    public void test1(){
        Response response = markService.getURLs("caizhe","cat");
        String repStr = JSON.toJSONString(response);
        String[] strings = new String[1];
        strings[0] = "picture/cat/timg.jpg";
        String hopeRep = JSON.toJSONString(new GetURLsRep(GetURLsRepCode.SUCCESS,new ImgUrlsVo(strings)));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test2(){
        Response response = markService.getURLs("caizhe","aTask");
        String repStr = JSON.toJSONString(response);
        String[] strings = new String[3];
        strings[0] = "picture/aTask/124AF2A09B63B97FC94CF0D914992CA0.jpg";
        strings[1] = "picture/aTask/21302FE86AABFF4DC9329D992836D30C.jpg";
        strings[2] = "picture/aTask/timg.jpg";
        String hopeRep = JSON.toJSONString(new GetURLsRep(GetURLsRepCode.SUCCESS,new ImgUrlsVo(strings)));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test3(){
        Response response = markService.getURLs("cai","cat");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new GetURLsRep(GetURLsRepCode.NOTFOUND));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test4(){
        Response response = markService.getURLs("caojiawei","cat");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new GetURLsRep(GetURLsRepCode.NOALLOW));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test5(){
        Response response = markService.getURLs("caojiawei","a");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new GetURLsRep(GetURLsRepCode.NOTASK));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test6(){
        Response response = markService.getURLs("caizhe","a");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new GetURLsRep(GetURLsRepCode.NOTASK));
        assertEquals(hopeRep,repStr);
    }
}
