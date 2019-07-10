package com.ls.vbuynet.service.provider.discounts.service;

import com.ls.vbuynet.commons.domain.Discounts;
import com.ls.vbuynet.commons.domain.DiscountsUser;

import java.util.List;

public interface DiscountsService {

    /**
     * 查询优惠券
     * @param userId
     * @return
     */
    List<DiscountsUser> discounts(int userId,int unkonwnstate);

    /**
     * 根据id查询优惠券信息
     * @param id
     * @return
     */
    Discounts favorable(int id);
}
