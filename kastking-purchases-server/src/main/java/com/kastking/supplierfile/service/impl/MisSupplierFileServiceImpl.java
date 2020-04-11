package com.kastking.supplierfile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.supplierfile.mapper.MisSupplierFileMapper;
import com.kastking.supplierfile.domain.MisSupplierFile;
import com.kastking.supplierfile.service.IMisSupplierFileService;
import com.kastking.common.core.text.Convert;
import com.kastking.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kastking.common.exception.BusinessException;

/**
 * 供应商凭证Service业务层处理
 *
 * @author James
 * @date 2020-02-26
 */
@Service
public class MisSupplierFileServiceImpl implements IMisSupplierFileService {
    private static final Logger log = LoggerFactory.getLogger(MisSupplierFileServiceImpl.class);

    @Autowired
    private MisSupplierFileMapper misSupplierFileMapper;

    /**
     * 查询供应商凭证
     *
     * @param certificateId 供应商凭证ID
     * @return 供应商凭证
     */
    @Override
    public MisSupplierFile selectMisSupplierFileById(Long certificateId) {
        return misSupplierFileMapper.selectMisSupplierFileById(certificateId);
    }

    /**
     * 查询供应商凭证列表
     *
     * @param misSupplierFile 供应商凭证
     * @return 供应商凭证
     */
    @Override
    public List<MisSupplierFile> selectMisSupplierFileList(MisSupplierFile misSupplierFile) {
        return misSupplierFileMapper.selectMisSupplierFileList(misSupplierFile);
    }

    /**
     * 新增供应商凭证
     *
     * @param misSupplierFile 供应商凭证
     * @return 结果
     */
    @Override
    public int insertMisSupplierFile(MisSupplierFile misSupplierFile) {
        return misSupplierFileMapper.insertMisSupplierFile(misSupplierFile);
    }

    /**
     * 修改供应商凭证
     *
     * @param misSupplierFile 供应商凭证
     * @return 结果
     */
    @Override
    public int updateMisSupplierFile(MisSupplierFile misSupplierFile) {
        return misSupplierFileMapper.updateMisSupplierFile(misSupplierFile);
    }

    /**
     * 删除供应商凭证对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMisSupplierFileByIds(String ids) {
        return misSupplierFileMapper.deleteMisSupplierFileByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应商凭证信息
     *
     * @param certificateId 供应商凭证ID
     * @return 结果
     */
    @Override
    public int deleteMisSupplierFileById(Long certificateId) {
        return misSupplierFileMapper.deleteMisSupplierFileById(certificateId);
    }

    /**
     * 导入供应商凭证数据
     *
     * @param misSupplierFileList 供应商凭证数据列表
     * @param isUpdateSupport     是否更新支持，如果已存在，则进行更新数据
     * @param operName            操作用户
     * @return 结果
     */
    public String importMisSupplierFile(List<MisSupplierFile> misSupplierFileList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(misSupplierFileList) || misSupplierFileList.size() == 0) {
            throw new BusinessException("导入供应商凭证数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (MisSupplierFile misSupplierFile : misSupplierFileList) {
            try {
                this.insertMisSupplierFile(misSupplierFile);
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
