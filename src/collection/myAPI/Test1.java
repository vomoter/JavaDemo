package collection.myAPI;

import java.util.Arrays;
import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) {
        People p1=new People("aaa",19,1.67);
        People p2=new People("abc",20,1.77);
        People p3=new People("aac",19,1.73);
        People arr[]={p1,p2,p3};
        Arrays.sort(arr, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                //按照年的大小进行排序，年龄一样，按照身高排序，身高一样按照姓名的字母进行排序
                double temp= o1.getAge()- o2.getAge();
                temp = temp== 0 ? o1.getHeight()- o2.getHeight() : temp;
                temp = temp== 0 ? o1.getName().compareTo(o2.getName()) : temp;

                if(temp>0){
                    return 1;
                }   else if(temp<0){
                    return -1;
                }   else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(arr));


    }
}
