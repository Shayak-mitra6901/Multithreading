package com.evilHunter2000.LockDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " amount successful withdraw from the bank");
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    System.out.println(Thread.currentThread().getName() + " processing with the transaction");
                    try {
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " amount successful withdraw from the bank");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance ");
                }
            }
            else
            {
                System.out.println(Thread.currentThread().getName()+" could not acquire the lock, please try again");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /*public synchronized void withdraw(int amount){
        c
        if(balance>=amount)
        {
            System.out.println(Thread.currentThread().getName()+" processing with the transaction");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            balance-=amount;
            System.out.println(Thread.currentThread().getName()+" amount successful withdraw from the bank");
        }
        else{
            System.out.println(Thread.currentThread().getName()+" insufficient balance ");
        }
    }*/

}
