package com.ls.vbuynet.service.provider.order.resources;

import com.ls.vbuynet.commons.domain.Orders;
import com.ls.vbuynet.service.provider.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "order/{statu}")
    public List<Orders> selectOrder(@PathVariable(value = "statu") int statu){
        List<Orders> orders = orderService.selectOrder(statu);
        return orders;
    }

}
