package com.kastking.personProduct.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 人员产品对象 mis_person_product
 *
 * @author Michael
 * @date 2020-02-07
 */
public class PersonProduct extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 人员产品ID
     */
    private Long personProductId;

    /**
     * 站点 ID
     */
    private Long platformChannelId;

    /**
     * 站点
     */
    @Excel(name = "站点")
    private String channel;
    /**
     * 业务员
     */
    @Excel(name = "业务员")
    private String salesman;

    /**
     * SKU
     */
    @Excel(name = "SKU")
    private String sku;

    /**
     * 售价
     */
    @Excel(name = "售价")
    private Double sellingPrice;

    /**
     * 是否预计
     */
    @Excel(name = "是否预计" , readConverterExp = "0=否,1=是")
    private String isExpected;

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

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }


    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setPersonProductId(Long personProductId) {
        this.personProductId = personProductId;
    }

    public Long getPersonProductId() {
        return personProductId;
    }

    public void setPlatformChannelId(Long platformChannelId) {
        this.platformChannelId = platformChannelId;
    }

    public Long getPlatformChannelId() {
        return platformChannelId;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public String getIsExpected() {
        return isExpected;
    }

    public void setIsExpected(String isExpected) {
        this.isExpected = isExpected;
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
                .append("personProductId" , getPersonProductId())
                .append("platformChannelId" , getPlatformChannelId())
                .append("sku" , getSku())
                .append("sellingPrice" , getSellingPrice())
                .append("memo" , getMemo())
                .append("createDate" , getCreateDate())
                .append("updateDate" , getUpdateDate())
                .toString();
    }
}
