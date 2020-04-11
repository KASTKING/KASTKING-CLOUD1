package com.kastking.salesforcastInfo.domain;

import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 销量预计信息对象 mis_salesforcast_info
 *
 * @author Michael
 * @date 2020-02-14
 */
public class SalesforcastInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long salesforcastInfoId;

    /**
     * 期数
     */
    @Excel(name = "期数" , type = Excel.Type.EXPORT)
    private String period;

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
     * 预计月份
     */
    @Excel(name = "预计月份")
    private String forecastMonth;

    /**
     * 审核人
     */
    @Excel(name = "审核人" , type = Excel.Type.EXPORT)
    private String reviewer;

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
    @Excel(name = "SKU")
    private String sku;

    /**
     * 产品层级
     */
    @Excel(name = "产品层级" , type = Excel.Type.EXPORT)
    private String productLevel;

    /**
     * MOM
     */
    @Excel(name = "MOM" , type = Excel.Type.EXPORT)
    private Double mom;

    /**
     * 去年销量
     */
    @Excel(name = "去年销量" , type = Excel.Type.EXPORT)
    private Long lastYearSales;

    /**
     * 近30天销量
     */
    @Excel(name = "近30天销量" , type = Excel.Type.EXPORT)
    private Long monthlySales;

    /**
     * 近7天预估30天销量
     */
    @Excel(name = "近7天预估30天销量" , type = Excel.Type.EXPORT)
    private Long forecastMonthlySales;

    /**
     * 上期需求量
     */
    @Excel(name = "上期需求量" , type = Excel.Type.EXPORT)
    private Long lastDemand;

    /**
     * 本月建议量
     */
    @Excel(name = "本月建议量" , type = Excel.Type.EXPORT)
    private Long suggestedAmount;

    /**
     * 本月需求量
     */
    @Excel(name = "本月需求量")
    private Long demand;

    /**
     * 2期需求变量
     */
    @Excel(name = "2期需求变量")
    private Long twoDemand;

    //备货系数
    @Excel(name = "备货系数" , type = Excel.Type.EXPORT)
    private Double stockingFactor;
    //风险判断
    @Excel(name = "风险判断" , type = Excel.Type.EXPORT)
    private String riskJudgment;

    /**
     * 近30天断货天数
     */
    @Excel(name = "近30天断货天数")
    private Long outofstockDays;

    /**
     * 近30天无断货销量预估
     */
    @Excel(name = "近30天无断货销量预估")
    private Long noOutofstockSales;

    //selling_price,increment,total_demand,stocking_factor,risk_judgment
    //售价
    @Excel(name = "售价" , type = Excel.Type.EXPORT)
    private Double sellingPrice;
    //增量
    @Excel(name = "增量" , type = Excel.Type.EXPORT)
    private Integer increment;
    //总需求量
    @Excel(name = "总需求量" , type = Excel.Type.EXPORT)
    private Integer totalDemand;


    /**
     * CreateDate
     */
    private Date createDate;

    /**
     * UpdateDate
     */
    private Date updateDate;

    public Long getSalesforcastInfoId() {
        return salesforcastInfoId;
    }

    public void setSalesforcastInfoId(Long salesforcastInfoId) {
        this.salesforcastInfoId = salesforcastInfoId;
    }

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

    public String getForecastMonth() {
        return forecastMonth;
    }

    public void setForecastMonth(String forecastMonth) {
        this.forecastMonth = forecastMonth;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
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

    public Double getMom() {
        return mom;
    }

    public void setMom(Double mom) {
        this.mom = mom;
    }

    public Long getLastYearSales() {
        return lastYearSales;
    }

    public void setLastYearSales(Long lastYearSales) {
        this.lastYearSales = lastYearSales;
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

    public Long getLastDemand() {
        return lastDemand;
    }

    public void setLastDemand(Long lastDemand) {
        this.lastDemand = lastDemand;
    }

    public Long getSuggestedAmount() {
        return suggestedAmount;
    }

    public void setSuggestedAmount(Long suggestedAmount) {
        this.suggestedAmount = suggestedAmount;
    }

    public Long getDemand() {
        return demand;
    }

    public void setDemand(Long demand) {
        this.demand = demand;
    }

    public Long getTwoDemand() {
        return twoDemand;
    }

    public void setTwoDemand(Long twoDemand) {
        this.twoDemand = twoDemand;
    }

    public Long getOutofstockDays() {
        return outofstockDays;
    }

    public void setOutofstockDays(Long outofstockDays) {
        this.outofstockDays = outofstockDays;
    }

    public Long getNoOutofstockSales() {
        return noOutofstockSales;
    }

    public void setNoOutofstockSales(Long noOutofstockSales) {
        this.noOutofstockSales = noOutofstockSales;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getIncrement() {
        return increment;
    }

    public void setIncrement(Integer increment) {
        this.increment = increment;
    }

    public Integer getTotalDemand() {
        return totalDemand;
    }

    public void setTotalDemand(Integer totalDemand) {
        this.totalDemand = totalDemand;
    }

    public Double getStockingFactor() {
        return stockingFactor;
    }

    public void setStockingFactor(Double stockingFactor) {
        this.stockingFactor = stockingFactor;
    }

    public String getRiskJudgment() {
        return riskJudgment;
    }

    public void setRiskJudgment(String riskJudgment) {
        this.riskJudgment = riskJudgment;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "SalesforcastInfo{" +
                "period='" + period + '\'' +
                ", channel='" + channel + '\'' +
                ", salesman='" + salesman + '\'' +
                ", forecastMonth='" + forecastMonth + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", band='" + band + '\'' +
                ", rootcategory='" + rootcategory + '\'' +
                ", secondcategory='" + secondcategory + '\'' +
                ", seriesname='" + seriesname + '\'' +
                ", sku='" + sku + '\'' +
                ", productLevel='" + productLevel + '\'' +
                ", mom=" + mom +
                ", lastYearSales=" + lastYearSales +
                ", monthlySales=" + monthlySales +
                ", forecastMonthlySales=" + forecastMonthlySales +
                ", lastDemand=" + lastDemand +
                ", suggestedAmount=" + suggestedAmount +
                ", demand=" + demand +
                ", twoDemand=" + twoDemand +
                ", outofstockDays=" + outofstockDays +
                ", noOutofstockSales=" + noOutofstockSales +
                ", sellingPrice=" + sellingPrice +
                ", increment=" + increment +
                ", totalDemand=" + totalDemand +
                ", stockingFactor=" + stockingFactor +
                ", riskJudgment='" + riskJudgment + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
