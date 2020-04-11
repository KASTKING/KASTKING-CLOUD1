package com.kastking.test.core;

import com.alibaba.fastjson.JSONObject;
import com.kastking.common.annotation.Log;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.core.page.TableDataInfo;
import com.kastking.common.enums.BusinessType;
import com.kastking.common.json.JSON;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@FeignClient(value = "TEST-SERVER")
public interface SysTestHttp {

    @RequestMapping(value = "api/testHttp/aa",method = RequestMethod.GET)
    String test(@RequestParam("str") String str, @RequestParam("name") String name);


    /**
     * 查询测试列表
     */
    @PostMapping("/test/testHttp/list")
    public TableDataInfo list(@RequestParam("json") String json);

    /**
     * 导入测试列表 produces="multipart/form-data"
     */
    @PostMapping(value = "/test/testHttp/importData",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public AjaxResult importData(@RequestPart("file")MultipartFile file,@RequestParam("updateSupport") boolean updateSupport);

    /**
     * 导出测试列表
     */
    @Log(title = "测试" , businessType = BusinessType.EXPORT)
    @PostMapping("/test/testHttp/export")
    @ResponseBody
    public AjaxResult export(@RequestParam("json") String json);

    /**
     * 新增保存测试
     */
    @Log(title = "测试" , businessType = BusinessType.INSERT)
    @PostMapping("/test/testHttp/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("json") String json);

    /**
     * 详情测试
     */
    @GetMapping("/test/testHttp/detail")
    public JSONObject detail(@RequestParam("id") Long id);

    /**
     * 修改保存测试
     */
    @Log(title = "测试" , businessType = BusinessType.UPDATE)
    @PostMapping("/test/testHttp/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestParam("json") String json);

    /**
     * 删除测试
     */
    @Log(title = "测试" , businessType = BusinessType.DELETE)
    @PostMapping("/test/testHttp/remove")
    @ResponseBody
    public AjaxResult remove(@RequestParam("ids")String ids);

    /**
     * 下载测试模板
     */
    @GetMapping("/test/testHttp/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate();
}
