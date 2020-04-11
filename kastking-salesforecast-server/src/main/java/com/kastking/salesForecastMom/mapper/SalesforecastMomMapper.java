package com.kastking.salesForecastMom.mapper;

import com.kastking.salesForecastMom.domain.SalesforecastMom;

import java.util.List;

/**
 * 销量预计MOMMapper接口
 *
 * @author Michael
 * @date 2020-02-14
 */
public interface SalesforecastMomMapper {
    /**
     * 查询销量预计MOM
     *
     * @param salesforecastMomId 销量预计MOMID
     * @return 销量预计MOM
     */
    public SalesforecastMom selectSalesforecastMomById(Long salesforecastMomId);

    /**
     * 查询销量预计MOM列表
     *
     * @param salesforecastMom 销量预计MOM
     * @return 销量预计MOM集合
     */
    public List<SalesforecastMom> selectSalesforecastMomList(SalesforecastMom salesforecastMom);

    /**
     * 新增销量预计MOM
     *
     * @param salesforecastMom 销量预计MOM
     * @return 结果
     */
    public int insertSalesforecastMom(SalesforecastMom salesforecastMom);

    /**
     * 修改销量预计MOM
     *
     * @param salesforecastMom 销量预计MOM
     * @return 结果
     */
    public int updateSalesforecastMom(SalesforecastMom salesforecastMom);

    /**
     * 删除销量预计MOM
     *
     * @param salesforecastMomId 销量预计MOMID
     * @return 结果
     */
    public int deleteSalesforecastMomById(Long salesforecastMomId);

    /**
     * 批量删除销量预计MOM
     *
     * @param salesforecastMomIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSalesforecastMomByIds(String[] salesforecastMomIds);
}
