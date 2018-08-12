package wnderful.imgannotator.imgServiceTests;

import com.alibaba.fastjson.JSON;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import wnderful.imgannotator.blserviceImpl.BaseServiceImpl;
import wnderful.imgannotator.blserviceImpl.ImgServiceImpl;
import wnderful.imgannotator.dataServiceImpl.NormalDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.ImgResponseCode.CreatePackageRepCode;
import wnderful.imgannotator.publicData.response.ImgResponse.CreatePackageRep;
import wnderful.imgannotator.publicData.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CreatePackageTest {
    private ImgServiceImpl imgService = new ImgServiceImpl();

    @BeforeClass
    public static void prepare(){
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caizhe","654321","caizhe@163.com","requester");
        baseService.signUp("caojiawei","6543210","caojiawei@163.com","requester");
    }

    @Test
    public void test1(){
        Response response = imgService.createPackage("caizhe","aTask");
        String repStr = JSON.toJSONString(response);
        String hopeResult = JSON.toJSONString(new CreatePackageRep(CreatePackageRepCode.SUCCESS));
        assertEquals(repStr,hopeResult);
    }

    @Test
    public void test2(){
        Response response = imgService.createPackage("caizhe","一个任务");
        String repStr = JSON.toJSONString(response);
        String hopeResult = JSON.toJSONString(new CreatePackageRep(CreatePackageRepCode.SUCCESS));
        assertEquals(repStr,hopeResult);
    }

    @Test
    public void test3(){
        Response response = imgService.createPackage("caizh","aTask");
        String repStr = JSON.toJSONString(response);
        String hopeResult = JSON.toJSONString(new CreatePackageRep(CreatePackageRepCode.NOTFOUND));
        assertEquals(repStr,hopeResult);
    }

    @Test
    public void test4(){
        Response response = imgService.createPackage("caizhe","aTask");
        String repStr = JSON.toJSONString(response);
        String hopeResult = JSON.toJSONString(new CreatePackageRep(CreatePackageRepCode.REPEAT));
        assertEquals(repStr,hopeResult);
    }

    @Test
    public void test5(){
        Response response = imgService.createPackage("","aTask");
        String repStr = JSON.toJSONString(response);
        String hopeResult = JSON.toJSONString(new CreatePackageRep(CreatePackageRepCode.NOTFOUND));
        assertEquals(repStr,hopeResult);
    }

    @Test
    public void test6(){
        Response response = imgService.createPackage("caizhe","");
        String repStr = JSON.toJSONString(response);
        String hopeResult = JSON.toJSONString(new CreatePackageRep(CreatePackageRepCode.EMPTYTASKNAME));
        assertEquals(repStr,hopeResult);
    }

    @Test
    public void test7(){
        Response response = imgService.createPackage("","");
        String repStr = JSON.toJSONString(response);
        String hopeResult = JSON.toJSONString(new CreatePackageRep(CreatePackageRepCode.NOTFOUND));
        assertEquals(repStr,hopeResult);
    }

    @Test
    public void test8(){
        Response response = imgService.createPackage("caidixi","newTask");
        String repStr = JSON.toJSONString(response);
        String hopeResult = JSON.toJSONString(new CreatePackageRep(CreatePackageRepCode.NOTFOUND));
        assertEquals(repStr,hopeResult);
    }

    @Test
    public void test9(){
        Response response = imgService.createPackage("caojiawei","newTask");
        String repStr = JSON.toJSONString(response);
        String hopeResult = JSON.toJSONString(new CreatePackageRep(CreatePackageRepCode.SUCCESS));
        assertEquals(repStr,hopeResult);
    }

}
