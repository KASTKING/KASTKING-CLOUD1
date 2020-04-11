package com.kastking.productLevel.controller;

import java.util.List;

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
import com.kastking.productLevel.domain.ProductLevel;
import com.kastking.productLevel.service.IProductLevelService;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import com.kastking.framework.util.ShiroUtils;
import com.kastking.common.core.page.TableDataInfo;

/**
 * 产品层级Controller
 *
 * @author Michael
 * @date 2020-02-15
 */
@Controller
@RequestMapping("/salesForecast/productLevel")
public class ProductLevelController extends BaseController {
    private String prefix = "salesForecast/productLevel";

    @Autowired
    private IProductLevelService productLevelService;

    @RequiresPermissions("salesForecast:productLevel:view")
    @GetMapping()
    public String productLevel() {
        return prefix + "/productLevel";
    }

    /**
     * 查询产品层级列表
     */
    @RequiresPermissions("salesForecast:productLevel:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProductLevel productLevel) {
        startPage();
        List<ProductLevel> list = productLevelService.selectProductLevelList(productLevel);
        return getDataTable(list);
    }

    /**
     * 导入产品层级列表
     */
    @RequiresPermissions("salesForecast:productLevel:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<ProductLevel> util = new ExcelUtil<ProductLevel>(ProductLevel.class);
        List<ProductLevel> productLevelList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = productLevelService.importProductLevel(productLevelList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出产品层级列表
     */
    @RequiresPermissions("salesForecast:productLevel:export")
    @Log(title = "产品层级" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductLevel productLevel) {
        List<ProductLevel> list = productLevelService.selectProductLevelList(productLevel);
        ExcelUtil<ProductLevel> util = new ExcelUtil<ProductLevel>(ProductLevel.class);
        return util.exportExcel(list, "productLevel");
    }

    /**
     * 新增产品层级
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存产品层级
     */
    @RequiresPermissions("salesForecast:productLevel:add")
    @Log(title = "产品层级" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProductLevel productLevel) {
        return toAjax(productLevelService.insertProductLevel(productLevel));
    }

    /**
     * 详情产品层级
     */
    @GetMapping("/detail/{productLevelId}")
    public String detail(@PathVariable("productLevelId") Long productLevelId, ModelMap mmap) {
        ProductLevel productLevel = productLevelService.selectProductLevelById(productLevelId);
        mmap.put("productLevel" , productLevel);
        return prefix + "/detail";
    }


    /**
     * 修改产品层级
     */
    @GetMapping("/edit/{productLevelId}")
    public String edit(@PathVariable("productLevelId") Long productLevelId, ModelMap mmap) {
        ProductLevel productLevel = productLevelService.selectProductLevelById(productLevelId);
        mmap.put("productLevel" , productLevel);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品层级
     */
    @RequiresPermissions("salesForecast:productLevel:edit")
    @Log(title = "产品层级" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProductLevel productLevel) {
        return toAjax(productLevelService.updateProductLevel(productLevel));
    }

    /**
     * 删除产品层级
     */
    @RequiresPermissions("salesForecast:productLevel:remove")
    @Log(title = "产品层级" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(productLevelService.deleteProductLevelByIds(ids));
    }

    /**
     * 下载产品层级模板
     */
    @RequiresPermissions("salesForecast:productLevel:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<ProductLevel> util = new ExcelUtil<ProductLevel>(ProductLevel.class);
        return util.importTemplateExcel("产品层级数据");
    }
}
