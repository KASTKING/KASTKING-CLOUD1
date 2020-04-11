package com.kastking.salesForecastMom.controller;

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
import com.kastking.salesForecastMom.domain.SalesforecastMom;
import com.kastking.salesForecastMom.service.ISalesforecastMomService;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import com.kastking.framework.util.ShiroUtils;
import com.kastking.common.core.page.TableDataInfo;

/**
 * 销量预计MOMController
 *
 * @author Michael
 * @date 2020-02-14
 */
@Controller
@RequestMapping("/salesForecast/salesForecastMom")
public class SalesforecastMomController extends BaseController {
    private String prefix = "salesForecast/salesForecastMom";

    @Autowired
    private ISalesforecastMomService salesforecastMomService;

    @RequiresPermissions("salesForecast:salesForecastMom:view")
    @GetMapping()
    public String salesForecastMom() {
        return prefix + "/salesForecastMom";
    }

    /**
     * 查询销量预计MOM列表
     */
    @RequiresPermissions("salesForecast:salesForecastMom:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SalesforecastMom salesforecastMom) {
        startPage();
        List<SalesforecastMom> list = salesforecastMomService.selectSalesforecastMomList(salesforecastMom);
        return getDataTable(list);
    }

    /**
     * 导入销量预计MOM列表
     */
    @RequiresPermissions("salesForecast:salesforecastMom:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<SalesforecastMom> util = new ExcelUtil<SalesforecastMom>(SalesforecastMom.class);
        List<SalesforecastMom> salesforecastMomList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = salesforecastMomService.importSalesforecastMom(salesforecastMomList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出销量预计MOM列表
     */
    @RequiresPermissions("salesForecast:salesForecastMom:export")
    @Log(title = "销量预计MOM" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SalesforecastMom salesforecastMom) {
        List<SalesforecastMom> list = salesforecastMomService.selectSalesforecastMomList(salesforecastMom);
        ExcelUtil<SalesforecastMom> util = new ExcelUtil<SalesforecastMom>(SalesforecastMom.class);
        return util.exportExcel(list, "salesForecastMom");
    }

    /**
     * 新增销量预计MOM
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存销量预计MOM
     */
    @RequiresPermissions("salesForecast:salesForecastMom:add")
    @Log(title = "销量预计MOM" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SalesforecastMom salesforecastMom) {
        return toAjax(salesforecastMomService.insertSalesforecastMom(salesforecastMom));
    }

    /**
     * 详情销量预计MOM
     */
    @GetMapping("/detail/{salesforecastMomId}")
    public String detail(@PathVariable("salesforecastMomId") Long salesforecastMomId, ModelMap mmap) {
        SalesforecastMom salesforecastMom = salesforecastMomService.selectSalesforecastMomById(salesforecastMomId);
        mmap.put("salesforecastMom" , salesforecastMom);
        return prefix + "/detail";
    }


    /**
     * 修改销量预计MOM
     */
    @GetMapping("/edit/{salesforecastMomId}")
    public String edit(@PathVariable("salesforecastMomId") Long salesforecastMomId, ModelMap mmap) {
        SalesforecastMom salesforecastMom = salesforecastMomService.selectSalesforecastMomById(salesforecastMomId);
        mmap.put("salesforecastMom" , salesforecastMom);
        return prefix + "/edit";
    }

    /**
     * 修改保存销量预计MOM
     */
    @RequiresPermissions("salesForecast:salesForecastMom:edit")
    @Log(title = "销量预计MOM" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SalesforecastMom salesforecastMom) {
        return toAjax(salesforecastMomService.updateSalesforecastMom(salesforecastMom));
    }

    /**
     * 删除销量预计MOM
     */
    @RequiresPermissions("salesForecast:salesForecastMom:remove")
    @Log(title = "销量预计MOM" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(salesforecastMomService.deleteSalesforecastMomByIds(ids));
    }

    /**
     * 下载销量预计MOM模板
     */
    @RequiresPermissions("salesForecast:salesForecastMom:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<SalesforecastMom> util = new ExcelUtil<SalesforecastMom>(SalesforecastMom.class);
        return util.importTemplateExcel("销量预计MOM数据");
    }
}
