package com.evilHunter2000.LockDemo;

public class Main1 {
    public static void main(String[] args) {
        FairnessExample fairnessExample=new FairnessExample();
        Runnable r= fairnessExample::accessResource;

        Thread t1=new Thread(r,"t1");
        Thread t2=new Thread(r,"t2");
        Thread t3=new Thread(r,"t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
