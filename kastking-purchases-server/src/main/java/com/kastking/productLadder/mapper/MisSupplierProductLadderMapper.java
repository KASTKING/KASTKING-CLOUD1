package com.kastking.productLadder.mapper;

import com.kastking.productLadder.domain.MisSupplierProductLadder;

import java.util.List;

/**
 * 供应商产品阶梯价Mapper接口
 *
 * @author James
 * @date 2020-02-14
 */
public interface MisSupplierProductLadderMapper {
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
     * 删除供应商产品阶梯价
     *
     * @param stepId 供应商产品阶梯价ID
     * @return 结果
     */
    public int deleteMisSupplierProductLadderById(Long stepId);

    /**
     * 删除供应商产品阶梯价
     *
     * @param productId 供应商产品阶梯价ID
     * @return 结果
     */
    public int deleteMisSupplierProductLadderByHeadId(Long productId);

    /**
     * 批量删除供应商产品阶梯价
     *
     * @param stepIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMisSupplierProductLadderByIds(String[] stepIds);
}
