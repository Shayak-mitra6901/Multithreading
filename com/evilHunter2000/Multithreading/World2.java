package com.evilHunter2000.Multithreading;

public class World2 implements Runnable{
    @Override
    public void run() {
        for(;;)
            System.out.println("World2");
    }
}
