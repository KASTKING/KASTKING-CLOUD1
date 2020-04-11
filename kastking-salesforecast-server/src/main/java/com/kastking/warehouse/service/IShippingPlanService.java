package com.kastking.warehouse.service;

import com.kastking.warehouse.domain.ShippingPlan;

import java.util.List;

/**
 * 出货计划Service接口
 *
 * @author Michael
 * @date 2020-03-06
 */
public interface IShippingPlanService {
    /**
     * 查询出货计划
     *
     * @param shippingPlanId 出货计划ID
     * @return 出货计划
     */
    public ShippingPlan selectShippingPlanById(Long shippingPlanId);

    /**
     * 查询出货计划列表
     *
     * @param shippingPlan 出货计划
     * @return 出货计划集合
     */
    public List<ShippingPlan> selectShippingPlanList(ShippingPlan shippingPlan);

    /**
     * 新增出货计划
     *
     * @param shippingPlan 出货计划
     * @return 结果
     */
    public int insertShippingPlan(ShippingPlan shippingPlan);

    /**
     * 修改出货计划
     *
     * @param shippingPlan 出货计划
     * @return 结果
     */
    public int updateShippingPlan(ShippingPlan shippingPlan);

    /**
     * 批量删除出货计划
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShippingPlanByIds(String ids);

    /**
     * 删除出货计划信息
     *
     * @param shippingPlanId 出货计划ID
     * @return 结果
     */
    public int deleteShippingPlanById(Long shippingPlanId);

    /**
     * 导入出货计划数据
     *
     * @param shippingPlanList 出货计划数据列表
     * @param isUpdateSupport  是否更新支持，如果已存在，则进行更新数据
     * @param operName         操作用户
     * @return 结果
     */
    public String importShippingPlan(List<ShippingPlan> shippingPlanList, Boolean isUpdateSupport, String operName);

}
