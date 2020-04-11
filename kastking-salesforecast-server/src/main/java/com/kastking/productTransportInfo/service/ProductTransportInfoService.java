package com.kastking.productTransportInfo.service;

import com.kastking.productTransportInfo.domain.ProductTransportInfo;

import java.util.HashMap;
import java.util.List;

/**
 * 商品运输属性Service接口
 *
 * @author Michael
 * @date 2020-02-07
 */
public interface ProductTransportInfoService {
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
    public HashMap<String, Object> insertProductTransportInfo(ProductTransportInfo productTransportInfo);

    /**
     * 修改商品运输属性
     *
     * @param productTransportInfo 商品运输属性
     * @return 结果
     */
    public int updateProductTransportInfo(ProductTransportInfo productTransportInfo);

    /**
     * 批量删除商品运输属性
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductTransportInfoByIds(String ids);

    /**
     * 删除商品运输属性信息
     *
     * @param transportInfoId 商品运输属性ID
     * @return 结果
     */
    public int deleteProductTransportInfoById(Long transportInfoId);

    /**
     * 导入商品运输属性数据
     *
     * @param productTransportInfoList 商品运输属性数据列表
     * @param isUpdateSupport          是否更新支持，如果已存在，则进行更新数据
     * @param operName                 操作用户
     * @return 结果
     */
    public String importProductTransportInfo(List<ProductTransportInfo> productTransportInfoList, Boolean isUpdateSupport, String operName);

}
