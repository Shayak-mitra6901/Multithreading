package com.evilHunter2000.Multithreading;

public class MyDaemon extends Thread{
    @Override
    public void run() {
        while(true)
            System.out.println("Running");
    }

    public static void main(String[] args) {
        MyDaemon t1=new MyDaemon();//User Thread
        t1.setDaemon(true);//Daemon thread are the background thread which JVM will be wait to finish the process
        t1.start();
        System.out.println("Main Thread");
    }
}
