package com.ls.vbuynet.service.provider.order.service;

import com.ls.vbuynet.commons.domain.Orders;
import com.ls.vbuynet.commons.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Orders> selectOrder(int statu) {
        Example example=new Example(Orders.class);
        example.createCriteria().andEqualTo("statu",statu);
        List<Orders> orders = orderMapper.selectByExample(example);
        return orders;
    }
}
