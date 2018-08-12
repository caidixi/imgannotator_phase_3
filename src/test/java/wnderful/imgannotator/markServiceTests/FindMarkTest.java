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
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.FindMarkRepCode;
import wnderful.imgannotator.publicData.response.MarkResponse.FindMarkRep;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.markVo.MarkVo;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FindMarkTest {
    private MarkServiceImpl markService = new MarkServiceImpl();

    @BeforeClass
    public static void prepare() {
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caizhe", "654321", "caizhe@163.com", "requester");
        baseService.signUp("caojiawei", "666666", "caojiawei@163.com", "requester");
        baseService.signUp("caidixi", "123456", "caidixi@163.com", "worker");
        baseService.signUp("caiweilin", "111111", "caiweilin@163.com", "worker");
        RequesterTaskServiceImpl taskService1 = new RequesterTaskServiceImpl();
    }

    @Test
    public void test1() {
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
        markService.setMark("caidixi", "aTask", "124AF2A09B63B97FC94CF0D914992CA0.jpg", jsonObject);
        Response response = markService.findMark("aTask","124AF2A09B63B97FC94CF0D914992CA0.jpg","caizhe");
        JSONObject[] aMarkVos = new JSONObject[1];
        aMarkVos[0] = jsonObject;
        MarkVo markVo = new MarkVo(aMarkVos);
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new FindMarkRep(FindMarkRepCode.SUCCESS,markVo));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test2() {
        Response response = markService.findMark("aTask","timg.jpg","caizhe");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new FindMarkRep(FindMarkRepCode.SUCCESS));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test3() {
        Response response = markService.findMark("aTask","124AF2A09B63B97FC94CF0D914992CA0.jpg","caojiawei");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new FindMarkRep(FindMarkRepCode.NOTALLOW));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test4() {
        Response response = markService.findMark("aTask","123.jpg","caizhe");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new FindMarkRep(FindMarkRepCode.NOIMG));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test5() {
        Response response = markService.findMark("aTask","timg.jpg","cao");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new FindMarkRep(FindMarkRepCode.NOTFOUND));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test6() {
        JSONObject jsonObject1 = JSON.parseObject("{\n" +
                "    \"wholeDesc\": \"125553\",\n" +
                "    \"rectMark\": [\n" +
                "      {\n" +
                "        \"info\": {\n" +
                "          \"left\": 2,\n" +
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
        JSONObject jsonObject2 = JSON.parseObject("{\n" +
                "    \"wholeDesc\": \"321\",\n" +
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
        markService.setMark("caidixi", "aTask", "124AF2A09B63B97FC94CF0D914992CA0.jpg", jsonObject1);
        markService.setMark("caiweilin", "aTask", "124AF2A09B63B97FC94CF0D914992CA0.jpg", jsonObject2);
        Response response = markService.findMark("aTask","124AF2A09B63B97FC94CF0D914992CA0.jpg","caizhe");
        JSONObject[] aMarkVos = new JSONObject[2];
        aMarkVos[0] = jsonObject1;
        aMarkVos[1] = jsonObject2;
        MarkVo markVo = new MarkVo(aMarkVos);
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new FindMarkRep(FindMarkRepCode.SUCCESS,markVo));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test7() {
        Response response = markService.findMark("ask","timg.jpg","caizhe");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new FindMarkRep(FindMarkRepCode.NOTASK));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test8() {
        Response response = markService.findMark("aTask","timg.jpg","caidixi");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new FindMarkRep(FindMarkRepCode.NOTFOUND));
        assertEquals(hopeRep, repStr);
    }


}
