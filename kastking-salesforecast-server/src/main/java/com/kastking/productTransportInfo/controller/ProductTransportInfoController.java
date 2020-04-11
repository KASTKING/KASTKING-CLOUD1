package com.kastking.productTransportInfo.controller;

import java.util.HashMap;
import java.util.List;

import com.kastking.productTransportInfo.domain.ProductTransportInfo;
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
import com.kastking.productTransportInfo.service.ProductTransportInfoService;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import com.kastking.framework.util.ShiroUtils;
import com.kastking.common.core.page.TableDataInfo;

/**
 * 商品运输属性Controller
 *
 * @author Michael
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/salesForecast/productTransportInfo")
public class ProductTransportInfoController extends BaseController {
    private String prefix = "salesForecast/productTransportInfo";

    @Autowired
    private ProductTransportInfoService productTransportInfoService;

    @RequiresPermissions("salesForecast:productTransportInfo:view")
    @GetMapping()
    public String productTransportInfo() {
        return prefix + "/productTransportInfo";
    }

    /**
     * 查询商品运输属性列表
     */
    @RequiresPermissions("salesForecast:productTransportInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProductTransportInfo productTransportInfo) {
        startPage();
        List<ProductTransportInfo> list = productTransportInfoService.selectProductTransportInfoList(productTransportInfo);
        return getDataTable(list);
    }

    /**
     * 导入商品运输属性列表
     */
    @RequiresPermissions("salesForecast:productTransportInfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<ProductTransportInfo> util = new ExcelUtil<ProductTransportInfo>(ProductTransportInfo.class);
        List<ProductTransportInfo> productTransportInfoList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = productTransportInfoService.importProductTransportInfo(productTransportInfoList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出商品运输属性列表
     */
    @RequiresPermissions("salesForecast:productTransportInfo:export")
    @Log(title = "商品运输属性" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductTransportInfo productTransportInfo) {
        List<ProductTransportInfo> list = productTransportInfoService.selectProductTransportInfoList(productTransportInfo);
        ExcelUtil<ProductTransportInfo> util = new ExcelUtil<ProductTransportInfo>(ProductTransportInfo.class);
        return util.exportExcel(list, "productTransportInfo");
    }

    /**
     * 新增商品运输属性
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存商品运输属性
     */
    @RequiresPermissions("salesForecast:productTransportInfo:add")
    @Log(title = "商品运输属性" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProductTransportInfo productTransportInfo) {
        HashMap hashMap = productTransportInfoService.insertProductTransportInfo(productTransportInfo);
        if (Boolean.valueOf(hashMap.get("success").toString())) {
            return success(hashMap.get("message").toString());
        } else {
            return error(hashMap.get("message").toString());
        }
    }

    /**
     * 详情商品运输属性
     */
    @GetMapping("/detail/{transportInfoId}")
    public String detail(@PathVariable("transportInfoId") Long transportInfoId, ModelMap mmap) {
        ProductTransportInfo productTransportInfo = productTransportInfoService.selectProductTransportInfoById(transportInfoId);
        mmap.put("productTransportInfo" , productTransportInfo);
        return prefix + "/detail";
    }


    /**
     * 修改商品运输属性
     */
    @GetMapping("/edit/{transportInfoId}")
    public String edit(@PathVariable("transportInfoId") Long transportInfoId, ModelMap mmap) {
        ProductTransportInfo productTransportInfo = productTransportInfoService.selectProductTransportInfoById(transportInfoId);
        mmap.put("productTransportInfo" , productTransportInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品运输属性
     */
    @RequiresPermissions("salesForecast:productTransportInfo:edit")
    @Log(title = "商品运输属性" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProductTransportInfo productTransportInfo) {
        return toAjax(productTransportInfoService.updateProductTransportInfo(productTransportInfo));
    }

    /**
     * 删除商品运输属性
     */
    @RequiresPermissions("salesForecast:productTransportInfo:remove")
    @Log(title = "商品运输属性" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(productTransportInfoService.deleteProductTransportInfoByIds(ids));
    }

    /**
     * 下载商品运输属性模板
     */
    @RequiresPermissions("salesForecast:productTransportInfo:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<ProductTransportInfo> util = new ExcelUtil<ProductTransportInfo>(ProductTransportInfo.class);
        return util.importTemplateExcel("商品运输属性数据");
    }
}
