package com.api.common.service;


import com.api.common.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author kk
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-04-10 12:43:36
*/
public interface InnerInterfaceInfoService {


    /**
     *数据库中查询模拟接口是否存在
     * @param path
     * @param method
     * @return
     */
    InterfaceInfo getInterfaceInfo(String path, String method);

}
