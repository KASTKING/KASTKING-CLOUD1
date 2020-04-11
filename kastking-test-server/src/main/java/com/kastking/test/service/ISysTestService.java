package com.kastking.test.service;


import com.kastking.test.domain.SysTest;

import java.util.List;

/**
 * 测试Service接口
 *
 * @author Michael
 * @date 2020-01-19
 */
public interface ISysTestService {
    /**
     * 查询测试
     *
     * @param id 测试ID
     * @return 测试
     */
    public SysTest selectSysTestById(Long id);

    /**
     * 查询测试列表
     *
     * @param sysTest 测试
     * @return 测试集合
     */
    public List<SysTest> selectSysTestList(SysTest sysTest);

    /**
     * 新增测试
     *
     * @param sysTest 测试
     * @return 结果
     */
    public int insertSysTest(SysTest sysTest);

    /**
     * 修改测试
     *
     * @param sysTest 测试
     * @return 结果
     */
    public int updateSysTest(SysTest sysTest);

    /**
     * 批量删除测试
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysTestByIds(String ids);

    /**
     * 删除测试信息
     *
     * @param id 测试ID
     * @return 结果
     */
    public int deleteSysTestById(Long id);

    /**
     * 导入测试数据
     *
     * @param sysTestList     测试数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    public String importSysTest(List<SysTest> sysTestList, Boolean isUpdateSupport, String operName);

}
