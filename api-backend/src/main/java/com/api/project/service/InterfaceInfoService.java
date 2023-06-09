package com.api.project.service;


import com.api.common.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author kk
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-04-10 12:43:36
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {


    /**
     * 校验
     *
     * @param interfaceInfo
     * @param add 是否为创建校验
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

}
