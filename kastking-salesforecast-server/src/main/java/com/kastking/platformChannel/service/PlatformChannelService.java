package com.kastking.platformChannel.service;

import com.kastking.platformChannel.domain.PlatformChannel;

import java.util.List;

import com.kastking.common.core.domain.Ztree;

/**
 * 平台站点Service接口
 *
 * @author Michael
 * @date 2020-02-06
 */
public interface PlatformChannelService {
    /**
     * 查询SKU是在产品档案否存在
     *
     * @param sku
     * @return
     */
    public Integer selectSku(String sku);

    /**
     * 查询业务员ID
     *
     * @param Salesman 业务员
     * @return ID
     */
    public Integer selectSalesmanId(String Salesman, String channel);

    /**
     * 查询平台站点
     *
     * @param platformChannelId 平台站点ID
     * @return 平台站点
     */
    public PlatformChannel selectPlatformChannelById(Long platformChannelId);

    /**
     * 查询平台站点列表
     *
     * @param platformChannel 平台站点
     * @return 平台站点集合
     */
    public List<PlatformChannel> selectPlatformChannelList(PlatformChannel platformChannel);

    /**
     * 新增平台站点
     *
     * @param platformChannel 平台站点
     * @return 结果
     */
    public int insertPlatformChannel(PlatformChannel platformChannel);

    /**
     * 修改平台站点
     *
     * @param platformChannel 平台站点
     * @return 结果
     */
    public int updatePlatformChannel(PlatformChannel platformChannel);

    /**
     * 批量删除平台站点
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePlatformChannelByIds(String ids);

    /**
     * 删除平台站点信息
     *
     * @param platformChannelId 平台站点ID
     * @return 结果
     */
    public int deletePlatformChannelById(Long platformChannelId);

    /**
     * 查询平台站点树列表
     *
     * @return 所有平台站点信息
     */
    public List<Ztree> selectPlatformChannelTree();

    /**
     * 导入平台站点数据
     *
     * @param platformChannelList 平台站点数据列表
     * @param isUpdateSupport     是否更新支持，如果已存在，则进行更新数据
     * @param operName            操作用户
     * @return 结果
     */
    public String importPlatformChannel(List<PlatformChannel> platformChannelList, Boolean isUpdateSupport, String operName);

}
