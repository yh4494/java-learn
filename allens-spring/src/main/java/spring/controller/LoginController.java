package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.service.TestService;
import spring.utils.Result;

@RestController
public class LoginController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public Result testReturn () {
        System.out.println(testService.testRequest("some"));
        Result<String> result = new Result<>();
        result.setCode("0");
        result.setMsg("返回成功");
        result.setData("HELLO STRANGER!");
        return result;
    }

}
