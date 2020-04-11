package com.kastking.salesforecastTree.mapper;

import com.kastking.salesforecastTree.domain.SalesforecastTree;

import java.util.List;

/**
 * 销量预计数菜单Mapper接口
 *
 * @author Michael
 * @date 2020-02-18
 */
public interface SalesforecastTreeMapper {
    /**
     * 查询销量预计数菜单
     *
     * @param treeId 销量预计数菜单ID
     * @return 销量预计数菜单
     */
    public SalesforecastTree selectSalesforecastTreeById(Long treeId);

    /**
     * 查询销量预计数菜单列表
     *
     * @param salesforecastTree 销量预计数菜单
     * @return 销量预计数菜单集合
     */
    public List<SalesforecastTree> selectSalesforecastTreeList(SalesforecastTree salesforecastTree);

    /**
     * 新增销量预计数菜单
     *
     * @param salesforecastTree 销量预计数菜单
     * @return 结果
     */
    public int insertSalesforecastTree(SalesforecastTree salesforecastTree);

    /**
     * 修改销量预计数菜单
     *
     * @param salesforecastTree 销量预计数菜单
     * @return 结果
     */
    public int updateSalesforecastTree(SalesforecastTree salesforecastTree);

    /**
     * 删除销量预计数菜单
     *
     * @param treeId 销量预计数菜单ID
     * @return 结果
     */
    public int deleteSalesforecastTreeById(Long treeId);

    /**
     * 批量删除销量预计数菜单
     *
     * @param treeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSalesforecastTreeByIds(String[] treeIds);
}
