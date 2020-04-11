package com.kastking.productLevel.mapper;

import com.kastking.productLevel.domain.ProductLevel;

import java.util.List;

/**
 * 产品层级Mapper接口
 *
 * @author Michael
 * @date 2020-02-15
 */
public interface ProductLevelMapper {
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
     * 删除产品层级
     *
     * @param productLevelId 产品层级ID
     * @return 结果
     */
    public int deleteProductLevelById(Long productLevelId);

    /**
     * 批量删除产品层级
     *
     * @param productLevelIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductLevelByIds(String[] productLevelIds);
}
