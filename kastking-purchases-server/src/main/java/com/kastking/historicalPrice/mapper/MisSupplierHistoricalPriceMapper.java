package com.kastking.historicalPrice.mapper;

import com.kastking.historicalPrice.domain.MisSupplierHistoricalPrice;

import java.util.List;

/**
 * 供应商产品历史价格Mapper接口
 *
 * @author James
 * @date 2020-02-19
 */
public interface MisSupplierHistoricalPriceMapper {
    /**
     * 查询供应商产品历史价格
     *
     * @param priceId 供应商产品历史价格ID
     * @return 供应商产品历史价格
     */
    public MisSupplierHistoricalPrice selectMisSupplierHistoricalPriceById(Long priceId);

    /**
     * 查询供应商产品历史价格列表
     *
     * @param misSupplierHistoricalPrice 供应商产品历史价格
     * @return 供应商产品历史价格集合
     */
    public List<MisSupplierHistoricalPrice> selectMisSupplierHistoricalPriceList(MisSupplierHistoricalPrice misSupplierHistoricalPrice);

    /**
     * 新增供应商产品历史价格
     *
     * @param misSupplierHistoricalPrice 供应商产品历史价格
     * @return 结果
     */
    public int insertMisSupplierHistoricalPrice(MisSupplierHistoricalPrice misSupplierHistoricalPrice);

    /**
     * 修改供应商产品历史价格
     *
     * @param misSupplierHistoricalPrice 供应商产品历史价格
     * @return 结果
     */
    public int updateMisSupplierHistoricalPrice(MisSupplierHistoricalPrice misSupplierHistoricalPrice);

    /**
     * 删除供应商产品历史价格
     *
     * @param priceId 供应商产品历史价格ID
     * @return 结果
     */
    public int deleteMisSupplierHistoricalPriceById(Long priceId);

    /**
     * 批量删除供应商产品历史价格
     *
     * @param priceIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMisSupplierHistoricalPriceByIds(String[] priceIds);
}
