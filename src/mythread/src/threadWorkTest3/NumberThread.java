package mythread.src.threadWorkTest3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumberThread extends Thread{

    static  int num=1;  //数字初始化
   static Lock lock=new ReentrantLock();  //创建锁对象

    @Override
    public void run() {
        while(true){
            lock.lock();
            if (num>100){
                break;
            }else {
                System.out.println(getName()+"在输出"+num);
                num+=2;
            }
            lock.unlock();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
