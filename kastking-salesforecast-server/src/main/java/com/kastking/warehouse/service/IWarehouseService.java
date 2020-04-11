package com.kastking.warehouse.service;

import com.kastking.warehouse.domain.Warehouse;

import java.util.List;

/**
 * 仓库Service接口
 *
 * @author Michael
 * @date 2020-02-28
 */
public interface IWarehouseService {
    /**
     * 查询仓库
     *
     * @param warehouseId 仓库ID
     * @return 仓库
     */
    public Warehouse selectWarehouseById(Long warehouseId);

    /**
     * 查询仓库列表
     *
     * @param warehouse 仓库
     * @return 仓库集合
     */
    public List<Warehouse> selectWarehouseList(Warehouse warehouse);

    /**
     * 新增仓库
     *
     * @param warehouse 仓库
     * @return 结果
     */
    public int insertWarehouse(Warehouse warehouse);

    /**
     * 修改仓库
     *
     * @param warehouse 仓库
     * @return 结果
     */
    public int updateWarehouse(Warehouse warehouse);

    /**
     * 批量删除仓库
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWarehouseByIds(String ids);

    /**
     * 删除仓库信息
     *
     * @param warehouseId 仓库ID
     * @return 结果
     */
    public int deleteWarehouseById(Long warehouseId);

    /**
     * 导入仓库数据
     *
     * @param warehouseList   仓库数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    public String importWarehouse(List<Warehouse> warehouseList, Boolean isUpdateSupport, String operName);

}
