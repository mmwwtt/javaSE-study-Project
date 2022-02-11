package mwt;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {

}

/**
 * 	访问修饰符（访问权限）
 * 		private         当前类
 * 		default（默认）  当前类 + 同包
 * 		protected       当前类 + 同包 + 子类
 * 		public          当前类 + 同包 + 子类 + 其他包
 */
class AccessRights{
    private int a;
    int b;
    protected int c;
    public int d;
}


/**
 * class:声明一个类
 * enum:声明枚举类
 */
enum EnumColor {
    RED, GREEN, BLUE;
}
class ClassDemo{
    public static void main(String[] args){
        EnumColor c1 = EnumColor.BLUE;
        System.out.println(c1);
    }
}


/**
 *  普通域：类对象实例化时初始化
 * 	static(静态域,类加载时初始化,既虚拟机初始化时,不能修饰局部变量)
 * 	 静态变量(类变量):   通过类名.变量名使用
 * 	 静态方法(类方法):   通过类名.方法名使用(不能访问非static的变量和方法,因为还没初始化)
 * 	 代码块：    在类实例化时执行一次
 * 	 静态代码块: 类加载的时候执行
 * 	 执行先后(同级则顺序执行)：  静态域 > main()方法 > 代码块 > 构造方法      父类 > 子类
 */
class StaticDemo{


    static { System.out.println("静态代码块，类启动时执行1"); }
    static StaticDemo staticDemo= new StaticDemo();
    static void fun1(){System.out.println("静态方法");}

    {System.out.println("代码块，实例化时执行"); fun1();}

    StaticDemo(){
        System.out.println("构造方法，实例化时执行");
    }

    public static void main(String[] args){
        StaticDemo staticDemo1 = new StaticDemo();
        StaticDemo staticDemo2 = new StaticDemo();
        System.out.println(StaticDemo.staticDemo);
        //可以但不推荐   对象.类变量|类方法的 形式访问
        System.out.println(staticDemo1.staticDemo);
        //static可直接访问static变量
        System.out.println(staticDemo);
        StaticDemo.fun1();
    }
    static { System.out.println("静态代码块，类启动时执行2"); }
}


/**
 * final
 *   修饰变量，为常量,值不可变；
 * 　修饰对象，值可变,引用不变；
 * 　修饰方法，方法不可重写；
 * 　修饰类，无子类，不可以被继承,更不可能被重写。
 * implements 实现接口
 * extends 继承类
 * interface 接口
 * abstract 抽象,必须被类继承/方法实现
 * 同：都不能实例化，要被继承/实现，并实现其中的抽象方法
 * 异：
 *  interface中
 *      变量类型：public static final(默认)
 *      方法类型：public abstract(默认)
 *      多继承
 *  abstract类中
 *      变量类型：all
 *      可以包含抽象()/非抽象方法
 *      可以包含静态方法和静态代码块
 *      单继承
 *  抽象方法：没有方法体的方法,必须在抽象类/接口中
 */
interface InterFaceA{
    void fun1();
}

abstract class ClassA{
    abstract void fun2();
}

class A extends ClassA implements InterFaceA {


    @Override
    public void fun1() { }

    @Override
    void fun2() { }
    public static void main(String[] args){
        final String str = "hello world";
    }
}

/**
 * instaneof关键字:判断是否为一个类的实例 返回boolean
 */
class InstanceofDemo{
    public static void main(String[] args){
        //未规定数组类型则默认为Object类型
        List list = new ArrayList();
        list.add(1);
        //会自动装箱成Integer
        System.out.println(list.get(0) instanceof Integer);
    }
}

