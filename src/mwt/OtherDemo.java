package mwt;

import java.io.UnsupportedEncodingException;

public class OtherDemo {
}


/**
 * 调用函数传入的是变量的地址，不是变量本身
 *  x.append(y)将x对应地址的内容+y地址对应的内容，所以结果是AB
 *  y=x是将y的地址改为x的地址,但是b的地址并未改变 所以仍是B
 */
class OtherDemo1{
    public static void operator(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }
    public static void main(String[] args){
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a + "," + b);
    }
}


/**
 * 引用传递
 * java中基本数据类型(值传递),引用类型(引用传递)
 * string也是值传递？为什么
 */
class OtherDemo2{

    /**
     * 改的是地址上的内容,形参改变,入参一起变
     * @param str
     */
    static void change1(StringBuffer str){
        str.append("ee");
    }

    /**
     * 改的是指向地址的引用,形参改变,入参不变
     * @param str
     */
    static void change2(StringBuffer str){
        str = new StringBuffer("world");
    }

    public static void main(String[] args){
        StringBuffer str1 = new StringBuffer("hello");
        StringBuffer str2 = str1;

        str1.append("ww");
        System.out.println("str1: " + str1 + "   str2: " + str2);

        OtherDemo2.change1(str1);
        System.out.println("str1: " + str1 + "   str2: " + str2);

        OtherDemo2.change2(str1);
        System.out.println("str1: " + str1 + "   str2:" + str2);
    }
}


/**
 * 浅拷贝：拷贝的是指向堆中地址的引用  使用 =
 * 深拷贝：拷贝的是对象的内容         继承Cloneable接口,使用clone()
 */
class StudentCopyDemo implements Cloneable{
    private String name;
    private Integer age;

    public StudentCopyDemo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentCopyDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        StudentCopyDemo studentCopyDemo1 = new StudentCopyDemo("小明", 18);
        //浅拷贝
        StudentCopyDemo studentCopyDemo2 = studentCopyDemo1;
        //深拷贝
        StudentCopyDemo studentCopyDemo3 = (StudentCopyDemo)studentCopyDemo1.clone();
        studentCopyDemo1.setName("小华");
        System.out.println("StudentCopyDemo1的内容为：" + studentCopyDemo1.toString());
        System.out.println("StudentCopyDemo2的内容为：" + studentCopyDemo2.toString());
        System.out.println("StudentCopyDemo3的内容为：" + studentCopyDemo3.toString());
    }
}


/**
 *  ==    : 运算符,基本数据类型(比较的是值),引用数据类型(比较的是地址)
 *  equals：方法,  基本数据类型(不能比较),  引用数据类型(默认比较的地址),String和包装类型重写了equals方法(先比较类型,再比较值)
 *  先比较hashcode(),一样后再比较equals hashcode()提前校验可以提高效率
 *      如果重写了equals不重写hashcode会出现equlas相等,hashcode不相等的情况
 *
 *  Integer类型 -128-127之间会被缓存,所以是同一个对象，超出这个返回会重新new一个对象出来
 */
class OtherDemo5{
    public static void main(String[] args){
        Float floatNumber = new Float(0.0f);
        Double doubleNumber1 = new Double(0.0d);
        Double doubleNumber2 = new Double(0.0d);
        // ==
        System.out.println(1==2);
        // equals
        System.out.println(floatNumber.equals(doubleNumber1));
        System.out.println(doubleNumber1.equals(doubleNumber2));

        // -128-127之间会被缓存
        Integer integer1 = 1,integer2=1,integer3=500,integer4=500;
        System.out.println(integer1 == integer2);
        System.out.println(integer3 == integer4);
    }
}


/**
 * java编码转换
 * 将ISO8859-1编码转为GB2312编码(先转成字节再转成GB2312)
 */
class OtherDemo6{
    public static void main(String[] args) throws UnsupportedEncodingException {
        new String("字符串".getBytes("ISO8859-1"),"GB2312");
    }
}





