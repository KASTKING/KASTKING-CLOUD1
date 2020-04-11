package com.kastking.productInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 产品信息对象 product_info
 *
 * @author Michael
 * @date 2020-01-16
 */
public class ProductInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * Product ID
     */
    private Long productId;

    /**
     * Seriesname ID
     */
    @Excel(name = "Seriesname ID")
    private Long seriesnameId;

    /**
     * SKU
     */
    @Excel(name = "SKU")
    private String sku;

    /**
     * Number
     */
    @Excel(name = "Number")
    private String number;

    /**
     * Memo
     */
    @Excel(name = "Memo")
    private String memo;

    /**
     * State
     */
    @Excel(name = "State")
    private Integer state;

    /**
     * Adjust
     */
    @Excel(name = "Adjust")
    private String adjust;

    /**
     * Designer
     */
    @Excel(name = "Designer")
    private String designer;

    /**
     * Changes
     */
    @Excel(name = "Changes")
    private String changes;

    /**
     * NameRule
     */
    @Excel(name = "NameRule")
    private String nameRule;

    /**
     * Country
     */
    @Excel(name = "Country")
    private String country;

    /**
     * IsAdjust
     */
    @Excel(name = "IsAdjust")
    private Integer isAdjust;

    /**
     * DiameterMM
     */
    @Excel(name = "DiameterMM")
    private String diameterMm;

    /**
     * DiameterInch
     */
    @Excel(name = "DiameterInch")
    private String diameterInch;

    /**
     * ReelSize
     */
    @Excel(name = "ReelSize")
    private String reelSize;

    /**
     * ReelWeight
     */
    @Excel(name = "ReelWeight")
    private String reelWeight;

    /**
     * MaxDrag
     */
    @Excel(name = "MaxDrag")
    private String maxDrag;

    /**
     * GearRatio
     */
    @Excel(name = "GearRatio")
    private String gearRatio;

    /**
     * BallBearing
     */
    @Excel(name = "BallBearing")
    private String ballBearing;

    /**
     * IPT
     */
    @Excel(name = "IPT")
    private String ipt;

    /**
     * CPT
     */
    @Excel(name = "CPT")
    private String cpt;

    /**
     * LineCapacityLB
     */
    @Excel(name = "LineCapacityLB")
    private String lineCapacityLb;

    /**
     * LineCapacityMM
     */
    @Excel(name = "LineCapacityMM")
    private String lineCapacityMm;

    /**
     * RodType
     */
    @Excel(name = "RodType")
    private String rodType;

    /**
     * RodWeight
     */
    @Excel(name = "RodWeight")
    private String rodWeight;

    /**
     * RodLength
     */
    @Excel(name = "RodLength")
    private String rodLength;

    /**
     * Action
     */
    @Excel(name = "Action")
    private String action;

    /**
     * Power
     */
    @Excel(name = "Power")
    private String power;

    /**
     * LineWt
     */
    @Excel(name = "LineWt")
    private String lineWt;

    /**
     * LureWt
     */
    @Excel(name = "LureWt")
    private String lureWt;

    /**
     * NOofGuides
     */
    @Excel(name = "NOofGuides")
    private String noOfGuides;

    /**
     * Pieces
     */
    @Excel(name = "Pieces")
    private String pieces;

    /**
     * ToolLength
     */
    @Excel(name = "ToolLength")
    private String toolLength;

    /**
     * Material
     */
    @Excel(name = "Material")
    private String material;

    /**
     * Color
     */
    @Excel(name = "Color")
    private String color;

    /**
     * Style
     */
    @Excel(name = "Style")
    private String style;

    /**
     * Type
     */
    @Excel(name = "Type")
    private String type;

    /**
     * Size
     */
    @Excel(name = "Size")
    private String size;

    /**
     * Notes
     */
    @Excel(name = "Notes")
    private String notes;

    /**
     * Note1
     */
    @Excel(name = "Note1")
    private String note1;

    /**
     * Note2
     */
    @Excel(name = "Note2")
    private String note2;

    /**
     * Note3
     */
    @Excel(name = "Note3")
    private String note3;

    /**
     * Note4
     */
    @Excel(name = "Note4")
    private String note4;

    /**
     * Note5
     */
    @Excel(name = "Note5")
    private String note5;

    /**
     * Note6
     */
    @Excel(name = "Note6")
    private String note6;

    /**
     * LenzColor
     */
    @Excel(name = "LenzColor")
    private String lenzColor;

    /**
     * CoatingColor
     */
    @Excel(name = "CoatingColor")
    private String coatingColor;

    /**
     * LenzMaterial
     */
    @Excel(name = "LenzMaterial")
    private String lenzMaterial;

    /**
     * FrameColor
     */
    @Excel(name = "FrameColor")
    private String frameColor;

    /**
     * FrameMateiral
     */
    @Excel(name = "FrameMateiral")
    private String frameMateiral;

    /**
     * Picture
     */
    @Excel(name = "Picture")
    private String picture;

    /**
     * LineWeight
     */
    @Excel(name = "LineWeight")
    private String lineWeight;

    /**
     * LineLength
     */
    @Excel(name = "LineLength")
    private String lineLength;

    /**
     * TestLB
     */
    @Excel(name = "TestLB")
    private String testLb;

    /**
     * LineType
     */
    @Excel(name = "LineType")
    private String lineType;

    /**
     * Strands
     */
    @Excel(name = "Strands")
    private String strands;

    /**
     * TestStrength
     */
    @Excel(name = "TestStrength")
    private String testStrength;

    /**
     * TTSKU
     */
    @Excel(name = "TTSKU")
    private String ttsku;

    /**
     * Tag
     */
    @Excel(name = "Tag")
    private String tag;

    /**
     * CreateDate
     */
    @Excel(name = "CreateDate" , width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /**
     * UpdateDate
     */
    private Date updateDate;

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setSeriesnameId(Long seriesnameId) {
        this.seriesnameId = seriesnameId;
    }

    public Long getSeriesnameId() {
        return seriesnameId;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

    public void setAdjust(String adjust) {
        this.adjust = adjust;
    }

    public String getAdjust() {
        return adjust;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getDesigner() {
        return designer;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }

    public String getChanges() {
        return changes;
    }

    public void setNameRule(String nameRule) {
        this.nameRule = nameRule;
    }

    public String getNameRule() {
        return nameRule;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setIsAdjust(Integer isAdjust) {
        this.isAdjust = isAdjust;
    }

    public Integer getIsAdjust() {
        return isAdjust;
    }

    public void setDiameterMm(String diameterMm) {
        this.diameterMm = diameterMm;
    }

    public String getDiameterMm() {
        return diameterMm;
    }

    public void setDiameterInch(String diameterInch) {
        this.diameterInch = diameterInch;
    }

    public String getDiameterInch() {
        return diameterInch;
    }

    public void setReelSize(String reelSize) {
        this.reelSize = reelSize;
    }

    public String getReelSize() {
        return reelSize;
    }

    public void setReelWeight(String reelWeight) {
        this.reelWeight = reelWeight;
    }

    public String getReelWeight() {
        return reelWeight;
    }

    public void setMaxDrag(String maxDrag) {
        this.maxDrag = maxDrag;
    }

    public String getMaxDrag() {
        return maxDrag;
    }

    public void setGearRatio(String gearRatio) {
        this.gearRatio = gearRatio;
    }

    public String getGearRatio() {
        return gearRatio;
    }

    public void setBallBearing(String ballBearing) {
        this.ballBearing = ballBearing;
    }

    public String getBallBearing() {
        return ballBearing;
    }

    public void setIpt(String ipt) {
        this.ipt = ipt;
    }

    public String getIpt() {
        return ipt;
    }

    public void setCpt(String cpt) {
        this.cpt = cpt;
    }

    public String getCpt() {
        return cpt;
    }

    public void setLineCapacityLb(String lineCapacityLb) {
        this.lineCapacityLb = lineCapacityLb;
    }

    public String getLineCapacityLb() {
        return lineCapacityLb;
    }

    public void setLineCapacityMm(String lineCapacityMm) {
        this.lineCapacityMm = lineCapacityMm;
    }

    public String getLineCapacityMm() {
        return lineCapacityMm;
    }

    public void setRodType(String rodType) {
        this.rodType = rodType;
    }

    public String getRodType() {
        return rodType;
    }

    public void setRodWeight(String rodWeight) {
        this.rodWeight = rodWeight;
    }

    public String getRodWeight() {
        return rodWeight;
    }

    public void setRodLength(String rodLength) {
        this.rodLength = rodLength;
    }

    public String getRodLength() {
        return rodLength;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getPower() {
        return power;
    }

    public void setLineWt(String lineWt) {
        this.lineWt = lineWt;
    }

    public String getLineWt() {
        return lineWt;
    }

    public void setLureWt(String lureWt) {
        this.lureWt = lureWt;
    }

    public String getLureWt() {
        return lureWt;
    }

    public void setNoOfGuides(String noOfGuides) {
        this.noOfGuides = noOfGuides;
    }

    public String getNoOfGuides() {
        return noOfGuides;
    }

    public void setPieces(String pieces) {
        this.pieces = pieces;
    }

    public String getPieces() {
        return pieces;
    }

    public void setToolLength(String toolLength) {
        this.toolLength = toolLength;
    }

    public String getToolLength() {
        return toolLength;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    public String getNote1() {
        return note1;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }

    public String getNote2() {
        return note2;
    }

    public void setNote3(String note3) {
        this.note3 = note3;
    }

    public String getNote3() {
        return note3;
    }

    public void setNote4(String note4) {
        this.note4 = note4;
    }

    public String getNote4() {
        return note4;
    }

    public void setNote5(String note5) {
        this.note5 = note5;
    }

    public String getNote5() {
        return note5;
    }

    public void setNote6(String note6) {
        this.note6 = note6;
    }

    public String getNote6() {
        return note6;
    }

    public void setLenzColor(String lenzColor) {
        this.lenzColor = lenzColor;
    }

    public String getLenzColor() {
        return lenzColor;
    }

    public void setCoatingColor(String coatingColor) {
        this.coatingColor = coatingColor;
    }

    public String getCoatingColor() {
        return coatingColor;
    }

    public void setLenzMaterial(String lenzMaterial) {
        this.lenzMaterial = lenzMaterial;
    }

    public String getLenzMaterial() {
        return lenzMaterial;
    }

    public void setFrameColor(String frameColor) {
        this.frameColor = frameColor;
    }

    public String getFrameColor() {
        return frameColor;
    }

    public void setFrameMateiral(String frameMateiral) {
        this.frameMateiral = frameMateiral;
    }

    public String getFrameMateiral() {
        return frameMateiral;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setLineWeight(String lineWeight) {
        this.lineWeight = lineWeight;
    }

    public String getLineWeight() {
        return lineWeight;
    }

    public void setLineLength(String lineLength) {
        this.lineLength = lineLength;
    }

    public String getLineLength() {
        return lineLength;
    }

    public void setTestLb(String testLb) {
        this.testLb = testLb;
    }

    public String getTestLb() {
        return testLb;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public String getLineType() {
        return lineType;
    }

    public void setStrands(String strands) {
        this.strands = strands;
    }

    public String getStrands() {
        return strands;
    }

    public void setTestStrength(String testStrength) {
        this.testStrength = testStrength;
    }

    public String getTestStrength() {
        return testStrength;
    }

    public void setTtsku(String ttsku) {
        this.ttsku = ttsku;
    }

    public String getTtsku() {
        return ttsku;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
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
                .append("productId" , getProductId())
                .append("seriesnameId" , getSeriesnameId())
                .append("sku" , getSku())
                .append("number" , getNumber())
                .append("memo" , getMemo())
                .append("state" , getState())
                .append("adjust" , getAdjust())
                .append("designer" , getDesigner())
                .append("changes" , getChanges())
                .append("nameRule" , getNameRule())
                .append("country" , getCountry())
                .append("isAdjust" , getIsAdjust())
                .append("diameterMm" , getDiameterMm())
                .append("diameterInch" , getDiameterInch())
                .append("reelSize" , getReelSize())
                .append("reelWeight" , getReelWeight())
                .append("maxDrag" , getMaxDrag())
                .append("gearRatio" , getGearRatio())
                .append("ballBearing" , getBallBearing())
                .append("ipt" , getIpt())
                .append("cpt" , getCpt())
                .append("lineCapacityLb" , getLineCapacityLb())
                .append("lineCapacityMm" , getLineCapacityMm())
                .append("rodType" , getRodType())
                .append("rodWeight" , getRodWeight())
                .append("rodLength" , getRodLength())
                .append("action" , getAction())
                .append("power" , getPower())
                .append("lineWt" , getLineWt())
                .append("lureWt" , getLureWt())
                .append("noOfGuides" , getNoOfGuides())
                .append("pieces" , getPieces())
                .append("toolLength" , getToolLength())
                .append("material" , getMaterial())
                .append("color" , getColor())
                .append("style" , getStyle())
                .append("type" , getType())
                .append("size" , getSize())
                .append("notes" , getNotes())
                .append("note1" , getNote1())
                .append("note2" , getNote2())
                .append("note3" , getNote3())
                .append("note4" , getNote4())
                .append("note5" , getNote5())
                .append("note6" , getNote6())
                .append("lenzColor" , getLenzColor())
                .append("coatingColor" , getCoatingColor())
                .append("lenzMaterial" , getLenzMaterial())
                .append("frameColor" , getFrameColor())
                .append("frameMateiral" , getFrameMateiral())
                .append("picture" , getPicture())
                .append("lineWeight" , getLineWeight())
                .append("lineLength" , getLineLength())
                .append("testLb" , getTestLb())
                .append("lineType" , getLineType())
                .append("strands" , getStrands())
                .append("testStrength" , getTestStrength())
                .append("ttsku" , getTtsku())
                .append("tag" , getTag())
                .append("createDate" , getCreateDate())
                .append("updateDate" , getUpdateDate())
                .toString();
    }
}
