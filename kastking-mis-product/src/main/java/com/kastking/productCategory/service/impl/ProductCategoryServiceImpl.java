package com.kastking.productCategory.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.kastking.common.core.domain.Ztree;
import com.kastking.productCategory.domain.ProductCategory;
import com.kastking.productCategory.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.productCategory.service.ProductCategoryService;
import com.kastking.common.core.text.Convert;

/**
 * 产品类目Service业务层处理
 *
 * @author Michael
 * @date 2020-01-16
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    /**
     * 查询是否有子产品
     *
     * @param categoryId
     * @return
     */
    @Override
    public Integer selectIsProductCategory(Long categoryId) {
        return productCategoryMapper.selectIsProductCategory(categoryId);
    }

    /**
     * 查询产品类目
     *
     * @param categoryId 产品类目ID
     * @return 产品类目
     */
    @Override
    public ProductCategory selectProductCategoryById(Long categoryId) {
        return productCategoryMapper.selectProductCategoryById(categoryId);
    }

    /**
     * 查询产品类目列表
     *
     * @param productCategory 产品类目
     * @return 产品类目
     */
    @Override
    public List<ProductCategory> selectProductCategoryList(ProductCategory productCategory) {
        return productCategoryMapper.selectProductCategoryList(productCategory);
    }

    /**
     * 新增产品类目
     *
     * @param productCategory 产品类目
     * @return 结果
     */
    @Override
    public int insertProductCategory(ProductCategory productCategory) {
        return productCategoryMapper.insertProductCategory(productCategory);
    }

    /**
     * 修改产品类目
     *
     * @param productCategory 产品类目
     * @return 结果
     */
    @Override
    public int updateProductCategory(ProductCategory productCategory) {
        return productCategoryMapper.updateProductCategory(productCategory);
    }

    /**
     * 删除产品类目对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProductCategoryByIds(String ids) {
        return productCategoryMapper.deleteProductCategoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品类目信息
     *
     * @param categoryId 产品类目ID
     * @return 结果
     */
    @Override
    public int deleteProductCategoryById(Long categoryId) {
        if (this.selectIsProductCategory(categoryId) != null)
            return -1;
        return productCategoryMapper.deleteProductCategoryById(categoryId);
    }

    /**
     * 查询产品类目树列表
     *
     * @return 所有产品类目信息
     */
    @Override
    public List<Ztree> selectProductCategoryTree() {
        List<ProductCategory> productCategoryList = productCategoryMapper.selectProductCategoryList(new ProductCategory());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (ProductCategory productCategory : productCategoryList) {
            Ztree ztree = new Ztree();
            ztree.setId(productCategory.getCategoryId());
            ztree.setpId(productCategory.getFatherId());
            ztree.setName(productCategory.getCategory());
            ztree.setTitle(productCategory.getCategory());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
