package com.kastking.warehouse.controller;

import java.util.List;

import com.kastking.warehouse.domain.Warehouse;
import com.kastking.warehouse.service.IWarehouseService;
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
 * 仓库Controller
 *
 * @author Michael
 * @date 2020-02-28
 */
@Controller
@RequestMapping("/salesForecast/warehouse")
public class WarehouseController extends BaseController {
    private String prefix = "salesForecast/warehouse";

    @Autowired
    private IWarehouseService warehouseService;

    @RequiresPermissions("salesForecast:warehouse:view")
    @GetMapping()
    public String warehouse() {
        return prefix + "/warehouse";
    }

    /**
     * 查询仓库列表
     */
    @RequiresPermissions("salesForecast:warehouse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Warehouse warehouse) {
        startPage();
        List<Warehouse> list = warehouseService.selectWarehouseList(warehouse);
        return getDataTable(list);
    }

    /**
     * 导入仓库列表
     */
    @RequiresPermissions("salesForecast:warehouse:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<Warehouse> util = new ExcelUtil<Warehouse>(Warehouse.class);
        List<Warehouse> warehouseList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = warehouseService.importWarehouse(warehouseList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出仓库列表
     */
    @RequiresPermissions("salesForecast:warehouse:export")
    @Log(title = "仓库" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Warehouse warehouse) {
        List<Warehouse> list = warehouseService.selectWarehouseList(warehouse);
        ExcelUtil<Warehouse> util = new ExcelUtil<Warehouse>(Warehouse.class);
        return util.exportExcel(list, "warehouse");
    }

    /**
     * 新增仓库
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存仓库
     */
    @RequiresPermissions("salesForecast:warehouse:add")
    @Log(title = "仓库" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Warehouse warehouse) {
        return toAjax(warehouseService.insertWarehouse(warehouse));
    }

    /**
     * 详情仓库
     */
    @GetMapping("/detail/{warehouseId}")
    public String detail(@PathVariable("warehouseId") Long warehouseId, ModelMap mmap) {
        Warehouse warehouse = warehouseService.selectWarehouseById(warehouseId);
        mmap.put("warehouse" , warehouse);
        return prefix + "/detail";
    }


    /**
     * 修改仓库
     */
    @GetMapping("/edit/{warehouseId}")
    public String edit(@PathVariable("warehouseId") Long warehouseId, ModelMap mmap) {
        Warehouse warehouse = warehouseService.selectWarehouseById(warehouseId);
        mmap.put("warehouse" , warehouse);
        return prefix + "/edit";
    }

    /**
     * 修改保存仓库
     */
    @RequiresPermissions("salesForecast:warehouse:edit")
    @Log(title = "仓库" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Warehouse warehouse) {
        return toAjax(warehouseService.updateWarehouse(warehouse));
    }

    /**
     * 删除仓库
     */
    @RequiresPermissions("salesForecast:warehouse:remove")
    @Log(title = "仓库" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(warehouseService.deleteWarehouseByIds(ids));
    }

    /**
     * 下载仓库模板
     */
    @RequiresPermissions("salesForecast:warehouse:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<Warehouse> util = new ExcelUtil<Warehouse>(Warehouse.class);
        return util.importTemplateExcel("仓库数据");
    }
}
