package com.kastking.personProduct.controller;

import java.util.HashMap;
import java.util.List;

import com.kastking.personProduct.domain.PersonProduct;
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
import com.kastking.personProduct.service.IPersonProductService;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import com.kastking.framework.util.ShiroUtils;
import com.kastking.common.core.page.TableDataInfo;

/**
 * 人员产品Controller
 *
 * @author Michael
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/salesForecast/personProduct")
public class PersonProductController extends BaseController {
    private String prefix = "salesForecast/personProduct";

    @Autowired
    private IPersonProductService personProductService;

    @RequiresPermissions("salesForecast:personProduct:view")
    @GetMapping()
    public String personProduct() {
        return prefix + "/personProduct";
    }

    /**
     * 查询人员产品列表
     */
    @RequiresPermissions("salesForecast:personProduct:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PersonProduct personProduct) {
        startPage();
        List<PersonProduct> list = personProductService.selectPersonProductList(personProduct);
        return getDataTable(list);
    }

    /**
     * 导入人员产品列表
     */
    @RequiresPermissions("salesForecast:personProduct:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<PersonProduct> util = new ExcelUtil<PersonProduct>(PersonProduct.class);
        List<PersonProduct> personProductList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = personProductService.importPersonProduct(personProductList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出人员产品列表
     */
    @RequiresPermissions("salesForecast:personProduct:export")
    @Log(title = "人员产品" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PersonProduct personProduct) {
        List<PersonProduct> list = personProductService.selectPersonProductList(personProduct);
        ExcelUtil<PersonProduct> util = new ExcelUtil<PersonProduct>(PersonProduct.class);
        return util.exportExcel(list, "personProduct");
    }

    /**
     * 新增人员产品
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存人员产品
     */
    @RequiresPermissions("salesForecast:personProduct:add")
    @Log(title = "人员产品" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PersonProduct personProduct) {
        HashMap hashMap = personProductService.insertPersonProduct(personProduct);
        if (Boolean.valueOf(hashMap.get("success").toString())) {
            return success(hashMap.get("message").toString());
        } else {
            return error(hashMap.get("message").toString());
        }
    }

    /**
     * 详情人员产品
     */
    @GetMapping("/detail/{personProductId}")
    public String detail(@PathVariable("personProductId") Long personProductId, ModelMap mmap) {
        PersonProduct personProduct = personProductService.selectPersonProductById(personProductId);
        mmap.put("personProduct" , personProduct);
        return prefix + "/detail";
    }


    /**
     * 修改人员产品
     */
    @GetMapping("/edit/{personProductId}")
    public String edit(@PathVariable("personProductId") Long personProductId, ModelMap mmap) {
        PersonProduct personProduct = personProductService.selectPersonProductById(personProductId);
        mmap.put("personProduct" , personProduct);
        return prefix + "/edit";
    }

    /**
     * 修改保存人员产品
     */
    @RequiresPermissions("salesForecast:personProduct:edit")
    @Log(title = "人员产品" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PersonProduct personProduct) {
        return toAjax(personProductService.updatePersonProduct(personProduct));
    }

    /**
     * 删除人员产品
     */
    @RequiresPermissions("salesForecast:personProduct:remove")
    @Log(title = "人员产品" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(personProductService.deletePersonProductByIds(ids));
    }

    /**
     * 下载人员产品模板
     */
    @RequiresPermissions("salesForecast:personProduct:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<PersonProduct> util = new ExcelUtil<PersonProduct>(PersonProduct.class);
        return util.importTemplateExcel("人员产品数据");
    }
}
