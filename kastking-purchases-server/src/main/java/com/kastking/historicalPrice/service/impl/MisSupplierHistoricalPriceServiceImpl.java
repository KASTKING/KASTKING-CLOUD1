package com.kastking.historicalPrice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.historicalPrice.mapper.MisSupplierHistoricalPriceMapper;
import com.kastking.historicalPrice.domain.MisSupplierHistoricalPrice;
import com.kastking.historicalPrice.service.IMisSupplierHistoricalPriceService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 供应商产品历史价格Service业务层处理
 *
 * @author James
 * @date 2020-02-19
 */
@Service
public class MisSupplierHistoricalPriceServiceImpl implements IMisSupplierHistoricalPriceService {
    private static final Logger log = LoggerFactory.getLogger(MisSupplierHistoricalPriceServiceImpl.class);

    @Autowired
    private MisSupplierHistoricalPriceMapper misSupplierHistoricalPriceMapper;

    /**
     * 查询供应商产品历史价格
     *
     * @param priceId 供应商产品历史价格ID
     * @return 供应商产品历史价格
     */
    @Override
    public MisSupplierHistoricalPrice selectMisSupplierHistoricalPriceById(Long priceId) {
        return misSupplierHistoricalPriceMapper.selectMisSupplierHistoricalPriceById(priceId);
    }

    /**
     * 查询供应商产品历史价格列表
     *
     * @param misSupplierHistoricalPrice 供应商产品历史价格
     * @return 供应商产品历史价格
     */
    @Override
    public List<MisSupplierHistoricalPrice> selectMisSupplierHistoricalPriceList(MisSupplierHistoricalPrice misSupplierHistoricalPrice) {
        return misSupplierHistoricalPriceMapper.selectMisSupplierHistoricalPriceList(misSupplierHistoricalPrice);
    }

    /**
     * 新增供应商产品历史价格
     *
     * @param misSupplierHistoricalPrice 供应商产品历史价格
     * @return 结果
     */
    @Override
    public int insertMisSupplierHistoricalPrice(MisSupplierHistoricalPrice misSupplierHistoricalPrice) {
        return misSupplierHistoricalPriceMapper.insertMisSupplierHistoricalPrice(misSupplierHistoricalPrice);
    }

    /**
     * 修改供应商产品历史价格
     *
     * @param misSupplierHistoricalPrice 供应商产品历史价格
     * @return 结果
     */
    @Override
    public int updateMisSupplierHistoricalPrice(MisSupplierHistoricalPrice misSupplierHistoricalPrice) {
        return misSupplierHistoricalPriceMapper.updateMisSupplierHistoricalPrice(misSupplierHistoricalPrice);
    }

    /**
     * 删除供应商产品历史价格对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMisSupplierHistoricalPriceByIds(String ids) {
        return misSupplierHistoricalPriceMapper.deleteMisSupplierHistoricalPriceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应商产品历史价格信息
     *
     * @param priceId 供应商产品历史价格ID
     * @return 结果
     */
    @Override
    public int deleteMisSupplierHistoricalPriceById(Long priceId) {
        return misSupplierHistoricalPriceMapper.deleteMisSupplierHistoricalPriceById(priceId);
    }

    /**
     * 导入供应商产品历史价格数据
     *
     * @param misSupplierHistoricalPriceList 供应商产品历史价格数据列表
     * @param isUpdateSupport                是否更新支持，如果已存在，则进行更新数据
     * @param operName                       操作用户
     * @return 结果
     */
    public String importMisSupplierHistoricalPrice(List<MisSupplierHistoricalPrice> misSupplierHistoricalPriceList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(misSupplierHistoricalPriceList) || misSupplierHistoricalPriceList.size() == 0) {
            throw new BusinessException("导入供应商产品历史价格数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (MisSupplierHistoricalPrice misSupplierHistoricalPrice : misSupplierHistoricalPriceList) {
            try {
                this.insertMisSupplierHistoricalPrice(misSupplierHistoricalPrice);
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
