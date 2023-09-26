package mythread.src.threadWaitandNotify2;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadMain {
    public static void main(String[] args) {
        /*
        *   需求：利用堵塞队列完成生产者和消费者（等待唤醒机制）的代码
        *   细节：
        *       生产者和消费者必须使用同一个堵塞队列
         */

        //创建堵塞队列容量为1
        ArrayBlockingQueue<String> queue=new ArrayBlockingQueue<>(1);

        //创建线程
        Cook cook=new Cook(queue);
        Foodie foodie=new Foodie(queue);

        //开启线程
        cook.start();
        foodie.start();

    }
}
