package com.evilHunter2000.LockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment() {
        writeLock.lock();
        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount(){
        readLock.lock();
        try{
            return count;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteCounter readWriteCounter=new ReadWriteCounter();

        Runnable readtask= () -> {
            for(int i=0;i<10;i++)
                System.out.println(Thread.currentThread().getName()+" count "+readWriteCounter.getCount());
        };

        Runnable writetask= () -> {
            for(int i=0;i<10;i++) {
                readWriteCounter.increment();
            }
            System.out.println(Thread.currentThread().getName()+" increment");
        };
        Thread t1=new Thread(writetask,"WriteTask");
        Thread t2=new Thread(readtask,"ReadTask");
        Thread t3=new Thread(readtask,"ReadTask2");


        t1.start();
        t2.start();
        t3.start();
    }
}
