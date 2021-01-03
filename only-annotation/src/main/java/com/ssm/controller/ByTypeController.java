package com.ssm.controller;


import com.ssm.entity.User;
import com.ssm.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class ByTypeController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/byType")
    @ResponseBody
    public User getUser(){
        return userService.getUser();
    }
}
