package mythread.src.threadWorkTest4;

public class RedPacketThread extends Thread{

    static int number=100;    //一共100元红包
    static int count=3;     //一共三次抢红包

    @Override
    public void run() {
        synchronized (RedPacketThread.class) {
            if (count == 0) {
                System.out.println(getName() + "没有抢到");
            } else {
                if (count == 1) {
                    System.out.println(getName() + "抢到了" + number + "元");
                    count--;
                } else {
                    int bound=number-(count-1);
                    int sum = (int) (Math.random() *bound) + 1;
                    number -= sum;
                    System.out.println(getName() + "抢到了" + sum + "元");
                    count--;
                }
            }
        }
    }
}

