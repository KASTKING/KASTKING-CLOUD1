package com.kastking.supplierfile.mapper;

import com.kastking.supplierfile.domain.MisSupplierFile;

import java.util.List;

/**
 * 供应商凭证Mapper接口
 *
 * @author James
 * @date 2020-02-26
 */
public interface MisSupplierFileMapper {
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
     * 删除供应商凭证
     *
     * @param certificateId 供应商凭证ID
     * @return 结果
     */
    public int deleteMisSupplierFileById(Long certificateId);

    /**
     * 批量删除供应商凭证
     *
     * @param certificateIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMisSupplierFileByIds(String[] certificateIds);
}
