package com.kastking.platformChannel.mapper;

import com.kastking.platformChannel.domain.PlatformChannel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 平台站点Mapper接口
 *
 * @author Michael
 * @date 2020-02-06
 */
public interface PlatformChannelMapper {

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
     * @param salesman 业务员
     * @return ID
     */
    public Integer selectSalesmanId(@Param("salesman") String salesman, @Param("channel") String channel);

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
     * 删除平台站点
     *
     * @param platformChannelId 平台站点ID
     * @return 结果
     */
    public int deletePlatformChannelById(Long platformChannelId);

    /**
     * 批量删除平台站点
     *
     * @param platformChannelIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePlatformChannelByIds(String[] platformChannelIds);
}
