package com.ls.vbuynet.service.provider.discounts.controller;

import com.github.pagehelper.PageInfo;
import com.ls.vbuynet.commons.domain.Discounts;
import com.ls.vbuynet.commons.domain.DiscountsUser;
import com.ls.vbuynet.service.provider.discounts.service.DiscountsService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscountsController {

    @Autowired
    private DiscountsService discountsService;

    @GetMapping(value = "discounts/{userid}/{unkonwnstate}")
    public List<DiscountsUser> page(@PathVariable(value = "userid") int userid,
                                    @PathVariable(value = "unkonwnstate") int unkonwnstate){
        List<DiscountsUser> discounts = discountsService.discounts(userid, unkonwnstate);
        return discounts;
    }

    @GetMapping(value = "favorable/{id}")
    public Discounts favorable(@PathVariable(value = "id") int id){
        Discounts favorable = discountsService.favorable(id);
        return favorable;
    }
}
