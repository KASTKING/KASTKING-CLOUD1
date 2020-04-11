package com.kastking.supplierInfo.controller;

import java.util.List;

import com.kastking.supplierInfo.domain.MisSupplierInfo;
import com.kastking.supplierInfo.service.IMisSupplierInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.kastking.common.annotation.Log;
import com.kastking.common.enums.BusinessType;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.utils.poi.ExcelUtil;
import com.kastking.common.utils.StringUtils;
import com.kastking.common.core.domain.Ztree;

/**
 * 供应商信息Controller
 *
 * @author James
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/supplier/supplierInfo")
public class MisSupplierInfoController extends BaseController {
    private String prefix = "supplier/supplierInfo";

    @Autowired
    private IMisSupplierInfoService misSupplierInfoService;

    @RequiresPermissions("supplier:supplierInfo:view")
    @GetMapping()
    public String supplierInfo() {
        return prefix + "/supplierInfo";
    }

    @GetMapping("/info")
    public String info() {
        return prefix + "/supplierInfo";
    }

    /**
     * 查询供应商信息树列表
     */
    @RequiresPermissions("supplier:supplierInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public List<MisSupplierInfo> list(MisSupplierInfo misSupplierInfo) {
        List<MisSupplierInfo> list = misSupplierInfoService.selectMisSupplierInfoList(misSupplierInfo);
        return list;
    }

    /**
     * 导出供应商信息列表
     */
    @RequiresPermissions("supplier:supplierInfo:export")
    @Log(title = "供应商信息" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MisSupplierInfo misSupplierInfo) {
        List<MisSupplierInfo> list = misSupplierInfoService.selectMisSupplierInfoList(misSupplierInfo);
        ExcelUtil<MisSupplierInfo> util = new ExcelUtil<MisSupplierInfo>(MisSupplierInfo.class);
        return util.exportExcel(list, "supplierInfo");
    }

    /**
     * 新增供应商信息
     */
    @GetMapping(value = {"/add/{supplierId}" , "/add/"})
    public String add(@PathVariable(value = "supplierId" , required = false) Long supplierId, ModelMap mmap) {
        if (StringUtils.isNotNull(supplierId)) {
            mmap.put("misSupplierInfo" , misSupplierInfoService.selectMisSupplierInfoById(supplierId));
        }
        return prefix + "/add";
    }

    /**
     * 新增供应商信息
     */
    @GetMapping(value = {"/adds/{supplierId}" , "/adds/"})
    public String adds(@PathVariable(value = "supplierId" , required = false) Long supplierId, ModelMap mmap) {
        if (StringUtils.isNotNull(supplierId)) {
            mmap.put("misSupplierInfo" , misSupplierInfoService.selectMisSupplierInfoById(supplierId));
        }
        return prefix + "/adds";
    }

    /**
     * 新增保存供应商信息
     */
    @RequiresPermissions("supplier:supplierInfo:add")
    @Log(title = "供应商信息" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MisSupplierInfo misSupplierInfo) {
//        Map<String,Object> map=new HashMap<>();
//        map.put("result",toAjax(misSupplierInfoService.insertMisSupplierInfo(misSupplierInfo)));
//        map.put("supplierId",misSupplierInfo.getSupplierId());
        return toAjax(misSupplierInfoService.insertMisSupplierInfo(misSupplierInfo));
    }

    /**
     * 详情供应商信息
     */
    @GetMapping("/detail/{supplierId}")
    public String detail(@PathVariable("supplierId") Long supplierId, ModelMap mmap) {
        MisSupplierInfo misSupplierInfo = misSupplierInfoService.selectMisSupplierInfoById(supplierId);
        mmap.put("misSupplierInfo" , misSupplierInfo);
        return prefix + "/detail";
    }

    /**
     * 修改供应商信息
     */
    @GetMapping("/edit/{supplierId}")
    public String edit(@PathVariable("supplierId") Long supplierId, ModelMap mmap) {
        MisSupplierInfo misSupplierInfo = misSupplierInfoService.selectMisSupplierInfoById(supplierId);
        mmap.put("misSupplierInfo" , misSupplierInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商信息
     */
    @RequiresPermissions("supplier:supplierInfo:edit")
    @Log(title = "供应商信息" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MisSupplierInfo misSupplierInfo) {
        return toAjax(misSupplierInfoService.updateMisSupplierInfo(misSupplierInfo));
    }

    /**
     * 删除
     */
    @RequiresPermissions("supplier:supplierInfo:remove")
    @Log(title = "供应商信息" , businessType = BusinessType.DELETE)
    @GetMapping("/remove/{supplierId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("supplierId") Long supplierId) {
        return toAjax(misSupplierInfoService.deleteMisSupplierInfoById(supplierId));
    }

    /**
     * 选择供应商信息树
     */
    @GetMapping(value = {"/selectSupplierInfoTree/{supplierId}" , "/selectSupplierInfoTree/"})
    public String selectSupplierInfoTree(@PathVariable(value = "supplierId" , required = false) Long supplierId, ModelMap mmap) {
        if (StringUtils.isNotNull(supplierId)) {
            mmap.put("misSupplierInfo" , misSupplierInfoService.selectMisSupplierInfoById(supplierId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载供应商信息树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData() {
        List<Ztree> ztrees = misSupplierInfoService.selectMisSupplierInfoTree();
        return ztrees;
    }

    /**
     * 根据供应商ID返回凭证列表页面
     */
    @GetMapping("/file/{fatherId}")
    public String selectFile(@PathVariable("fatherId") Long fatherId, ModelMap mmap) {
        //供应商信息对象
        MisSupplierInfo misSupplierInfo = misSupplierInfoService.selectMisSupplierInfoById(fatherId);
        mmap.put("misSupplierInfo" , misSupplierInfo);
        //返回凭证列表页面
        return prefix + "/file";
    }
}
