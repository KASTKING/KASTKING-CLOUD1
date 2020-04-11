package com.kastking.platformChannel.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kastking.common.annotation.Log;
import com.kastking.common.enums.BusinessType;
import com.kastking.platformChannel.domain.PlatformChannel;
import com.kastking.platformChannel.service.PlatformChannelService;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.utils.poi.ExcelUtil;
import com.kastking.common.utils.StringUtils;
import com.kastking.common.core.domain.Ztree;

/**
 * 平台站点Controller
 *
 * @author Michael
 * @date 2020-02-06
 */
@Controller
@RequestMapping("/salesForecast/platformChannel")
public class PlatformChannelController extends BaseController {
    private String prefix = "salesForecast/platformChannel";

    @Autowired
    private PlatformChannelService platformChannelService;

    @RequiresPermissions("salesForecast:platformChannel:view")
    @GetMapping()
    public String platformChannel() {
        return prefix + "/platformChannel";
    }

    /**
     * 查询平台站点树列表
     */
    @RequiresPermissions("salesForecast:platformChannel:list")
    @PostMapping("/list")
    @ResponseBody
    public List<PlatformChannel> list(PlatformChannel platformChannel) {
        List<PlatformChannel> list = platformChannelService.selectPlatformChannelList(platformChannel);
        return list;
    }

    /**
     * 导出平台站点列表
     */
    @RequiresPermissions("salesForecast:platformChannel:export")
    @Log(title = "平台站点" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PlatformChannel platformChannel) {
        List<PlatformChannel> list = platformChannelService.selectPlatformChannelList(platformChannel);
        ExcelUtil<PlatformChannel> util = new ExcelUtil<PlatformChannel>(PlatformChannel.class);
        return util.exportExcel(list, "platformChannel");
    }

    /**
     * 新增平台站点
     */
    @GetMapping(value = {"/add/{platformChannelId}" , "/add/"})
    public String add(@PathVariable(value = "platformChannelId" , required = false) Long platformChannelId, ModelMap mmap) {
        if (StringUtils.isNotNull(platformChannelId)) {
            mmap.put("platformChannel" , platformChannelService.selectPlatformChannelById(platformChannelId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存平台站点
     */
    @RequiresPermissions("salesForecast:platformChannel:add")
    @Log(title = "平台站点" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PlatformChannel platformChannel) {
        return toAjax(platformChannelService.insertPlatformChannel(platformChannel));
    }

    /**
     * 详情平台站点
     */
    @GetMapping("/detail/{platformChannelId}")
    public String detail(@PathVariable("platformChannelId") Long platformChannelId, ModelMap mmap) {
        PlatformChannel platformChannel = platformChannelService.selectPlatformChannelById(platformChannelId);
        mmap.put("platformChannel" , platformChannel);
        return prefix + "/detail";
    }


    /**
     * 修改平台站点
     */
    @GetMapping("/edit/{platformChannelId}")
    public String edit(@PathVariable("platformChannelId") Long platformChannelId, ModelMap mmap) {
        PlatformChannel platformChannel = platformChannelService.selectPlatformChannelById(platformChannelId);
        mmap.put("platformChannel" , platformChannel);
        return prefix + "/edit";
    }

    /**
     * 修改保存平台站点
     */
    @RequiresPermissions("salesForecast:platformChannel:edit")
    @Log(title = "平台站点" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PlatformChannel platformChannel) {
        return toAjax(platformChannelService.updatePlatformChannel(platformChannel));
    }

    /**
     * 删除
     */
    @RequiresPermissions("salesForecast:platformChannel:remove")
    @Log(title = "平台站点" , businessType = BusinessType.DELETE)
    @GetMapping("/remove/{platformChannelId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("platformChannelId") Long platformChannelId) {
        return toAjax(platformChannelService.deletePlatformChannelById(platformChannelId));
    }

    /**
     * 选择平台站点树
     */
    @GetMapping(value = {"/selectPlatformChannelTree/{platformChannelId}" , "/selectPlatformChannelTree/"})
    public String selectPlatformChannelTree(@PathVariable(value = "platformChannelId" , required = false) Long platformChannelId, ModelMap mmap) {
        if (StringUtils.isNotNull(platformChannelId)) {
            mmap.put("platformChannel" , platformChannelService.selectPlatformChannelById(platformChannelId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载平台站点树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData() {
        List<Ztree> ztrees = platformChannelService.selectPlatformChannelTree();
        return ztrees;
    }
}
