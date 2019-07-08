package com.ls.vbuynet.service.consumer.site.service;


import com.ls.vbuynet.commons.domain.Site;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "vbuynet-service-provider-site")
public interface SiteService {


    /**
     * 插入数据
     * @param site
     * @param Consigneename
     * @param siteName
     * @param consigneeSize
     * @param cellphone
     * @param phone
     * @return
     */
    @RequestMapping(value = "site/{Consigneename}/{siteName}/{consigneeSize}/{cellphone}/{phone}",method = RequestMethod.POST)
    public String insertsite(Site site,
                             @PathVariable(value = "Consigneename") String Consigneename,
                             @PathVariable(value = "siteName") String siteName,
                             @PathVariable(value = "consigneeSize") String consigneeSize,
                             @PathVariable(value = "cellphone",required = false) int cellphone,
                             @PathVariable(value = "phone",required = false) int phone);


    /**
     * 根据用户id查询
     * @param userid
     * @return
     */
    @GetMapping(value = "sites/{userid}")
    public String sites(@PathVariable(value = "userid") int userid);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable(value = "id") int id);

    /**
     * 更新数据
     * @param site
     * @param id
     * @param Consigneename
     * @param siteName
     * @param consigneeSize
     * @param cellphone
     * @param phone
     * @param defaults
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
                         @PathVariable(value = "defaults") int  defaults);
}
