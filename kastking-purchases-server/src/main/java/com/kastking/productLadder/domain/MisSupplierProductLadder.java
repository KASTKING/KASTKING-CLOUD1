package com.kastking.productLadder.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

/**
 * 供应商产品阶梯价对象 mis_supplier_product_ladder
 *
 * @author James
 * @date 2020-02-14
 */
public class MisSupplierProductLadder extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long stepId;

    /**
     * 供应商产品ID
     */
    private Long productId;

    @Excel(name = "sku")
    private String sku;

    /**
     * 价格1
     */
    @Excel(name = "价格1")
    private Double priceOne;

    /**
     * 价格2
     */
    @Excel(name = "价格2")
    private Double priceTwo;

    /**
     * 单价
     */
    @Excel(name = "单价")
    private Double unitPrice;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }

    public Long getStepId() {
        return stepId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setPriceOne(Double priceOne) {
        this.priceOne = priceOne;
    }

    public Double getPriceOne() {
        return priceOne;
    }

    public void setPriceTwo(Double priceTwo) {
        this.priceTwo = priceTwo;
    }

    public Double getPriceTwo() {
        return priceTwo;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("stepId" , getStepId())
                .append("productId" , getProductId())
                .append("priceOne" , getPriceOne())
                .append("priceTwo" , getPriceTwo())
                .append("unitPrice" , getUnitPrice())
                .toString();
    }
}
