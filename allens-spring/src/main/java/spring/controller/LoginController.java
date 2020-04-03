package spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.utils.Result;

@RestController
public class LoginController {

    @GetMapping("/test")
    public Result testReturn () {
        Result<String> result = new Result<>();
        result.setCode("0");
        result.setMsg("返回成功");
        result.setData("HELLO STRANGER!");
        return result;
    }

}
