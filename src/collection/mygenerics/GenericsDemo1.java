package collection.mygenerics;

public class GenericsDemo1 {
    public static void main(String[] args) {
        MyArryList<String> list=new MyArryList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        String s=list.get(0);
        System.out.println(s);
        System.out.println(list);


    }
}
