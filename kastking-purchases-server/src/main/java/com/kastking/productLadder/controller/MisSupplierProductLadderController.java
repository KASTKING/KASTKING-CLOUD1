package com.kastking.productLadder.controller;

import java.util.List;

import com.kastking.productLadder.domain.MisSupplierProductLadder;
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
import com.kastking.productLadder.service.IMisSupplierProductLadderService;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import com.kastking.framework.util.ShiroUtils;
import com.kastking.common.core.page.TableDataInfo;

/**
 * 供应商产品阶梯价Controller
 *
 * @author James
 * @date 2020-02-14
 */
@Controller
@RequestMapping("/supplier/productLadder")
public class MisSupplierProductLadderController extends BaseController {
    private String prefix = "supplier/productLadder";

    @Autowired
    private IMisSupplierProductLadderService misSupplierProductLadderService;

    @RequiresPermissions("supplier:productLadder:view")
    @GetMapping()
    public String productLadder() {
        return prefix + "/productLadder";
    }

    /**
     * 查询供应商产品阶梯价列表
     */
    @RequiresPermissions("supplier:productLadder:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisSupplierProductLadder misSupplierProductLadder) {
        startPage();
        List<MisSupplierProductLadder> list = misSupplierProductLadderService.selectMisSupplierProductLadderList(misSupplierProductLadder);
        return getDataTable(list);
    }

    /**
     * 导入供应商产品阶梯价列表
     */
    @RequiresPermissions("supplier:misSupplierProductLadder:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<MisSupplierProductLadder> util = new ExcelUtil<MisSupplierProductLadder>(MisSupplierProductLadder.class);
        List<MisSupplierProductLadder> misSupplierProductLadderList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = misSupplierProductLadderService.importMisSupplierProductLadder(misSupplierProductLadderList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出供应商产品阶梯价列表
     */
    @RequiresPermissions("supplier:productLadder:export")
    @Log(title = "供应商产品阶梯价" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MisSupplierProductLadder misSupplierProductLadder) {
        List<MisSupplierProductLadder> list = misSupplierProductLadderService.selectMisSupplierProductLadderList(misSupplierProductLadder);
        ExcelUtil<MisSupplierProductLadder> util = new ExcelUtil<MisSupplierProductLadder>(MisSupplierProductLadder.class);
        return util.exportExcel(list, "productLadder");
    }

    /**
     * 新增供应商产品阶梯价
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存供应商产品阶梯价
     */
    @RequiresPermissions("supplier:productLadder:add")
    @Log(title = "供应商产品阶梯价" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MisSupplierProductLadder misSupplierProductLadder) {
        return toAjax(misSupplierProductLadderService.insertMisSupplierProductLadder(misSupplierProductLadder));
    }

    /**
     * 详情供应商产品阶梯价
     */
    @GetMapping("/detail/{stepId}")
    public String detail(@PathVariable("stepId") Long stepId, ModelMap mmap) {
        MisSupplierProductLadder misSupplierProductLadder = misSupplierProductLadderService.selectMisSupplierProductLadderById(stepId);
        mmap.put("misSupplierProductLadder" , misSupplierProductLadder);
        return prefix + "/detail";
    }


    /**
     * 修改供应商产品阶梯价
     */
    @GetMapping("/edit/{stepId}")
    public String edit(@PathVariable("stepId") Long stepId, ModelMap mmap) {
        MisSupplierProductLadder misSupplierProductLadder = misSupplierProductLadderService.selectMisSupplierProductLadderById(stepId);
        mmap.put("misSupplierProductLadder" , misSupplierProductLadder);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商产品阶梯价
     */
    @RequiresPermissions("supplier:productLadder:edit")
    @Log(title = "供应商产品阶梯价" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MisSupplierProductLadder misSupplierProductLadder) {
        return toAjax(misSupplierProductLadderService.updateMisSupplierProductLadder(misSupplierProductLadder));
    }

    /**
     * 删除供应商产品阶梯价
     */
    @RequiresPermissions("supplier:productLadder:remove")
    @Log(title = "供应商产品阶梯价" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(misSupplierProductLadderService.deleteMisSupplierProductLadderByIds(ids));
    }

    /**
     * 下载供应商产品阶梯价模板
     */
    @RequiresPermissions("supplier:productLadder:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<MisSupplierProductLadder> util = new ExcelUtil<MisSupplierProductLadder>(MisSupplierProductLadder.class);
        return util.importTemplateExcel("供应商产品阶梯价数据");
    }
}
