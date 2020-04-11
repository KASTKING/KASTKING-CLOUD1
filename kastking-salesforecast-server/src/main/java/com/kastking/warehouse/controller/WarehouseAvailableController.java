package com.kastking.warehouse.controller;

import java.util.List;

import com.kastking.common.core.domain.Ztree;
import com.kastking.warehouse.domain.WarehouseAvailable;
import com.kastking.warehouse.service.IWarehouseAvailableService;
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
 * 仓库可用Controller
 *
 * @author Michael
 * @date 2020-03-03
 */
@Controller
@RequestMapping("/salesForecast/available")
public class WarehouseAvailableController extends BaseController {
    private String prefix = "salesForecast/available";

    @Autowired
    private IWarehouseAvailableService warehouseAvailableService;

    /**
     * 加载数菜单树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData() {
        List<Ztree> ztrees = warehouseAvailableService.selectWarehouseAvailableTree();
        return ztrees;
    }

    @RequiresPermissions("salesForecast:available:view")
    @GetMapping()
    public String available() {
        return prefix + "/available";
    }

    /**
     * 查询仓库可用列表
     */
    @RequiresPermissions("salesForecast:available:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WarehouseAvailable warehouseAvailable) {
        startPage();
        List<WarehouseAvailable> list = warehouseAvailableService.selectWarehouseAvailableList(warehouseAvailable);
        return getDataTable(list);
    }

    /**
     * 导入仓库可用列表
     */
    @RequiresPermissions("salesForecast:warehouseAvailable:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<WarehouseAvailable> util = new ExcelUtil<WarehouseAvailable>(WarehouseAvailable.class);
        List<WarehouseAvailable> warehouseAvailableList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = warehouseAvailableService.importWarehouseAvailable(warehouseAvailableList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出仓库可用列表
     */
    @RequiresPermissions("salesForecast:available:export")
    @Log(title = "仓库可用" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WarehouseAvailable warehouseAvailable) {
        List<WarehouseAvailable> list = warehouseAvailableService.selectWarehouseAvailableList(warehouseAvailable);
        ExcelUtil<WarehouseAvailable> util = new ExcelUtil<WarehouseAvailable>(WarehouseAvailable.class);
        return util.exportExcel(list, "available");
    }

    /**
     * 新增仓库可用
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存仓库可用
     */
    @RequiresPermissions("salesForecast:available:add")
    @Log(title = "仓库可用" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WarehouseAvailable warehouseAvailable) {
        return toAjax(warehouseAvailableService.insertWarehouseAvailable(warehouseAvailable));
    }

    /**
     * 详情仓库可用
     */
    @GetMapping("/detail/{availableId}")
    public String detail(@PathVariable("availableId") Long availableId, ModelMap mmap) {
        WarehouseAvailable warehouseAvailable = warehouseAvailableService.selectWarehouseAvailableById(availableId);
        mmap.put("warehouseAvailable" , warehouseAvailable);
        return prefix + "/detail";
    }


    /**
     * 修改仓库可用
     */
    @GetMapping("/edit/{availableId}")
    public String edit(@PathVariable("availableId") Long availableId, ModelMap mmap) {
        WarehouseAvailable warehouseAvailable = warehouseAvailableService.selectWarehouseAvailableById(availableId);
        mmap.put("warehouseAvailable" , warehouseAvailable);
        return prefix + "/edit";
    }

    /**
     * 修改保存仓库可用
     */
    @RequiresPermissions("salesForecast:available:edit")
    @Log(title = "仓库可用" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WarehouseAvailable warehouseAvailable) {
        return toAjax(warehouseAvailableService.updateWarehouseAvailable(warehouseAvailable));
    }

    /**
     * 删除仓库可用
     */
    @RequiresPermissions("salesForecast:available:remove")
    @Log(title = "仓库可用" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(warehouseAvailableService.deleteWarehouseAvailableByIds(ids));
    }

    /**
     * 下载仓库可用模板
     */
    @RequiresPermissions("salesForecast:available:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<WarehouseAvailable> util = new ExcelUtil<WarehouseAvailable>(WarehouseAvailable.class);
        return util.importTemplateExcel("仓库可用数据");
    }
}
