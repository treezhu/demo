package com.treezhu.demo;

public class AProxy implements A {

    private A a;

    AProxy(A a){
        this.a = a;
    }


    @Override
    public String a(){
        //
        System.out.println("开始");
        String res = a.a();
        System.out.println("结束");
        return res;
    }

    public static void main(String[] args) {
        A a = new AImpl();
        A aProxy = new AProxy(a);
        aProxy.a();
    }


}
