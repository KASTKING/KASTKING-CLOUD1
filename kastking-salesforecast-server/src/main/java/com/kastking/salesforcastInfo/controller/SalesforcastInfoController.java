package com.kastking.salesforcastInfo.controller;

import java.util.List;

import com.kastking.salesforcastInfo.domain.SalesforcastDemanda;
import com.kastking.salesforcastInfo.domain.SalesforcastInfo;
import com.kastking.system.domain.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.kastking.common.annotation.Log;
import com.kastking.common.enums.BusinessType;
import com.kastking.salesforcastInfo.service.SalesforcastInfoService;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import com.kastking.framework.util.ShiroUtils;
import com.kastking.common.core.page.TableDataInfo;

/**
 * 销量预计信息Controller
 *
 * @author Michael
 * @date 2020-02-14
 */
@Controller
@RequestMapping("/salesForecast/salesforcastInfo")
public class SalesforcastInfoController extends BaseController {
    private String prefix = "salesForecast/salesforcastInfo";

    @Autowired
    private SalesforcastInfoService salesforcastInfoService;

    /**
     * 删除销量预计信息
     */
    @RequiresPermissions("salesForecast:salesforcastInfo:remove")
    @Log(title = "销量预计信息" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(salesforcastInfoService.deleteSalesforcastInfoByIds(ids));
    }


    /**
     * 销量预计销量报表
     *
     * @return
     */
    @RequiresPermissions("salesForecast:salesforcastInfo:viewSalesList")
    @PostMapping("/listSalesData")
    @ResponseBody
    TableDataInfo listSalesforcastSales(SalesforcastDemanda salesforcastDemanda) {
        startPage();
        List<SalesforcastDemanda> list = salesforcastInfoService.listSalesforcastSales(salesforcastDemanda);
        return getDataTable(list);
    }

    /**
     * 导出销量预计销量列表
     */
//    @RequiresPermissions("salesForecast:salesforcastInfo:export")
    @Log(title = "销量预计销量报表" , businessType = BusinessType.EXPORT)
    @PostMapping("/exportSales")
    @ResponseBody
    public AjaxResult exportSales(SalesforcastDemanda salesforcastDemanda) {
        List<SalesforcastDemanda> list = salesforcastInfoService.listSalesforcastSales(salesforcastDemanda);
        ExcelUtil<SalesforcastDemanda> util = new ExcelUtil<SalesforcastDemanda>(SalesforcastDemanda.class);
        return util.exportExcel(list, "salesforcastSales");
    }

    /**
     * 销量预计销量报表
     *
     * @return
     */
    @RequiresPermissions("salesForecast:salesforcastInfo:viewSalesList")
    @GetMapping("/salesList")
    public String salesforcastSales() {
        return prefix + "/salesforcastSalesList";
    }
    //----------------------------------------------------------------------------------------

    /**
     * 销量预计需求量报表
     *
     * @return
     */
    @RequiresPermissions("salesForecast:salesforcastInfo:viewDemandList")
    @PostMapping("/listDemandData")
    @ResponseBody
    TableDataInfo listSalesforcastDemand(SalesforcastDemanda salesforcastDemanda) {
        startPage();
        List<SalesforcastDemanda> list = salesforcastInfoService.listSalesforcastDemand(salesforcastDemanda);
        return getDataTable(list);
    }

    /**
     * 导出销量预计需求量列表
     */
//    @RequiresPermissions("salesForecast:salesforcastInfo:export")
    @Log(title = "销量预计需求量报表" , businessType = BusinessType.EXPORT)
    @PostMapping("/exportDemand")
    @ResponseBody
    public AjaxResult exportDemand(SalesforcastDemanda salesforcastDemanda) {
        List<SalesforcastDemanda> list = salesforcastInfoService.listSalesforcastDemand(salesforcastDemanda);
        ExcelUtil<SalesforcastDemanda> util = new ExcelUtil<SalesforcastDemanda>(SalesforcastDemanda.class);
        return util.exportExcel(list, "salesforcastDemand");
    }

    /**
     * 销量预计需求量报表
     *
     * @return
     */
    @RequiresPermissions("salesForecast:salesforcastInfo:viewDemandList")
    @GetMapping("/demandList")
    public String salesforcastDemand() {
        return prefix + "/salesforcastDemandList";
    }

    //--------------------------------------------------------------------------------------------
    @RequiresPermissions("salesForecast:salesforcastInfo:view")
    @GetMapping()
    public String salesforcastInfo() {
        return prefix + "/salesforcastInfo";
    }

    /**
     * 查询销量预计信息列表
     */
    @RequiresPermissions("salesForecast:salesforcastInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SalesforcastInfo salesforcastInfo) {
        if (salesforcastInfo.getSalesforcastInfoId() == null)
            salesforcastInfo.setSku("111111111111111111");
        startPage();
        List<SalesforcastInfo> list = salesforcastInfoService.selectSalesforcastInfoList(salesforcastInfo);
        return getDataTable(list);
    }

    /**
     * 导入销量预计信息列表
     */
    @RequiresPermissions("salesForecast:salesforcastInfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<SalesforcastInfo> util = new ExcelUtil<SalesforcastInfo>(SalesforcastInfo.class);
        List<SalesforcastInfo> salesforcastInfoList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = salesforcastInfoService.importSalesforcastInfo(salesforcastInfoList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出销量预计信息列表
     */
    @RequiresPermissions("salesForecast:salesforcastInfo:export")
    @Log(title = "销量预计信息" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SalesforcastInfo salesforcastInfo) {
        List<SalesforcastInfo> list = salesforcastInfoService.selectSalesforcastInfoList(salesforcastInfo);
        ExcelUtil<SalesforcastInfo> util = new ExcelUtil<SalesforcastInfo>(SalesforcastInfo.class);
        return util.exportExcel(list, "salesforcastInfo");
    }


    /**
     * 新增销量预计信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存销量预计信息
     */
    @RequiresPermissions("salesForecast:salesforcastInfo:add")
    @Log(title = "销量预计信息" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SalesforcastInfo salesforcastInfo) {
        return toAjax(salesforcastInfoService.insertSalesforcastInfo(salesforcastInfo));
    }

    /**
     * 详情销量预计信息
     */
    @GetMapping("/detail/{salesforcastInfoId}")
    public String detail(@PathVariable("salesforcastInfoId") Long salesforcastInfoId, ModelMap mmap) {
        SalesforcastInfo salesforcastInfo = salesforcastInfoService.selectSalesforcastInfoById(salesforcastInfoId);
        mmap.put("salesforcastInfo" , salesforcastInfo);
        return prefix + "/detail";
    }


    /**
     * 修改销量预计信息
     */
    @GetMapping("/edit/{salesforcastInfoId}")
    public String edit(@PathVariable("salesforcastInfoId") Long salesforcastInfoId, ModelMap mmap) {
        SalesforcastInfo salesforcastInfo = salesforcastInfoService.selectSalesforcastInfoById(salesforcastInfoId);
        mmap.put("salesforcastInfo" , salesforcastInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存销量预计信息
     */
    @RequiresPermissions("salesForecast:salesforcastInfo:edit")
    @Log(title = "销量预计信息" , businessType = BusinessType.UPDATE)
    @PostMapping("/editnum")
    @ResponseBody
    public AjaxResult editnum(@RequestBody SalesforcastInfo salesforcastInfo) {
        return toAjax(salesforcastInfoService.updateSalesforcastInfo(salesforcastInfo));
    }

    /**
     * 修改保存销量预计信息
     */
    @RequiresPermissions("salesForecast:salesforcastInfo:edit")
    @Log(title = "销量预计信息" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SalesforcastInfo salesforcastInfo) {
        return toAjax(salesforcastInfoService.updateSalesforcastInfo(salesforcastInfo));
    }

    /**
     * 审核
     */
    @RequiresPermissions("salesForecast:salesforcastInfo:review")
    @Log(title = "销量预计信息" , businessType = BusinessType.DELETE)
    @PostMapping("/review")
    @ResponseBody
    public AjaxResult review(@RequestBody SalesforcastInfo salesforcastInfo) {
        // 获取当前的用户信息
        SysUser currentUser = ShiroUtils.getSysUser();
        // 获取当前的用户名称
        String userName = currentUser.getUserName();
        return toAjax(salesforcastInfoService.review(1, Integer.valueOf(salesforcastInfo.getSalesforcastInfoId().toString()), userName));
    }

    /**
     * 反审核
     */
    @RequiresPermissions("salesForecast:salesforcastInfo:antiReview")
    @Log(title = "销量预计信息" , businessType = BusinessType.DELETE)
    @PostMapping("/antiReview")
    @ResponseBody
    public AjaxResult antiReview(@RequestBody SalesforcastInfo salesforcastInfo) {
        // 获取当前的用户信息
        SysUser currentUser = ShiroUtils.getSysUser();
        // 获取当前的用户名称
        String userName = currentUser.getUserName();
        return toAjax(salesforcastInfoService.review(0, Integer.valueOf(salesforcastInfo.getSalesforcastInfoId().toString()), null));
    }

    /**
     * 下载销量预计信息模板
     */
    @RequiresPermissions("salesForecast:salesforcastInfo:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<SalesforcastInfo> util = new ExcelUtil<SalesforcastInfo>(SalesforcastInfo.class);
        return util.importTemplateExcel("销量预计信息数据");
    }
}
