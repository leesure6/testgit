package com.sure.zerotoone.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sure.zerotoone.common.ErrorCode;
import com.sure.zerotoone.exception.BusinessException;
import com.sure.zerotoone.mapper.InterfaceInfoMapper;
import com.sure.zerotoone.model.entity.InterfaceInfo;
import com.sure.zerotoone.service.InterfaceInfoService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2024-11-27 16:35:36
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {

        if(interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        if(add) {
            if(StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if(StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }
}




