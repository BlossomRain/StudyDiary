package com.enumannotation;

/**
 * @Auther: lxz
 * @Date: 2020/3/19 0019
 * @Description:自定义枚举类,enum关键字的测试使用
 */
public class EnumTest {


}

enum SeasonEnum{

    //提供多个对象
     SPRING("SPRING", "春"),
     SUMMER("SUMMER", "夏"),
     AUTUMN("AUTUMN", "秋"),
     WINTER("WINTER", "冬");

    private final String name;
    private final String desc;


    private SeasonEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


    @Override
    public String toString() {
        return "SeasonEnum{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }


}

//jdk5.0之前   自定义枚举类 -->多例模式
class Season {

    private final String name;
    private final String desc;

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //提供多个对象
    public static final Season SPRING = new Season("SPRING", "春");
    public static final Season SUMMER = new Season("SUMMER", "夏");
    public static final Season AUTUMN = new Season("AUTUMN", "秋");

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public static final Season WINTER = new Season("WINTER", "冬");

}


