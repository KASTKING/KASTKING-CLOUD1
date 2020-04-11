package com.kastking.supplierfile.service;

import com.kastking.supplierfile.domain.MisSupplierFile;

import java.util.List;

/**
 * 供应商凭证Service接口
 *
 * @author James
 * @date 2020-02-26
 */
public interface IMisSupplierFileService {
    /**
     * 查询供应商凭证
     *
     * @param certificateId 供应商凭证ID
     * @return 供应商凭证
     */
    public MisSupplierFile selectMisSupplierFileById(Long certificateId);

    /**
     * 查询供应商凭证列表
     *
     * @param misSupplierFile 供应商凭证
     * @return 供应商凭证集合
     */
    public List<MisSupplierFile> selectMisSupplierFileList(MisSupplierFile misSupplierFile);

    /**
     * 新增供应商凭证
     *
     * @param misSupplierFile 供应商凭证
     * @return 结果
     */
    public int insertMisSupplierFile(MisSupplierFile misSupplierFile);

    /**
     * 修改供应商凭证
     *
     * @param misSupplierFile 供应商凭证
     * @return 结果
     */
    public int updateMisSupplierFile(MisSupplierFile misSupplierFile);

    /**
     * 批量删除供应商凭证
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMisSupplierFileByIds(String ids);

    /**
     * 删除供应商凭证信息
     *
     * @param certificateId 供应商凭证ID
     * @return 结果
     */
    public int deleteMisSupplierFileById(Long certificateId);

    /**
     * 导入供应商凭证数据
     *
     * @param misSupplierFileList 供应商凭证数据列表
     * @param isUpdateSupport     是否更新支持，如果已存在，则进行更新数据
     * @param operName            操作用户
     * @return 结果
     */
    public String importMisSupplierFile(List<MisSupplierFile> misSupplierFileList, Boolean isUpdateSupport, String operName);

}
