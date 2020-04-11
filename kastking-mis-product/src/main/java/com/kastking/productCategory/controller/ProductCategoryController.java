package com.kastking.productCategory.controller;

import java.util.List;

import com.kastking.productCategory.domain.ProductCategory;
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
import com.kastking.productCategory.service.ProductCategoryService;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.utils.poi.ExcelUtil;
import com.kastking.common.utils.StringUtils;
import com.kastking.common.core.domain.Ztree;

/**
 * 产品类目Controller
 *
 * @author Michael
 * @date 2020-01-16
 */
@Controller
@RequestMapping("/product/productCategory")
public class ProductCategoryController extends BaseController {
    private String prefix = "product/productCategory";

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequiresPermissions("product:productCategory:view")
    @GetMapping()
    public String productCategory() {
        return prefix + "/productCategory";
    }

    /**
     * 查询产品类目树列表
     */
    @RequiresPermissions("product:productCategory:list")
    @PostMapping("/list")
    @ResponseBody
    public List<ProductCategory> list(ProductCategory productCategory) {
        List<ProductCategory> list = productCategoryService.selectProductCategoryList(productCategory);
        return list;
    }

    /**
     * 导出产品类目列表
     */
    @RequiresPermissions("product:productCategory:export")
    @Log(title = "产品类目" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductCategory productCategory) {
        List<ProductCategory> list = productCategoryService.selectProductCategoryList(productCategory);
        ExcelUtil<ProductCategory> util = new ExcelUtil<ProductCategory>(ProductCategory.class);
        return util.exportExcel(list, "productCategory");
    }

    /**
     * 新增产品类目
     */
    @GetMapping(value = {"/add/{categoryId}" , "/add/"})
    public String add(@PathVariable(value = "categoryId" , required = false) Long categoryId, ModelMap mmap) {
        if (StringUtils.isNotNull(categoryId)) {
            mmap.put("productCategory" , productCategoryService.selectProductCategoryById(categoryId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存产品类目
     */
    @RequiresPermissions("product:productCategory:add")
    @Log(title = "产品类目" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProductCategory productCategory) {
        return toAjax(productCategoryService.insertProductCategory(productCategory));
    }

    /**
     * 修改产品类目
     */
    @GetMapping("/edit/{categoryId}")
    public String edit(@PathVariable("categoryId") Long categoryId, ModelMap mmap) {
        ProductCategory productCategory = productCategoryService.selectProductCategoryById(categoryId);
        mmap.put("productCategory" , productCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品类目
     */
    @RequiresPermissions("product:productCategory:edit")
    @Log(title = "产品类目" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProductCategory productCategory) {
        return toAjax(productCategoryService.updateProductCategory(productCategory));
    }

    /**
     * 删除
     */
    @RequiresPermissions("product:productCategory:remove")
    @Log(title = "产品类目" , businessType = BusinessType.DELETE)
    @GetMapping("/remove/{categoryId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("categoryId") Long categoryId) {
        int i = productCategoryService.deleteProductCategoryById(categoryId);
        if (i == -1)
            return AjaxResult.warn("该类目下存在子类目,不可删除!");
        return toAjax(i);
    }

    /**
     * 选择产品类目树
     */
    @GetMapping(value = {"/selectProductCategoryTree/{categoryId}" , "/selectProductCategoryTree/"})
    public String selectProductCategoryTree(@PathVariable(value = "categoryId" , required = false) Long categoryId, ModelMap mmap) {
        if (StringUtils.isNotNull(categoryId)) {
            mmap.put("productCategory" , productCategoryService.selectProductCategoryById(categoryId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载产品类目树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData() {
        List<Ztree> ztrees = productCategoryService.selectProductCategoryTree();
        return ztrees;
    }
}
