package com.api.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.api.common.model.entity.UserInterfaceInfo;

/**
* @author kk
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service
* @createDate 2023-04-14 21:40:20
*/
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口次数统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(Long interfaceInfoId, Long userId);

}
