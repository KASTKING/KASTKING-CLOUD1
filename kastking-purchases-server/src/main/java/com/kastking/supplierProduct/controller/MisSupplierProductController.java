package com.kastking.supplierProduct.controller;

import java.util.List;

import com.kastking.common.utils.StringUtils;
import com.kastking.supplierInfo.service.IMisSupplierInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.kastking.common.annotation.Log;
import com.kastking.common.enums.BusinessType;
import com.kastking.supplierProduct.domain.MisSupplierProduct;
import com.kastking.supplierProduct.service.IMisSupplierProductService;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import com.kastking.framework.util.ShiroUtils;
import com.kastking.common.core.page.TableDataInfo;

/**
 * 供应商产品Controller
 *
 * @author James
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/supplier/supplierProducts")
public class MisSupplierProductController extends BaseController {
    private String prefix = "supplier/supplierProducts";

    @Autowired
    private IMisSupplierProductService misSupplierProductService;

    @Autowired
    private IMisSupplierInfoService misSupplierInfoService;

    @RequiresPermissions("supplier:supplierProducts:view")
    @GetMapping()
    public String supplierProducts() {
        return prefix + "/supplierProducts";
    }

    /**
     * 查询供应商产品列表
     */
    @RequiresPermissions("supplier:supplierProducts:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisSupplierProduct misSupplierProduct) {
        startPage();
        List<MisSupplierProduct> list = misSupplierProductService.selectMisSupplierProductList(misSupplierProduct);
        return getDataTable(list);
    }

    /**
     * 导入供应商产品列表
     */
    @RequiresPermissions("supplier:misSupplierProduct:import")
    @PostMapping("/importData/{supplierId}")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport, @PathVariable("supplierId") String supplierId) throws Exception {
        if ("-1".equals(supplierId) || "-2".equals(supplierId) || "-3".equals(supplierId) || "-4".equals(supplierId) || "-5".equals(supplierId) || "undefined".equals(supplierId)) {
            return AjaxResult.error("导入失败，请选择供应商!");
        } else {
            ExcelUtil<MisSupplierProduct> util = new ExcelUtil<MisSupplierProduct>(MisSupplierProduct.class);
            List<MisSupplierProduct> misSupplierProductList = util.importExcel(file.getInputStream());
            for (MisSupplierProduct msp : misSupplierProductList) {
                msp.setSupplierId(Long.valueOf(supplierId));
            }
            String operName = ShiroUtils.getSysUser().getLoginName();
            String message = misSupplierProductService.importMisSupplierProduct(misSupplierProductList, updateSupport, operName);
            return AjaxResult.success(message);
        }
    }

    /**
     * 导出供应商产品列表
     */
    @RequiresPermissions("supplier:supplierProducts:export")
    @Log(title = "供应商产品" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MisSupplierProduct misSupplierProduct) {
        List<MisSupplierProduct> list = misSupplierProductService.selectMisSupplierProductList(misSupplierProduct);
        ExcelUtil<MisSupplierProduct> util = new ExcelUtil<MisSupplierProduct>(MisSupplierProduct.class);
        return util.exportExcel(list, "supplierProducts");
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
     * 新增保存供应商产品
     */
    @RequiresPermissions("supplier:supplierProducts:add")
    @Log(title = "供应商产品" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MisSupplierProduct misSupplierProduct) {
        return toAjax(misSupplierProductService.insertMisSupplierProduct(misSupplierProduct));
    }

    /**
     * 详情供应商产品
     */
    @GetMapping("/detail/{productId}")
    public String detail(@PathVariable("productId") Long productId, ModelMap mmap) {
        MisSupplierProduct misSupplierProduct = misSupplierProductService.selectMisSupplierProductById(productId);
        mmap.put("misSupplierProduct" , misSupplierProduct);
        return prefix + "/detail";
    }

    /**
     * 供应商产品历史价格列表
     */
    @GetMapping("/historical/{productId}")
    public String historical(@PathVariable("productId") Long productId, ModelMap mmap) {
        MisSupplierProduct misSupplierProduct = misSupplierProductService.selectMisSupplierProductById(productId);
        mmap.put("misSupplierProduct" , misSupplierProduct);
        return prefix + "/historical";
    }


    /**
     * 修改供应商产品
     */
    @GetMapping("/edit/{productId}")
    public String edit(@PathVariable("productId") Long productId, ModelMap mmap) {
        MisSupplierProduct misSupplierProduct = misSupplierProductService.selectMisSupplierProductById(productId);
        mmap.put("misSupplierProduct" , misSupplierProduct);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商产品
     */
    @RequiresPermissions("supplier:supplierProducts:edit")
    @Log(title = "供应商产品" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MisSupplierProduct misSupplierProduct) {
        return toAjax(misSupplierProductService.updateMisSupplierProduct(misSupplierProduct));
    }

    /**
     * 删除供应商产品
     */
    @RequiresPermissions("supplier:supplierProducts:remove")
    @Log(title = "供应商产品" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(misSupplierProductService.deleteMisSupplierProductByIds(ids));
    }

    /**
     * 下载供应商产品模板
     */
    @RequiresPermissions("supplier:supplierProducts:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<MisSupplierProduct> util = new ExcelUtil<MisSupplierProduct>(MisSupplierProduct.class);
        return util.importTemplateExcel("供应商产品数据");
    }

    /**
     * 根据供应商产品ID返回附件列表页面
     */
    @GetMapping("/file/{fatherId}")
    public String selectFile(@PathVariable("fatherId") Long fatherId, ModelMap mmap) {
        //供应商产品对象
        MisSupplierProduct misSupplierProduct = misSupplierProductService.selectMisSupplierProductById(fatherId);
        mmap.put("misSupplierProduct" , misSupplierProduct);
        //返回附件列表页面
        return prefix + "/file";
    }

}
