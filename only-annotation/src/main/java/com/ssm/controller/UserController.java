package com.ssm.controller;

import com.ssm.entity.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljh
 *
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/hello")
    public List<String> hello() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("张三:" + i);
        }
        return list;
    }
    @GetMapping("/login/{username}")
    public User login(@PathVariable("username") String username) {
        return userService.login(username);
    }
}
