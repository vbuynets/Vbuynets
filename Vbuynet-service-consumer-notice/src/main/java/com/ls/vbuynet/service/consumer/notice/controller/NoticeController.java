package com.ls.vbuynet.service.consumer.notice.controller;

import com.github.pagehelper.PageInfo;
import com.ls.vbuynet.commons.domain.Notice;
import com.ls.vbuynet.service.consumer.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "noticeConsumer")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 查询全部信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "notice",method = RequestMethod.GET)
    List<Notice> selectAll(){
        return noticeService.selectAll();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "noticeId/{id}",method = RequestMethod.GET)
    Notice selectId(@PathVariable(value = "id") int id){
        return noticeService.selectId(id);
    }

    /**
     * 分页查询全部新闻
     * @param notice
     * @param pageSzie
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page/{pageSzie}/{pageNum}",method = RequestMethod.GET)
    PageInfo<Notice> page(Notice notice,@PathVariable(value = "pageSzie") int pageSzie,@PathVariable(value = "pageNum") int pageNum){
        return noticeService.page(notice,pageSzie,pageNum);
    }
}
