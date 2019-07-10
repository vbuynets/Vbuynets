package com.ls.vbuynet.service.consumer.forget.controller;

import com.ls.vbuynet.commons.domain.User;
import com.ls.vbuynet.service.consumer.forget.service.ForgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "forgetConsumer")
public class ForgetController {

    @Autowired
    private ForgetService forgetService;

    @ResponseBody
    @GetMapping(value = "code/{id}")
    User code(@PathVariable(value = "id") int id){
       return forgetService.code(id);
    }

    @ResponseBody
    @GetMapping(value = "changecode/{password}")
    String update(@PathVariable(value = "password") String password){
        return forgetService.update(password);
    }
}
