package mythread.src.threadWorkTest2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GiftRunnable implements Runnable{

    int gift =100;  //礼物个数

    //创建锁对象
    Lock lock =new ReentrantLock();

    @Override
    public void run() {
        while (true){
       //     lock.lock();
           synchronized (GiftRunnable.class){
                if (gift == 10) {
                    break;
                } else {
                    gift--;
                    System.out.println(Thread.currentThread().getName() + "送了一份礼物，还有" + gift + "份礼物");
                }
            }
         //   lock.unlock();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
