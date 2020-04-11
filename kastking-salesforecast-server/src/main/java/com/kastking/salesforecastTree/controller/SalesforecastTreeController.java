package com.kastking.salesforecastTree.controller;

import java.util.List;

import com.kastking.salesforecastTree.service.ISalesforecastTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.Ztree;

/**
 * 销量预计数菜单Controller
 *
 * @author Michael
 * @date 2020-02-18
 */
@Controller
@RequestMapping("/salesforecast/salesforecastTree")
public class SalesforecastTreeController extends BaseController {
    private String prefix = "salesforecast/salesforecastTree";

    @Autowired
    private ISalesforecastTreeService salesforecastTreeService;

//    @RequiresPermissions("salesforecast:salesforecastTree:view")
//    @GetMapping()
//    public String salesforecastTree()
//    {
//        return prefix + "/salesforecastTree";
//    }
//
//    /**
//     * 查询销量预计数菜单树列表
//     */
//    @RequiresPermissions("salesforecast:salesforecastTree:list")
//    @PostMapping("/list")
//    @ResponseBody
//    public List<SalesforecastTree> list(SalesforecastTree salesforecastTree)
//    {
//        List<SalesforecastTree> list = salesforecastTreeService.selectSalesforecastTreeList(salesforecastTree);
//        return list;
//    }
//
//
//    /**
//     * 选择销量预计数菜单树
//     */
//    @GetMapping(value = { "/selectSalesforecastTreeTree/{treeId}", "/selectSalesforecastTreeTree/" })
//    public String selectSalesforecastTreeTree(@PathVariable(value = "treeId", required = false) Long treeId, ModelMap mmap)
//    {
//        if (StringUtils.isNotNull(treeId))
//        {
//            mmap.put("salesforecastTree", salesforecastTreeService.selectSalesforecastTreeById(treeId));
//        }
//        return prefix + "/tree";
//    }

    /**
     * 加载销量预计数菜单树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData() {
        List<Ztree> ztrees = salesforecastTreeService.selectSalesforecastTreeTree();
        return ztrees;
    }
}
