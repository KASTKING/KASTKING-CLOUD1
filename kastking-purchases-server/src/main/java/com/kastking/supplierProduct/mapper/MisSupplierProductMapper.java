package com.kastking.supplierProduct.mapper;

import com.kastking.supplierProduct.domain.MisSupplierProduct;

import java.util.List;

/**
 * 供应商产品Mapper接口
 *
 * @author James
 * @date 2020-02-07
 */
public interface MisSupplierProductMapper {
    /**
     * 查询供应商产品
     *
     * @param productId 供应商产品ID
     * @return 供应商产品
     */
    public MisSupplierProduct selectMisSupplierProductById(Long productId);

    /**
     * 查询供应商产品列表
     *
     * @param misSupplierProduct 供应商产品
     * @return 供应商产品集合
     */
    public List<MisSupplierProduct> selectMisSupplierProductList(MisSupplierProduct misSupplierProduct);

    /**
     * 新增供应商产品
     *
     * @param misSupplierProduct 供应商产品
     * @return 结果
     */
    public int insertMisSupplierProduct(MisSupplierProduct misSupplierProduct);

    /**
     * 修改供应商产品
     *
     * @param misSupplierProduct 供应商产品
     * @return 结果
     */
    public int updateMisSupplierProduct(MisSupplierProduct misSupplierProduct);

    /**
     * 删除供应商产品
     *
     * @param productId 供应商产品ID
     * @return 结果
     */
    public int deleteMisSupplierProductById(Long productId);

    /**
     * 批量删除供应商产品
     *
     * @param productIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMisSupplierProductByIds(String[] productIds);

    /**
     * 验证SKU唯一
     *
     * @param misSupplierProduct 供应商产品
     * @return 结果
     */
    public Long verificationSku(MisSupplierProduct misSupplierProduct);
}
