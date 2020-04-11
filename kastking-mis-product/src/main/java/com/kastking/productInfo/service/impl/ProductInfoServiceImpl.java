package com.kastking.productInfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.productInfo.mapper.ProductInfoMapper;
import com.kastking.productInfo.domain.ProductInfo;
import com.kastking.productInfo.service.ProductInfoService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 产品信息Service业务层处理
 *
 * @author Michael
 * @date 2020-01-18
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    private static final Logger log = LoggerFactory.getLogger(ProductInfoServiceImpl.class);

    @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
     * 查询产品信息
     *
     * @param productId 产品信息ID
     * @return 产品信息
     */
    @Override
    public ProductInfo selectProductInfoById(Long productId) {
        return productInfoMapper.selectProductInfoById(productId);
    }

    /**
     * 查询产品信息列表
     *
     * @param productInfo 产品信息
     * @return 产品信息
     */
    @Override
    public List<ProductInfo> selectProductInfoList(ProductInfo productInfo) {
        return productInfoMapper.selectProductInfoList(productInfo);
    }

    /**
     * 新增产品信息
     *
     * @param productInfo 产品信息
     * @return 结果
     */
    @Override
    public int insertProductInfo(ProductInfo productInfo) {
        return productInfoMapper.insertProductInfo(productInfo);
    }

    /**
     * 修改产品信息
     *
     * @param productInfo 产品信息
     * @return 结果
     */
    @Override
    public int updateProductInfo(ProductInfo productInfo) {
        return productInfoMapper.updateProductInfo(productInfo);
    }

    /**
     * 删除产品信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProductInfoByIds(String ids) {
        return productInfoMapper.deleteProductInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品信息信息
     *
     * @param productId 产品信息ID
     * @return 结果
     */
    @Override
    public int deleteProductInfoById(Long productId) {
        return productInfoMapper.deleteProductInfoById(productId);
    }

    /**
     * 导入产品信息数据
     *
     * @param productInfoList 产品信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    public String importProductInfo(List<ProductInfo> productInfoList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(productInfoList) || productInfoList.size() == 0) {
            throw new BusinessException("导入产品信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ProductInfo productInfo : productInfoList) {
            try {
                this.insertProductInfo(productInfo);
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
