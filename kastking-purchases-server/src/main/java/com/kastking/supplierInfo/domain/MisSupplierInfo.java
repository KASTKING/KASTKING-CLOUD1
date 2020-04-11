package com.kastking.supplierInfo.domain;

import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.TreeEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 供应商信息对象 mis_supplier_info
 *
 * @author James
 * @date 2020-02-07
 */
public class MisSupplierInfo extends TreeEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 供应商ID
     */
    private Long supplierId;

    /**
     * 父ID
     */
    @Excel(name = "父ID")
    private Long fatherId;

    /**
     * 采购员
     */
    @Excel(name = "采购员")
    private String buyer;

    /**
     * 产品性质
     */
    @Excel(name = "产品性质")
    private String productProperties;

    /**
     * 付款属性
     */
    @Excel(name = "付款属性")
    private String paymentAttributes;

    /**
     * 供应商全称
     */
    @Excel(name = "供应商全称")
    private String fullSupplierName;

    /**
     * 供应商编号
     */
    @Excel(name = "供应商编号")
    private String supplierCode;

    /**
     * 结款方式
     */
    @Excel(name = "结款方式")
    private String paymentMethod;

    /**
     * 出货付款
     */
    @Excel(name = "出货付款")
    private String shippingPayment;

    /**
     * 联系人1
     */
    @Excel(name = "联系人1")
    private String contact1;

    /**
     * qq
     */
    @Excel(name = "qq")
    private String qq1;

    /**
     * 手机号码
     */
    @Excel(name = "手机号码")
    private String mobilePhoneNumber1;

    /**
     * 联系人2
     */
    @Excel(name = "联系人2")
    private String contact2;

    /**
     * qq
     */
    @Excel(name = "qq")
    private String qq2;

    /**
     * 手机号码
     */
    @Excel(name = "手机号码")
    private String mobilePhoneNumber2;

    /**
     * 联系人
     */
    @Excel(name = "联系人")
    private String contact3;

    /**
     * qq
     */
    @Excel(name = "qq")
    private String qq3;

    /**
     * 手机号码
     */
    @Excel(name = "手机号码")
    private String mobilePhoneNumber3;

    /**
     * 供应商地址
     */
    @Excel(name = "供应商地址")
    private String supplierAddress;

    /**
     * 收款人(私)
     */
    @Excel(name = "收款人(私)")
    private String payeePrivate;

    /**
     * 收款银行
     */
    @Excel(name = "收款银行")
    private String beneficiaryBankPrivate;

    /**
     * 银行账号
     */
    @Excel(name = "银行账号")
    private String bankAccountPrivate;

    /**
     * 收款人(公)
     */
    @Excel(name = "收款人(公)")
    private String payeePublic;

    /**
     * 收款银行
     */
    @Excel(name = "收款银行")
    private String beneficiaryBankPublic;

    /**
     * 银行账号
     */
    @Excel(name = "银行账号")
    private String bankAccountPublic;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;


    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    public Long getFatherId() {
        return fatherId;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setProductProperties(String productProperties) {
        this.productProperties = productProperties;
    }

    public String getProductProperties() {
        return productProperties;
    }

    public void setPaymentAttributes(String paymentAttributes) {
        this.paymentAttributes = paymentAttributes;
    }

    public String getPaymentAttributes() {
        return paymentAttributes;
    }

    public void setFullSupplierName(String fullSupplierName) {
        this.fullSupplierName = fullSupplierName;
    }

    public String getFullSupplierName() {
        return fullSupplierName;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setShippingPayment(String shippingPayment) {
        this.shippingPayment = shippingPayment;
    }

    public String getShippingPayment() {
        return shippingPayment;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact1() {
        return contact1;
    }

    public void setQq1(String qq1) {
        this.qq1 = qq1;
    }

    public String getQq1() {
        return qq1;
    }

    public void setMobilePhoneNumber1(String mobilePhoneNumber1) {
        this.mobilePhoneNumber1 = mobilePhoneNumber1;
    }

    public String getMobilePhoneNumber1() {
        return mobilePhoneNumber1;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getContact2() {
        return contact2;
    }

    public void setQq2(String qq2) {
        this.qq2 = qq2;
    }

    public String getQq2() {
        return qq2;
    }

    public void setMobilePhoneNumber2(String mobilePhoneNumber2) {
        this.mobilePhoneNumber2 = mobilePhoneNumber2;
    }

    public String getMobilePhoneNumber2() {
        return mobilePhoneNumber2;
    }

    public void setContact3(String contact3) {
        this.contact3 = contact3;
    }

    public String getContact3() {
        return contact3;
    }

    public void setQq3(String qq3) {
        this.qq3 = qq3;
    }

    public String getQq3() {
        return qq3;
    }

    public void setMobilePhoneNumber3(String mobilePhoneNumber3) {
        this.mobilePhoneNumber3 = mobilePhoneNumber3;
    }

    public String getMobilePhoneNumber3() {
        return mobilePhoneNumber3;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setPayeePrivate(String payeePrivate) {
        this.payeePrivate = payeePrivate;
    }

    public String getPayeePrivate() {
        return payeePrivate;
    }

    public void setBeneficiaryBankPrivate(String beneficiaryBankPrivate) {
        this.beneficiaryBankPrivate = beneficiaryBankPrivate;
    }

    public String getBeneficiaryBankPrivate() {
        return beneficiaryBankPrivate;
    }

    public void setBankAccountPrivate(String bankAccountPrivate) {
        this.bankAccountPrivate = bankAccountPrivate;
    }

    public String getBankAccountPrivate() {
        return bankAccountPrivate;
    }

    public void setPayeePublic(String payeePublic) {
        this.payeePublic = payeePublic;
    }

    public String getPayeePublic() {
        return payeePublic;
    }

    public void setBeneficiaryBankPublic(String beneficiaryBankPublic) {
        this.beneficiaryBankPublic = beneficiaryBankPublic;
    }

    public String getBeneficiaryBankPublic() {
        return beneficiaryBankPublic;
    }

    public void setBankAccountPublic(String bankAccountPublic) {
        this.bankAccountPublic = bankAccountPublic;
    }

    public String getBankAccountPublic() {
        return bankAccountPublic;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("supplierId" , getSupplierId())
                .append("fatherId" , getFatherId())
                .append("buyer" , getBuyer())
                .append("productProperties" , getProductProperties())
                .append("paymentAttributes" , getPaymentAttributes())
                .append("fullSupplierName" , getFullSupplierName())
                .append("supplierCode" , getSupplierCode())
                .append("paymentMethod" , getPaymentMethod())
                .append("shippingPayment" , getShippingPayment())
                .append("contact1" , getContact1())
                .append("qq1" , getQq1())
                .append("mobilePhoneNumber1" , getMobilePhoneNumber1())
                .append("contact2" , getContact2())
                .append("qq2" , getQq2())
                .append("mobilePhoneNumber2" , getMobilePhoneNumber2())
                .append("contact3" , getContact3())
                .append("qq3" , getQq3())
                .append("mobilePhoneNumber3" , getMobilePhoneNumber3())
                .append("supplierAddress" , getSupplierAddress())
                .append("payeePrivate" , getPayeePrivate())
                .append("beneficiaryBankPrivate" , getBeneficiaryBankPrivate())
                .append("bankAccountPrivate" , getBankAccountPrivate())
                .append("payeePublic" , getPayeePublic())
                .append("beneficiaryBankPublic" , getBeneficiaryBankPublic())
                .append("bankAccountPublic" , getBankAccountPublic())
                .append("email" , getEmail())
                .append("remark" , getRemark())
                .toString();
    }
}
