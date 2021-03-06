package com.kastking.testTree.mapper;

import com.kastking.testTree.domain.SysTestTree;

import java.util.List;

/**
 * 树测试Mapper接口
 *
 * @author Michael
 * @date 2020-01-14
 */
public interface SysTestTreeMapper {
    /**
     * 查询树测试
     *
     * @param treeId 树测试ID
     * @return 树测试
     */
    public SysTestTree selectSysTestTreeById(Long treeId);

    /**
     * 查询树测试列表
     *
     * @param sysTestTree 树测试
     * @return 树测试集合
     */
    public List<SysTestTree> selectSysTestTreeList(SysTestTree sysTestTree);

    /**
     * 新增树测试
     *
     * @param sysTestTree 树测试
     * @return 结果
     */
    public int insertSysTestTree(SysTestTree sysTestTree);

    /**
     * 修改树测试
     *
     * @param sysTestTree 树测试
     * @return 结果
     */
    public int updateSysTestTree(SysTestTree sysTestTree);

    /**
     * 删除树测试
     *
     * @param treeId 树测试ID
     * @return 结果
     */
    public int deleteSysTestTreeById(Long treeId);

    /**
     * 批量删除树测试
     *
     * @param treeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysTestTreeByIds(String[] treeIds);
}
