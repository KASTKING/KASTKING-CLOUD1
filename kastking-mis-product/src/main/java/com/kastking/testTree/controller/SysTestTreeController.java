package com.kastking.testTree.controller;

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
import com.kastking.testTree.domain.SysTestTree;
import com.kastking.testTree.service.ISysTestTreeService;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.utils.poi.ExcelUtil;
import com.kastking.common.utils.StringUtils;
import com.kastking.common.core.domain.Ztree;

/**
 * 树测试Controller
 *
 * @author Michael
 * @date 2020-01-14
 */
@Controller
@RequestMapping("/testTree/testTree")
public class SysTestTreeController extends BaseController {
    private String prefix = "testTree/testTree";

    @Autowired
    private ISysTestTreeService sysTestTreeService;

    @RequiresPermissions("testTree:testTree:view")
    @GetMapping()
    public String testTree() {
        return prefix + "/testTree";
    }

    /**
     * 查询树测试树列表
     */
    @RequiresPermissions("testTree:testTree:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysTestTree> list(SysTestTree sysTestTree) {
        List<SysTestTree> list = sysTestTreeService.selectSysTestTreeList(sysTestTree);
        return list;
    }

    /**
     * 导出树测试列表
     */
    @RequiresPermissions("testTree:testTree:export")
    @Log(title = "树测试" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysTestTree sysTestTree) {
        List<SysTestTree> list = sysTestTreeService.selectSysTestTreeList(sysTestTree);
        ExcelUtil<SysTestTree> util = new ExcelUtil<SysTestTree>(SysTestTree.class);
        return util.exportExcel(list, "testTree");
    }

    /**
     * 新增树测试
     */
    @GetMapping(value = {"/add/{treeId}" , "/add/"})
    public String add(@PathVariable(value = "treeId" , required = false) Long treeId, ModelMap mmap) {
        if (StringUtils.isNotNull(treeId)) {
            mmap.put("sysTestTree" , sysTestTreeService.selectSysTestTreeById(treeId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存树测试
     */
    @RequiresPermissions("testTree:testTree:add")
    @Log(title = "树测试" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysTestTree sysTestTree) {
        return toAjax(sysTestTreeService.insertSysTestTree(sysTestTree));
    }

    /**
     * 修改树测试
     */
    @GetMapping("/edit/{treeId}")
    public String edit(@PathVariable("treeId") Long treeId, ModelMap mmap) {
        SysTestTree sysTestTree = sysTestTreeService.selectSysTestTreeById(treeId);
        if (StringUtils.isNotNull(sysTestTree) && 1L == treeId) {
            sysTestTree.setTreeName("无");
        }
        mmap.put("sysTestTree" , sysTestTree);
        return prefix + "/edit";
    }

    /**
     * 修改保存树测试
     */
    @RequiresPermissions("testTree:testTree:edit")
    @Log(title = "树测试" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysTestTree sysTestTree) {
        return toAjax(sysTestTreeService.updateSysTestTree(sysTestTree));
    }

    /**
     * 删除
     */
    @RequiresPermissions("testTree:testTree:remove")
    @Log(title = "树测试" , businessType = BusinessType.DELETE)
    @GetMapping("/remove/{treeId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("treeId") Long treeId) {
        return toAjax(sysTestTreeService.deleteSysTestTreeById(treeId));
    }

    /**
     * 选择树测试树
     */
    @GetMapping(value = {"/selectTestTreeTree/{treeId}" , "/selectTestTreeTree/"})
    public String selectTestTreeTree(@PathVariable(value = "treeId" , required = false) Long treeId, ModelMap mmap) {
        if (StringUtils.isNotNull(treeId)) {
            mmap.put("sysTestTree" , sysTestTreeService.selectSysTestTreeById(treeId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载树测试树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData() {
        List<Ztree> ztrees = sysTestTreeService.selectSysTestTreeTree();
        return ztrees;
    }
}
