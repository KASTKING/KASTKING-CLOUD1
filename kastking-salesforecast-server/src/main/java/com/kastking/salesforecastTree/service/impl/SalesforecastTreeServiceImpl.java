package com.kastking.salesforecastTree.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.kastking.common.core.domain.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.salesforecastTree.mapper.SalesforecastTreeMapper;
import com.kastking.salesforecastTree.domain.SalesforecastTree;
import com.kastking.salesforecastTree.service.ISalesforecastTreeService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 销量预计数菜单Service业务层处理
 *
 * @author Michael
 * @date 2020-02-18
 */
@Service
public class SalesforecastTreeServiceImpl implements ISalesforecastTreeService {
    private static final Logger log = LoggerFactory.getLogger(SalesforecastTreeServiceImpl.class);

    @Autowired
    private SalesforecastTreeMapper salesforecastTreeMapper;

    /**
     * 查询销量预计数菜单
     *
     * @param treeId 销量预计数菜单ID
     * @return 销量预计数菜单
     */
    @Override
    public SalesforecastTree selectSalesforecastTreeById(Long treeId) {
        return salesforecastTreeMapper.selectSalesforecastTreeById(treeId);
    }

    /**
     * 查询销量预计数菜单列表
     *
     * @param salesforecastTree 销量预计数菜单
     * @return 销量预计数菜单
     */
    @Override
    public List<SalesforecastTree> selectSalesforecastTreeList(SalesforecastTree salesforecastTree) {
        return salesforecastTreeMapper.selectSalesforecastTreeList(salesforecastTree);
    }

    /**
     * 新增销量预计数菜单
     *
     * @param salesforecastTree 销量预计数菜单
     * @return 结果
     */
    @Override
    public int insertSalesforecastTree(SalesforecastTree salesforecastTree) {
        return salesforecastTreeMapper.insertSalesforecastTree(salesforecastTree);
    }

    /**
     * 修改销量预计数菜单
     *
     * @param salesforecastTree 销量预计数菜单
     * @return 结果
     */
    @Override
    public int updateSalesforecastTree(SalesforecastTree salesforecastTree) {
        return salesforecastTreeMapper.updateSalesforecastTree(salesforecastTree);
    }

    /**
     * 删除销量预计数菜单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSalesforecastTreeByIds(String ids) {
        return salesforecastTreeMapper.deleteSalesforecastTreeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除销量预计数菜单信息
     *
     * @param treeId 销量预计数菜单ID
     * @return 结果
     */
    @Override
    public int deleteSalesforecastTreeById(Long treeId) {
        return salesforecastTreeMapper.deleteSalesforecastTreeById(treeId);
    }

    /**
     * 查询销量预计数菜单树列表
     *
     * @return 所有销量预计数菜单信息
     */
    @Override
    public List<Ztree> selectSalesforecastTreeTree() {
        List<SalesforecastTree> salesforecastTreeList = salesforecastTreeMapper.selectSalesforecastTreeList(new SalesforecastTree());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SalesforecastTree salesforecastTree : salesforecastTreeList) {
            Ztree ztree = new Ztree();
            ztree.setId(salesforecastTree.getTreeId());
            ztree.setpId(salesforecastTree.getParentId());
            ztree.setName(salesforecastTree.getTreeName());
            ztree.setTitle(salesforecastTree.getTreeName());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    /**
     * 导入销量预计数菜单数据
     *
     * @param salesforecastTreeList 销量预计数菜单数据列表
     * @param isUpdateSupport       是否更新支持，如果已存在，则进行更新数据
     * @param operName              操作用户
     * @return 结果
     */
    public String importSalesforecastTree(List<SalesforecastTree> salesforecastTreeList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(salesforecastTreeList) || salesforecastTreeList.size() == 0) {
            throw new BusinessException("导入销量预计数菜单数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (SalesforecastTree salesforecastTree : salesforecastTreeList) {
            try {
                this.insertSalesforecastTree(salesforecastTree);
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
