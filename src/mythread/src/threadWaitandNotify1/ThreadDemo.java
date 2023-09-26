package mythread.src.threadWaitandNotify1;

public class ThreadDemo {
    public static void main(String[] args) {
        /*
        * 需求：  完成生产者和消费者(等待唤醒机制)的代码
        *       实现线程轮流交替执行的效果
        */

        //创建线程名字
        Cook cook=new Cook();
        Foodie foodie=new Foodie();

        //设置线程名称
        cook.setName("厨师");
        foodie.setName("吃货");

        //开启线程
        cook.start();
        foodie.start();
    }
}
