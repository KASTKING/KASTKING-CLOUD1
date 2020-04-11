package com.kastking.platformChannel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kastking.common.annotation.Excel;
import com.kastking.common.core.domain.TreeEntity;

/**
 * 平台站点对象 mis_platform_channel
 *
 * @author Michael
 * @date 2020-02-06
 */
public class PlatformChannel extends TreeEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long platformChannelId;

    /**
     * 父ID
     */
    @Excel(name = "父ID")
    private Long fatherId;

    /**
     * 祖级列表
     */
    @Excel(name = "祖级列表")
    private String ancestors;

    /**
     * 平台站点
     */
    @Excel(name = "平台站点")
    private String platformChannel;

    /**
     * 市场ID
     */
    @Excel(name = "市场ID")
    private Integer marketId;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String memo;

    public void setPlatformChannelId(Long platformChannelId) {
        this.platformChannelId = platformChannelId;
    }

    public Long getPlatformChannelId() {
        return platformChannelId;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    public Long getFatherId() {
        return fatherId;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setPlatformChannel(String platformChannel) {
        this.platformChannel = platformChannel;
    }

    public String getPlatformChannel() {
        return platformChannel;
    }

    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    public Integer getMarketId() {
        return marketId;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("platformChannelId" , getPlatformChannelId())
                .append("fatherId" , getFatherId())
                .append("ancestors" , getAncestors())
                .append("platformChannel" , getPlatformChannel())
                .append("marketId" , getMarketId())
                .append("memo" , getMemo())
                .toString();
    }
}
