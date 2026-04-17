import java.io.*;

class MyThread extends Thread {

    private boolean paused = false;

    public void run() {

        for (int i = 0; i < 10; i++) {

            System.out.println("Running thread : " + i);

            try {
                Thread.sleep(1000);

                synchronized (this) {

                    while (paused) {
                        wait();   // thread wait until resume
                    }

                }

            } catch (InterruptedException e) {

                System.out.println(e);

            }

        }

    }

    // suspend method
    public void pauseThread() {

        paused = true;

    }

    // resume method
    public synchronized void resumeThread() {

        paused = false;

        notify();   // wake up thread

    }

}

class GFG {

    public static void main(String[] args) {

        MyThread t1 = new MyThread();

        t1.start();

        try {

            Thread.sleep(3000);

        } catch (InterruptedException e) {

            System.out.println(e);

        }

        t1.pauseThread();

        System.out.println("Thread Suspended");

        try {

            Thread.sleep(3000);

        } catch (InterruptedException e) {

            System.out.println(e);

        }

        t1.resumeThread();

        System.out.println("Thread Resumed");

    }

}