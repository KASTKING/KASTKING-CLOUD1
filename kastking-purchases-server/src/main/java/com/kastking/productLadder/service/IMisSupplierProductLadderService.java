package com.kastking.productLadder.service;

import com.kastking.productLadder.domain.MisSupplierProductLadder;

import java.util.List;

/**
 * 供应商产品阶梯价Service接口
 *
 * @author James
 * @date 2020-02-14
 */
public interface IMisSupplierProductLadderService {
    /**
     * 查询供应商产品阶梯价
     *
     * @param stepId 供应商产品阶梯价ID
     * @return 供应商产品阶梯价
     */
    public MisSupplierProductLadder selectMisSupplierProductLadderById(Long stepId);

    /**
     * 查询供应商产品阶梯价列表
     *
     * @param misSupplierProductLadder 供应商产品阶梯价
     * @return 供应商产品阶梯价集合
     */
    public List<MisSupplierProductLadder> selectMisSupplierProductLadderList(MisSupplierProductLadder misSupplierProductLadder);

    /**
     * 新增供应商产品阶梯价
     *
     * @param misSupplierProductLadder 供应商产品阶梯价
     * @return 结果
     */
    public int insertMisSupplierProductLadder(MisSupplierProductLadder misSupplierProductLadder);

    /**
     * 修改供应商产品阶梯价
     *
     * @param misSupplierProductLadder 供应商产品阶梯价
     * @return 结果
     */
    public int updateMisSupplierProductLadder(MisSupplierProductLadder misSupplierProductLadder);

    /**
     * 批量删除供应商产品阶梯价
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMisSupplierProductLadderByIds(String ids);

    /**
     * 删除供应商产品阶梯价信息
     *
     * @param stepId 供应商产品阶梯价ID
     * @return 结果
     */
    public int deleteMisSupplierProductLadderById(Long stepId);

    /**
     * 导入供应商产品阶梯价数据
     *
     * @param misSupplierProductLadderList 供应商产品阶梯价数据列表
     * @param isUpdateSupport              是否更新支持，如果已存在，则进行更新数据
     * @param operName                     操作用户
     * @return 结果
     */
    public String importMisSupplierProductLadder(List<MisSupplierProductLadder> misSupplierProductLadderList, Boolean isUpdateSupport, String operName);

}
