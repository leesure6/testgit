package com.sure.zerotoone.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sure.zerotoone.model.entity.InterfaceInfo;


/**
* @author Administrator
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-11-27 16:35:36
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

}
