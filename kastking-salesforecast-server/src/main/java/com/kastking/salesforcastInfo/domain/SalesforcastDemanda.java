package com.kastking.salesforcastInfo.domain;

import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

/**
 * 销量预计信息对象 mis_salesforcast_info
 *
 * @author Michael
 * @date 2020-02-14
 */
public class SalesforcastDemanda extends BaseEntity {
    private static final long serialVersionUID = 1L;


    /**
     * 期数
     */
    @Excel(name = "期数" , type = Excel.Type.EXPORT)
    private String period;

    /**
     * 站点
     */
    @Excel(name = "站点" , type = Excel.Type.EXPORT)
    private String channel;

    /**
     * 业务员
     */
    @Excel(name = "业务员" , type = Excel.Type.EXPORT)
    private String salesman;

    @Excel(name = "Band" , type = Excel.Type.EXPORT)
    private String band;
    @Excel(name = "RootCategory" , type = Excel.Type.EXPORT)
    private String rootcategory;
    @Excel(name = "SecondCategory" , type = Excel.Type.EXPORT)
    private String secondcategory;
    @Excel(name = "SeriesName" , type = Excel.Type.EXPORT)
    private String seriesname;

    /**
     * SKU
     */
    @Excel(name = "SKU" , type = Excel.Type.EXPORT)
    private String sku;

    /**
     * 产品层级
     */
    @Excel(name = "产品层级" , type = Excel.Type.EXPORT)
    private String productLevel;

    /**
     * 近30天销量
     */
    @Excel(name = "近30天销量" , type = Excel.Type.EXPORT)
    private Long monthlySales;

    /**
     * 近7天预估30天销量
     */
    @Excel(name = "预估30天销量" , type = Excel.Type.EXPORT)
    private Long forecastMonthlySales;

    /**
     *
     */
    @Excel(name = "2020-04" , type = Excel.Type.EXPORT)
    private String r1;
    @Excel(name = "2020-05" , type = Excel.Type.EXPORT)
    private String r2;
    @Excel(name = "2020-06" , type = Excel.Type.EXPORT)
    private String r3;
    @Excel(name = "2020-07" , type = Excel.Type.EXPORT)
    private String r4;
    @Excel(name = "2020-08" , type = Excel.Type.EXPORT)
    private String r5;
    @Excel(name = "2020-09" , type = Excel.Type.EXPORT)
    private String r6;
    @Excel(name = "2020-10" , type = Excel.Type.EXPORT)
    private String r7;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getRootcategory() {
        return rootcategory;
    }

    public void setRootcategory(String rootcategory) {
        this.rootcategory = rootcategory;
    }

    public String getSecondcategory() {
        return secondcategory;
    }

    public void setSecondcategory(String secondcategory) {
        this.secondcategory = secondcategory;
    }

    public String getSeriesname() {
        return seriesname;
    }

    public void setSeriesname(String seriesname) {
        this.seriesname = seriesname;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductLevel() {
        return productLevel;
    }

    public void setProductLevel(String productLevel) {
        this.productLevel = productLevel;
    }

    public Long getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(Long monthlySales) {
        this.monthlySales = monthlySales;
    }

    public Long getForecastMonthlySales() {
        return forecastMonthlySales;
    }

    public void setForecastMonthlySales(Long forecastMonthlySales) {
        this.forecastMonthlySales = forecastMonthlySales;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3;
    }

    public String getR4() {
        return r4;
    }

    public void setR4(String r4) {
        this.r4 = r4;
    }

    public String getR5() {
        return r5;
    }

    public void setR5(String r5) {
        this.r5 = r5;
    }

    public String getR6() {
        return r6;
    }

    public void setR6(String r6) {
        this.r6 = r6;
    }

    public String getR7() {
        return r7;
    }

    public void setR7(String r7) {
        this.r7 = r7;
    }
}
