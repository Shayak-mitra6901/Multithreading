package com.evilHunter2000.ThreadCommunication;


class SharedResource {

    private int data;
    private boolean hasData;

    public synchronized void producer(int value) {
        if (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + data);
        notify();

    }

    public synchronized void Consumer() {
        if (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
        hasData = false;
        System.out.println("Consumer: " +data);
        notify();
    }
}

class Consumer implements Runnable{

    private final SharedResource sharedResource;

    public Consumer(SharedResource sharedResource)
    {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++)
        {
            sharedResource.Consumer();
            //System.out.println("Consumer: "+value);
        }
    }
}

class Produce implements Runnable{
    private final SharedResource sharedResource;

    public Produce(SharedResource sharedResource)
    {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++)
        {
            sharedResource.producer(i);
        }
    }
}

public class ThreadCommunicationExmple {
    public static void main(String[] args) {
      SharedResource sharedResource =new SharedResource();

      Thread producerThread=new Thread(new Produce(sharedResource));
      Thread consumerThread=new Thread(new Consumer(sharedResource));

      producerThread.start();
      consumerThread.start();

    }
}
