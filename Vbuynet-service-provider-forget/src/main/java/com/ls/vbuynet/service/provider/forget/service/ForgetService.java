package com.ls.vbuynet.service.provider.forget.service;

import com.ls.vbuynet.commons.domain.User;

public interface ForgetService {

    /**
     * 拿到用户
     * @param id
     * @return
     */
    User examinecode(int id);

    /**
     * 更新用户密码
     * @param user
     * @return
     */
    int changecode(User user);
}
