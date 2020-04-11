package com.kastking.supplierProduct.service.impl;

import java.util.Date;
import java.util.List;

import com.kastking.historicalPrice.domain.MisSupplierHistoricalPrice;
import com.kastking.historicalPrice.mapper.MisSupplierHistoricalPriceMapper;
import com.kastking.productLadder.domain.MisSupplierProductLadder;
import com.kastking.productLadder.mapper.MisSupplierProductLadderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.supplierProduct.mapper.MisSupplierProductMapper;
import com.kastking.supplierProduct.domain.MisSupplierProduct;
import com.kastking.supplierProduct.service.IMisSupplierProductService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 供应商产品Service业务层处理
 *
 * @author James
 * @date 2020-02-07
 */
@Service
public class MisSupplierProductServiceImpl implements IMisSupplierProductService {
    private static final Logger log = LoggerFactory.getLogger(MisSupplierProductServiceImpl.class);

    @Autowired
    private MisSupplierProductMapper misSupplierProductMapper;
    @Autowired
    private MisSupplierProductLadderMapper productLadderMapper;
    @Autowired
    private MisSupplierHistoricalPriceMapper priceMapper;

    /**
     * 查询供应商产品
     *
     * @param productId 供应商产品ID
     * @return 供应商产品
     */
    @Override
    public MisSupplierProduct selectMisSupplierProductById(Long productId) {
        return misSupplierProductMapper.selectMisSupplierProductById(productId);
    }

    /**
     * 查询供应商产品列表
     *
     * @param misSupplierProduct 供应商产品
     * @return 供应商产品
     */
    @Override
    public List<MisSupplierProduct> selectMisSupplierProductList(MisSupplierProduct misSupplierProduct) {
        return misSupplierProductMapper.selectMisSupplierProductList(misSupplierProduct);
    }

    /**
     * 新增供应商产品
     *
     * @param misSupplierProduct 供应商产品
     * @return 结果
     */
    @Override
    public int insertMisSupplierProduct(MisSupplierProduct misSupplierProduct) {
        //判断SKU是否重复
        if (this.verificationSku(misSupplierProduct) != null) {
            return 0;
        } else {
            //新增产品对象
            misSupplierProductMapper.insertMisSupplierProduct(misSupplierProduct);
            if (misSupplierProduct.getStr1() != null && !"".equals(misSupplierProduct.getStr1()) && !"-/".equals(misSupplierProduct.getStr1())) {
                // 1 - 2 / 3
                //阶梯价对象
                MisSupplierProductLadder misSupplierProductLadder = new MisSupplierProductLadder();
                //价格1
                String str1 = misSupplierProduct.getStr1().substring(0, misSupplierProduct.getStr1().indexOf("-"));
                //价格2
                String str2 = misSupplierProduct.getStr1().substring(str1.length() + 1, misSupplierProduct.getStr1().length());
                String str2s = str2.substring(0, str2.indexOf("/"));
                //单价
                String str3 = str2.substring(str2s.length() + 1, str2.length());
                misSupplierProductLadder.setPriceOne(Double.valueOf(str1));
                misSupplierProductLadder.setPriceTwo(Double.valueOf(str2s));
                misSupplierProductLadder.setUnitPrice(Double.valueOf(str3));
                misSupplierProductLadder.setProductId(misSupplierProduct.getProductId());
                productLadderMapper.insertMisSupplierProductLadder(misSupplierProductLadder);
            }
            if (misSupplierProduct.getStr2() != null && !"".equals(misSupplierProduct.getStr2())) {
                // 1 - 2 / 3
                //阶梯价对象
                MisSupplierProductLadder misSupplierProductLadder = new MisSupplierProductLadder();
                //价格1
                String str1 = misSupplierProduct.getStr2().substring(0, misSupplierProduct.getStr2().indexOf("-"));
                //价格2
                String str2 = misSupplierProduct.getStr2().substring(str1.length() + 1, misSupplierProduct.getStr2().length());
                String str2s = str2.substring(0, str2.indexOf("/"));
                //单价
                String str3 = str2.substring(str2s.length() + 1, str2.length());
                misSupplierProductLadder.setPriceOne(Double.valueOf(str1));
                misSupplierProductLadder.setPriceTwo(Double.valueOf(str2s));
                misSupplierProductLadder.setUnitPrice(Double.valueOf(str3));
                misSupplierProductLadder.setProductId(misSupplierProduct.getProductId());
                productLadderMapper.insertMisSupplierProductLadder(misSupplierProductLadder);
            }
            if (misSupplierProduct.getStr3() != null && !"".equals(misSupplierProduct.getStr3())) {
                // 1 - 2 / 3
                //阶梯价对象
                MisSupplierProductLadder misSupplierProductLadder = new MisSupplierProductLadder();
                //价格1
                String str1 = misSupplierProduct.getStr3().substring(0, misSupplierProduct.getStr3().indexOf("-"));
                //价格2
                String str2 = misSupplierProduct.getStr3().substring(str1.length() + 1, misSupplierProduct.getStr3().length());
                String str2s = str2.substring(0, str2.indexOf("/"));
                //单价
                String str3 = str2.substring(str2s.length() + 1, str2.length());
                misSupplierProductLadder.setPriceOne(Double.valueOf(str1));
                misSupplierProductLadder.setPriceTwo(Double.valueOf(str2s));
                misSupplierProductLadder.setUnitPrice(Double.valueOf(str3));
                misSupplierProductLadder.setProductId(misSupplierProduct.getProductId());
                productLadderMapper.insertMisSupplierProductLadder(misSupplierProductLadder);
            }
            if (misSupplierProduct.getStr4() != null && !"".equals(misSupplierProduct.getStr4())) {
                // 1 - 2 / 3
                //阶梯价对象
                MisSupplierProductLadder misSupplierProductLadder = new MisSupplierProductLadder();
                //价格1
                String str1 = misSupplierProduct.getStr4().substring(0, misSupplierProduct.getStr4().indexOf("-"));
                //价格2
                String str2 = misSupplierProduct.getStr4().substring(str1.length() + 1, misSupplierProduct.getStr4().length());
                String str2s = str2.substring(0, str2.indexOf("/"));
                //单价
                String str3 = str2.substring(str2s.length() + 1, str2.length());
                misSupplierProductLadder.setPriceOne(Double.valueOf(str1));
                misSupplierProductLadder.setPriceTwo(Double.valueOf(str2s));
                misSupplierProductLadder.setUnitPrice(Double.valueOf(str3));
                misSupplierProductLadder.setProductId(misSupplierProduct.getProductId());
                productLadderMapper.insertMisSupplierProductLadder(misSupplierProductLadder);
            }
            if (misSupplierProduct.getStr5() != null && !"".equals(misSupplierProduct.getStr5())) {
                // 1 - 2 / 3
                //阶梯价对象
                MisSupplierProductLadder misSupplierProductLadder = new MisSupplierProductLadder();
                //价格1
                String str1 = misSupplierProduct.getStr5().substring(0, misSupplierProduct.getStr5().indexOf("-"));
                //价格2
                String str2 = misSupplierProduct.getStr5().substring(str1.length() + 1, misSupplierProduct.getStr5().length());
                String str2s = str2.substring(0, str2.indexOf("/"));
                //单价
                String str3 = str2.substring(str2s.length() + 1, str2.length());
                misSupplierProductLadder.setPriceOne(Double.valueOf(str1));
                misSupplierProductLadder.setPriceTwo(Double.valueOf(str2s));
                misSupplierProductLadder.setUnitPrice(Double.valueOf(str3));
                misSupplierProductLadder.setProductId(misSupplierProduct.getProductId());
                productLadderMapper.insertMisSupplierProductLadder(misSupplierProductLadder);
            }
            return 1;
        }
    }

    /**
     * 修改供应商产品
     *
     * @param misSupplierProduct 供应商产品
     * @return 结果
     */
    @Override
    public int updateMisSupplierProduct(MisSupplierProduct misSupplierProduct) {
        //判断SKU是否重复
        if (this.verificationSku(misSupplierProduct) != null) {
            return 0;
        } else {
            //未修改产品对象
            MisSupplierProduct product = misSupplierProductMapper.selectMisSupplierProductById(misSupplierProduct.getProductId());
            //判断单价是否修改
            if (!product.getNoUnitPrice().equals(misSupplierProduct.getNoUnitPrice()) || !product.getCurrency().equals(misSupplierProduct.getTaxPoint()) || !product.getCurrency().equals(misSupplierProduct.getCurrency())) {
                //历史价对象
                MisSupplierHistoricalPrice price = new MisSupplierHistoricalPrice();
                //未修改产品对象ID
                price.setProductId(product.getProductId());
                //修改产品对象币种
                price.setCurrency(misSupplierProduct.getCurrency());
                //当前时间
                price.setCurrentTime(new Date());
                //修改税点
                price.setTaxPoint(misSupplierProduct.getTaxPoint());
                //未修改产品对象不含税价格
                price.setLastNoPrice(product.getNoUnitPrice());
                //未修改产品对象含税价格
                price.setLastPrice(product.getUnitPrice());
                //未修改税点
                price.setLastTax(product.getTaxPoint());
                //当前产品对象不含税价格
                price.setCurrentNoPrice(misSupplierProduct.getNoUnitPrice());
                //当前产品对象含税价格
                price.setCurrentPrice(misSupplierProduct.getNoUnitPrice());
                //未修改产品对象修改时间
                price.setLastTime(product.getUpdateDate());
                //新增历史价对象
                priceMapper.insertMisSupplierHistoricalPrice(price);
            }

            //修改产品对象
            misSupplierProductMapper.updateMisSupplierProduct(misSupplierProduct);
            //根据产品ID删除阶梯价对象
            productLadderMapper.deleteMisSupplierProductLadderByHeadId(misSupplierProduct.getProductId());
            if (misSupplierProduct.getStr1() != null && !"".equals(misSupplierProduct.getStr1()) && !"-/".equals(misSupplierProduct.getStr1())) {
                // 1 - 2 / 3
                //新建阶梯价对象
                MisSupplierProductLadder misSupplierProductLadder = new MisSupplierProductLadder();
                //价格1
                String str1 = misSupplierProduct.getStr1().substring(0, misSupplierProduct.getStr1().indexOf("-"));
                //价格2
                String str2 = misSupplierProduct.getStr1().substring(str1.length() + 1, misSupplierProduct.getStr1().length());
                String str2s = str2.substring(0, str2.indexOf("/"));
                //单价
                String str3 = str2.substring(str2s.length() + 1, str2.length());
                misSupplierProductLadder.setPriceOne(Double.valueOf(str1));
                misSupplierProductLadder.setPriceTwo(Double.valueOf(str2s));
                misSupplierProductLadder.setUnitPrice(Double.valueOf(str3));
                misSupplierProductLadder.setProductId(misSupplierProduct.getProductId());
                productLadderMapper.insertMisSupplierProductLadder(misSupplierProductLadder);
            }
            if (misSupplierProduct.getStr2() != null && !"".equals(misSupplierProduct.getStr2())) {
                // 1 - 2 / 3
                //新建阶梯价对象
                MisSupplierProductLadder misSupplierProductLadder = new MisSupplierProductLadder();
                //价格1
                String str1 = misSupplierProduct.getStr2().substring(0, misSupplierProduct.getStr2().indexOf("-"));
                //价格2
                String str2 = misSupplierProduct.getStr2().substring(str1.length() + 1, misSupplierProduct.getStr2().length());
                String str2s = str2.substring(0, str2.indexOf("/"));
                //单价
                String str3 = str2.substring(str2s.length() + 1, str2.length());
                misSupplierProductLadder.setPriceOne(Double.valueOf(str1));
                misSupplierProductLadder.setPriceTwo(Double.valueOf(str2s));
                misSupplierProductLadder.setUnitPrice(Double.valueOf(str3));
                misSupplierProductLadder.setProductId(misSupplierProduct.getProductId());
                productLadderMapper.insertMisSupplierProductLadder(misSupplierProductLadder);
            }
            if (misSupplierProduct.getStr3() != null && !"".equals(misSupplierProduct.getStr3())) {
                // 1 - 2 / 3
                //新建阶梯价对象
                MisSupplierProductLadder misSupplierProductLadder = new MisSupplierProductLadder();
                //价格1
                String str1 = misSupplierProduct.getStr3().substring(0, misSupplierProduct.getStr3().indexOf("-"));
                //价格2
                String str2 = misSupplierProduct.getStr3().substring(str1.length() + 1, misSupplierProduct.getStr3().length());
                String str2s = str2.substring(0, str2.indexOf("/"));
                //单价
                String str3 = str2.substring(str2s.length() + 1, str2.length());
                misSupplierProductLadder.setPriceOne(Double.valueOf(str1));
                misSupplierProductLadder.setPriceTwo(Double.valueOf(str2s));
                misSupplierProductLadder.setUnitPrice(Double.valueOf(str3));
                misSupplierProductLadder.setProductId(misSupplierProduct.getProductId());
                productLadderMapper.insertMisSupplierProductLadder(misSupplierProductLadder);
            }
            if (misSupplierProduct.getStr4() != null && !"".equals(misSupplierProduct.getStr4())) {
                // 1 - 2 / 3
                //新建阶梯价对象
                MisSupplierProductLadder misSupplierProductLadder = new MisSupplierProductLadder();
                //价格1
                String str1 = misSupplierProduct.getStr4().substring(0, misSupplierProduct.getStr4().indexOf("-"));
                //价格2
                String str2 = misSupplierProduct.getStr4().substring(str1.length() + 1, misSupplierProduct.getStr4().length());
                String str2s = str2.substring(0, str2.indexOf("/"));
                //单价
                String str3 = str2.substring(str2s.length() + 1, str2.length());
                misSupplierProductLadder.setPriceOne(Double.valueOf(str1));
                misSupplierProductLadder.setPriceTwo(Double.valueOf(str2s));
                misSupplierProductLadder.setUnitPrice(Double.valueOf(str3));
                misSupplierProductLadder.setProductId(misSupplierProduct.getProductId());
                productLadderMapper.insertMisSupplierProductLadder(misSupplierProductLadder);
            }
            if (misSupplierProduct.getStr5() != null && !"".equals(misSupplierProduct.getStr5())) {
                // 1 - 2 / 3
                //新建阶梯价对象
                MisSupplierProductLadder misSupplierProductLadder = new MisSupplierProductLadder();
                //价格1
                String str1 = misSupplierProduct.getStr5().substring(0, misSupplierProduct.getStr5().indexOf("-"));
                //价格2
                String str2 = misSupplierProduct.getStr5().substring(str1.length() + 1, misSupplierProduct.getStr5().length());
                String str2s = str2.substring(0, str2.indexOf("/"));
                //单价
                String str3 = str2.substring(str2s.length() + 1, str2.length());
                misSupplierProductLadder.setPriceOne(Double.valueOf(str1));
                misSupplierProductLadder.setPriceTwo(Double.valueOf(str2s));
                misSupplierProductLadder.setUnitPrice(Double.valueOf(str3));
                misSupplierProductLadder.setProductId(misSupplierProduct.getProductId());
                productLadderMapper.insertMisSupplierProductLadder(misSupplierProductLadder);
            }
            return 1;
        }
    }

    /**
     * 删除供应商产品对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMisSupplierProductByIds(String ids) {
        return misSupplierProductMapper.deleteMisSupplierProductByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应商产品信息
     *
     * @param productId 供应商产品ID
     * @return 结果
     */
    @Override
    public int deleteMisSupplierProductById(Long productId) {
        //删除产品对象同时删除阶梯价
        //productLadderMapper.deleteMisSupplierProductLadderByHeadId(productId);
        return misSupplierProductMapper.deleteMisSupplierProductById(productId);
    }


    /**
     * 导入供应商产品数据
     *
     * @param misSupplierProductList 供应商产品数据列表
     * @param isUpdateSupport        是否更新支持，如果已存在，则进行更新数据
     * @param operName               操作用户
     * @return 结果
     */
    public String importMisSupplierProduct(List<MisSupplierProduct> misSupplierProductList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(misSupplierProductList) || misSupplierProductList.size() == 0) {
            throw new BusinessException("导入供应商产品数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (MisSupplierProduct misSupplierProduct : misSupplierProductList) {
            try {
                //判断是否修改还是新增
                if (isUpdateSupport) {
                    if (this.verificationSku(misSupplierProduct) != null) {
                        //根据SKU唯一查找产品ID
                        misSupplierProduct.setProductId(this.verificationSku(misSupplierProduct));
                        //修改产品对象
                        if (this.updateMisSupplierProduct(misSupplierProduct) > 0) {
                            successNum++;
                            successMsg.append("<br/>" + successNum + "、导入修改成功");
                        }
                    }
                } else {
                    //判断SKU是否唯一
                    if (this.verificationSku(misSupplierProduct) != null) {
                        failureNum++;
                        String msg = "<br/>" + failureNum + "、导入失败：";
                        failureMsg.append(msg + "SKU重复");
                    } else {
                        if (this.insertMisSupplierProduct(misSupplierProduct) > 0) {
                            successNum++;
                            successMsg.append("<br/>" + successNum + "、导入新增成功");
                        }
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

    @Override
    public Long verificationSku(MisSupplierProduct misSupplierProduct) {
        //判断SKU唯一
        return misSupplierProductMapper.verificationSku(misSupplierProduct);
    }
}
