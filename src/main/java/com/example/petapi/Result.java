package com.example.petapi;

import com.alibaba.fastjson.JSONObject;

public class Result {

    public static JSONObject Success(Object t) {
        JSONObject json = new JSONObject();
        json.put("ok", true);
        json.put("data", t);
        return json;
    }

    public static JSONObject Failed(Object t) {
        JSONObject json = new JSONObject();
        json.put("ok", false);
        json.put("reason", t);
        return json;
    }
}
