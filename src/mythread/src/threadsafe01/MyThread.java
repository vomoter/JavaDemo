package mythread.src.threadsafe01;

public class MyThread extends Thread{

    //表示这个类的所以对象，都共享ticket变量
    static int ticket=0;
    //锁对象：一定要是唯一的
    static  Object object=new Object();


    @Override
    public void run() {
        while (true){
            //文件字节码对象也是唯一的
            synchronized (MyThread.class) {
                if (ticket < 100){
                    ticket++;
                    System.out.println(getName()+"正在卖第"+ticket+"张票");
                }   else {
                    break;
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
