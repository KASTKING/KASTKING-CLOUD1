package com.kastking.warehouse.mapper;

import com.kastking.warehouse.domain.WarehouseWay;

import java.util.List;

/**
 * 仓库在途Mapper接口
 *
 * @author Michael
 * @date 2020-03-06
 */
public interface WarehouseWayMapper {
    /**
     * 查询仓库在途
     *
     * @param wayId 仓库在途ID
     * @return 仓库在途
     */
    public WarehouseWay selectWarehouseWayById(Long wayId);

    /**
     * 查询仓库在途列表
     *
     * @param warehouseWay 仓库在途
     * @return 仓库在途集合
     */
    public List<WarehouseWay> selectWarehouseWayList(WarehouseWay warehouseWay);

    /**
     * 新增仓库在途
     *
     * @param warehouseWay 仓库在途
     * @return 结果
     */
    public int insertWarehouseWay(WarehouseWay warehouseWay);

    /**
     * 修改仓库在途
     *
     * @param warehouseWay 仓库在途
     * @return 结果
     */
    public int updateWarehouseWay(WarehouseWay warehouseWay);

    /**
     * 删除仓库在途
     *
     * @param wayId 仓库在途ID
     * @return 结果
     */
    public int deleteWarehouseWayById(Long wayId);

    /**
     * 批量删除仓库在途
     *
     * @param wayIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteWarehouseWayByIds(String[] wayIds);
}
