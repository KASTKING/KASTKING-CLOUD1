package com.kastking.productLevel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.productLevel.mapper.ProductLevelMapper;
import com.kastking.productLevel.domain.ProductLevel;
import com.kastking.productLevel.service.IProductLevelService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 产品层级Service业务层处理
 *
 * @author Michael
 * @date 2020-02-15
 */
@Service
public class ProductLevelServiceImpl implements IProductLevelService {
    private static final Logger log = LoggerFactory.getLogger(ProductLevelServiceImpl.class);

    @Autowired
    private ProductLevelMapper productLevelMapper;

    /**
     * 查询产品层级
     *
     * @param productLevelId 产品层级ID
     * @return 产品层级
     */
    @Override
    public ProductLevel selectProductLevelById(Long productLevelId) {
        return productLevelMapper.selectProductLevelById(productLevelId);
    }

    /**
     * 查询产品层级列表
     *
     * @param productLevel 产品层级
     * @return 产品层级
     */
    @Override
    public List<ProductLevel> selectProductLevelList(ProductLevel productLevel) {
        return productLevelMapper.selectProductLevelList(productLevel);
    }

    /**
     * 新增产品层级
     *
     * @param productLevel 产品层级
     * @return 结果
     */
    @Override
    public int insertProductLevel(ProductLevel productLevel) {
        return productLevelMapper.insertProductLevel(productLevel);
    }

    /**
     * 修改产品层级
     *
     * @param productLevel 产品层级
     * @return 结果
     */
    @Override
    public int updateProductLevel(ProductLevel productLevel) {
        return productLevelMapper.updateProductLevel(productLevel);
    }

    /**
     * 删除产品层级对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProductLevelByIds(String ids) {
        return productLevelMapper.deleteProductLevelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品层级信息
     *
     * @param productLevelId 产品层级ID
     * @return 结果
     */
    @Override
    public int deleteProductLevelById(Long productLevelId) {
        return productLevelMapper.deleteProductLevelById(productLevelId);
    }

    /**
     * 导入产品层级数据
     *
     * @param productLevelList 产品层级数据列表
     * @param isUpdateSupport  是否更新支持，如果已存在，则进行更新数据
     * @param operName         操作用户
     * @return 结果
     */
    public String importProductLevel(List<ProductLevel> productLevelList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(productLevelList) || productLevelList.size() == 0) {
            throw new BusinessException("导入产品层级数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ProductLevel productLevel : productLevelList) {
            try {
                this.insertProductLevel(productLevel);
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
