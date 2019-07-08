package com.ls.vbuynet.service.provider.comments.controller;

import com.github.pagehelper.PageInfo;
import com.ls.vbuynet.commons.domain.Notice;
import com.ls.vbuynet.commons.mapper.NoticeMapper;
import com.ls.vbuynet.service.provider.comments.service.CommentsService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Controller
public class CommentsController {

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private CommentsService   commentsService;

    @ResponseBody
    @RequestMapping(value = "notice",method = RequestMethod.GET)
    public List<Notice> selectNotion(){
        return commentsService.selectAll();
    }

    @ResponseBody
    @RequestMapping(value = "noticeId/{id}",method = RequestMethod.GET)
    public Notice selectId(@PathVariable(value = "id") int id){
        Notice notice =commentsService.selectId(id);
        return notice;
    }
    @ResponseBody
    @RequestMapping(value = "page/{pageSzie}/{pageNum}",method = RequestMethod.GET)
    public PageInfo<Notice> page(@RequestParam(required = false)@RequestBody Notice notice,
                                 @PathVariable(value = "pageSzie") int pageSizee,
                                 @PathVariable(value = "pageNum") int pageeNum){
        PageInfo<Notice> page = commentsService.page(notice, pageSizee, pageeNum);
        return page;
    }

}
