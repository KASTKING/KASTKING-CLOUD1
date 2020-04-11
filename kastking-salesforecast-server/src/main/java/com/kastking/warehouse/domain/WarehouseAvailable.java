package com.kastking.warehouse.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 仓库可用对象 mis_warehouse_available
 *
 * @author Michael
 * @date 2020-03-03
 */
public class WarehouseAvailable extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long availableId;

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
     * 预计月份
     */
    @Excel(name = "预计月份" , width = 30, dateFormat = "yyyy-MM-dd")
    private Date forecastMonth;

    /**
     * SKU
     */
    @Excel(name = "SKU")
    private String sku;

    /**
     * 可用数
     */
    @Excel(name = "可用数")
    private Integer availableNum;

    /**
     * 最后一天销量
     */
    @Excel(name = "最后一天销量")
    private Integer lastDaySales;

    public void setAvailableId(Long availableId) {
        this.availableId = availableId;
    }

    public Long getAvailableId() {
        return availableId;
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

    public void setForecastMonth(Date forecastMonth) {
        this.forecastMonth = forecastMonth;
    }

    public Date getForecastMonth() {
        return forecastMonth;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setAvailableNum(Integer availableNum) {
        this.availableNum = availableNum;
    }

    public Integer getAvailableNum() {
        return availableNum;
    }

    public void setLastDaySales(Integer lastDaySales) {
        this.lastDaySales = lastDaySales;
    }

    public Integer getLastDaySales() {
        return lastDaySales;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("availableId" , getAvailableId())
                .append("period" , getPeriod())
                .append("warehouse" , getWarehouse())
                .append("forecastMonth" , getForecastMonth())
                .append("sku" , getSku())
                .append("availableNum" , getAvailableNum())
                .append("lastDaySales" , getLastDaySales())
                .toString();
    }
}
