package com.ls.vbuynet.service.provider.order.service;

import com.ls.vbuynet.commons.domain.Orders;

import java.util.List;

public interface OrderService {

    List<Orders> selectOrder(int statu);
}
