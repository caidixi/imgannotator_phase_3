package wnderful.imgannotator.taskServiceTests;

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
import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.DeleteTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.taskResponse.DeleteTaskRep;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class deleteTaskTest {
    private RequesterTaskServiceImpl taskService = new RequesterTaskServiceImpl();

    @BeforeClass
    public static void prepare(){
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caizhe","654321","caizhe@163.com","requester");
        baseService.signUp("caojiawei","666666","caojiawei@163.com","requester");
        baseService.signUp("caidixi","123456","caidixi@163.com","worker");
        RequesterTaskServiceImpl taskService1 = new RequesterTaskServiceImpl();
    }

    @Test
    public void test1(){
        Response response = taskService.deleteTask("caojiawei","cat");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new DeleteTaskRep(DeleteTaskRepCode.SUCCESS));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test2(){
        Response response = taskService.deleteTask("caojia","cat");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new DeleteTaskRep(DeleteTaskRepCode.NOTFOUND));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test3(){
        Response response = taskService.deleteTask("caojiawei","aTask");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new DeleteTaskRep(DeleteTaskRepCode.WRONGREQ));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test4(){
        Response response = taskService.deleteTask("caojiawei","cat");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new DeleteTaskRep(DeleteTaskRepCode.HASEND));
        assertEquals(hopeRep,repStr);
    }
    @Test
    public void test5(){
        Response response = taskService.deleteTask("caidixi","aTask");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new DeleteTaskRep(DeleteTaskRepCode.NOTFOUND));
        assertEquals(hopeRep,repStr);
    }


    @Test
    public void test6(){
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
        markService.setMark("caidixi", "aTask", "124AF2A09B63B97FC94CF0D914992CA0.jpg", jsonObject);
        Response response = taskService.deleteTask("caizhe","aTask");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new DeleteTaskRep(DeleteTaskRepCode.SUCCESS));
        assertEquals(hopeRep,repStr);
    }

}
