package com.kastking.personProduct.mapper;

import com.kastking.personProduct.domain.PersonProduct;

import java.util.List;

/**
 * 人员产品Mapper接口
 *
 * @author Michael
 * @date 2020-02-07
 */
public interface PersonProductMapper {
    /**
     * 查询人员产品
     *
     * @param personProductId 人员产品ID
     * @return 人员产品
     */
    public PersonProduct selectPersonProductById(Long personProductId);

    /**
     * 查询人员产品列表
     *
     * @param personProduct 人员产品
     * @return 人员产品集合
     */
    public List<PersonProduct> selectPersonProductList(PersonProduct personProduct);

    /**
     * 新增人员产品
     *
     * @param personProduct 人员产品
     * @return 结果
     */
    public int insertPersonProduct(PersonProduct personProduct);

    /**
     * 修改人员产品
     *
     * @param personProduct 人员产品
     * @return 结果
     */
    public int updatePersonProduct(PersonProduct personProduct);

    /**
     * 删除人员产品
     *
     * @param personProductId 人员产品ID
     * @return 结果
     */
    public int deletePersonProductById(Long personProductId);

    /**
     * 批量删除人员产品
     *
     * @param personProductIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePersonProductByIds(String[] personProductIds);
}
