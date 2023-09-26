package mythread.src.threadWaitandNotify2;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread{

    ArrayBlockingQueue<String> queue;
    public Foodie(ArrayBlockingQueue<String> queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        while(true){
            //不断重堵塞队列获取面条
            try {
                String food = queue.take();
                System.out.println("吃货吃了一碗"+food);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
