package com.evilHunter2000.Multithreading;


import com.sun.jdi.event.ThreadDeathEvent;

//interrupt and yield
public class MyThread3 extends Thread {

    public MyThread3(String name) {
        super(name);
    }

    @Override
    public void run() {
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException"+e);
        }*/
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " started "+i);
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        MyThread3 t1 = new MyThread3("t1");
        MyThread3 t2 = new MyThread3("t2");
        t1.start();
//         t1.interrupt();
        t2.start();
    }
}
