package com.evilHunter2000.Multithreading;



/// name and priority
public class MyThread2 extends Thread {

    public MyThread2(String name)
    {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"priority"+Thread.currentThread().getPriority()+"count"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
      MyThread2 t1=new MyThread2("shayak");
      MyThread2 t2=new MyThread2("abhi");
      MyThread2 t3=new MyThread2("shomik");
      t1.setPriority(MyThread.MAX_PRIORITY);
      t2.setPriority(MyThread.MIN_PRIORITY);
      t3.setPriority(MyThread.NORM_PRIORITY);
      t1.start();
      t2.start();
      t3.start();
    }
}
