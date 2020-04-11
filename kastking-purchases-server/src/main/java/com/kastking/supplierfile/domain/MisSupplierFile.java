package com.kastking.supplierfile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 供应商凭证对象 mis_supplier_file
 *
 * @author James
 * @date 2020-02-26
 */
public class MisSupplierFile extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long certificateId;

    /**
     * 父ID
     */
    private Long fatherId;

    /**
     * 所属类型
     */
    @Excel(name = "所属类型")
    private String type;

    /**
     * 父级名称
     */
    @Excel(name = "父级名称")
    private String fatherName;

    /**
     * 文件名称
     */
    @Excel(name = "文件名称")
    private String caption;

    /**
     * 文件类型
     */
    @Excel(name = "文件类型")
    private String types;

    /**
     * 文件大小
     */
    @Excel(name = "文件大小")
    private Double size;

    /**
     * 凭证&amp;附件
     */
    @Excel(name = "凭证&amp;附件路径")
    private String annex;

    /**
     * CreateDate
     */
    //@Excel(name = "CreateDate", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /**
     * UpdateDate
     */
    //@Excel(name = "UpdateDate", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    public String getTypes() {
        return types;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public Long getCertificateId() {
        return certificateId;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    public Long getFatherId() {
        return fatherId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setAnnex(String annex) {
        this.annex = annex;
    }

    public String getAnnex() {
        return annex;
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
                .append("certificateId" , getCertificateId())
                .append("fatherId" , getFatherId())
                .append("type" , getType())
                .append("annex" , getAnnex())
                .append("createDate" , getCreateDate())
                .append("updateDate" , getUpdateDate())
                .toString();
    }
}
