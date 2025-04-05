package com.evilHunter2000.RunCondition;

public class Counter {
    private int count=0;

    // to remove the run condition
    public synchronized void increament(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
