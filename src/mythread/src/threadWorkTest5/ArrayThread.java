package mythread.src.threadWorkTest5;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayThread extends Thread{

    ArrayList<Integer> list;

    ArrayThread(ArrayList<Integer> list){
        this.list=list;
    }
    @Override
    public void run() {
        while(true){
            synchronized(ArrayThread.class){
                if (list.size() == 0){
                    break;
                }else {
                    Collections.shuffle(list);
                    int prize=list.remove(0);
                    System.out.println(getName()+"又产生了一个"+prize+"元大奖");
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}

