package com.treezhu.demo;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class BaseNullAdapter<T> extends TypeAdapter<Object> {
    /**
     * 反序列化时 若为 null 或 空字符串
     *    皆反序列化 为 null
     * @param reader
     * @return
     * @throws IOException
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        // 这里仅针对与 Integer 和 Double类型
        if (reader.peek() == JsonToken.NUMBER) {
            double res = reader.nextDouble();
            if(Math.floor(res) == res){
                return ((int) res);
            }else{
                return res;
            }
        }
        if (reader.peek() == JsonToken.BOOLEAN) {
            return reader.nextBoolean();
        }

        String res = reader.nextString();
        return "".equals(res) ? null : res;
    }

    /**
     * 序列化时  若属性值 为null  则 序列化为 空字符串
     * 反之  反序列化时 若属性值 为 null 或者为 空字符串时  --
     *    则对应反序列化为 null
     * @param writer
     * @param value
     * @throws IOException
     */
    @Override
    public void write(JsonWriter writer, Object value) throws IOException {
        if (value == null) {
            writer.value("");
            return;
        }
        // 在 反序列化 是 无法动态 绑定其类型
        if(value instanceof Number){
            writer.value((Number) value);
            return;
        }
        if(value instanceof Boolean){
            writer.value((Boolean) value);
            return;
        }

        writer.value(value.toString());
    }
}
