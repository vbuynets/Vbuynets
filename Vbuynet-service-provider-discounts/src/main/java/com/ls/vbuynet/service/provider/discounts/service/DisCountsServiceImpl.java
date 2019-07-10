package com.ls.vbuynet.service.provider.discounts.service;

import com.ls.vbuynet.commons.domain.Discounts;
import com.ls.vbuynet.commons.domain.DiscountsUser;
import com.ls.vbuynet.commons.mapper.DiscountsMapper;
import com.ls.vbuynet.commons.mapper.DiscountsUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DisCountsServiceImpl implements DiscountsService {

    @Autowired
    private DiscountsUserMapper discountsUserMapper;

    @Autowired
    private DiscountsMapper discountsMapper;

    @Override
    public List<DiscountsUser> discounts(int userId,int unkonwnstate) {
        Example example=new Example(DiscountsUser.class);
        example.createCriteria().andEqualTo("userid",userId).andEqualTo("unkonwnstate",unkonwnstate);
        List<DiscountsUser> discountsUsers = discountsUserMapper.selectByExample(example);
        return discountsUsers;
    }

    @Override
    public Discounts favorable(int id) {
        Example example=new Example(Discounts.class);
        example.createCriteria().andEqualTo("id",id);
        Discounts discounts = discountsMapper.selectOneByExample(example);
        return discounts;
    }
}
