package com.kastking.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.kastking.common.annotation.Log;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.core.page.TableDataInfo;
import com.kastking.common.enums.BusinessType;
import com.kastking.common.utils.poi.ExcelUtil;
import com.kastking.test.domain.SysTest;
import com.kastking.test.service.ISysTestService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 测试Controller
 *
 * @author Michael
 * @date 2020-01-19
 */
@Controller
@RequestMapping("/test/testHttp")
public class SysTestController extends BaseController {
    private String prefix = "test/test";

    @Autowired
    private ISysTestService sysTestService;


    @RequestMapping(value = "/aa",method = RequestMethod.GET)
    String test(@RequestParam("str") String str, @RequestParam("name") String name){
        return "*************"+str+"***************"+name+"****";
    }

    /**
     * 查询测试列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(String json) {
        SysTest sysTest = JSONObject.parseObject(json, SysTest.class);
        startPageJSON(json);
        List<SysTest> list = sysTestService.selectSysTestList(sysTest);
//        Map map = new HashMap();
//        Map<String,String[]> maps= request.getParameterMap();
//        System.out.println(maps);
//        System.out.println(maps.size());
//        System.out.println(maps.get("name"));
//        for(int i =0;i<maps.size();i++){
//
//        }
//        Enumeration<String> names2 = request.getParameterNames();
//        while (names2.hasMoreElements()){
//            map.put(names2.nextElement(),request.getParameter(names2.nextElement()));
//        }
//        System.out.println(request.getParameterMap());
        return getDataTable(list);
    }

    /**
     * 导入测试列表
     */
    @PostMapping(value = "/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file,boolean updateSupport) throws Exception {
        ExcelUtil<SysTest> util = new ExcelUtil<SysTest>(SysTest.class);
        List<SysTest> sysTestList = util.importExcel(file.getInputStream());
//        String operName = ShiroUtils.getSysUser().getLoginName();
        String operName = "Michael";
        String message = sysTestService.importSysTest(sysTestList, false, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出测试列表
     */
    @Log(title = "测试" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(String json) {
        SysTest sysTest = JSONObject.parseObject(json, SysTest.class);
        List<SysTest> list = sysTestService.selectSysTestList(sysTest);
        ExcelUtil<SysTest> util = new ExcelUtil<SysTest>(SysTest.class);
        return util.exportExcel(list, "test");
    }


    /**
     * 新增保存测试
     */
    @Log(title = "测试" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(String json) {
        SysTest sysTest = JSONObject.parseObject(json, SysTest.class);
        return toAjax(sysTestService.insertSysTest(sysTest));
    }

    /**
     * 详情测试
     */
    @GetMapping("/detail")
    @ResponseBody
    public SysTest detail(Long id) {
        SysTest sysTest = sysTestService.selectSysTestById(id);
        return sysTest;
    }


    /**
     * 修改保存测试
     */
    @RequiresPermissions("test:test:edit")
    @Log(title = "测试" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(String json) {
        SysTest sysTest = JSONObject.parseObject(json, SysTest.class);
        return toAjax(sysTestService.updateSysTest(sysTest));
    }

    /**
     * 删除测试
     */
    @RequiresPermissions("test:test:remove")
    @Log(title = "测试" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(sysTestService.deleteSysTestByIds(ids));
    }

    /**
     * 下载测试模板
     */
    @RequiresPermissions("test:test:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<SysTest> util = new ExcelUtil<SysTest>(SysTest.class);
        return util.importTemplateExcel("测试数据");
    }
}
