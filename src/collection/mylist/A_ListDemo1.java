package collection.mylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class A_ListDemo1 {
    public static void main(String[] args) {
        Collection<String> coll =new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");

        //此方法判断集合里是否有某个元素
        boolean b= coll.contains("dd");
        System.out.println(b);

        //1.获取迭代器对象
        //2.迭代器就好比一个箭头，默认指向集合的0索引处
        Iterator<String> it= coll.iterator();
        //3.利用循环不断去获取集合中的每一个元素
        while(it.hasNext()){
            //4.next方法的两件事，获取元素并移动指针
            String s=it.next();
            System.out.println(s);
        }
    }
}
