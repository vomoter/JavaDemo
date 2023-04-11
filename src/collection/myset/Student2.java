package collection.myset;

public class Student2 implements Comparable<Student2>{
    private String name;
    private int age;
    private int Chinese;
    private int Math;
    private int English;

    public Student2(){

    }

    public Student2(String name, int age, int chinese, int math, int english) {
        this.name = name;
        this.age = age;
        Chinese = chinese;
        Math = math;
        English = english;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChinese() {
        return Chinese;
    }

    public void setChinese(int chinese) {
        Chinese = chinese;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int math) {
        Math = math;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    @Override
    public String toString() {
        int sum=this.getChinese()+this.getMath()+this.getEnglish();
        return "Student2{" + "name=" + name +  ", age=" + age + ", Chinese=" + Chinese +
                ", Math=" + Math + ", English=" + English + ",sum="+sum+"}\n";
    }

    /*
     *     按照总分从高到低输出到控制台
     *     如果总分一样，按照语文成绩排序
     *     如果语文成绩一样，按照数学成绩排序
     *     如果数学成绩一样，按照英语成绩排序
     *     如果英语成绩一样，按照年龄排序
     *     如果年龄一样，按照姓名的字母顺序排
     *     如果都一样，认为是同一个学生，不存。
    */
    @Override
    public int compareTo(Student2 o) {
        int sum1=this.getChinese()+this.getMath()+this.getEnglish();
        int sum2=o.getChinese()+o.getMath()+o.getEnglish();
        //比较总分
        int i=sum2-sum1;
        //如果总分一样，按照语文成绩排序
        i=i==0 ? o.getChinese()-this.getChinese() : i;
        //如果语文成绩一样，按照数学成绩排序
        i=i==0 ? o.getMath()-this.getMath() : i;
        //如果数学成绩一样，按照英语成绩排序
        i=i==0 ? o.getEnglish()-this.getEnglish() : i;
        //如果英语成绩一样，按照年龄排序
        i=i==0 ? o.getAge()-this.getAge() : i;
        //如果年龄一样，按照姓名的字母顺序排
        i=i==0 ? o.getName().compareTo(this.getName()) : i;

        return  i;

    }
}
