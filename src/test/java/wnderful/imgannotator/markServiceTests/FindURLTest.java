package wnderful.imgannotator.markServiceTests;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.FindURLRepCode;
import wnderful.imgannotator.publicData.response.MarkResponse.FindURLRep;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.markVo.ImgUrlVo;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FindURLTest {
    private MarkServiceImpl markService = new MarkServiceImpl();

    @BeforeClass
    public static void prepare() {
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caizhe", "654321", "caizhe@163.com", "requester");
        baseService.signUp("caidixi", "123456", "caidixi@163.com", "worker");
        baseService.signUp("caiweilin", "111111", "caiweilin@163.com", "worker");
        RequesterTaskServiceImpl taskService1 = new RequesterTaskServiceImpl();
        JSONObject jsonObject = JSON.parseObject("{\n" +
                "    \"wholeDesc\": \"123\",\n" +
                "    \"rectMark\": [\n" +
                "      {\n" +
                "        \"info\": {\n" +
                "          \"left\": 1,\n" +
                "          \"top\": 1,\n" +
                "          \"width\": 1,\n" +
                "          \"height\": 1\n" +
                "        },\n" +
                "        \"description\": {\n" +
                "          \"time\": \"\",\n" +
                "          \"content\": \"\"\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"polyMark\": [\n" +
                "      {\n" +
                "        \"info\": {\n" +
                "          \"x\": [],\n" +
                "          \"y\": []\n" +
                "        },\n" +
                "        \"description\": {\n" +
                "          \"time\": \"\",\n" +
                "          \"content\": \"\"\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }");
        MarkServiceImpl markService = new MarkServiceImpl();
        Response response = markService.setMark("caidixi", "aTask", "124AF2A09B63B97FC94CF0D914992CA0.jpg", jsonObject);
        System.out.println(response); }

    @Test
    public void test7(){
        String hopeRep = JSON.toJSONString(new FindURLRep(FindURLRepCode.SUCCESS));
        Response response = markService.findURL("caidixi", "aTask");
        String repStr = JSON.toJSONString(response);
        assertEquals(hopeRep, repStr);
    }


    @Test
    public void test2() {
        Response response = markService.findURL("caididi", "aTask");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new FindURLRep(FindURLRepCode.NOTFOUND));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test3() {
        Response response = markService.findURL("caiweilin", "cat");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new FindURLRep(FindURLRepCode.NOTASK));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test4() {
        Response response = markService.findURL("caidixi", "a");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new FindURLRep(FindURLRepCode.NOTEXIST));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test5() {
        Response response = markService.findURL("caidixi", "cat");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new FindURLRep(FindURLRepCode.SUCCESS));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test6() {
        JSONObject jsonObject = JSON.parseObject("{\n" +
                "    \"wholeDesc\": \"123\",\n" +
                "    \"rectMark\": [\n" +
                "      {\n" +
                "        \"info\": {\n" +
                "          \"left\": 1,\n" +
                "          \"top\": 1,\n" +
                "          \"width\": 1,\n" +
                "          \"height\": 1\n" +
                "        },\n" +
                "        \"description\": {\n" +
                "          \"time\": \"\",\n" +
                "          \"content\": \"\"\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"polyMark\": [\n" +
                "      {\n" +
                "        \"info\": {\n" +
                "          \"x\": [],\n" +
                "          \"y\": []\n" +
                "        },\n" +
                "        \"description\": {\n" +
                "          \"time\": \"\",\n" +
                "          \"content\": \"\"\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }");
        markService.setMark("caidixi", "cat", "timg.jpg", jsonObject);
        Response response = markService.findURL("caidixi", "cat");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new FindURLRep(FindURLRepCode.COMPLETE));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test8() {
        RequesterTaskServiceImpl taskService = new RequesterTaskServiceImpl();
        taskService.deleteTask("caizhe", "aTask");
        Response response = markService.findURL("caidixi", "aTask");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new FindURLRep(FindURLRepCode.END));
        assertEquals(hopeRep, repStr);
    }
}
