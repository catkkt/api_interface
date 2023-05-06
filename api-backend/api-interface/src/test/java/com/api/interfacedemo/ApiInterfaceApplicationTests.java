package com.api.interfacedemo;


import com.api.clientsdk.client.ApiClient;
import com.api.clientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiInterfaceApplicationTests {

    @Resource
    private ApiClient apiClient;

    @Test
    void contextLoads() {
        String test1 = apiClient.getNameByGet("test1");
        User user = new User();
        user.setUsername("test2");
        String test2 = apiClient.getUserNameByPost(user);
        System.out.println(test1);
        System.out.println(test2);
    }

}
