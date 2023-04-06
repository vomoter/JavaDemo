package collection.myset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class A01_SetDemo1 {
    public static void main(String[] args) {
        //1.创建一个Set集合的对象
        Set<String> s=new HashSet<>();
        //2.添加元素
        //如果当前元素是第一次添加，那么可以添加成功，返回true
        //如果当前元素是第二次添加，那么添加失败，返回false
        boolean b1=s.add("aaa");
        boolean b2=s.add("aaa");
        System.out.println(b1);
        System.out.println(b2);
        s.add("bbb");
        s.add("ccc");

        //3.打印集合(无序)
        //迭代器遍历
        System.out.println("迭代器遍历--------------");
        Iterator<String> iter=s.iterator();
        while (iter.hasNext()){
            String str=iter.next();
            System.out.println(str);
        }

        //增强for遍历
        System.out.println("增强for遍历--------------");
        for (String  str: s) {
            System.out.println(str);
        }
        //lambda表达式
        System.out.println("Lambda表达式遍历-----------");
        s.forEach(str-> System.out.println(str));
    }

}
