package com.kastking.salesForecastMom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.salesForecastMom.mapper.SalesforecastMomMapper;
import com.kastking.salesForecastMom.domain.SalesforecastMom;
import com.kastking.salesForecastMom.service.ISalesforecastMomService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 销量预计MOMService业务层处理
 *
 * @author Michael
 * @date 2020-02-14
 */
@Service
public class SalesforecastMomServiceImpl implements ISalesforecastMomService {
    private static final Logger log = LoggerFactory.getLogger(SalesforecastMomServiceImpl.class);

    @Autowired
    private SalesforecastMomMapper salesforecastMomMapper;

    /**
     * 查询销量预计MOM
     *
     * @param salesforecastMomId 销量预计MOMID
     * @return 销量预计MOM
     */
    @Override
    public SalesforecastMom selectSalesforecastMomById(Long salesforecastMomId) {
        return salesforecastMomMapper.selectSalesforecastMomById(salesforecastMomId);
    }

    /**
     * 查询销量预计MOM列表
     *
     * @param salesforecastMom 销量预计MOM
     * @return 销量预计MOM
     */
    @Override
    public List<SalesforecastMom> selectSalesforecastMomList(SalesforecastMom salesforecastMom) {
        return salesforecastMomMapper.selectSalesforecastMomList(salesforecastMom);
    }

    /**
     * 新增销量预计MOM
     *
     * @param salesforecastMom 销量预计MOM
     * @return 结果
     */
    @Override
    public int insertSalesforecastMom(SalesforecastMom salesforecastMom) {
        return salesforecastMomMapper.insertSalesforecastMom(salesforecastMom);
    }

    /**
     * 修改销量预计MOM
     *
     * @param salesforecastMom 销量预计MOM
     * @return 结果
     */
    @Override
    public int updateSalesforecastMom(SalesforecastMom salesforecastMom) {
        return salesforecastMomMapper.updateSalesforecastMom(salesforecastMom);
    }

    /**
     * 删除销量预计MOM对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSalesforecastMomByIds(String ids) {
        return salesforecastMomMapper.deleteSalesforecastMomByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除销量预计MOM信息
     *
     * @param salesforecastMomId 销量预计MOMID
     * @return 结果
     */
    @Override
    public int deleteSalesforecastMomById(Long salesforecastMomId) {
        return salesforecastMomMapper.deleteSalesforecastMomById(salesforecastMomId);
    }

    /**
     * 导入销量预计MOM数据
     *
     * @param salesforecastMomList 销量预计MOM数据列表
     * @param isUpdateSupport      是否更新支持，如果已存在，则进行更新数据
     * @param operName             操作用户
     * @return 结果
     */
    public String importSalesforecastMom(List<SalesforecastMom> salesforecastMomList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(salesforecastMomList) || salesforecastMomList.size() == 0) {
            throw new BusinessException("导入销量预计MOM数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (SalesforecastMom salesforecastMom : salesforecastMomList) {
            try {
                this.insertSalesforecastMom(salesforecastMom);
                successNum++;
                successMsg.append("<br/>" + successNum + "、导入成功");
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
