package com.kastking.warehouse.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 仓库在途对象 mis_warehouse_way
 *
 * @author Michael
 * @date 2020-03-06
 */
public class WarehouseWay extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long wayId;

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
     * 在途数
     */
    @Excel(name = "在途数")
    private Integer wayNum;

    public void setWayId(Long wayId) {
        this.wayId = wayId;
    }

    public Long getWayId() {
        return wayId;
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

    public void setWayNum(Integer wayNum) {
        this.wayNum = wayNum;
    }

    public Integer getWayNum() {
        return wayNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("wayId" , getWayId())
                .append("period" , getPeriod())
                .append("warehouse" , getWarehouse())
                .append("forecastMonth" , getForecastMonth())
                .append("sku" , getSku())
                .append("wayNum" , getWayNum())
                .toString();
    }
}
