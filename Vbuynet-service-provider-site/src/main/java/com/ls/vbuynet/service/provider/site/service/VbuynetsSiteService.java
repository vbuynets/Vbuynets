package com.ls.vbuynet.service.provider.site.service;

import com.ls.vbuynet.commons.domain.Site;

import java.util.List;

public interface VbuynetsSiteService {
    /**
     * 新增收货地址
     * @param site
     * @return
     */
    int insertSite(Site site);

    /**
     * 根据用户Id查询以保存的收货地址
     * @param
     * @return
     */
    List<Site> selectUserId(int userid);

    /**
     * 根据id进行删除
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 更新地址目录
     * @param site
     * @return
     */
    int updates(Site site);
}
