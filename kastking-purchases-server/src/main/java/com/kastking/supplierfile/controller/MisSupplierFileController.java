package com.kastking.supplierfile.controller;

import java.util.List;
import java.util.Map;

import com.kastking.common.config.Global;
import com.kastking.common.utils.file.FileUploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.kastking.common.annotation.Log;
import com.kastking.common.enums.BusinessType;
import com.kastking.supplierfile.domain.MisSupplierFile;
import com.kastking.supplierfile.service.IMisSupplierFileService;
import com.kastking.common.core.controller.BaseController;
import com.kastking.common.core.domain.AjaxResult;
import com.kastking.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import com.kastking.framework.util.ShiroUtils;
import com.kastking.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * 供应商凭证Controller
 *
 * @author James
 * @date 2020-02-26
 */
@Controller
@RequestMapping("/supplier/supplierFile")
public class MisSupplierFileController extends BaseController {
    private String prefix = "supplier/supplierFile";

    @Autowired
    private IMisSupplierFileService misSupplierFileService;

    @RequiresPermissions("supplier:supplierFile:view")
    @GetMapping()
    public String supplierFile() {
        return prefix + "/supplierFile";
    }

    /**
     * 查询供应商凭证列表
     */
    @RequiresPermissions("supplier:supplierFile:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisSupplierFile misSupplierFile) {
        startPage();
        List<MisSupplierFile> list = misSupplierFileService.selectMisSupplierFileList(misSupplierFile);
        return getDataTable(list);
    }

    /**
     * 导入供应商凭证列表
     */
    @RequiresPermissions("supplier:misSupplierFile:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<MisSupplierFile> util = new ExcelUtil<MisSupplierFile>(MisSupplierFile.class);
        List<MisSupplierFile> misSupplierFileList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = misSupplierFileService.importMisSupplierFile(misSupplierFileList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 导出供应商凭证列表
     */
    @RequiresPermissions("supplier:supplierFile:export")
    @Log(title = "供应商凭证" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MisSupplierFile misSupplierFile) {
        List<MisSupplierFile> list = misSupplierFileService.selectMisSupplierFileList(misSupplierFile);
        ExcelUtil<MisSupplierFile> util = new ExcelUtil<MisSupplierFile>(MisSupplierFile.class);
        return util.exportExcel(list, "supplierFile");
    }

    /**
     * 新增供应商凭证
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存供应商凭证
     */
    @RequiresPermissions("supplier:supplierFile:add")
    @Log(title = "供应商凭证" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MisSupplierFile misSupplierFile) {
        return toAjax(misSupplierFileService.insertMisSupplierFile(misSupplierFile));
    }

    /**
     * 新增保存供应商凭证
     */
    @RequiresPermissions("supplier:supplierFile:add")
    @Log(title = "供应商凭证" , businessType = BusinessType.INSERT)
    @PostMapping("/adds")
    @ResponseBody
    public AjaxResult addSave(HttpServletRequest request, MisSupplierFile misSupplierFile) {
        try {
            MultipartHttpServletRequest mureq = (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> files = mureq.getFileMap();
            MultipartFile file = null;
            if (files == null && files.size() == 0) {
                return error();
            }
            if (files != null && files.size() > 0) {
                //文件对象
                Map.Entry<String, MultipartFile> f = files.entrySet().iterator().next();
                file = f.getValue();
            }
            //接收工具随机生成的文件路径
            String avatar = FileUploadUtils.upload(Global.getAvatarPath(), file);
            //实体接收http请求的文件名
            misSupplierFile.setCaption(file.getOriginalFilename());
            //截取文件路径后缀
            String lastStr = avatar.substring(avatar.lastIndexOf(".") + 1);
            if ("bmp".equals(lastStr) || "jpg".equals(lastStr) || "png".equals(lastStr) || "tif".equals(lastStr) || "gif".equals(lastStr) || "pcx".equals(lastStr)) {
                misSupplierFile.setTypes("image");
            } else if ("pdf".equals(lastStr)) {
                misSupplierFile.setTypes("pdf");
            } else {
                misSupplierFile.setTypes("object");
            }
            //文件大小
            misSupplierFile.setSize(Double.valueOf(file.getSize()));
            //文件访问路径
            misSupplierFile.setAnnex(avatar);
            return toAjax(misSupplierFileService.insertMisSupplierFile(misSupplierFile));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 详情供应商凭证
     */
    @GetMapping("/detail/{certificateId}")
    public String detail(@PathVariable("certificateId") Long certificateId, ModelMap mmap) {
        MisSupplierFile misSupplierFile = misSupplierFileService.selectMisSupplierFileById(certificateId);
        mmap.put("misSupplierFile" , misSupplierFile);
        return prefix + "/detail";
    }

    /**
     * 修改供应商凭证
     */
    @GetMapping("/edit/{certificateId}")
    public String edit(@PathVariable("certificateId") Long certificateId, ModelMap mmap) {
        MisSupplierFile misSupplierFile = misSupplierFileService.selectMisSupplierFileById(certificateId);
        mmap.put("misSupplierFile" , misSupplierFile);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商凭证
     */
    @RequiresPermissions("supplier:supplierFile:edit")
    @Log(title = "供应商凭证" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MisSupplierFile misSupplierFile) {
        return toAjax(misSupplierFileService.updateMisSupplierFile(misSupplierFile));
    }

    /**
     * 删除供应商凭证
     */
    @PostMapping("/del/{certificateId}")
    @ResponseBody
    public AjaxResult del(HttpServletRequest request, @PathVariable("certificateId") Long certificateId) {
        return toAjax(misSupplierFileService.deleteMisSupplierFileByIds(certificateId.toString()));
    }

    /**
     * 删除供应商凭证
     */
    @RequiresPermissions("supplier:supplierFile:remove")
    @Log(title = "供应商凭证" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(misSupplierFileService.deleteMisSupplierFileByIds(ids));
    }


    /**
     * 下载供应商凭证模板
     */
    @RequiresPermissions("supplier:supplierFile:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<MisSupplierFile> util = new ExcelUtil<MisSupplierFile>(MisSupplierFile.class);
        return util.importTemplateExcel("供应商凭证数据");
    }
}
