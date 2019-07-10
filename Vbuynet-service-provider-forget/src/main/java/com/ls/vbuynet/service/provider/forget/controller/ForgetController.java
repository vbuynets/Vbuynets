package com.ls.vbuynet.service.provider.forget.controller;

import com.ls.vbuynet.commons.domain.User;
import com.ls.vbuynet.service.provider.forget.service.ForgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForgetController {

    @Autowired
    private ForgetService forgetService;

    @GetMapping(value = "code/{id}")
    public User code(@PathVariable(value = "id") int id){
        User examinecode = forgetService.examinecode(id);
        return examinecode;
    }
    @GetMapping(value = "changecode/{password}")
    public String update(User user,@PathVariable(value = "password") String password){
        user.setId(1);
        user.setPassword(password);
        int changecode = forgetService.changecode(user);
        if(changecode>0){
            return "ok!";
        }
        else{
            return "No!";
        }
    }

}
