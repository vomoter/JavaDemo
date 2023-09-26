package mythread.src.threadWorkTest5;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        /*
        *   问题：有一个抽奖池存放了奖励的金额，该抽奖池为
        *   {10，5，20，50，100，500，800，2，80，300，700}；
        *   创建两个抽奖箱（线程）设置线程名称分别为：抽奖箱1，抽奖箱2
        * */
        ArrayList<Integer> list=new ArrayList<>();
        Collections.addAll(list,0,5,20,100,500,2,80,300,700);

        ArrayThread a1=new ArrayThread(list);
        ArrayThread a2=new ArrayThread(list);

        a1.setName("抽奖箱1");
        a2.setName("抽奖箱2");

        a1.start();
        a2.start();

    }
}
