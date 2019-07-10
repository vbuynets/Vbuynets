package com.ls.vbuynet.service.consumer.site.controller;


import com.ls.vbuynet.commons.domain.Site;
import com.ls.vbuynet.service.consumer.site.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "siteConsumer")
public class SiteController {


    //得到udai_notice.html

    @GetMapping(value = "getUdai_address")
    public String getUdai_address(){
        return "udai_address";
    }



    @Autowired
    private SiteService siteService;

    @ResponseBody
    @RequestMapping(value = "site/{Consigneename}/{siteName}/{consigneeSize}/{cellphone}/{phone}",method = RequestMethod.POST)
    public String insertsite(Site site,
                             @PathVariable(value = "Consigneename") String Consigneename,
                             @PathVariable(value = "siteName") String siteName,
                             @PathVariable(value = "consigneeSize") String consigneeSize,
                             @PathVariable(value = "cellphone",required = false) int cellphone,
                             @PathVariable(value = "phone",required = false) int phone){
                     return siteService.insertsite(site,Consigneename,siteName,consigneeSize,cellphone,phone);
    }

    @ResponseBody
    @GetMapping(value = "sites")
    public String sites(@RequestParam(value = "userid") int userid){
      return   siteService.sites(userid);
    }

    @ResponseBody
    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        return siteService.delete(id);
    }

    @ResponseBody
    @GetMapping(value = "amend/{id}/{Consigneename}/{siteName}/{consigneeSize}/{cellphone}/{phone}/{defaults}")
    public String update(
                       @PathVariable(value = "id") int id,
                       @PathVariable(value = "Consigneename") String Consigneename,
                       @PathVariable(value = "siteName") String siteName,
                       @PathVariable(value = "consigneeSize") String consigneeSize,
                       @PathVariable(value = "cellphone",required = false) int cellphone,
                       @PathVariable(value = "phone",required = false) int phone,
                       @PathVariable(value = "defaults") int  defaults) {
        return siteService.update(id,Consigneename,siteName,consigneeSize,cellphone,phone,defaults);
    }
}
