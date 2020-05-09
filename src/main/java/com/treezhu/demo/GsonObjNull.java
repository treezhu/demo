package com.treezhu.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GsonObjNull {
    private String name;
    private Integer integerType;
    private int in;
    private Double doubleType;
    private double dou;
    private Boolean boolType;
    private boolean bool;

    private Character ch;

    public GsonObjNull(String name, Character ch) {
        this.name = name;
        this.ch = ch;
    }
}
