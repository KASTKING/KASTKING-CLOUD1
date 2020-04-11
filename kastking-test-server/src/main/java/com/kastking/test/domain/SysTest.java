package com.kastking.test.domain;

import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 测试对象 sys_test
 *
 * @author Michael
 * @date 2020-01-19
 */
public class SysTest extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String name;

    /**
     * 类型
     */
    @Excel(name = "类型")
    private String type;

    /**
     * Test ID
     */
    private Long id;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("name" , getName())
                .append("type" , getType())
                .append("id" , getId())
                .toString();
    }
}
