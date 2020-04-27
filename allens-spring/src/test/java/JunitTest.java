import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import server.ServerInitializer;
import spring.service.TestService;
import spring.utils.Result;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerInitializer.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class JunitTest {

    @MockBean
    TestService testService;

    @Autowired
    protected MockMvc mockMvc;

    @Test
    public void Test1 () {
         Mockito.when(testService.testRequest(Mockito.anyString())).thenReturn("some");
         Assert.assertTrue(true);
    }

    @Test
    public void test2 () throws Exception {
        Mockito.when(testService.testRequest(Mockito.anyString())).thenReturn("这是mock返回的数据");
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/test")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .param("xxx", "xxx")
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();

        Result<String> map = JSON.parseObject(result.getResponse().getContentAsByteArray(), Result.class);
        Assert.assertNotNull(map);
        Assert.assertTrue("失败了，因为字符串不相等", map.getData().equals("HELLO STRANGER!"));
//         .andDo(MockMvcResultHandlers.print());
    }
}
