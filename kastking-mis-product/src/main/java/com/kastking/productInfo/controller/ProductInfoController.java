package com.kastking.productInfo.controller;

import java.util.List;

import com.kastking.productInfo.domain.ProductInfo;
import com.kastking.productInfo.service.ProductInfoService;
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
 * 产品信息Controller
 *
 * @author Michael
 * @date 2020-01-18
 */
@Controller
@RequestMapping("/product/productInfo")
public class ProductInfoController extends BaseController {
    private String prefix = "product/productInfo";

    @Autowired
    private ProductInfoService productInfoService;

    @RequiresPermissions("product:productInfo:view")
    @GetMapping()
    public String productInfo() {
        return prefix + "/productInfo";
    }

    /**
     * 查询产品信息列表
     */
    @RequiresPermissions("product:productInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProductInfo productInfo) {
        startPage();
        List<ProductInfo> list = productInfoService.selectProductInfoList(productInfo);
        return getDataTable(list);
    }

    /**
     * 导入产品信息列表
     */
    @RequiresPermissions("product:productInfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<ProductInfo> util = new ExcelUtil<ProductInfo>(ProductInfo.class);
        List<ProductInfo> productInfoList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = productInfoService.importProductInfo(productInfoList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出产品信息列表
     */
    @RequiresPermissions("product:productInfo:export")
    @Log(title = "产品信息" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductInfo productInfo) {
        List<ProductInfo> list = productInfoService.selectProductInfoList(productInfo);
        ExcelUtil<ProductInfo> util = new ExcelUtil<ProductInfo>(ProductInfo.class);
        return util.exportExcel(list, "productInfo");
    }

    /**
     * 新增产品信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存产品信息
     */
    @RequiresPermissions("product:productInfo:add")
    @Log(title = "产品信息" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProductInfo productInfo) {
        return toAjax(productInfoService.insertProductInfo(productInfo));
    }

    /**
     * 详情产品信息
     */
    @GetMapping("/detail/{productId}")
    public String detail(@PathVariable("productId") Long productId, ModelMap mmap) {
        ProductInfo productInfo = productInfoService.selectProductInfoById(productId);
        mmap.put("productInfo" , productInfo);
        return prefix + "/detail";
    }


    /**
     * 修改产品信息
     */
    @GetMapping("/edit/{productId}")
    public String edit(@PathVariable("productId") Long productId, ModelMap mmap) {
        ProductInfo productInfo = productInfoService.selectProductInfoById(productId);
        mmap.put("productInfo" , productInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品信息
     */
    @RequiresPermissions("product:productInfo:edit")
    @Log(title = "产品信息" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProductInfo productInfo) {
        return toAjax(productInfoService.updateProductInfo(productInfo));
    }

    /**
     * 删除产品信息
     */
    @RequiresPermissions("product:productInfo:remove")
    @Log(title = "产品信息" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(productInfoService.deleteProductInfoByIds(ids));
    }

    /**
     * 下载产品信息模板
     */
    @RequiresPermissions("product:productInfo:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<ProductInfo> util = new ExcelUtil<ProductInfo>(ProductInfo.class);
        return util.importTemplateExcel("产品信息数据");
    }
}
