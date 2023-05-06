package com.api.project.service.impl.inner;

import com.api.common.service.InnerUserInterfaceInfoService;
import com.api.project.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(Long interfaceInfoId, Long userId) {

        return userInterfaceInfoService.invokeCount(interfaceInfoId,userId);
    }
}
