package mwt;

import java.io.Serializable;
import java.util.Date;

/**
 * 面向对象编程（OOP）
 * 三大特性
 *  封装：封装属性和方法，对外暴露调用的接口
 *  继承：子类继承父类
 *  多态：同一个行为具有多个不同表现形式或形态的能力
 *      格式：父类类型 变量名=new 子类类型();
 * 六大原则：
 *  单一职责原则：一个类只有一个职责，一个类被改变的原因不能超过一个
 *  开放封闭原则：对拓展开放，对修改封闭（在不被修改的前提下拓展）
 *  里式替换原则：允许父类替换成子类，程序行为没有发生变化
 *      子类可以增加自己的方法
 *      子类不能重写父类中的方法
 *      子类重载父类方法时，形参要更加宽松
 *      子类实现父类中的抽象方法时，返回值要更加严格
 *  依赖倒置原则：程序要依赖与接口，不要依赖于具体实现
 *  迪米特法则：  有依赖关系的类之间，尽量只依赖必要的接口
 *  聚合复用原则：尽量使用合成/聚合，不要使用类继承，即在一个新的对象里面使用一些已有的对象，使之成为新对象的一部分
 */
public class Demo4 {
    public static void main(String[] args) {
        //里式替换原则
        Object x = new String("hello");
    }
}




/**
 * 构造方法
 * 每个类都有默认构造方法（没有自定义构造方法时）
 * 无参构造
 * 有参构造
 * 构造方法不能被继承，子类默认调用父类无参构造，若无无参构造，子类要用super()调用父类有参构造，且在第一行
 */
class ConstructorsDemo{
    private String name;
    private Integer age;
    private Date birthday;
    ConstructorsDemo(String name, Integer age, Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
}


/**
 * 方法重载(相同的方法名)
 * 条件：方法名相同，参数类型/个数不同
 */
class OverloadDemo {
    void fun1(int a){System.out.println("a:" + a);}
    void fun1(int a, int b){System.out.println("a:" + a + ", b:" + b);}
    public static void main(String[] args){
        OverloadDemo overloadDemo = new OverloadDemo();
        overloadDemo.fun1(1);
        overloadDemo.fun1(1,2);
    }
}

/**
 * 方法重写
 *  方法名相同，参数类型相同
 *  子类返回类型小于等于父类方法返回类型，
 *  子类抛出异常小于等于父类方法抛出异常，
 *  子类访问权限大于等于父类方法访问权限。
 */
class FatherDemo{
    public void say(){

    }
}
class SonDemo{
    public void say(){
        System.out.println("hello");
    }
}


/**
 * 多态：同一个行为具有多个不同表现形式或形态的能力
 */
class Animal {
    public void say(){ System.out.println("hello"); }
}
class Dog extends Animal{
    @Override
    public void say(){ System.out.println("汪汪"); }
}
class Cat extends Animal{
    @Override
    public void say(){ System.out.println("喵喵"); }
    public void move(){ System.out.println("动一动"); }
}
class PolymorphismDemo{
    public static void main(String[] args){
        //创建父类的引用，指向子类对象，编译看左，运行看右
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        //同一个类的不同实例化，会有不同的行为
        animal1.say();
        animal2.say();

        //父类对象不能使用子类中新定义的方法
        //animal2.move();会报错 (编译看左,运行看右)
    }
}


/**
 * this
 *  用法1：调用其他构造参数
 *  用法2：形参/局部变量和成员变量重名
 *  用法3：代表自身对象
 */
class ThisDemo{
    String name;
    Integer age;

    public ThisDemo(String name, Integer age) {
        //用法1 调用其他构造参数,要放第一句
        this();
        //用法2 形参/局部变量和成员变量重名时,指向成员变量
        this.name = name;
        this.age = age;
        System.out.println("构造参数2");
    }

    public ThisDemo() {
        System.out.println("构造参数1");
    }

    @Override
    public String toString() {
        return "ThisDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * this用法3：代表自身对象
     */
    public ThisDemo getThisDemo() {
        return this;
    }

    public static void main(String[] args){
        ThisDemo thisDemo = new ThisDemo("小明", 22);
        System.out.println(thisDemo.getThisDemo());
    }
}


/**
 * super关键字用法
 *  用法1：调用父类构造方法
 *  用法2：调用父类中被重写的方法
 *  用法3: 调用父类被隐藏的非私有成员变量
 */
class SuperDemo1 {
    String name;

    public SuperDemo1(String name) {
        this.name = name;
    }
    public void say(){
        System.out.println("hello");
    }
}
class SuperDemo2 extends SuperDemo1{
    Integer age;

    public SuperDemo2(String name,Integer age) {
        // 用法1：调用父类构造方法,要放第一句
        super(name);
        this.age = age;
        // 用法2：调用父类的方法
        super.name = name;
        super.say();
    }
    @Override
    public void say(){
        System.out.println("hello world");
    }

    public static void main(String[] args){
        SuperDemo2 superDemo2 = new SuperDemo2("小明",18);
    }
}


/**
 * Serializable接口 用于序列化(转成二进制流)
 * 为什么要序列化？
 *   存储对象在存储介质中，下次使用可快捷的重建一个副本
 *
 * 未实现序列化时，也可以存到数据库中，为什么一定要序列化存储？
 *   便于数据传输，尤其是在远程调用的时候！
 *
 * Serializable接口是一个里面什么都没有的接口
 *   一个接口里面什么内容都没有，则是一个标识接口
 *   Serializable接口告诉JVM，由JVM进行序列化，对象要在网络中传输，需要为二进制流
 */
class SerializableDemo implements Serializable {

}
