package com.kastking.supplierInfo.service;

import com.kastking.supplierInfo.domain.MisSupplierInfo;

import java.util.List;

import com.kastking.common.core.domain.Ztree;

/**
 * 供应商信息Service接口
 *
 * @author James
 * @date 2020-02-07
 */
public interface IMisSupplierInfoService {
    /**
     * 查询供应商信息
     *
     * @param supplierId 供应商信息ID
     * @return 供应商信息
     */
    public MisSupplierInfo selectMisSupplierInfoById(Long supplierId);

    /**
     * 查询供应商信息列表
     *
     * @param misSupplierInfo 供应商信息
     * @return 供应商信息集合
     */
    public List<MisSupplierInfo> selectMisSupplierInfoList(MisSupplierInfo misSupplierInfo);

    /**
     * 新增供应商信息
     *
     * @param misSupplierInfo 供应商信息
     * @return 结果
     */
    public int insertMisSupplierInfo(MisSupplierInfo misSupplierInfo);

    /**
     * 修改供应商信息
     *
     * @param misSupplierInfo 供应商信息
     * @return 结果
     */
    public int updateMisSupplierInfo(MisSupplierInfo misSupplierInfo);

    /**
     * 批量删除供应商信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMisSupplierInfoByIds(String ids);

    /**
     * 删除供应商信息信息
     *
     * @param supplierId 供应商信息ID
     * @return 结果
     */
    public int deleteMisSupplierInfoById(Long supplierId);

    /**
     * 查询供应商信息树列表
     *
     * @return 所有供应商信息信息
     */
    public List<Ztree> selectMisSupplierInfoTree();

    /**
     * 验证供应商唯一
     *
     * @param misSupplierInfo 供应商信息
     * @return 结果
     */
    public Long verificationBuyer(MisSupplierInfo misSupplierInfo);
}
