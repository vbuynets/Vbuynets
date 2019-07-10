package com.ls.vbuynet.service.consumer.forget.service;

import com.ls.vbuynet.commons.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "vbuynet-service-provider-forget")
public interface ForgetService {

    @GetMapping(value = "code/{id}")
     User code(@PathVariable(value = "id") int id);

    @GetMapping(value = "changecode/{password}")
     String update(@PathVariable(value = "password") String password);
}
