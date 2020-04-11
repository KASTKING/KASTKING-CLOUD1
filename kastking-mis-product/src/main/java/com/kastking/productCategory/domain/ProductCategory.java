package com.kastking.productCategory.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.TreeEntity;

/**
 * 产品类目对象 product_category
 *
 * @author Michael
 * @date 2020-01-16
 */
public class ProductCategory extends TreeEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 类目ID
     */
    private Long categoryId;

    /**
     * 父ID
     */
    @Excel(name = "父ID")
    private Long fatherId;

    /**
     * 类型ID
     */
    @Excel(name = "类型ID")
    private String categoryNo;

    /**
     * 类目
     */
    @Excel(name = "类目")
    private String category;

    /**
     * abbv
     */
    @Excel(name = "abbv")
    private String abbv;

    /**
     * 标签
     */
    @Excel(name = "标签")
    private String tag;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String memo;

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    public Long getFatherId() {
        return fatherId;
    }

    public void setCategoryNo(String categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getCategoryNo() {
        return categoryNo;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setAbbv(String abbv) {
        this.abbv = abbv;
    }

    public String getAbbv() {
        return abbv;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("categoryId" , getCategoryId())
                .append("fatherId" , getFatherId())
                .append("categoryNo" , getCategoryNo())
                .append("category" , getCategory())
                .append("abbv" , getAbbv())
                .append("tag" , getTag())
                .append("memo" , getMemo())
                .toString();
    }
}
