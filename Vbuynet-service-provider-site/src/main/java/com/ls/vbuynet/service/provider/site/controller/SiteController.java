package com.ls.vbuynet.service.provider.site.controller;

import com.ls.vbuynet.commons.domain.Site;
import com.ls.vbuynet.commons.mapper.SiteMapper;
import com.ls.vbuynet.service.provider.site.service.VbuynetSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class SiteController {


    @Autowired
    private VbuynetSiteService vbuynetSiteService;

    @Autowired
    private SiteMapper siteMapper;

    public Site getSite(String Consigneename,String siteName,String consigneeSize,int cellphone,int phone,int defaults){
        Site site=new Site();
        site.setConsigneename(Consigneename);
        site.setSitename(siteName);
        site.setConsigneesize(consigneeSize);
        site.setCellphone(cellphone);
        site.setPhone(phone);
       site.setDefaults(defaults);
        return site;
    }


    /**
     * 保存地址信息
     * @param site
     * @param session
     * @param Consigneename
     * @param siteName
     * @param consigneeSize
     * @param cellphone
     * @param phone
     * @return
     */
    @RequestMapping(value = "site/{Consigneename}/{siteName}/{consigneeSize}/{cellphone}/{phone}/{defaults}",method = RequestMethod.GET)
    public String insertsite(Site site,HttpSession session,
                             @PathVariable(value = "Consigneename") String Consigneename,
                             @PathVariable(value = "siteName") String siteName,
                             @PathVariable(value = "consigneeSize") String consigneeSize,
                             @PathVariable(value = "cellphone",required = false) int cellphone,
                             @PathVariable(value = "phone",required = false) int phone,
                             @PathVariable(value = "defaults") int defaults){
//        int userId =(int) session.getAttribute("user");
        site = getSite(Consigneename, siteName, consigneeSize, cellphone, phone,defaults);
        site.setUserid(1);
        int i = vbuynetSiteService.insertSite(site);
        if(i>0){
            return "ok!";
        }
        return "No!";
    }


    /**
     * 根据用户id查询用户保存过的地址
     * @param userid
     * @return
     */

    @GetMapping(value = "sites/{userid}")
    public String sites(@PathVariable(value = "userid") int userid){
        List<Site> sites = vbuynetSiteService.selectUserId(userid);
        for(Site site:sites){
            System.out.println(site.getConsigneename());
        }
            return sites.toString();
        }

    /**
     * 更新地址信息
     * @param site
     * @param id
     * @param Consigneename
     * @param siteName
     * @param consigneeSize
     * @param cellphone
     * @param phone
     * @return
     */
    @GetMapping(value = "amend/{id}/{Consigneename}/{siteName}/{consigneeSize}/{cellphone}/{phone}/{defaults}")
    public String update(Site site,
                             @PathVariable(value = "id") int id,
                             @PathVariable(value = "Consigneename") String Consigneename,
                             @PathVariable(value = "siteName") String siteName,
                             @PathVariable(value = "consigneeSize") String consigneeSize,
                             @PathVariable(value = "cellphone",required = false) int cellphone,
                             @PathVariable(value = "phone",required = false) int phone,
                             @PathVariable(value = "defaults") int  defaults){
        //site = getSite(Consigneename, siteName, consigneeSize, cellphone, phone);
       // int update = siteMapper.amend(id, Consigneename, siteName, consigneeSize, cellphone, phone);
        site = getSite(Consigneename, siteName, consigneeSize, cellphone, phone, defaults);
        site.setId(id);
        int update = vbuynetSiteService.updates(site);
        if(update>0){
            return "ok!";
        }
        else{
            return "no!";
        }
    }

    /**
     * 根据地址id删除地址信息
     * @param id 地址id
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        int delete = vbuynetSiteService.delete(id);
        if(delete>0){
            return "ok!";
        }
        else{
            return "no!";
        }
    }
}
