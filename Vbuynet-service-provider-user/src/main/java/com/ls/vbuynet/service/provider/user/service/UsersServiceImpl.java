package com.ls.vbuynet.service.provider.user.service;

import com.ls.vbuynet.commons.domain.User;
import com.ls.vbuynet.commons.mapper.UserMapper;
import com.ls.vbuynet.commons.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UsersServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUser(int id) {
        Example example=new Example(User.class);
        example.createCriteria().andEqualTo("id",id);
        User user = userMapper.selectOneByExample(example);
        return user;
    }

    @Override
    public int update(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        return i;
    }
}
