package com.kastking.warehouse.mapper;

import com.kastking.warehouse.domain.ShippingPlan;

import java.util.List;

/**
 * 出货计划Mapper接口
 *
 * @author Michael
 * @date 2020-03-06
 */
public interface ShippingPlanMapper {
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
     * 删除出货计划
     *
     * @param shippingPlanId 出货计划ID
     * @return 结果
     */
    public int deleteShippingPlanById(Long shippingPlanId);

    /**
     * 批量删除出货计划
     *
     * @param shippingPlanIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShippingPlanByIds(String[] shippingPlanIds);
}
