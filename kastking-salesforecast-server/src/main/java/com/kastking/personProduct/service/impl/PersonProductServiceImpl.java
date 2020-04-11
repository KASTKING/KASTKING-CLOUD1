package com.kastking.personProduct.service.impl;

import java.util.HashMap;
import java.util.List;

import com.kastking.personProduct.domain.PersonProduct;
import com.kastking.personProduct.mapper.PersonProductMapper;
import com.kastking.platformChannel.service.PlatformChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.kastking.personProduct.service.IPersonProductService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 人员产品Service业务层处理
 *
 * @author Michael
 * @date 2020-02-07
 */
@Service
public class PersonProductServiceImpl implements IPersonProductService {
    private static final Logger log = LoggerFactory.getLogger(PersonProductServiceImpl.class);

    @Autowired
    private PersonProductMapper personProductMapper;

    @Autowired
    private PlatformChannelService platformChannelService;

    /**
     * 查询人员产品
     *
     * @param personProductId 人员产品ID
     * @return 人员产品
     */
    @Override
    public PersonProduct selectPersonProductById(Long personProductId) {
        return personProductMapper.selectPersonProductById(personProductId);
    }

    /**
     * 查询人员产品列表
     *
     * @param personProduct 人员产品
     * @return 人员产品
     */
    @Override
    public List<PersonProduct> selectPersonProductList(PersonProduct personProduct) {
        return personProductMapper.selectPersonProductList(personProduct);
    }

    /**
     * 新增人员产品
     *
     * @param personProduct 人员产品
     * @return 结果
     */
    @Override
    public HashMap<String, Object> insertPersonProduct(PersonProduct personProduct) {
        HashMap<String, Object> hashMap = new HashMap();
        try {
            if (platformChannelService.selectSku(personProduct.getSku()) == null) {
                hashMap.put("success" , false);
                hashMap.put("message" , personProduct.getSku() + "在产品档案不存在");
            } else {
                int i = personProductMapper.insertPersonProduct(personProduct);
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
            hashMap.put("message" , personProduct.getSku() + "已存在");
        }
        return hashMap;
    }

    /**
     * 修改人员产品
     *
     * @param personProduct 人员产品
     * @return 结果
     */
    @Override
    public int updatePersonProduct(PersonProduct personProduct) {
        return personProductMapper.updatePersonProduct(personProduct);
    }

    /**
     * 删除人员产品对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePersonProductByIds(String ids) {
        return personProductMapper.deletePersonProductByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人员产品信息
     *
     * @param personProductId 人员产品ID
     * @return 结果
     */
    @Override
    public int deletePersonProductById(Long personProductId) {
        return personProductMapper.deletePersonProductById(personProductId);
    }

    /**
     * 导入人员产品数据
     *
     * @param personProductList 人员产品数据列表
     * @param isUpdateSupport   是否更新支持，如果已存在，则进行更新数据
     * @param operName          操作用户
     * @return 结果
     */
    public String importPersonProduct(List<PersonProduct> personProductList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(personProductList) || personProductList.size() == 0) {
            throw new BusinessException("导入人员产品数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (PersonProduct personProduct : personProductList) {
            try {
                Integer SalesmanId = platformChannelService.selectSalesmanId(personProduct.getSalesman(), personProduct.getChannel());
                if (SalesmanId == null) {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、业务员" + personProduct.getSalesman() + "填写错误");
                } else {
                    personProduct.setPlatformChannelId(Long.valueOf(SalesmanId));
                    HashMap hashMap = this.insertPersonProduct(personProduct);
                    if (Boolean.valueOf(hashMap.get("success").toString())) {
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、导入成功");
                    } else {
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、" + hashMap.get("message"));
                    }
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
