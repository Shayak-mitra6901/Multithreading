package com.evilHunter2000.RunCondition;

public class MyThread extends Thread{

    Counter c=new Counter();
    public MyThread(Counter counter)
    {
        this.c=counter;
    }

    @Override
    public void run() {

        for(int i=0;i<1000;i++)
        {
            c.increament();
        }
    }
}
