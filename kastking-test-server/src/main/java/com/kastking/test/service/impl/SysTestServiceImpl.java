package com.kastking.test.service.impl;


import com.kastking.test.domain.SysTest;
import com.kastking.test.mapper.SysTestMapper;
import com.kastking.test.service.ISysTestService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.exception.BusinessException;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试Service业务层处理
 *
 * @author Michael
 * @date 2020-01-19
 */
@Service
public class SysTestServiceImpl implements ISysTestService {
    private static final Logger log = LoggerFactory.getLogger(SysTestServiceImpl.class);

    @Autowired
    private SysTestMapper sysTestMapper;

    /**
     * 查询测试
     *
     * @param id 测试ID
     * @return 测试
     */
    @Override
    public SysTest selectSysTestById(Long id) {
        return sysTestMapper.selectSysTestById(id);
    }

    /**
     * 查询测试列表
     *
     * @param sysTest 测试
     * @return 测试
     */
    @Override
    public List<SysTest> selectSysTestList(SysTest sysTest) {
        return sysTestMapper.selectSysTestList(sysTest);
    }

    /**
     * 新增测试
     *
     * @param sysTest 测试
     * @return 结果
     */
    @Override
    public int insertSysTest(SysTest sysTest) {
        return sysTestMapper.insertSysTest(sysTest);
    }

    /**
     * 修改测试
     *
     * @param sysTest 测试
     * @return 结果
     */
    @Override
    public int updateSysTest(SysTest sysTest) {
        return sysTestMapper.updateSysTest(sysTest);
    }

    /**
     * 删除测试对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysTestByIds(String ids) {
        return sysTestMapper.deleteSysTestByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除测试信息
     *
     * @param id 测试ID
     * @return 结果
     */
    @Override
    public int deleteSysTestById(Long id) {
        return sysTestMapper.deleteSysTestById(id);
    }

    /**
     * 导入测试数据
     *
     * @param sysTestList     测试数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    public String importSysTest(List<SysTest> sysTestList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(sysTestList) || sysTestList.size() == 0) {
            throw new BusinessException("导入测试数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (SysTest sysTest : sysTestList) {
            try {
                this.insertSysTest(sysTest);
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
