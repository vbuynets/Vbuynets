package com.ls.vbuynet.service.provider.forget.service;

import com.ls.vbuynet.commons.domain.User;
import com.ls.vbuynet.commons.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class ForgetServiceImpl implements ForgetService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User examinecode(int id) {
        Example example=new Example(User.class);
        example.createCriteria().andEqualTo("id",id);
        User user = userMapper.selectOneByExample(example);
        return user;
    }

    @Override
    public int changecode(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        return i;
    }
}
