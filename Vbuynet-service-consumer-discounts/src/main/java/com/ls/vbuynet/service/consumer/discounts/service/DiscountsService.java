package com.ls.vbuynet.service.consumer.discounts.service;

import com.ls.vbuynet.commons.domain.Discounts;
import com.ls.vbuynet.commons.domain.DiscountsUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "vbuynet-service-provider-discounts")
public interface DiscountsService {

    @GetMapping(value = "discounts/{userid}/{unkonwnstate}")
    public List<DiscountsUser> page(@PathVariable(value = "userid") int userid,
                                    @PathVariable(value = "unkonwnstate") int unkonwnstate);


    @GetMapping(value = "favorable/{id}")
    public Discounts favorable(@PathVariable(value = "id") int id);
}
