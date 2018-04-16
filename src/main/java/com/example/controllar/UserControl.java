package com.example.controllar;/*
 *Created by tutu on 2018/4/16
 */

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
public class UserControl {
   @Resource
    private UserService userService;
    @RequestMapping("/test")
    public String test(){
         User user=new User();
         user.setName("tutu");
         user.setPassword("132433");
         userService.insert(user);
         return "success";
    }
}
