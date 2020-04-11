package com.kastking.testTree.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.kastking.common.core.domain.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.testTree.mapper.SysTestTreeMapper;
import com.kastking.testTree.domain.SysTestTree;
import com.kastking.testTree.service.ISysTestTreeService;
import com.kastking.common.core.text.Convert;

/**
 * 树测试Service业务层处理
 *
 * @author Michael
 * @date 2020-01-14
 */
@Service
public class SysTestTreeServiceImpl implements ISysTestTreeService {
    @Autowired
    private SysTestTreeMapper sysTestTreeMapper;

    /**
     * 查询树测试
     *
     * @param treeId 树测试ID
     * @return 树测试
     */
    @Override
    public SysTestTree selectSysTestTreeById(Long treeId) {
        return sysTestTreeMapper.selectSysTestTreeById(treeId);
    }

    /**
     * 查询树测试列表
     *
     * @param sysTestTree 树测试
     * @return 树测试
     */
    @Override
    public List<SysTestTree> selectSysTestTreeList(SysTestTree sysTestTree) {
        return sysTestTreeMapper.selectSysTestTreeList(sysTestTree);
    }

    /**
     * 新增树测试
     *
     * @param sysTestTree 树测试
     * @return 结果
     */
    @Override
    public int insertSysTestTree(SysTestTree sysTestTree) {
        return sysTestTreeMapper.insertSysTestTree(sysTestTree);
    }

    /**
     * 修改树测试
     *
     * @param sysTestTree 树测试
     * @return 结果
     */
    @Override
    public int updateSysTestTree(SysTestTree sysTestTree) {
        return sysTestTreeMapper.updateSysTestTree(sysTestTree);
    }

    /**
     * 删除树测试对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysTestTreeByIds(String ids) {
        return sysTestTreeMapper.deleteSysTestTreeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除树测试信息
     *
     * @param treeId 树测试ID
     * @return 结果
     */
    @Override
    public int deleteSysTestTreeById(Long treeId) {
        return sysTestTreeMapper.deleteSysTestTreeById(treeId);
    }

    /**
     * 查询树测试树列表
     *
     * @return 所有树测试信息
     */
    @Override
    public List<Ztree> selectSysTestTreeTree() {
        List<SysTestTree> sysTestTreeList = sysTestTreeMapper.selectSysTestTreeList(new SysTestTree());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SysTestTree sysTestTree : sysTestTreeList) {
            Ztree ztree = new Ztree();
            ztree.setId(sysTestTree.getTreeId());
            ztree.setpId(sysTestTree.getParentId());
            ztree.setName(sysTestTree.getTreeName());
            ztree.setTitle(sysTestTree.getTreeName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
