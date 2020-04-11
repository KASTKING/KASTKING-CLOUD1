package com.kastking.warehouse.service;

import com.kastking.warehouse.domain.WarehouseWay;

import java.util.List;

/**
 * 仓库在途Service接口
 *
 * @author Michael
 * @date 2020-03-06
 */
public interface IWarehouseWayService {
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
     * 批量删除仓库在途
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWarehouseWayByIds(String ids);

    /**
     * 删除仓库在途信息
     *
     * @param wayId 仓库在途ID
     * @return 结果
     */
    public int deleteWarehouseWayById(Long wayId);

    /**
     * 导入仓库在途数据
     *
     * @param warehouseWayList 仓库在途数据列表
     * @param isUpdateSupport  是否更新支持，如果已存在，则进行更新数据
     * @param operName         操作用户
     * @return 结果
     */
    public String importWarehouseWay(List<WarehouseWay> warehouseWayList, Boolean isUpdateSupport, String operName);

}
