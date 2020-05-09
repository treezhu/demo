package com.treezhu.demo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ThreadNum {

    private volatile static AtomicInteger count = new AtomicInteger();
    private static Thread t1,t2,t3;

    public static void main(String[] args) {

        Runnable runnable1 = ()->{
            while (count.get()<100){
                System.out.println(count.incrementAndGet());
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        };
        Runnable runnable2 = ()->{
            while (count.get()<100){
                System.out.println(count.incrementAndGet());
                LockSupport.unpark(t3);
                LockSupport.park();
            }
        };
        Runnable runnable3 = ()->{
            while (count.get()<100){
                System.out.println(count.incrementAndGet());
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        };

         t1= new Thread(runnable1);
         t2= new Thread(runnable2);
         t3= new Thread(runnable3);
         t1.start();
         t2.start();
         t3.start();
    }
}
