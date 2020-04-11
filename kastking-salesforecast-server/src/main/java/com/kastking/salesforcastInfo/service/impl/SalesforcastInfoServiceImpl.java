package com.kastking.salesforcastInfo.service.impl;

import java.util.Date;
import java.util.List;

import com.kastking.salesforcastInfo.domain.SalesforcastDemanda;
import com.kastking.salesforcastInfo.domain.SalesforcastInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.salesforcastInfo.mapper.SalesforcastInfoMapper;
import com.kastking.salesforcastInfo.service.SalesforcastInfoService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 销量预计信息Service业务层处理
 *
 * @author Michael
 * @date 2020-02-14
 */
@Service
public class SalesforcastInfoServiceImpl implements SalesforcastInfoService {
    private static final Logger log = LoggerFactory.getLogger(SalesforcastInfoServiceImpl.class);

    @Autowired
    private SalesforcastInfoMapper salesforcastInfoMapper;

    @Override
    public int review(int anti, Integer salesforcastInfoId, String person) {
        return salesforcastInfoMapper.review(anti, salesforcastInfoId, person);
    }

    @Override
    public List<SalesforcastDemanda> listSalesforcastSales(SalesforcastDemanda salesforcastDemanda) {
        return salesforcastInfoMapper.listSalesforcastSales(salesforcastDemanda);
    }

    /**
     * 销量预计需求量报表
     *
     * @return
     */
    @Override
    public List<SalesforcastDemanda> listSalesforcastDemand(SalesforcastDemanda salesforcastDemanda) {
        return salesforcastInfoMapper.listSalesforcastDemand(salesforcastDemanda);
    }

    /**
     * 生成销量预计
     *
     * @param period
     * @return
     */
    @Override
    public int generateSalesEstimates(Date period) {
        return salesforcastInfoMapper.generateSalesEstimates(period);
    }

    /**
     * 查询销量预计信息
     *
     * @param salesforcastInfoId 销量预计信息ID
     * @return 销量预计信息
     */
    @Override
    public SalesforcastInfo selectSalesforcastInfoById(Long salesforcastInfoId) {
        return salesforcastInfoMapper.selectSalesforcastInfoById(salesforcastInfoId);
    }

    /**
     * 查询销量预计信息列表
     *
     * @param salesforcastInfo 销量预计信息
     * @return 销量预计信息
     */
    @Override
    public List<SalesforcastInfo> selectSalesforcastInfoList(SalesforcastInfo salesforcastInfo) {
        return salesforcastInfoMapper.selectSalesforcastInfoList(salesforcastInfo);
    }

    /**
     * 新增销量预计信息
     *
     * @param salesforcastInfo 销量预计信息
     * @return 结果
     */
    @Override
    public int insertSalesforcastInfo(SalesforcastInfo salesforcastInfo) {
        return salesforcastInfoMapper.insertSalesforcastInfo(salesforcastInfo);
    }

    /**
     * 修改销量预计信息
     *
     * @param salesforcastInfo 销量预计信息
     * @return 结果
     */
    @Override
    public int updateSalesforcastInfo(SalesforcastInfo salesforcastInfo) {
        return salesforcastInfoMapper.updateSalesforcastInfo(salesforcastInfo);
    }

    /**
     * 删除销量预计信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSalesforcastInfoByIds(String ids) {
        return salesforcastInfoMapper.deleteSalesforcastInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除销量预计信息信息
     *
     * @param salesforcastInfoId 销量预计信息ID
     * @return 结果
     */
    @Override
    public int deleteSalesforcastInfoById(Long salesforcastInfoId) {
        return salesforcastInfoMapper.deleteSalesforcastInfoById(salesforcastInfoId);
    }

    /**
     * 导入销量预计信息数据
     *
     * @param salesforcastInfoList 销量预计信息数据列表
     * @param isUpdateSupport      是否更新支持，如果已存在，则进行更新数据
     * @param operName             操作用户
     * @return 结果
     */
    public String importSalesforcastInfo(List<SalesforcastInfo> salesforcastInfoList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(salesforcastInfoList) || salesforcastInfoList.size() == 0) {
            throw new BusinessException("导入销量预计信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (SalesforcastInfo salesforcastInfo : salesforcastInfoList) {
            try {
                StringBuilder forecastMonthMsg = new StringBuilder(salesforcastInfo.getForecastMonth());
                forecastMonthMsg.append("-01");
                salesforcastInfo.setForecastMonth(forecastMonthMsg.toString());
                salesforcastInfo.setPeriod("2020-03-01");
                int res = this.updateSalesforcastInfo(salesforcastInfo);
                if (res < 1) {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、导入失败/已审核");
                } else {
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、导入成功");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
