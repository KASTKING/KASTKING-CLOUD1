package com.kastking.productCategory.service;

import com.kastking.productCategory.domain.ProductCategory;

import java.util.List;

import com.kastking.common.core.domain.Ztree;

/**
 * 产品类目Service接口
 *
 * @author Michael
 * @date 2020-01-16
 */
public interface ProductCategoryService {
    /**
     * 查询是否有子产品
     *
     * @param categoryId
     * @return
     */
    public Integer selectIsProductCategory(Long categoryId);

    /**
     * 查询产品类目
     *
     * @param categoryId 产品类目ID
     * @return 产品类目
     */
    public ProductCategory selectProductCategoryById(Long categoryId);

    /**
     * 查询产品类目列表
     *
     * @param productCategory 产品类目
     * @return 产品类目集合
     */
    public List<ProductCategory> selectProductCategoryList(ProductCategory productCategory);

    /**
     * 新增产品类目
     *
     * @param productCategory 产品类目
     * @return 结果
     */
    public int insertProductCategory(ProductCategory productCategory);

    /**
     * 修改产品类目
     *
     * @param productCategory 产品类目
     * @return 结果
     */
    public int updateProductCategory(ProductCategory productCategory);

    /**
     * 批量删除产品类目
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductCategoryByIds(String ids);

    /**
     * 删除产品类目信息
     *
     * @param categoryId 产品类目ID
     * @return 结果
     */
    public int deleteProductCategoryById(Long categoryId);

    /**
     * 查询产品类目树列表
     *
     * @return 所有产品类目信息
     */
    public List<Ztree> selectProductCategoryTree();
}
