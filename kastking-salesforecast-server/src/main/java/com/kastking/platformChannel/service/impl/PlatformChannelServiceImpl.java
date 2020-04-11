package com.kastking.platformChannel.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.kastking.common.core.domain.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.platformChannel.mapper.PlatformChannelMapper;
import com.kastking.platformChannel.domain.PlatformChannel;
import com.kastking.platformChannel.service.PlatformChannelService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 平台站点Service业务层处理
 *
 * @author Michael
 * @date 2020-02-06
 */
@Service
public class PlatformChannelServiceImpl implements PlatformChannelService {
    private static final Logger log = LoggerFactory.getLogger(PlatformChannelServiceImpl.class);

    @Autowired
    private PlatformChannelMapper platformChannelMapper;

    @Override
    public Integer selectSku(String sku) {
        return platformChannelMapper.selectSku(sku);
    }

    @Override
    public Integer selectSalesmanId(String Salesman, String channel) {
        return platformChannelMapper.selectSalesmanId(Salesman, channel);
    }

    /**
     * 查询平台站点
     *
     * @param platformChannelId 平台站点ID
     * @return 平台站点
     */
    @Override
    public PlatformChannel selectPlatformChannelById(Long platformChannelId) {
        return platformChannelMapper.selectPlatformChannelById(platformChannelId);
    }

    /**
     * 查询平台站点列表
     *
     * @param platformChannel 平台站点
     * @return 平台站点
     */
    @Override
    public List<PlatformChannel> selectPlatformChannelList(PlatformChannel platformChannel) {
        return platformChannelMapper.selectPlatformChannelList(platformChannel);
    }

    /**
     * 新增平台站点
     *
     * @param platformChannel 平台站点
     * @return 结果
     */
    @Override
    public int insertPlatformChannel(PlatformChannel platformChannel) {
        PlatformChannel pc = platformChannelMapper.selectPlatformChannelById(platformChannel.getFatherId());
        platformChannel.setAncestors(pc.getAncestors() + "," + platformChannel.getFatherId());
        return platformChannelMapper.insertPlatformChannel(platformChannel);
    }

    /**
     * 修改平台站点
     *
     * @param platformChannel 平台站点
     * @return 结果
     */
    @Override
    public int updatePlatformChannel(PlatformChannel platformChannel) {
        return platformChannelMapper.updatePlatformChannel(platformChannel);
    }

    /**
     * 删除平台站点对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePlatformChannelByIds(String ids) {
        return platformChannelMapper.deletePlatformChannelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除平台站点信息
     *
     * @param platformChannelId 平台站点ID
     * @return 结果
     */
    @Override
    public int deletePlatformChannelById(Long platformChannelId) {
        return platformChannelMapper.deletePlatformChannelById(platformChannelId);
    }

    /**
     * 查询平台站点树列表
     *
     * @return 所有平台站点信息
     */
    @Override
    public List<Ztree> selectPlatformChannelTree() {
        List<PlatformChannel> platformChannelList = platformChannelMapper.selectPlatformChannelList(new PlatformChannel());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (PlatformChannel platformChannel : platformChannelList) {
            Ztree ztree = new Ztree();
            ztree.setId(platformChannel.getPlatformChannelId());
            ztree.setpId(platformChannel.getFatherId());
            ztree.setName(platformChannel.getPlatformChannel());
            ztree.setTitle(platformChannel.getPlatformChannel());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    /**
     * 导入平台站点数据
     *
     * @param platformChannelList 平台站点数据列表
     * @param isUpdateSupport     是否更新支持，如果已存在，则进行更新数据
     * @param operName            操作用户
     * @return 结果
     */
    public String importPlatformChannel(List<PlatformChannel> platformChannelList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(platformChannelList) || platformChannelList.size() == 0) {
            throw new BusinessException("导入平台站点数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (PlatformChannel platformChannel : platformChannelList) {
            try {
                this.insertPlatformChannel(platformChannel);
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
