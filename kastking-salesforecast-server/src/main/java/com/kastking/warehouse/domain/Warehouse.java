package com.kastking.warehouse.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

/**
 * 仓库对象 mis_warehouse
 *
 * @author Michael
 * @date 2020-02-28
 */
public class Warehouse extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 仓库ID
     */
    private Long warehouseId;

    /**
     * 仓库
     */
    @Excel(name = "仓库")
    private String warehouse;

    /**
     * 站点
     */
    @Excel(name = "站点")
    private String channel;

    /**
     * 市场ID
     */
    @Excel(name = "市场" , readConverterExp = "1=USA,2=Other")
    private String marketId;

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getMarketId() {
        return marketId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("warehouseId" , getWarehouseId())
                .append("warehouse" , getWarehouse())
                .append("channel" , getChannel())
                .append("marketId" , getMarketId())
                .toString();
    }
}
