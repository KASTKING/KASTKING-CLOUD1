package com.kastking.personProduct.service;

import com.kastking.personProduct.domain.PersonProduct;

import java.util.HashMap;
import java.util.List;

/**
 * 人员产品Service接口
 *
 * @author Michael
 * @date 2020-02-07
 */
public interface IPersonProductService {
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
    public HashMap<String, Object> insertPersonProduct(PersonProduct personProduct);

    /**
     * 修改人员产品
     *
     * @param personProduct 人员产品
     * @return 结果
     */
    public int updatePersonProduct(PersonProduct personProduct);

    /**
     * 批量删除人员产品
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePersonProductByIds(String ids);

    /**
     * 删除人员产品信息
     *
     * @param personProductId 人员产品ID
     * @return 结果
     */
    public int deletePersonProductById(Long personProductId);

    /**
     * 导入人员产品数据
     *
     * @param personProductList 人员产品数据列表
     * @param isUpdateSupport   是否更新支持，如果已存在，则进行更新数据
     * @param operName          操作用户
     * @return 结果
     */
    public String importPersonProduct(List<PersonProduct> personProductList, Boolean isUpdateSupport, String operName);

}
