package com.kastking.historicalPrice.controller;

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
import com.kastking.historicalPrice.domain.MisSupplierHistoricalPrice;
import com.kastking.historicalPrice.service.IMisSupplierHistoricalPriceService;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import com.kastking.framework.util.ShiroUtils;
import com.kastking.common.core.page.TableDataInfo;

/**
 * 供应商产品历史价格Controller
 *
 * @author James
 * @date 2020-02-19
 */
@Controller
@RequestMapping("/supplier/historicalPrice")
public class MisSupplierHistoricalPriceController extends BaseController {
    private String prefix = "supplier/historicalPrice";

    @Autowired
    private IMisSupplierHistoricalPriceService misSupplierHistoricalPriceService;

    @RequiresPermissions("supplier:historicalPrice:view")
    @GetMapping()
    public String historicalPrice() {
        return prefix + "/historicalPrice";
    }

    /**
     * 查询供应商产品历史价格列表
     */
    @RequiresPermissions("supplier:historicalPrice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisSupplierHistoricalPrice misSupplierHistoricalPrice) {
        startPage();
        List<MisSupplierHistoricalPrice> list = misSupplierHistoricalPriceService.selectMisSupplierHistoricalPriceList(misSupplierHistoricalPrice);
        return getDataTable(list);
    }

    /**
     * 查询供应商产品历史价格列表
     */
    @RequiresPermissions("supplier:historicalPrice:list")
    @GetMapping("/lists")
    @ResponseBody
    public TableDataInfo lists(MisSupplierHistoricalPrice misSupplierHistoricalPrice) {
        startPage();
        List<MisSupplierHistoricalPrice> list = misSupplierHistoricalPriceService.selectMisSupplierHistoricalPriceList(misSupplierHistoricalPrice);
        return getDataTable(list);
    }

    /**
     * 导入供应商产品历史价格列表
     */
    @RequiresPermissions("supplier:misSupplierHistoricalPrice:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<MisSupplierHistoricalPrice> util = new ExcelUtil<MisSupplierHistoricalPrice>(MisSupplierHistoricalPrice.class);
        List<MisSupplierHistoricalPrice> misSupplierHistoricalPriceList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = misSupplierHistoricalPriceService.importMisSupplierHistoricalPrice(misSupplierHistoricalPriceList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出供应商产品历史价格列表
     */
    @RequiresPermissions("supplier:historicalPrice:export")
    @Log(title = "供应商产品历史价格" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MisSupplierHistoricalPrice misSupplierHistoricalPrice) {
        List<MisSupplierHistoricalPrice> list = misSupplierHistoricalPriceService.selectMisSupplierHistoricalPriceList(misSupplierHistoricalPrice);
        ExcelUtil<MisSupplierHistoricalPrice> util = new ExcelUtil<MisSupplierHistoricalPrice>(MisSupplierHistoricalPrice.class);
        return util.exportExcel(list, "historicalPrice");
    }

    /**
     * 新增供应商产品历史价格
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存供应商产品历史价格
     */
    @RequiresPermissions("supplier:historicalPrice:add")
    @Log(title = "供应商产品历史价格" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MisSupplierHistoricalPrice misSupplierHistoricalPrice) {
        return toAjax(misSupplierHistoricalPriceService.insertMisSupplierHistoricalPrice(misSupplierHistoricalPrice));
    }

    /**
     * 详情供应商产品历史价格
     */
    @GetMapping("/detail/{priceId}")
    public String detail(@PathVariable("priceId") Long priceId, ModelMap mmap) {
        MisSupplierHistoricalPrice misSupplierHistoricalPrice = misSupplierHistoricalPriceService.selectMisSupplierHistoricalPriceById(priceId);
        mmap.put("misSupplierHistoricalPrice" , misSupplierHistoricalPrice);
        return prefix + "/detail";
    }


    /**
     * 修改供应商产品历史价格
     */
    @GetMapping("/edit/{priceId}")
    public String edit(@PathVariable("priceId") Long priceId, ModelMap mmap) {
        MisSupplierHistoricalPrice misSupplierHistoricalPrice = misSupplierHistoricalPriceService.selectMisSupplierHistoricalPriceById(priceId);
        mmap.put("misSupplierHistoricalPrice" , misSupplierHistoricalPrice);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商产品历史价格
     */
    @RequiresPermissions("supplier:historicalPrice:edit")
    @Log(title = "供应商产品历史价格" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MisSupplierHistoricalPrice misSupplierHistoricalPrice) {
        return toAjax(misSupplierHistoricalPriceService.updateMisSupplierHistoricalPrice(misSupplierHistoricalPrice));
    }

    /**
     * 删除供应商产品历史价格
     */
    @RequiresPermissions("supplier:historicalPrice:remove")
    @Log(title = "供应商产品历史价格" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(misSupplierHistoricalPriceService.deleteMisSupplierHistoricalPriceByIds(ids));
    }

    /**
     * 下载供应商产品历史价格模板
     */
    @RequiresPermissions("supplier:historicalPrice:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<MisSupplierHistoricalPrice> util = new ExcelUtil<MisSupplierHistoricalPrice>(MisSupplierHistoricalPrice.class);
        return util.importTemplateExcel("供应商产品历史价格数据");
    }
}
