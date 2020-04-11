package com.kastking.warehouse.service.impl;

import java.util.List;

import com.kastking.warehouse.domain.ShippingPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.warehouse.mapper.ShippingPlanMapper;
import com.kastking.warehouse.service.IShippingPlanService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 出货计划Service业务层处理
 *
 * @author Michael
 * @date 2020-03-06
 */
@Service
public class ShippingPlanServiceImpl implements IShippingPlanService {
    private static final Logger log = LoggerFactory.getLogger(ShippingPlanServiceImpl.class);

    @Autowired
    private ShippingPlanMapper shippingPlanMapper;

    /**
     * 查询出货计划
     *
     * @param shippingPlanId 出货计划ID
     * @return 出货计划
     */
    @Override
    public ShippingPlan selectShippingPlanById(Long shippingPlanId) {
        return shippingPlanMapper.selectShippingPlanById(shippingPlanId);
    }

    /**
     * 查询出货计划列表
     *
     * @param shippingPlan 出货计划
     * @return 出货计划
     */
    @Override
    public List<ShippingPlan> selectShippingPlanList(ShippingPlan shippingPlan) {
        return shippingPlanMapper.selectShippingPlanList(shippingPlan);
    }

    /**
     * 新增出货计划
     *
     * @param shippingPlan 出货计划
     * @return 结果
     */
    @Override
    public int insertShippingPlan(ShippingPlan shippingPlan) {
        return shippingPlanMapper.insertShippingPlan(shippingPlan);
    }

    /**
     * 修改出货计划
     *
     * @param shippingPlan 出货计划
     * @return 结果
     */
    @Override
    public int updateShippingPlan(ShippingPlan shippingPlan) {
        return shippingPlanMapper.updateShippingPlan(shippingPlan);
    }

    /**
     * 删除出货计划对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShippingPlanByIds(String ids) {
        return shippingPlanMapper.deleteShippingPlanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除出货计划信息
     *
     * @param shippingPlanId 出货计划ID
     * @return 结果
     */
    @Override
    public int deleteShippingPlanById(Long shippingPlanId) {
        return shippingPlanMapper.deleteShippingPlanById(shippingPlanId);
    }

    /**
     * 导入出货计划数据
     *
     * @param shippingPlanList 出货计划数据列表
     * @param isUpdateSupport  是否更新支持，如果已存在，则进行更新数据
     * @param operName         操作用户
     * @return 结果
     */
    public String importShippingPlan(List<ShippingPlan> shippingPlanList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(shippingPlanList) || shippingPlanList.size() == 0) {
            throw new BusinessException("导入出货计划数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ShippingPlan shippingPlan : shippingPlanList) {
            try {
                this.insertShippingPlan(shippingPlan);
                successNum++;
                successMsg.append("<br/>" + successNum + "、导入成功");
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
