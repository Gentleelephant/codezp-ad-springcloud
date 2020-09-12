package club.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:Zpg
 * @Date:2020/8/2 15:01
 * @Version:1.0
 * @Description:
 */
@RestController
public class TestController {

    @GetMapping("hello")
    public String hello(){
        return "Hello";
    }

}
