package com.treezhu.demo;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.text.SimpleDateFormat;

public class TestClass {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS Z");
        String date = "2020-03-13T06:05:00.059 UTC";
        System.out.println(sdf.parse(date));
    }

    @Test
    public void testObjNull(){
        GsonObjNull g = new GsonObjNull("tom",12,10,
                12.36,15.32,true,true,'A');
        Gson gson  = new GsonBuilder()
                .registerTypeAdapterFactory(new NullToEmptyAdapterFactory())
                .create();

        //序列化
        String json = gson.toJson(g);
        System.out.println(json);
        //反序列化
        json = "{\"name\":\"tom\",\"integerType\":\"\",\"in\":10,\"doubleType\":12.36,\"dou\":15.32,\"boolType\":true,\"bool\":true,\"ch\":\"A\"}";
        g = gson.fromJson(json, GsonObjNull.class);
        System.out.println(g);
    }
}
