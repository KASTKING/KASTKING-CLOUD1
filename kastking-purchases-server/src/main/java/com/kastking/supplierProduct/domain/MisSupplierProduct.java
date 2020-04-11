package com.kastking.supplierProduct.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 供应商产品对象 mis_supplier_product
 *
 * @author James
 * @date 2020-02-07
 */
public class MisSupplierProduct extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 供应商ID
     */

    private Long supplierId;

    /**
     * SKU
     */
    @Excel(name = "SKU")
    private String sku;

    /**
     * 币种
     */
    @Excel(name = "币种")
    private String currency;

    /**
     * 税点(%)
     */
    @Excel(name = "税点(%)")
    private Double taxPoint;

    /**
     * 单价(不含税)
     */
    @Excel(name = "单价(不含税)")
    private Double noUnitPrice;

    /**
     * 单价(含税)
     */
    @Excel(name = "单价(含税)")
    private Double unitPrice;

    /**
     * 生产周期(天)
     */
    @Excel(name = "生产周期(天)")
    private Long productionCycle;

    /**
     * 最小下单数
     */
    @Excel(name = "最小下单数")
    private Long minimumOrder;

    /**
     * 装箱数
     */
    @Excel(name = "装箱数")
    private Long qty;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private String status;

    /**
     * 是否最新
     */
    @Excel(name = "是否最新")
    private String upToDate;

    /**
     * 是否阶梯价
     */
    @Excel(name = "是否阶梯价")
    private String stepPrice;

    /**
     * 附件
     */
    @Excel(name = "类型")
    private String logo;

    /**
     * CreateDate
     */
    private Date createDate;

    /**
     * UpdateDate
     */
    private Date updateDate;

    private String str1;
    private String str2;
    private String str3;
    private String str4;
    private String str5;

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getStr3() {
        return str3;
    }

    public void setStr3(String str3) {
        this.str3 = str3;
    }

    public String getStr4() {
        return str4;
    }

    public void setStr4(String str4) {
        this.str4 = str4;
    }

    public String getStr5() {
        return str5;
    }

    public void setStr5(String str5) {
        this.str5 = str5;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setTaxPoint(Double taxPoint) {
        this.taxPoint = taxPoint;
    }

    public Double getTaxPoint() {
        return taxPoint;
    }

    public void setNoUnitPrice(Double noUnitPrice) {
        this.noUnitPrice = noUnitPrice;
    }

    public Double getNoUnitPrice() {
        return noUnitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setProductionCycle(Long productionCycle) {
        this.productionCycle = productionCycle;
    }

    public Long getProductionCycle() {
        return productionCycle;
    }

    public void setMinimumOrder(Long minimumOrder) {
        this.minimumOrder = minimumOrder;
    }

    public Long getMinimumOrder() {
        return minimumOrder;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public Long getQty() {
        return qty;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUpToDate(String upToDate) {
        this.upToDate = upToDate;
    }

    public String getUpToDate() {
        return upToDate;
    }

    public void setStepPrice(String stepPrice) {
        this.stepPrice = stepPrice;
    }

    public String getStepPrice() {
        return stepPrice;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("productId" , getProductId())
                .append("spplierId" , getSupplierId())
                .append("sku" , getSku())
                .append("currency" , getCurrency())
                .append("taxPoint" , getTaxPoint())
                .append("noUnitPrice" , getNoUnitPrice())
                .append("unitPrice" , getUnitPrice())
                .append("productionCycle" , getProductionCycle())
                .append("minimumOrder" , getMinimumOrder())
                .append("qty" , getQty())
                .append("status" , getStatus())
                .append("upToDate" , getUpToDate())
                .append("stepPrice" , getStepPrice())
                .append("logo" , getLogo())
                .append("remark" , getRemark())
                .append("createDate" , getCreateDate())
                .append("updateDate" , getUpdateDate())
                .toString();
    }
}
