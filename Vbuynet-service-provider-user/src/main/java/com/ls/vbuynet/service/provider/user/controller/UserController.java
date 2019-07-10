package com.ls.vbuynet.service.provider.user.controller;

import com.ls.vbuynet.commons.domain.User;
import com.ls.vbuynet.service.provider.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "user/{id}")
    public User getUser(@PathVariable(value = "id") int id){
        User user = userService.queryUser(id);
        return user;
    }

    @GetMapping(value = "update/{id}/{sex}/{birthday}/{level}")
    public String update(User user,
                         @PathVariable(value = "id") int  id,
                         @PathVariable(value = "sex")int sex,
                         @PathVariable(value = "birthday")Date birthday,
                         @PathVariable(value = "level",required = false)int level){
        user.setId(id);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setLevel(level);
        int update = userService.update(user);
        if(update>0){
            return "ok!";
        }
        else{
            return "No!";
        }
    }
}
