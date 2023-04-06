package collection.mygenericitytest;

public class PersianCat extends Cat {

    public PersianCat(){

    }
    public PersianCat(String name, int age) {
        super(name,age);
    }

    @Override
    public String eat() {
        return "一只叫做" + this.getName() + "," + this.getAge() + "岁的波斯猫，正在吃小饼干";
    }
}
