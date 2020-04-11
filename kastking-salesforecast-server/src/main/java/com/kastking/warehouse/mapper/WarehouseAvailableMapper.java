package com.kastking.warehouse.mapper;

import com.kastking.warehouse.domain.WarehouseAvailable;
import com.kastking.warehouse.domain.WarehouseTree;

import java.util.List;

/**
 * 仓库可用Mapper接口
 *
 * @author Michael
 * @date 2020-03-03
 */
public interface WarehouseAvailableMapper {

    /**
     * 查询仓库可用数菜单列表
     *
     * @param warehouseTree
     * @return
     */
    public List<WarehouseTree> selectWarehouseAvailableTreeList(WarehouseTree warehouseTree);

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
     * 删除仓库可用
     *
     * @param availableId 仓库可用ID
     * @return 结果
     */
    public int deleteWarehouseAvailableById(Long availableId);

    /**
     * 批量删除仓库可用
     *
     * @param availableIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteWarehouseAvailableByIds(String[] availableIds);
}
