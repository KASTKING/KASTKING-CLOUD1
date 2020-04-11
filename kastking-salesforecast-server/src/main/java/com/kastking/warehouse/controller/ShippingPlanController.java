package com.kastking.warehouse.controller;

import java.util.List;

import com.kastking.warehouse.domain.ShippingPlan;
import com.kastking.warehouse.service.IShippingPlanService;
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
 * 出货计划Controller
 *
 * @author Michael
 * @date 2020-03-06
 */
@Controller
@RequestMapping("/salesForecast/plan")
public class ShippingPlanController extends BaseController {
    private String prefix = "salesForecast/plan";

    @Autowired
    private IShippingPlanService shippingPlanService;

    @RequiresPermissions("salesForecast:plan:view")
    @GetMapping()
    public String plan() {
        return prefix + "/plan";
    }

    /**
     * 查询出货计划列表
     */
    @RequiresPermissions("salesForecast:plan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShippingPlan shippingPlan) {
        startPage();
        List<ShippingPlan> list = shippingPlanService.selectShippingPlanList(shippingPlan);
        return getDataTable(list);
    }

    /**
     * 导入出货计划列表
     */
    @RequiresPermissions("salesForecast:shippingPlan:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<ShippingPlan> util = new ExcelUtil<ShippingPlan>(ShippingPlan.class);
        List<ShippingPlan> shippingPlanList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = shippingPlanService.importShippingPlan(shippingPlanList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出出货计划列表
     */
    @RequiresPermissions("salesForecast:plan:export")
    @Log(title = "出货计划" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShippingPlan shippingPlan) {
        List<ShippingPlan> list = shippingPlanService.selectShippingPlanList(shippingPlan);
        ExcelUtil<ShippingPlan> util = new ExcelUtil<ShippingPlan>(ShippingPlan.class);
        return util.exportExcel(list, "plan");
    }

    /**
     * 新增出货计划
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存出货计划
     */
    @RequiresPermissions("salesForecast:plan:add")
    @Log(title = "出货计划" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShippingPlan shippingPlan) {
        return toAjax(shippingPlanService.insertShippingPlan(shippingPlan));
    }

    /**
     * 详情出货计划
     */
    @GetMapping("/detail/{shippingPlanId}")
    public String detail(@PathVariable("shippingPlanId") Long shippingPlanId, ModelMap mmap) {
        ShippingPlan shippingPlan = shippingPlanService.selectShippingPlanById(shippingPlanId);
        mmap.put("shippingPlan" , shippingPlan);
        return prefix + "/detail";
    }


    /**
     * 修改出货计划
     */
    @GetMapping("/edit/{shippingPlanId}")
    public String edit(@PathVariable("shippingPlanId") Long shippingPlanId, ModelMap mmap) {
        ShippingPlan shippingPlan = shippingPlanService.selectShippingPlanById(shippingPlanId);
        mmap.put("shippingPlan" , shippingPlan);
        return prefix + "/edit";
    }

    /**
     * 修改保存出货计划
     */
    @RequiresPermissions("salesForecast:plan:edit")
    @Log(title = "出货计划" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShippingPlan shippingPlan) {
        return toAjax(shippingPlanService.updateShippingPlan(shippingPlan));
    }

    /**
     * 删除出货计划
     */
    @RequiresPermissions("salesForecast:plan:remove")
    @Log(title = "出货计划" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(shippingPlanService.deleteShippingPlanByIds(ids));
    }

    /**
     * 下载出货计划模板
     */
    @RequiresPermissions("salesForecast:plan:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<ShippingPlan> util = new ExcelUtil<ShippingPlan>(ShippingPlan.class);
        return util.importTemplateExcel("出货计划数据");
    }
}
