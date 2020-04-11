package com.kastking.warehouse.service.impl;

import java.util.List;

import com.kastking.warehouse.domain.WarehouseWay;
import com.kastking.warehouse.mapper.WarehouseWayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.warehouse.service.IWarehouseWayService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 仓库在途Service业务层处理
 *
 * @author Michael
 * @date 2020-03-06
 */
@Service
public class WarehouseWayServiceImpl implements IWarehouseWayService {
    private static final Logger log = LoggerFactory.getLogger(WarehouseWayServiceImpl.class);

    @Autowired
    private WarehouseWayMapper warehouseWayMapper;

    /**
     * 查询仓库在途
     *
     * @param wayId 仓库在途ID
     * @return 仓库在途
     */
    @Override
    public WarehouseWay selectWarehouseWayById(Long wayId) {
        return warehouseWayMapper.selectWarehouseWayById(wayId);
    }

    /**
     * 查询仓库在途列表
     *
     * @param warehouseWay 仓库在途
     * @return 仓库在途
     */
    @Override
    public List<WarehouseWay> selectWarehouseWayList(WarehouseWay warehouseWay) {
        return warehouseWayMapper.selectWarehouseWayList(warehouseWay);
    }

    /**
     * 新增仓库在途
     *
     * @param warehouseWay 仓库在途
     * @return 结果
     */
    @Override
    public int insertWarehouseWay(WarehouseWay warehouseWay) {
        return warehouseWayMapper.insertWarehouseWay(warehouseWay);
    }

    /**
     * 修改仓库在途
     *
     * @param warehouseWay 仓库在途
     * @return 结果
     */
    @Override
    public int updateWarehouseWay(WarehouseWay warehouseWay) {
        return warehouseWayMapper.updateWarehouseWay(warehouseWay);
    }

    /**
     * 删除仓库在途对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWarehouseWayByIds(String ids) {
        return warehouseWayMapper.deleteWarehouseWayByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除仓库在途信息
     *
     * @param wayId 仓库在途ID
     * @return 结果
     */
    @Override
    public int deleteWarehouseWayById(Long wayId) {
        return warehouseWayMapper.deleteWarehouseWayById(wayId);
    }

    /**
     * 导入仓库在途数据
     *
     * @param warehouseWayList 仓库在途数据列表
     * @param isUpdateSupport  是否更新支持，如果已存在，则进行更新数据
     * @param operName         操作用户
     * @return 结果
     */
    public String importWarehouseWay(List<WarehouseWay> warehouseWayList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(warehouseWayList) || warehouseWayList.size() == 0) {
            throw new BusinessException("导入仓库在途数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (WarehouseWay warehouseWay : warehouseWayList) {
            try {
                this.insertWarehouseWay(warehouseWay);
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
