package collection.mygenerics;

import java.util.ArrayList;

public class GenericsDemo2 {
    public static void main(String[] args) {
        ArrayList<String> list1=new ArrayList<>();
        ListUtil.addAll(list1,"aaa","bbb","ccc");
        System.out.println(list1);

        ArrayList<Integer> list2=new ArrayList<>();
        ListUtil.addAll(list2,1,2,3);
        System.out.println(list2);
    }
}
