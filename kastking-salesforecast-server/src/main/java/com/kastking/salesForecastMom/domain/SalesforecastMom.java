package com.kastking.salesForecastMom.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 销量预计MOM对象 mis_salesforecast_mom
 *
 * @author Michael
 * @date 2020-02-14
 */
public class SalesforecastMom extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long salesforecastMomId;

    /**
     * 年月
     */
    @Excel(name = "年月" , width = 30, dateFormat = "yyyy-MM-dd")
    private Date years;

    /**
     * MOM
     */
    @Excel(name = "MOM")
    private Double mom;

    public void setSalesforecastMomId(Long salesforecastMomId) {
        this.salesforecastMomId = salesforecastMomId;
    }

    public Long getSalesforecastMomId() {
        return salesforecastMomId;
    }

    public void setYears(Date years) {
        this.years = years;
    }

    public Date getYears() {
        return years;
    }

    public void setMom(Double mom) {
        this.mom = mom;
    }

    public Double getMom() {
        return mom;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("salesforecastMomId" , getSalesforecastMomId())
                .append("years" , getYears())
                .append("mom" , getMom())
                .toString();
    }
}
