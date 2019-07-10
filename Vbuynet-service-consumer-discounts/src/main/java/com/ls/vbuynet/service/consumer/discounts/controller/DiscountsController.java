package com.ls.vbuynet.service.consumer.discounts.controller;

import com.ls.vbuynet.commons.domain.Discounts;
import com.ls.vbuynet.commons.domain.DiscountsUser;
import com.ls.vbuynet.service.consumer.discounts.service.DiscountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Column;
import java.util.List;

@Controller
public class DiscountsController {

    @Autowired
    private DiscountsService discountsService;

    @ResponseBody
    @GetMapping(value = "discounts/{userid}/{unkonwnstate}")
    public List<DiscountsUser> page(@PathVariable(value = "userid") int userid,
                                    @PathVariable(value = "unkonwnstate") int unkonwnstate){
        return discountsService.page(userid,unkonwnstate);
    }

    @ResponseBody
    @GetMapping(value = "favorable/{id}")
    public Discounts favorable(@PathVariable(value = "id") int id){
        return discountsService.favorable(id);
    }
}
