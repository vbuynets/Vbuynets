package com.ls.vbuynet.service.consumer.user.controller;

import com.ls.vbuynet.service.consumer.user.service.UserService;
import com.ls.vbuynet.commons.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping(value = "userConsumer")
public class UsersController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
    User getUser(@PathVariable(value = "id") int id){
        return userService.getUser(id);
    }

    @ResponseBody
    @RequestMapping(value = "update/{id}/{sex}/{birthday}/{level}",method = RequestMethod.GET)
    public String update(User user,
                         @PathVariable(value = "id") int  id,
                         @PathVariable(value = "sex")int sex,
                         @PathVariable(value = "birthday")Date birthday,
                         @PathVariable(value = "level",required = false)int level){
        return userService.update(user,id,sex,birthday,level);
    }
}
