package com.kastking.productTransportInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 商品运输属性对象 mis_product_transport_info
 *
 * @author Michael
 * @date 2020-02-07
 */
public class ProductTransportInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Excel(name = "运输周期")
    private Integer transportMonth;
    @Excel(name = "预计月数")
    private Integer presellsMonth;
    @Excel(name = "生产周期")
    private Integer produceMonth;
    @Excel(name = "MOQ")
    private Integer moq;
    @Excel(name = "状态")
    private String state;


    /**
     * 商品运输属性ID
     */
    private Long transportInfoId;

    /**
     * SKU
     */
    @Excel(name = "SKU")
    private String sku;

    /**
     * 市场ID
     */
    @Excel(name = "市场" , readConverterExp = "1=USA,2=Other")
    private String marketId;

    /**
     * 运输方式ID
     */
    @Excel(name = "运输方式" , readConverterExp = "1=海运,2=空运,3=新品空运,4=待定")
    private String transportId;

    /**
     * Memo
     */
    @Excel(name = "Memo")
    private String memo;

    /**
     * CreateDate
     */
    private Date createDate;

    /**
     * UpdateDate
     */
    private Date updateDate;

    public Integer getTransportMonth() {
        return transportMonth;
    }

    public void setTransportMonth(Integer transportMonth) {
        this.transportMonth = transportMonth;
    }

    public Integer getPresellsMonth() {
        return presellsMonth;
    }

    public void setPresellsMonth(Integer presellsMonth) {
        this.presellsMonth = presellsMonth;
    }

    public Integer getProduceMonth() {
        return produceMonth;
    }

    public void setProduceMonth(Integer produceMonth) {
        this.produceMonth = produceMonth;
    }

    public Integer getMoq() {
        return moq;
    }

    public void setMoq(Integer moq) {
        this.moq = moq;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTransportInfoId(Long transportInfoId) {
        this.transportInfoId = transportInfoId;
    }

    public Long getTransportInfoId() {
        return transportInfoId;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public String getTransportId() {
        return transportId;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("transportInfoId" , getTransportInfoId())
                .append("sku" , getSku())
                .append("marketId" , getMarketId())
                .append("transportId" , getTransportId())
                .append("memo" , getMemo())
                .append("createDate" , getCreateDate())
                .append("updateDate" , getUpdateDate())
                .toString();
    }
}
