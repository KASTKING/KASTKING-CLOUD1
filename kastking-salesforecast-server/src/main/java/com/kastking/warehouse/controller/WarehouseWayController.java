package com.kastking.warehouse.controller;

import java.util.List;

import com.kastking.warehouse.domain.WarehouseWay;
import com.kastking.warehouse.service.IWarehouseWayService;
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
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import com.kastking.framework.util.ShiroUtils;
import com.kastking.common.core.page.TableDataInfo;

/**
 * 仓库在途Controller
 *
 * @author Michael
 * @date 2020-03-06
 */
@Controller
@RequestMapping("/salesForecast/way")
public class WarehouseWayController extends BaseController {
    private String prefix = "salesForecast/way";

    @Autowired
    private IWarehouseWayService warehouseWayService;

    @RequiresPermissions("salesForecast:way:view")
    @GetMapping()
    public String way() {
        return prefix + "/way";
    }

    /**
     * 查询仓库在途列表
     */
    @RequiresPermissions("salesForecast:way:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WarehouseWay warehouseWay) {
        startPage();
        List<WarehouseWay> list = warehouseWayService.selectWarehouseWayList(warehouseWay);
        return getDataTable(list);
    }

    /**
     * 导入仓库在途列表
     */
    @RequiresPermissions("salesForecast:warehouseWay:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<WarehouseWay> util = new ExcelUtil<WarehouseWay>(WarehouseWay.class);
        List<WarehouseWay> warehouseWayList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = warehouseWayService.importWarehouseWay(warehouseWayList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出仓库在途列表
     */
    @RequiresPermissions("salesForecast:way:export")
    @Log(title = "仓库在途" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WarehouseWay warehouseWay) {
        List<WarehouseWay> list = warehouseWayService.selectWarehouseWayList(warehouseWay);
        ExcelUtil<WarehouseWay> util = new ExcelUtil<WarehouseWay>(WarehouseWay.class);
        return util.exportExcel(list, "way");
    }

    /**
     * 新增仓库在途
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存仓库在途
     */
    @RequiresPermissions("salesForecast:way:add")
    @Log(title = "仓库在途" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WarehouseWay warehouseWay) {
        return toAjax(warehouseWayService.insertWarehouseWay(warehouseWay));
    }

    /**
     * 详情仓库在途
     */
    @GetMapping("/detail/{wayId}")
    public String detail(@PathVariable("wayId") Long wayId, ModelMap mmap) {
        WarehouseWay warehouseWay = warehouseWayService.selectWarehouseWayById(wayId);
        mmap.put("warehouseWay" , warehouseWay);
        return prefix + "/detail";
    }


    /**
     * 修改仓库在途
     */
    @GetMapping("/edit/{wayId}")
    public String edit(@PathVariable("wayId") Long wayId, ModelMap mmap) {
        WarehouseWay warehouseWay = warehouseWayService.selectWarehouseWayById(wayId);
        mmap.put("warehouseWay" , warehouseWay);
        return prefix + "/edit";
    }

    /**
     * 修改保存仓库在途
     */
    @RequiresPermissions("salesForecast:way:edit")
    @Log(title = "仓库在途" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WarehouseWay warehouseWay) {
        return toAjax(warehouseWayService.updateWarehouseWay(warehouseWay));
    }

    /**
     * 删除仓库在途
     */
    @RequiresPermissions("salesForecast:way:remove")
    @Log(title = "仓库在途" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(warehouseWayService.deleteWarehouseWayByIds(ids));
    }

    /**
     * 下载仓库在途模板
     */
    @RequiresPermissions("salesForecast:way:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<WarehouseWay> util = new ExcelUtil<WarehouseWay>(WarehouseWay.class);
        return util.importTemplateExcel("仓库在途数据");
    }
}
