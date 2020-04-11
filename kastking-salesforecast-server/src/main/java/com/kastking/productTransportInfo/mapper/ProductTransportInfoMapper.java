package com.kastking.productTransportInfo.mapper;

import com.kastking.productTransportInfo.domain.ProductTransportInfo;

import java.util.List;

/**
 * 商品运输属性Mapper接口
 *
 * @author Michael
 * @date 2020-02-07
 */
public interface ProductTransportInfoMapper {
    /**
     * 查询商品运输属性
     *
     * @param transportInfoId 商品运输属性ID
     * @return 商品运输属性
     */
    public ProductTransportInfo selectProductTransportInfoById(Long transportInfoId);

    /**
     * 查询商品运输属性列表
     *
     * @param productTransportInfo 商品运输属性
     * @return 商品运输属性集合
     */
    public List<ProductTransportInfo> selectProductTransportInfoList(ProductTransportInfo productTransportInfo);

    /**
     * 新增商品运输属性
     *
     * @param productTransportInfo 商品运输属性
     * @return 结果
     */
    public int insertProductTransportInfo(ProductTransportInfo productTransportInfo);

    /**
     * 修改商品运输属性
     *
     * @param productTransportInfo 商品运输属性
     * @return 结果
     */
    public int updateProductTransportInfo(ProductTransportInfo productTransportInfo);

    /**
     * 删除商品运输属性
     *
     * @param transportInfoId 商品运输属性ID
     * @return 结果
     */
    public int deleteProductTransportInfoById(Long transportInfoId);

    /**
     * 批量删除商品运输属性
     *
     * @param transportInfoIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductTransportInfoByIds(String[] transportInfoIds);
}
