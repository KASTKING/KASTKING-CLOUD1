package com.kastking.warehouse.service;

import com.kastking.common.core.domain.Ztree;
import com.kastking.warehouse.domain.WarehouseAvailable;

import java.util.List;

/**
 * 仓库可用Service接口
 *
 * @author Michael
 * @date 2020-03-03
 */
public interface IWarehouseAvailableService {

    /**
     * 查询仓库可用数菜单树列表
     *
     * @return 所有仓库可用数菜单信息
     */
    public List<Ztree> selectWarehouseAvailableTree();

    /**
     * 查询仓库可用
     *
     * @param availableId 仓库可用ID
     * @return 仓库可用
     */
    public WarehouseAvailable selectWarehouseAvailableById(Long availableId);

    /**
     * 查询仓库可用列表
     *
     * @param warehouseAvailable 仓库可用
     * @return 仓库可用集合
     */
    public List<WarehouseAvailable> selectWarehouseAvailableList(WarehouseAvailable warehouseAvailable);

    /**
     * 新增仓库可用
     *
     * @param warehouseAvailable 仓库可用
     * @return 结果
     */
    public int insertWarehouseAvailable(WarehouseAvailable warehouseAvailable);

    /**
     * 修改仓库可用
     *
     * @param warehouseAvailable 仓库可用
     * @return 结果
     */
    public int updateWarehouseAvailable(WarehouseAvailable warehouseAvailable);

    /**
     * 批量删除仓库可用
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWarehouseAvailableByIds(String ids);

    /**
     * 删除仓库可用信息
     *
     * @param availableId 仓库可用ID
     * @return 结果
     */
    public int deleteWarehouseAvailableById(Long availableId);

    /**
     * 导入仓库可用数据
     *
     * @param warehouseAvailableList 仓库可用数据列表
     * @param isUpdateSupport        是否更新支持，如果已存在，则进行更新数据
     * @param operName               操作用户
     * @return 结果
     */
    public String importWarehouseAvailable(List<WarehouseAvailable> warehouseAvailableList, Boolean isUpdateSupport, String operName);

}
