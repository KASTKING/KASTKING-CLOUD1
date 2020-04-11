package com.kastking.salesforecastTree.service;

import com.kastking.salesforecastTree.domain.SalesforecastTree;

import java.util.List;

import com.kastking.common.core.domain.Ztree;

/**
 * 销量预计数菜单Service接口
 *
 * @author Michael
 * @date 2020-02-18
 */
public interface ISalesforecastTreeService {
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
     * 批量删除销量预计数菜单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSalesforecastTreeByIds(String ids);

    /**
     * 删除销量预计数菜单信息
     *
     * @param treeId 销量预计数菜单ID
     * @return 结果
     */
    public int deleteSalesforecastTreeById(Long treeId);

    /**
     * 查询销量预计数菜单树列表
     *
     * @return 所有销量预计数菜单信息
     */
    public List<Ztree> selectSalesforecastTreeTree();

    /**
     * 导入销量预计数菜单数据
     *
     * @param salesforecastTreeList 销量预计数菜单数据列表
     * @param isUpdateSupport       是否更新支持，如果已存在，则进行更新数据
     * @param operName              操作用户
     * @return 结果
     */
    public String importSalesforecastTree(List<SalesforecastTree> salesforecastTreeList, Boolean isUpdateSupport, String operName);

}
