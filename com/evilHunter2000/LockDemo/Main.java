package com.evilHunter2000.LockDemo;

public class Main {
    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();
        Runnable r = () -> sbi.withdraw(50);
        Thread t1=new Thread(r,"thread1");
        Thread t2=new Thread(r,"thread2");
        t1.start();
        t2.start();

    }
}
