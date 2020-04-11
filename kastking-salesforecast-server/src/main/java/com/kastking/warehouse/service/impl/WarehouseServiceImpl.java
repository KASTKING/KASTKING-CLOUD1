package com.kastking.warehouse.service.impl;

import java.util.List;

import com.kastking.warehouse.domain.Warehouse;
import com.kastking.warehouse.mapper.WarehouseMapper;
import com.kastking.warehouse.service.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 仓库Service业务层处理
 *
 * @author Michael
 * @date 2020-02-28
 */
@Service
public class WarehouseServiceImpl implements IWarehouseService {
    private static final Logger log = LoggerFactory.getLogger(WarehouseServiceImpl.class);

    @Autowired
    private WarehouseMapper warehouseMapper;

    /**
     * 查询仓库
     *
     * @param warehouseId 仓库ID
     * @return 仓库
     */
    @Override
    public Warehouse selectWarehouseById(Long warehouseId) {
        return warehouseMapper.selectWarehouseById(warehouseId);
    }

    /**
     * 查询仓库列表
     *
     * @param warehouse 仓库
     * @return 仓库
     */
    @Override
    public List<Warehouse> selectWarehouseList(Warehouse warehouse) {
        return warehouseMapper.selectWarehouseList(warehouse);
    }

    /**
     * 新增仓库
     *
     * @param warehouse 仓库
     * @return 结果
     */
    @Override
    public int insertWarehouse(Warehouse warehouse) {
        return warehouseMapper.insertWarehouse(warehouse);
    }

    /**
     * 修改仓库
     *
     * @param warehouse 仓库
     * @return 结果
     */
    @Override
    public int updateWarehouse(Warehouse warehouse) {
        return warehouseMapper.updateWarehouse(warehouse);
    }

    /**
     * 删除仓库对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWarehouseByIds(String ids) {
        return warehouseMapper.deleteWarehouseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除仓库信息
     *
     * @param warehouseId 仓库ID
     * @return 结果
     */
    @Override
    public int deleteWarehouseById(Long warehouseId) {
        return warehouseMapper.deleteWarehouseById(warehouseId);
    }

    /**
     * 导入仓库数据
     *
     * @param warehouseList   仓库数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    public String importWarehouse(List<Warehouse> warehouseList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(warehouseList) || warehouseList.size() == 0) {
            throw new BusinessException("导入仓库数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Warehouse warehouse : warehouseList) {
            try {
                this.insertWarehouse(warehouse);
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
