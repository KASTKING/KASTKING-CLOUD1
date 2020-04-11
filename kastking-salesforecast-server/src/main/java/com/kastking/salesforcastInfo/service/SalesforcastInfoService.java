package com.kastking.salesforcastInfo.service;

import com.kastking.salesforcastInfo.domain.SalesforcastDemanda;
import com.kastking.salesforcastInfo.domain.SalesforcastInfo;

import java.util.Date;
import java.util.List;

/**
 * 销量预计信息Service接口
 *
 * @author Michael
 * @date 2020-02-14
 */
public interface SalesforcastInfoService {

    /***
     * 审核
     * @param anti 是否反审核
     * @param salesforcastInfoId
     * @param person
     * @return
     */
    int review(int anti, Integer salesforcastInfoId, String person);

    /**
     * 销量预计销售额报表
     *
     * @return
     */
    List<SalesforcastDemanda> listSalesforcastSales(SalesforcastDemanda salesforcastDemanda);

    /**
     * 销量预计需求量报表
     *
     * @return
     */
    List<SalesforcastDemanda> listSalesforcastDemand(SalesforcastDemanda salesforcastDemanda);

    /**
     * 生成销量预计
     *
     * @param period
     * @return
     */
    public int generateSalesEstimates(Date period);

    /**
     * 查询销量预计信息
     *
     * @param salesforcastInfoId 销量预计信息ID
     * @return 销量预计信息
     */
    public SalesforcastInfo selectSalesforcastInfoById(Long salesforcastInfoId);

    /**
     * 查询销量预计信息列表
     *
     * @param salesforcastInfo 销量预计信息
     * @return 销量预计信息集合
     */
    public List<SalesforcastInfo> selectSalesforcastInfoList(SalesforcastInfo salesforcastInfo);

    /**
     * 新增销量预计信息
     *
     * @param salesforcastInfo 销量预计信息
     * @return 结果
     */
    public int insertSalesforcastInfo(SalesforcastInfo salesforcastInfo);

    /**
     * 修改销量预计信息
     *
     * @param salesforcastInfo 销量预计信息
     * @return 结果
     */
    public int updateSalesforcastInfo(SalesforcastInfo salesforcastInfo);

    /**
     * 批量删除销量预计信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSalesforcastInfoByIds(String ids);

    /**
     * 删除销量预计信息信息
     *
     * @param salesforcastInfoId 销量预计信息ID
     * @return 结果
     */
    public int deleteSalesforcastInfoById(Long salesforcastInfoId);

    /**
     * 导入销量预计信息数据
     *
     * @param salesforcastInfoList 销量预计信息数据列表
     * @param isUpdateSupport      是否更新支持，如果已存在，则进行更新数据
     * @param operName             操作用户
     * @return 结果
     */
    public String importSalesforcastInfo(List<SalesforcastInfo> salesforcastInfoList, Boolean isUpdateSupport, String operName);

}
