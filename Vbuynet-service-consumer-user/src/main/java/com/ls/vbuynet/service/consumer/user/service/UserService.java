package com.ls.vbuynet.service.consumer.user.service;

import com.ls.vbuynet.commons.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;

@FeignClient(value = "vbuynet-service-provider-user")
public interface UserService {

    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
     User getUser(@PathVariable(value = "id") int id);


    @RequestMapping(value = "update/{id}/{sex}/{birthday}/{level}",method = RequestMethod.GET)
    String update(User user,
                        @PathVariable(value = "id") int  id,
                        @PathVariable(value = "sex")int sex,
                        @PathVariable(value = "birthday") Date birthday,
                        @PathVariable(value = "level",required = false)int level);

}
