package mythread.src.threadWorkTest1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread{
    //表示这个类的所以对象，都共享ticket变量
    static int ticket=1000;

    //创建锁lock的子类对象
     Lock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true){
           lock.lock();    //上锁
         //   synchronized (MyThread.class) {
                if (ticket != 0) {
                    ticket--;
                    System.out.println(getName() + "卖出一张票，还有" + ticket + "张票");
                } else {
                    break;
                }
                lock.unlock();  //开锁
         //   }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
