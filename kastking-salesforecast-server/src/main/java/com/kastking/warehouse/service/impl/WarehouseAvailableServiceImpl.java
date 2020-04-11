package com.kastking.warehouse.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.kastking.common.core.domain.Ztree;
import com.kastking.warehouse.domain.WarehouseAvailable;
import com.kastking.warehouse.domain.WarehouseTree;
import com.kastking.warehouse.mapper.WarehouseAvailableMapper;
import com.kastking.warehouse.service.IWarehouseAvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 仓库可用Service业务层处理
 *
 * @author Michael
 * @date 2020-03-03
 */
@Service
public class WarehouseAvailableServiceImpl implements IWarehouseAvailableService {
    private static final Logger log = LoggerFactory.getLogger(WarehouseAvailableServiceImpl.class);

    @Autowired
    private WarehouseAvailableMapper warehouseAvailableMapper;

    @Override
    public List<Ztree> selectWarehouseAvailableTree() {
        List<WarehouseTree> treeList = warehouseAvailableMapper.selectWarehouseAvailableTreeList(new WarehouseTree());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (WarehouseTree warehouseTree : treeList) {
            Ztree ztree = new Ztree();
            ztree.setId(warehouseTree.getTreeId());
            ztree.setpId(warehouseTree.getParentId());
            ztree.setName(warehouseTree.getTreeName());
            ztree.setTitle(warehouseTree.getTreeName());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    /**
     * 查询仓库可用
     *
     * @param availableId 仓库可用ID
     * @return 仓库可用
     */
    @Override
    public WarehouseAvailable selectWarehouseAvailableById(Long availableId) {
        return warehouseAvailableMapper.selectWarehouseAvailableById(availableId);
    }

    /**
     * 查询仓库可用列表
     *
     * @param warehouseAvailable 仓库可用
     * @return 仓库可用
     */
    @Override
    public List<WarehouseAvailable> selectWarehouseAvailableList(WarehouseAvailable warehouseAvailable) {
        return warehouseAvailableMapper.selectWarehouseAvailableList(warehouseAvailable);
    }

    /**
     * 新增仓库可用
     *
     * @param warehouseAvailable 仓库可用
     * @return 结果
     */
    @Override
    public int insertWarehouseAvailable(WarehouseAvailable warehouseAvailable) {
        return warehouseAvailableMapper.insertWarehouseAvailable(warehouseAvailable);
    }

    /**
     * 修改仓库可用
     *
     * @param warehouseAvailable 仓库可用
     * @return 结果
     */
    @Override
    public int updateWarehouseAvailable(WarehouseAvailable warehouseAvailable) {
        return warehouseAvailableMapper.updateWarehouseAvailable(warehouseAvailable);
    }

    /**
     * 删除仓库可用对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWarehouseAvailableByIds(String ids) {
        return warehouseAvailableMapper.deleteWarehouseAvailableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除仓库可用信息
     *
     * @param availableId 仓库可用ID
     * @return 结果
     */
    @Override
    public int deleteWarehouseAvailableById(Long availableId) {
        return warehouseAvailableMapper.deleteWarehouseAvailableById(availableId);
    }

    /**
     * 导入仓库可用数据
     *
     * @param warehouseAvailableList 仓库可用数据列表
     * @param isUpdateSupport        是否更新支持，如果已存在，则进行更新数据
     * @param operName               操作用户
     * @return 结果
     */
    public String importWarehouseAvailable(List<WarehouseAvailable> warehouseAvailableList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(warehouseAvailableList) || warehouseAvailableList.size() == 0) {
            throw new BusinessException("导入仓库可用数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (WarehouseAvailable warehouseAvailable : warehouseAvailableList) {
            try {
                this.insertWarehouseAvailable(warehouseAvailable);
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
