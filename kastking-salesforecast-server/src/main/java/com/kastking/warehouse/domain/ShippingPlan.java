package com.kastking.warehouse.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 出货计划对象 mis_shipping_plan
 *
 * @author Michael
 * @date 2020-03-06
 */
public class ShippingPlan extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long shippingPlanId;

    /**
     * 期数
     */
    @Excel(name = "期数" , width = 30, dateFormat = "yyyy-MM-dd")
    private Date period;

    /**
     * 仓库
     */
    @Excel(name = "仓库")
    private String warehouse;

    /**
     * SKU
     */
    @Excel(name = "SKU")
    private String sku;

    /**
     * 出货数
     */
    @Excel(name = "出货数")
    private Integer shipNum;

    public void setShippingPlanId(Long shippingPlanId) {
        this.shippingPlanId = shippingPlanId;
    }

    public Long getShippingPlanId() {
        return shippingPlanId;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public Date getPeriod() {
        return period;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setShipNum(Integer shipNum) {
        this.shipNum = shipNum;
    }

    public Integer getShipNum() {
        return shipNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("shippingPlanId" , getShippingPlanId())
                .append("period" , getPeriod())
                .append("warehouse" , getWarehouse())
                .append("sku" , getSku())
                .append("shipNum" , getShipNum())
                .toString();
    }
}
