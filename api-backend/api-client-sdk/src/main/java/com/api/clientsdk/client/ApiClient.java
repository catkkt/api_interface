package com.api.clientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.api.clientsdk.model.User;
import com.api.clientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * 调用第三方接口的客户端
 */
public class ApiClient {

    private static final String GATEWAY_HOST = "http://localhost:8090";
    private String accessKey ;
    private String secretKey ;

    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet( String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/", paramMap);
        return result;
    }

    public String getNameByPost(@RequestParam String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        String result = HttpUtil.post(GATEWAY_HOST + "/api/name/", paramMap);
        return result;
    }



    private Map<String, String> getHeaderMap(String body) {

        HashMap<String, String> map = new HashMap<>();
        map.put("accessKey", accessKey);
//        map.put("secretKey", secretKey);
        map.put("nonce", RandomUtil.randomNumbers(4));
        map.put("body", body);
        map.put("timestamp", String.valueOf(System.currentTimeMillis()/1000));
        map.put("sign", SignUtils.getSign(body,secretKey));
        return map;
    }



    public String getUserNameByPost(@RequestBody User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse response = HttpRequest.post(GATEWAY_HOST + "/api/name/json")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        String result = response.body();
        return result;
    }
}
