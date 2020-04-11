package com.kastking.historicalPrice.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 供应商产品历史价格对象 mis_supplier_historical_price
 *
 * @author James
 * @date 2020-02-19
 */
public class MisSupplierHistoricalPrice extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long priceId;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 本期时间
     */
    @Excel(name = "本期时间" , width = 30, dateFormat = "yyyy-MM-dd")
    private Date currentTime;

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
     * 上期税点
     */
    @Excel(name = "上期税点")
    private Double lastTax;

    /**
     * 上期时间
     */
    @Excel(name = "上期时间" , width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastTime;

    /**
     * 上期单价(不含税)
     */
    @Excel(name = "上期单价(不含税)")
    private Double lastNoPrice;

    /**
     * 上期单价(含税)
     */
    @Excel(name = "上期单价(含税)")
    private Double lastPrice;

    /**
     * 上期税点
     */
    @Excel(name = "本期税点")
    private Double taxPoint;

    /**
     * 本期单价(不含税)
     */
    @Excel(name = "本期单价(不含税)")
    private Double currentNoPrice;

    /**
     * 本期单价(含税)
     */
    @Excel(name = "本期单价(含税)")
    private Double currentPrice;

    /**
     * 本期单价(不含税)
     */
    @Excel(name = "差值单价(不含税)")
    private Double differenceNoPrice;

    /**
     * 本期单价(含税)
     */
    @Excel(name = "差值单价(含税)")
    private Double differencePrice;

    private Date currentTimeEnd;

    public Double getLastTax() {
        return lastTax;
    }

    public void setLastTax(Double lastTax) {
        this.lastTax = lastTax;
    }

    public Double getTaxPoint() {
        return taxPoint;
    }

    public void setTaxPoint(Double taxPoint) {
        this.taxPoint = taxPoint;
    }

    public Date getCurrentTimeEnd() {
        return currentTimeEnd;
    }

    public void setCurrentTimeEnd(Date currentTimeEnd) {
        this.currentTimeEnd = currentTimeEnd;
    }

    public Double getDifferenceNoPrice() {
        return differenceNoPrice;
    }

    public void setDifferenceNoPrice(Double differenceNoPrice) {
        this.differenceNoPrice = differenceNoPrice;
    }

    public Double getDifferencePrice() {
        return differencePrice;
    }

    public void setDifferencePrice(Double differencePrice) {
        this.differencePrice = differencePrice;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public Long getPriceId() {
        return priceId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public Date getCurrentTime() {
        return currentTime;
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

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastNoPrice(Double lastNoPrice) {
        this.lastNoPrice = lastNoPrice;
    }

    public Double getLastNoPrice() {
        return lastNoPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setCurrentNoPrice(Double currentNoPrice) {
        this.currentNoPrice = currentNoPrice;
    }

    public Double getCurrentNoPrice() {
        return currentNoPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("priceId" , getPriceId())
                .append("productId" , getProductId())
                .append("currentTime" , getCurrentTime())
                .append("sku" , getSku())
                .append("currency" , getCurrency())
                .append("lastTime" , getLastTime())
                .append("lastNoPrice" , getLastNoPrice())
                .append("lastPrice" , getLastPrice())
                .append("currentNoPrice" , getCurrentNoPrice())
                .append("currentPrice" , getCurrentPrice())
                .toString();
    }
}
