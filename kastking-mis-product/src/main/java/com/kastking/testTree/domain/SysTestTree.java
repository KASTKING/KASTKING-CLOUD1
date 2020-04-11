package com.kastking.testTree.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.TreeEntity;

/**
 * 树测试对象 sys_test_tree
 *
 * @author Michael
 * @date 2020-01-14
 */
public class SysTestTree extends TreeEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 树ID
     */
    private Long treeId;

    /**
     * 父ID
     */
    @Excel(name = "父ID")
    private Long parentId;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String treeName;

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Long getTreeId() {
        return treeId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String getTreeName() {
        return treeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("treeId" , getTreeId())
                .append("parentId" , getParentId())
                .append("treeName" , getTreeName())
                .toString();
    }
}
