package mythread.src.threadsafe02;

public class MyRunnable implements Runnable{
    //电影票票数初始化
    int ticket=0;

    @Override
    public void run() {
        //1.循环
        //2.同步代码块
        //3.判断共享数据是否到了末尾，如果到了末尾
        //4.判断共享数据是否到了末尾，如果没有到末尾

        //1.循环
        while(true)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
                //2.同步代码块
                if (method()) break;
        }
    }
    private synchronized boolean method() {
        //3.判断共享数据是否到了末尾，如果到了末尾
        if(ticket == 100){
            return true;
        }else {     //4.判断共享数据是否到了末尾，如果没有到末尾
            ticket++;
            System.out.println(Thread.currentThread().getName()+"在卖第"+ticket+"张票");
        }
        return false;
    }
}
