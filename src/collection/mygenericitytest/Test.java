package collection.mygenericitytest;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        System.out.println("遍历猫的集合，打印eat()方法=======================");
        ArrayList<Cat> list1 = new ArrayList<>();
        PersianCat p = new PersianCat("PersianCat", 1);
        list1.add(p);
        LiHuaCat l=new LiHuaCat("LiHua",2);
        list1.add(l);
        keepCat(list1);

        System.out.println("遍历狗的集合，打印eat()方法=======================");
        ArrayList<Dog> list2=new ArrayList<>();
        Huskie h=new Huskie("Huskie",1);
        list2.add(h);
        Teddy t=new Teddy("Teddy",1);
        list2.add(t);
        keepDog(list2);

        System.out.println("遍历动物的集合，打印eat()方法=======================");
        ArrayList<Animal> list3=new ArrayList<>();
        list3.add(p);
        list3.add(l);
        list3.add(h);
        list3.add(t);
        keepAnimal(list3);


    }

    //该方法能养所有品种的狗，但是不能养猫
    public static void keepDog(ArrayList<? extends Dog> list){
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).eat());
        }
    }

    //该方法能养所有品种的猫，但是不能养狗
    public static void keepCat(ArrayList<? extends Cat> list) {
        Iterator<? extends Cat> iter = list.iterator();
        while (iter.hasNext()) {
            Object object = iter.next().eat();
            System.out.println(object);
        }


    }
    //该方法能养所有的动物，但是不能传递其他类型
    public static void keepAnimal(ArrayList<? extends Animal> list){
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).eat());
        }
    }

}
