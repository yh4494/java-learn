package spring.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    public void test() {
        System.out.println("Hello test Service");
        System.out.println(testRequest("abc"));
    }

    public String testRequest(String some) {
        return "result";
    }

}
