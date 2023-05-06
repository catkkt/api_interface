package com.api.common.service;



import com.api.common.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户服务
 *
 * @author kk
 */
public interface InnerUserService {


    /**
     *数据库中查看是否已经分配给用户秘钥
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);

}
