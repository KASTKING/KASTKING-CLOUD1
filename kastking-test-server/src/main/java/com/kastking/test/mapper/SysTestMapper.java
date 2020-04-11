package com.kastking.test.mapper;



import com.kastking.test.domain.SysTest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 测试Mapper接口
 *
 * @author Michael
 * @date 2020-01-19
 */
@Mapper
@Repository
public interface SysTestMapper {
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
     * 删除测试
     *
     * @param id 测试ID
     * @return 结果
     */
    public int deleteSysTestById(Long id);

    /**
     * 批量删除测试
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysTestByIds(String[] ids);
}
