package com.kastking.productLevel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

/**
 * 产品层级对象 mis_product_level
 *
 * @author Michael
 * @date 2020-02-15
 */
public class ProductLevel extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long productLevelId;

    /**
     * 站点
     */
    @Excel(name = "站点")
    private String channel;

    /**
     * SKU
     */
    @Excel(name = "SKU")
    private String sku;

    /**
     * 产品层级
     */
    @Excel(name = "产品层级")
    private String productLevel;

    /**
     * 业务员
     */
    @Excel(name = "业务员")
    private String salesman;

    public void setProductLevelId(Long productLevelId) {
        this.productLevelId = productLevelId;
    }

    public Long getProductLevelId() {
        return productLevelId;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setProductLevel(String productLevel) {
        this.productLevel = productLevel;
    }

    public String getProductLevel() {
        return productLevel;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getSalesman() {
        return salesman;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("productLevelId" , getProductLevelId())
                .append("channel" , getChannel())
                .append("sku" , getSku())
                .append("productLevel" , getProductLevel())
                .append("salesman" , getSalesman())
                .toString();
    }
}
