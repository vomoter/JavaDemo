package collection.a01;

import java.util.Arrays;
import java.util.Comparator;

public class Demo1 {
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            int a[]= {1,2,3,4,5,6,7,8};
            Integer[] arr= {1,3,5,2,4,6,8,7};
            String s=Arrays.toString(a);
            System.out.println(s);
            System.out.println("Integer------------");
            System.out.println(Arrays.toString(arr));

            Arrays.sort(arr, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1,Integer o2) {
                    System.out.println("------------");
                    System.out.println("o1:"+o1);
                    System.out.println("o2:"+o2);

                    return o2-o1;
                }
            }	);
            System.out.println("Comparator------------");
            System.out.println(Arrays.toString(arr));
            Arrays.sort(arr,(Integer o1,Integer o2)->{
                        return o2-o1;
                    }
            );
            System.out.println("Lamda----------------");
            System.out.println(Arrays.toString(arr));

        }

    }



