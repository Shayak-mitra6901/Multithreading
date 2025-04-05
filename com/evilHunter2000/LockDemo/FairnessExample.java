package com.evilHunter2000.LockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessExample {

    private final Lock lock = new ReentrantLock(true);

    public void accessResource(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"acquiring the lock");
            Thread.sleep(1000);
        }catch(Exception e){
          Thread.currentThread().interrupt();
        }
        finally {
            System.out.println(Thread.currentThread().getName()+"releasing the lock");
            lock.unlock();
        }
    }
}
