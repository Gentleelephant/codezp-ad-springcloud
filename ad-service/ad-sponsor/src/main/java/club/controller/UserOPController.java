package club.controller;

import club.codezp.exception.AdException;
import club.service.IUserService;
import club.vo.CreateUserRequest;
import club.vo.CreateUserResponse;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:Zpg
 * @Date:2020/8/2 14:27
 * @Version:1.0
 * @Description: user的操作
 */
@Slf4j
@RestController
public class UserOPController {

    private final IUserService userService;

    @Autowired
    public UserOPController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create/user")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws AdException {
        log.info("ad-sponsor:createUser -> {}", JSON.toJSONString(request));
        return userService.createUser(request);

    }
}
