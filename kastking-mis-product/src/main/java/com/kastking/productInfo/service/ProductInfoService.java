package com.kastking.productInfo.service;

import com.kastking.productInfo.domain.ProductInfo;

import java.util.List;

/**
 * 产品信息Service接口
 *
 * @author Michael
 * @date 2020-01-18
 */
public interface ProductInfoService {
    /**
     * 查询产品信息
     *
     * @param productId 产品信息ID
     * @return 产品信息
     */
    public ProductInfo selectProductInfoById(Long productId);

    /**
     * 查询产品信息列表
     *
     * @param productInfo 产品信息
     * @return 产品信息集合
     */
    public List<ProductInfo> selectProductInfoList(ProductInfo productInfo);

    /**
     * 新增产品信息
     *
     * @param productInfo 产品信息
     * @return 结果
     */
    public int insertProductInfo(ProductInfo productInfo);

    /**
     * 修改产品信息
     *
     * @param productInfo 产品信息
     * @return 结果
     */
    public int updateProductInfo(ProductInfo productInfo);

    /**
     * 批量删除产品信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductInfoByIds(String ids);

    /**
     * 删除产品信息信息
     *
     * @param productId 产品信息ID
     * @return 结果
     */
    public int deleteProductInfoById(Long productId);

    /**
     * 导入产品信息数据
     *
     * @param productInfoList 产品信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    public String importProductInfo(List<ProductInfo> productInfoList, Boolean isUpdateSupport, String operName);

}
