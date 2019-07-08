package com.ls.vbuynet.service.consumer.notice.service;

import com.github.pagehelper.PageInfo;
import com.ls.vbuynet.commons.domain.Notice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "vbuynet-service-notice")
public interface NoticeService {

    /**
     * 查询全部信息
     * @return
     */
    @RequestMapping(value = "notice",method = RequestMethod.GET)
    List<Notice> selectAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "noticeId/{id}",method = RequestMethod.GET)
    Notice selectId(@PathVariable(value = "id") int id) ;

    /**
     * 分页查询全部新闻
     * @param notice
     * @param pageSizee
     * @param pageeNum
     * @return
     */
    @RequestMapping(value = "page/{pageSzie}/{pageNum}",method = RequestMethod.GET)
    public PageInfo<Notice> page(@RequestParam(required = false)@RequestBody Notice notice,
                                 @PathVariable(value = "pageSzie") int pageSizee,
                                 @PathVariable(value = "pageNum") int pageeNum);
}
