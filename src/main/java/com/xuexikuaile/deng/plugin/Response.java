package com.xuexikuaile.deng.plugin;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: cytern
 * @Date: 2020/6/12 14:04
 */
@Component
public class Response {
    public Map<String,Object> responseError(String msg){
        Map<String,Object> map = new HashMap<>();
        map.put("error",msg);
        return map;
    }
}
