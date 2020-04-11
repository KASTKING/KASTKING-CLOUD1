package com.kastking.productInfo.mapper;

import com.kastking.productInfo.domain.ProductInfo;

import java.util.List;

/**
 * 产品信息Mapper接口
 *
 * @author Michael
 * @date 2020-01-16
 */
public interface ProductInfoMapper {
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
     * 删除产品信息
     *
     * @param productId 产品信息ID
     * @return 结果
     */
    public int deleteProductInfoById(Long productId);

    /**
     * 批量删除产品信息
     *
     * @param productIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductInfoByIds(String[] productIds);
}
