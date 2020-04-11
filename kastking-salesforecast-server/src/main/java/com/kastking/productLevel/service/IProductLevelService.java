package com.kastking.productLevel.service;

import com.kastking.productLevel.domain.ProductLevel;

import java.util.List;

/**
 * 产品层级Service接口
 *
 * @author Michael
 * @date 2020-02-15
 */
public interface IProductLevelService {
    /**
     * 查询产品层级
     *
     * @param productLevelId 产品层级ID
     * @return 产品层级
     */
    public ProductLevel selectProductLevelById(Long productLevelId);

    /**
     * 查询产品层级列表
     *
     * @param productLevel 产品层级
     * @return 产品层级集合
     */
    public List<ProductLevel> selectProductLevelList(ProductLevel productLevel);

    /**
     * 新增产品层级
     *
     * @param productLevel 产品层级
     * @return 结果
     */
    public int insertProductLevel(ProductLevel productLevel);

    /**
     * 修改产品层级
     *
     * @param productLevel 产品层级
     * @return 结果
     */
    public int updateProductLevel(ProductLevel productLevel);

    /**
     * 批量删除产品层级
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductLevelByIds(String ids);

    /**
     * 删除产品层级信息
     *
     * @param productLevelId 产品层级ID
     * @return 结果
     */
    public int deleteProductLevelById(Long productLevelId);

    /**
     * 导入产品层级数据
     *
     * @param productLevelList 产品层级数据列表
     * @param isUpdateSupport  是否更新支持，如果已存在，则进行更新数据
     * @param operName         操作用户
     * @return 结果
     */
    public String importProductLevel(List<ProductLevel> productLevelList, Boolean isUpdateSupport, String operName);

}
