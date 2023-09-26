package mythread.src.threadWaitandNotify1;

public class Foodie extends Thread{
    /*
    * 1.循环
    * 2.同步代码块
    * 3.判断共享数据是否到了末尾（到了末尾）
    * 4.判断共享数据是否到了末尾（没有到末尾，执行核心逻辑）
    * */
    @Override
    public void run()
    {
        //1.循环
        while (true)
        {
            //2.同步代码块
            synchronized(Desk.lock){
                //3.判断共享数据是否到了末尾（到了末尾）
                if(Desk.count == 0){
                    break;
                }else {

                    if(Desk.foodFlag==0){
                        //先判断桌子上是否有面条
                        try {
                            //如果没有，就等待
                            Desk.lock.wait();   //让当前线程跟锁进行绑定
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                            //把吃的总数-1
                            Desk.count--;
                            //如果有，就开吃
                            System.out.println("吃货在吃面条，还能再吃"+(Desk.count)+"碗！！！");
                            //吃完之后，唤醒厨师继续
                            Desk.lock.notifyAll();  //唤醒跟锁绑定的所有线程
                            //更改桌子的状态
                            Desk.foodFlag=0;
                    }
                }
            }

        }

    }
}
