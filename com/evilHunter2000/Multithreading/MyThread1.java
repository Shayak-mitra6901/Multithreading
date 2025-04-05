package com.evilHunter2000.Multithreading;

import java.sql.SQLOutput;


// sleep, join , start, run
public class MyThread1 extends Thread{
    @Override
    public void run() {
        //System.out.println("Running");
        for(int i=0;i<5;i++)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);

        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread1 t1=new MyThread1();
        t1.start();
        t1.join();
        System.out.println(t1.getState());
        System.out.println("HELLO");
    }
}
