package com.ls.vbuynet.service.provider.user.service;

import com.ls.vbuynet.commons.domain.User;

public interface UserService {
    /**
     * 查询用户信息
     * @param id
     * @return
     */
    User queryUser(int id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int update(User user);
}
