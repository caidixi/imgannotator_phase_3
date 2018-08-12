package wnderful.imgannotator.taskServiceTests;

import com.alibaba.fastjson.JSON;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import wnderful.imgannotator.blserviceImpl.BaseServiceImpl;
import wnderful.imgannotator.blserviceImpl.RequesterTaskServiceImpl;
import wnderful.imgannotator.blserviceImpl.WorkerTaskServiceImpl;
import wnderful.imgannotator.dataServiceImpl.NormalDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.ReceiptTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.taskResponse.ReceiptTaskRep;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration

public class ReceiptTaskTest {
    private WorkerTaskServiceImpl taskService = new WorkerTaskServiceImpl();

    @BeforeClass
    public static void prepare(){
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caizhe","654321","caizhe@163.com","requester");
        baseService.signUp("caidixi","123456","caidixi@163.com","worker");
        baseService.signUp("caiweilin","123456","caiweilin@163.com","worker");
        RequesterTaskServiceImpl taskService1 = new RequesterTaskServiceImpl();
    }

    @Test
    public void test1(){
        Response response = taskService.receiptTask("caidixi","aTask");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ReceiptTaskRep(ReceiptTaskRepCode.SUCCESS));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test2(){
        Response response = taskService.receiptTask("caiweilin","aTask");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ReceiptTaskRep(ReceiptTaskRepCode.SUCCESS));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test3(){
        Response response = taskService.receiptTask("caidixi","cat");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ReceiptTaskRep(ReceiptTaskRepCode.SUCCESS));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test4(){
        Response response = taskService.receiptTask("caidix","aTask");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ReceiptTaskRep(ReceiptTaskRepCode.NOTFOUND));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test5(){
        Response response = taskService.receiptTask("caidixi","aTask");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ReceiptTaskRep(ReceiptTaskRepCode.HASRECEIPT));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test6(){
        Response response = taskService.receiptTask("caidixi","ask");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ReceiptTaskRep(ReceiptTaskRepCode.NOTASK));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test7(){
        Response response = taskService.receiptTask("caiweilin","empty");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ReceiptTaskRep(ReceiptTaskRepCode.NOTASK));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test8(){
        Response response = taskService.receiptTask("caiweilin","cat");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ReceiptTaskRep(ReceiptTaskRepCode.FULL));
        assertEquals(hopeRep,repStr);
    }


}
