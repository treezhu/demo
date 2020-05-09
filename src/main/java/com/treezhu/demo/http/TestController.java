package com.treezhu.demo.http;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController  {

    public void test(){

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("","");

            OkHttpClient httpClient = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
            Request request = new Request.Builder().url("")
                    .post(RequestBody.create(mediaType,jsonObject.toJSONString()))
                    //todo 用户名和密码
                    .addHeader("Authorization", Credentials.basic("",""))
                    .build();
            Call call = httpClient.newCall(request);
            Response result = call.execute();
            System.out.println(result.body().string());
            System.out.println(result.code());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
