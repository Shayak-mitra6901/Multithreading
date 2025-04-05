package com.evilHunter2000.Multithreading;

public class World1 extends Thread{

    @Override
    public void run() {
        for(;;)
            System.out.println("World1");

    }
}
