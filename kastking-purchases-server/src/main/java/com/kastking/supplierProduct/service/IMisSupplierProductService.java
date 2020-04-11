package com.kastking.supplierProduct.service;

import com.kastking.supplierProduct.domain.MisSupplierProduct;

import java.util.List;

/**
 * 供应商产品Service接口
 *
 * @author James
 * @date 2020-02-07
 */
public interface IMisSupplierProductService {
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
     * 批量删除供应商产品
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMisSupplierProductByIds(String ids);

    /**
     * 删除供应商产品信息
     *
     * @param productId 供应商产品ID
     * @return 结果
     */
    public int deleteMisSupplierProductById(Long productId);

    /**
     * 导入供应商产品数据
     *
     * @param misSupplierProductList 供应商产品数据列表
     * @param isUpdateSupport        是否更新支持，如果已存在，则进行更新数据
     * @param operName               操作用户
     * @return 结果
     */
    public String importMisSupplierProduct(List<MisSupplierProduct> misSupplierProductList, Boolean isUpdateSupport, String operName);

    /**
     * 验证SKU唯一
     *
     * @param misSupplierProduct 供应商产品
     * @return 结果
     */
    public Long verificationSku(MisSupplierProduct misSupplierProduct);

}
