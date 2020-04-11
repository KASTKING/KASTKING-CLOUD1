package com.kastking.salesForecastMom.service;

import com.kastking.salesForecastMom.domain.SalesforecastMom;

import java.util.List;

/**
 * 销量预计MOMService接口
 *
 * @author Michael
 * @date 2020-02-14
 */
public interface ISalesforecastMomService {
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
     * 批量删除销量预计MOM
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSalesforecastMomByIds(String ids);

    /**
     * 删除销量预计MOM信息
     *
     * @param salesforecastMomId 销量预计MOMID
     * @return 结果
     */
    public int deleteSalesforecastMomById(Long salesforecastMomId);

    /**
     * 导入销量预计MOM数据
     *
     * @param salesforecastMomList 销量预计MOM数据列表
     * @param isUpdateSupport      是否更新支持，如果已存在，则进行更新数据
     * @param operName             操作用户
     * @return 结果
     */
    public String importSalesforecastMom(List<SalesforecastMom> salesforecastMomList, Boolean isUpdateSupport, String operName);

}
