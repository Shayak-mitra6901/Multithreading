package com.evilHunter2000.Multithreading;
// when java run the program first main thread will executed
public class MultiTest {
    public static void main(String[] args){
        /*System.out.println("Hello world");
        System.out.println(Thread.currentThread().getName());*/

       /* World1 world1 = new World1();
        world1.start();*/

        World2 world2 = new World2();
        Thread thread=new Thread(world2);
        thread.start();

        for (; ; ) {
            System.out.println("Hello");
        }
    }

}
