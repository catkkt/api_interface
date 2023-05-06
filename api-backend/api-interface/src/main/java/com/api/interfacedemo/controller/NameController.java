package com.api.interfacedemo.controller;

import com.api.clientsdk.model.User;
import com.api.clientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称API
 */
@RestController
@RequestMapping("/name")
public class NameController {

     @GetMapping("/")
    public String getNameByGet(String name) {

         return "GET 你的名字是：" + name;
     }

     @PostMapping("/")
     public String getNameByPost(@RequestParam String name) {
         return "POST 你的名字是：" + name;
     }

    @PostMapping("/json")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request) {

        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String body = request.getHeader("body");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        if(!accessKey.equals("test")) {

            throw new RuntimeException("无权限");
        }
        if(Long.parseLong(nonce) > 10000) {

            throw new RuntimeException("无权限");
        }

        String serverSign = SignUtils.getSign(body, "abcdefg");
        if(!sign.equals(serverSign)) {

            throw new RuntimeException("无权限");
        }

        String result = "POST 你的名字是：" + user.getUsername();
        //调用成功后次数+1

        return result;
    }
}
