package com.kastking.productTransportInfo.service.impl;

import java.util.HashMap;
import java.util.List;

import com.kastking.productTransportInfo.domain.ProductTransportInfo;
import com.kastking.productTransportInfo.mapper.ProductTransportInfoMapper;
import com.kastking.platformChannel.service.PlatformChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.kastking.productTransportInfo.service.ProductTransportInfoService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 商品运输属性Service业务层处理
 *
 * @author Michael
 * @date 2020-02-07
 */
@Service
public class ProductTransportInfoServiceImpl implements ProductTransportInfoService {
    private static final Logger log = LoggerFactory.getLogger(ProductTransportInfoServiceImpl.class);

    @Autowired
    private ProductTransportInfoMapper productTransportInfoMapper;
    @Autowired
    private PlatformChannelService platformChannelService;

    /**
     * 查询商品运输属性
     *
     * @param transportInfoId 商品运输属性ID
     * @return 商品运输属性
     */
    @Override
    public ProductTransportInfo selectProductTransportInfoById(Long transportInfoId) {
        return productTransportInfoMapper.selectProductTransportInfoById(transportInfoId);
    }

    /**
     * 查询商品运输属性列表
     *
     * @param productTransportInfo 商品运输属性
     * @return 商品运输属性
     */
    @Override
    public List<ProductTransportInfo> selectProductTransportInfoList(ProductTransportInfo productTransportInfo) {
        return productTransportInfoMapper.selectProductTransportInfoList(productTransportInfo);
    }

    /**
     * 新增商品运输属性
     *
     * @param productTransportInfo 商品运输属性
     * @return 结果
     */
    @Override
    public HashMap<String, Object> insertProductTransportInfo(ProductTransportInfo productTransportInfo) {
        HashMap<String, Object> hashMap = new HashMap();
        try {
            if (platformChannelService.selectSku(productTransportInfo.getSku()) == null) {
                hashMap.put("success" , false);
                hashMap.put("message" , "SKU在产品档案不存在");
            } else {
                int i = productTransportInfoMapper.insertProductTransportInfo(productTransportInfo);
                if (i > 0) {
                    hashMap.put("success" , true);
                    hashMap.put("message" , "新增成功");
                } else {
                    hashMap.put("success" , false);
                    hashMap.put("message" , "新增失败");
                }
            }
        } catch (DuplicateKeyException e) {
            hashMap.put("success" , false);
            hashMap.put("message" , "SKU已存在");
        }
        return hashMap;
    }

    /**
     * 修改商品运输属性
     *
     * @param productTransportInfo 商品运输属性
     * @return 结果
     */
    @Override
    public int updateProductTransportInfo(ProductTransportInfo productTransportInfo) {
        return productTransportInfoMapper.updateProductTransportInfo(productTransportInfo);
    }

    /**
     * 删除商品运输属性对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProductTransportInfoByIds(String ids) {
        return productTransportInfoMapper.deleteProductTransportInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品运输属性信息
     *
     * @param transportInfoId 商品运输属性ID
     * @return 结果
     */
    @Override
    public int deleteProductTransportInfoById(Long transportInfoId) {
        return productTransportInfoMapper.deleteProductTransportInfoById(transportInfoId);
    }

    /**
     * 导入商品运输属性数据
     *
     * @param productTransportInfoList 商品运输属性数据列表
     * @param isUpdateSupport          是否更新支持，如果已存在，则进行更新数据
     * @param operName                 操作用户
     * @return 结果
     */
    public String importProductTransportInfo(List<ProductTransportInfo> productTransportInfoList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(productTransportInfoList) || productTransportInfoList.size() == 0) {
            throw new BusinessException("导入商品运输属性数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ProductTransportInfo productTransportInfo : productTransportInfoList) {
            try {
                HashMap hashMap = this.insertProductTransportInfo(productTransportInfo);
                if (Boolean.valueOf(hashMap.get("success").toString())) {
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、导入成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、" + hashMap.get("message"));
                }
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
