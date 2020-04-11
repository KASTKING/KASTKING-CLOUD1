package com.kastking.productLadder.service.impl;

import java.util.List;

import com.kastking.productLadder.domain.MisSupplierProductLadder;
import com.kastking.productLadder.mapper.MisSupplierProductLadderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.productLadder.service.IMisSupplierProductLadderService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 供应商产品阶梯价Service业务层处理
 *
 * @author James
 * @date 2020-02-14
 */
@Service
public class MisSupplierProductLadderServiceImpl implements IMisSupplierProductLadderService {
    private static final Logger log = LoggerFactory.getLogger(MisSupplierProductLadderServiceImpl.class);

    @Autowired
    private MisSupplierProductLadderMapper misSupplierProductLadderMapper;

    /**
     * 查询供应商产品阶梯价
     *
     * @param stepId 供应商产品阶梯价ID
     * @return 供应商产品阶梯价
     */
    @Override
    public MisSupplierProductLadder selectMisSupplierProductLadderById(Long stepId) {
        return misSupplierProductLadderMapper.selectMisSupplierProductLadderById(stepId);
    }

    /**
     * 查询供应商产品阶梯价列表
     *
     * @param misSupplierProductLadder 供应商产品阶梯价
     * @return 供应商产品阶梯价
     */
    @Override
    public List<MisSupplierProductLadder> selectMisSupplierProductLadderList(MisSupplierProductLadder misSupplierProductLadder) {
        return misSupplierProductLadderMapper.selectMisSupplierProductLadderList(misSupplierProductLadder);
    }

    /**
     * 新增供应商产品阶梯价
     *
     * @param misSupplierProductLadder 供应商产品阶梯价
     * @return 结果
     */
    @Override
    public int insertMisSupplierProductLadder(MisSupplierProductLadder misSupplierProductLadder) {
        return misSupplierProductLadderMapper.insertMisSupplierProductLadder(misSupplierProductLadder);
    }

    /**
     * 修改供应商产品阶梯价
     *
     * @param misSupplierProductLadder 供应商产品阶梯价
     * @return 结果
     */
    @Override
    public int updateMisSupplierProductLadder(MisSupplierProductLadder misSupplierProductLadder) {
        return misSupplierProductLadderMapper.updateMisSupplierProductLadder(misSupplierProductLadder);
    }

    /**
     * 删除供应商产品阶梯价对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMisSupplierProductLadderByIds(String ids) {
        return misSupplierProductLadderMapper.deleteMisSupplierProductLadderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应商产品阶梯价信息
     *
     * @param stepId 供应商产品阶梯价ID
     * @return 结果
     */
    @Override
    public int deleteMisSupplierProductLadderById(Long stepId) {
        return misSupplierProductLadderMapper.deleteMisSupplierProductLadderById(stepId);
    }

    /**
     * 导入供应商产品阶梯价数据
     *
     * @param misSupplierProductLadderList 供应商产品阶梯价数据列表
     * @param isUpdateSupport              是否更新支持，如果已存在，则进行更新数据
     * @param operName                     操作用户
     * @return 结果
     */
    public String importMisSupplierProductLadder(List<MisSupplierProductLadder> misSupplierProductLadderList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(misSupplierProductLadderList) || misSupplierProductLadderList.size() == 0) {
            throw new BusinessException("导入供应商产品阶梯价数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (MisSupplierProductLadder misSupplierProductLadder : misSupplierProductLadderList) {
            try {
                this.insertMisSupplierProductLadder(misSupplierProductLadder);
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
