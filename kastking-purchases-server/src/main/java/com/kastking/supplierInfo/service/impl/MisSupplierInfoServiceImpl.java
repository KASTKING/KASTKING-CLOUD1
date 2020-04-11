package com.kastking.supplierInfo.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.kastking.common.core.domain.Ztree;
import com.kastking.supplierInfo.domain.MisSupplierInfo;
import com.kastking.supplierInfo.mapper.MisSupplierInfoMapper;
import com.kastking.supplierInfo.service.IMisSupplierInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kastking.common.core.text.Convert;

/**
 * 供应商信息Service业务层处理
 *
 * @author James
 * @date 2020-02-07
 */
@Service
public class MisSupplierInfoServiceImpl implements IMisSupplierInfoService {
    @Autowired
    private MisSupplierInfoMapper misSupplierInfoMapper;

    /**
     * 查询供应商信息
     *
     * @param supplierId 供应商信息ID
     * @return 供应商信息
     */
    @Override
    public MisSupplierInfo selectMisSupplierInfoById(Long supplierId) {
        return misSupplierInfoMapper.selectMisSupplierInfoById(supplierId);
    }

    /**
     * 查询供应商信息列表
     *
     * @param misSupplierInfo 供应商信息
     * @return 供应商信息
     */
    @Override
    public List<MisSupplierInfo> selectMisSupplierInfoList(MisSupplierInfo misSupplierInfo) {
        return misSupplierInfoMapper.selectMisSupplierInfoList(misSupplierInfo);
    }

    /**
     * 新增供应商信息
     *
     * @param misSupplierInfo 供应商信息
     * @return 结果
     */
    @Override
    public int insertMisSupplierInfo(MisSupplierInfo misSupplierInfo) {
        if (this.verificationBuyer(misSupplierInfo) != null) {
            return 0;
        } else {
            return misSupplierInfoMapper.insertMisSupplierInfo(misSupplierInfo);
        }
    }

    /**
     * 修改供应商信息
     *
     * @param misSupplierInfo 供应商信息
     * @return 结果
     */
    @Override
    public int updateMisSupplierInfo(MisSupplierInfo misSupplierInfo) {
        if (this.verificationBuyer(misSupplierInfo) != null) {
            return 0;
        } else {
            return misSupplierInfoMapper.updateMisSupplierInfo(misSupplierInfo);
        }
    }

    /**
     * 删除供应商信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMisSupplierInfoByIds(String ids) {
        return misSupplierInfoMapper.deleteMisSupplierInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应商信息信息
     *
     * @param supplierId 供应商信息ID
     * @return 结果
     */
    @Override
    public int deleteMisSupplierInfoById(Long supplierId) {
        return misSupplierInfoMapper.deleteMisSupplierInfoById(supplierId);
    }

    /**
     * 查询供应商信息树列表
     *
     * @return 所有供应商信息信息
     */
    @Override
    public List<Ztree> selectMisSupplierInfoTree() {
        List<MisSupplierInfo> misSupplierInfoList = misSupplierInfoMapper.selectMisSupplierInfoList(new MisSupplierInfo());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (MisSupplierInfo misSupplierInfo : misSupplierInfoList) {
            Ztree ztree = new Ztree();
            ztree.setId(misSupplierInfo.getSupplierId());
            ztree.setpId(misSupplierInfo.getFatherId());
            ztree.setName(misSupplierInfo.getBuyer());
            ztree.setTitle(misSupplierInfo.getBuyer());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    @Override
    public Long verificationBuyer(MisSupplierInfo misSupplierInfo) {
        return misSupplierInfoMapper.verificationBuyer(misSupplierInfo);
    }
}
