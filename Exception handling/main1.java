import java.io.*;
class MyThread extends Thread {
    public void run()
    {
        for (int i = 0; i < 10; i++) {
            System.out.println(" Running thread : " + i);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class main1 {
    public static void main(String[] args)
    {
        MyThread t1 = new MyThread();
        t1.start();
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        // suspend the execution of the thread
        t1.suspend();
        System.out.println("Suspended thread ");
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        // resume the execution of the thread
        t1.resume();
        System.out.println("Resumed thread");
    }
}