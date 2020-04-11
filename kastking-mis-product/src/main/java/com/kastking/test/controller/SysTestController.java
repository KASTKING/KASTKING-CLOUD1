package com.kastking.test.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.kastking.common.json.JSON;
import com.kastking.common.json.MapToJSONString;
import com.kastking.test.core.SysTestHttp;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.kastking.common.annotation.Log;
import com.kastking.common.enums.BusinessType;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;
import com.kastking.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试Controller
 *
 * @author Michael
 * @date 2020-01-19
 */
@Controller
@RequestMapping("/test/test")
public class SysTestController extends BaseController {
    private String prefix = "test/test";

    @Autowired
    private SysTestHttp sysTestHttp;

    @RequiresPermissions("test:test:view")
    @GetMapping()
    public String test() {
        return prefix + "/test";
    }


    @RequestMapping(value = "/aa",method = RequestMethod.GET)
    String test(@RequestParam("str") String str, @RequestParam("name") String name){
        return sysTestHttp.test(str,name);
    }

    /**
     * 查询测试列表
     */
    @RequiresPermissions("test:test:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HttpServletRequest request) {
        return sysTestHttp.list(MapToJSONString.toJSONString(request.getParameterMap()));
    }

    /**
     * 导入测试列表
     */
    @RequiresPermissions("test:sysTest:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) {
        return sysTestHttp.importData(file,updateSupport);
    }

    /**
     * 导出测试列表
     */
    @RequiresPermissions("test:test:export")
    @Log(title = "测试" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HttpServletRequest request) {
        return sysTestHttp.export(MapToJSONString.toJSONString(request.getParameterMap()));
    }

    /**
     * 新增测试
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存测试
     */
    @RequiresPermissions("test:test:add")
    @Log(title = "测试" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HttpServletRequest request) {
        return sysTestHttp.addSave(MapToJSONString.toJSONString(request.getParameterMap()));
    }

    /**
     * 详情测试
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("sysTest" , sysTestHttp.detail(id));
        return prefix + "/detail";
    }


    /**
     * 修改测试
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("sysTest" , sysTestHttp.detail(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存测试
     */
    @RequiresPermissions("test:test:edit")
    @Log(title = "测试" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HttpServletRequest request) {
        return sysTestHttp.editSave(MapToJSONString.toJSONString(request.getParameterMap()));
    }

    /**
     * 删除测试
     */
    @RequiresPermissions("test:test:remove")
    @Log(title = "测试" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return sysTestHttp.remove(ids);
    }

    /**
     * 下载测试模板
     */
    @RequiresPermissions("test:test:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        return sysTestHttp.importTemplate();
    }
}
