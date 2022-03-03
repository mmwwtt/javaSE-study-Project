package mwt;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *  java字符是 Unicode编码
 *
 *  编译：        javac 类名.java   生成 .class的二进制字节码文件
 *  终端中运行：   java  字节码文件(不带后缀)
 *  制作java文档: javadoc.exe 制作java文档
 *  java调试器:   jdb.exe     java的调试器
 *
 *	命名规范
 * 		标识符：数字、字母、下划线和美元组成，不能数字开头
 * 		项目名：全小写,单词用_隔开        javase-study-project
 * 		包名：全小写,多级用.隔开          mwt
 * 		类名、接口：首字母大写，驼峰命名   Demo
 * 		常量：全大写，单词用_隔开         MAX_NUMBER
 * 		方法、变量：首字母小写，驼峰命名   number
 *
 * 	成员变量：类中定义的变量（未初始化会有默认值）
 * 	局部变量：方法中定义的变量（未初始化无默认值,要赋值后才能用）
 *
 * 	一个java文件中只能有一个public class
 */
public class Demo1 {
    static final int MAX_NUMBER = 100;
    int number;

    //单行注释
    /*多行注释*/
    /**
     * 文档注释
     */
    public void fun(){
        //局部变量
        int number = 1;
    }
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.fun();
    }
}


/**
 * 	基本数据类型(速度快,有默认值,在方法栈中存值)
 * 		byte、short、int、long、float、double、char('')、boolean(false)
 * 	    long  赋值加L尾缀
 * 	    float 赋值加f尾缀
 * 	    double赋值加d尾缀
 *
 * 	包装类(用new创建对象,默认为null,在堆中开辟空间,存指向堆的地址,有属性和方法)
 * 		Byte、Short、Int、Long、Float、Double、Charater、Boolean
 * 	    包装类型间的相等判断应该用equals
 *  基本数据类型和包装类之间会自动拆装箱
 *
 * 	引用类型
 * 	    类、接口、数组
 *
 * 	类型转换
 * 	    Integer.parseInt()   将字符串转为int类型
 * 	    Integer.intValue()   将Integer对象中的数据取出，返回一个int
 * 	    Integer.valueOf()    将字符串转为Integer对象
 */
class BaseDemo{
    byte a ;
    public static void main(String[] args){
        boolean booleanFlag = false;
        char charStr = 'a';
        byte byteNumber = 1;
        short shortNumber = 2;
        int intNumber = 1;
        long longNumber = 2147483648L;
        float floatNumber = 1.0f;
        double doubleNumber = 1.0d;

        // 将int 10 装箱为 Integer
        Integer n = 10;
        //自动将 Inetger n 自动拆箱为 int
        int m = n;

        //类型转换
        Integer x1 = Integer.valueOf("9");
        int x2 = Integer.parseInt("9");
        int x3 = x1.intValue();
    }
}


/**
 *  加减乘除运算规则(双目都用final修饰的类型不会转换)
 *   if 有double     都转成 double
 *   else if 有float 都转成 float
 *   else if 有long  都转成 long
 *   else            都转成 int
 *
 *  +=类型的赋值运算会将类型自动强转
 *
 *
 *  三目运算符规则
 *      表达式1 ？ 表达式2 : 表达式3
 *      表达式2和表达式3的结果如果是数字,转为范围大的类型
 * 	运算符优先级（单目乘除为关系，逻辑三目后赋值。 ）
 * 		() []
 * 		! +(正) -(负) ~ ++ --
 * 		* / %       取模：余数符号和除数(前面的)符号相等
 * 		+ -
 * 		<< >>
 * 		< <= > >=
 * 		== !=
 * 		& ^ |       逻辑运算符
 * 		&& ||       短路运算符：会短路
 * 		?:
 * 		= += -= *= /=
 *
 *  Math类：ceil()、floot()、round()
 *
 *  赋值运算有返回值,赋什么值返回什么
 */
class MathDemo{
    public static void main(String[] args){
        byte byte1 = 1, byte2 = 2;
        float float1 = 1.0f;
        double double1 = 1.5d;
        long long1 = 1L;

        // 会报错， 左边byte 右边int
        // byte1 = byte1 + byte2;

        // +=会将自动强转类型 等同于 (byte)(byte1+byte2 )
        byte1 += byte2;

        double doubleNumber = double1 + byte1;
        float floatNumber = float1 + byte1;
        long longNumber = long1 + byte1;
        int intNumber = byte1 + byte2;

        //向上取整(如果参数小于0且大于-1.0，结果为 -0)
        System.out.println(Math.ceil(1.3));
        //向下取整
        System.out.println(Math.floor(1.3));
        //四舍五入取整
        System.out.println(Math.round(1.5));


        //赋值运算,赋什么值返回什么
        System.out.println(intNumber = 15);
    }
}


/**
 * 字符串类型
 *  length()、valueOf()、split()、replace()、replaceALl()
 *
 * String,StringBuffer,StringBuilder
 * 	String：每次都返回新对象，开辟新空间,效率低
 * 	    底层：private final char value[];  final的数组,内容不可变,引用可变,但private权限修饰使其内容也不可变
 * 		在栈中存储指向堆中对象的地址可以改变，但地址所指的对象内容不可变，
 * 	StringBuffer和StringBuilder
 * 	    底层：char[] value;    对自身进行操作,内容可变(不返回新对象)
 * 		前者线程安全，后者线程不安全
 * 	速度StringBuilder>StringBuffer>String
 *
 */
class StringDemo{
    public static void main(String[] args){
        // 这行代码 会在常量池中先生成一个 "hello" 的字符串对象(前提是常量池中无该字符串对象)
        // 再去堆中new了一个 str的字符串对象， 所以这行代码会产生 1个或2个对象
        String str = new String("hello");
        //length() 获得字符串长度
        System.out.println(str.length());

        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        String str4 = new String("hello");
        System.out.println("str1和str2是否相等：" + (str1 == str2));
        System.out.println("str1和str2是否相等：" + str1.equals(str2));
        System.out.println("str1和str3是否相等：" + (str1 == str3));
        System.out.println("str1和str3是否相等：" + str1.equals(str3));
        System.out.println("str3和str4是否相等：" + (str3 == str4));
        System.out.println("str3和str4是否相等：" + str3.equals(str4));
    }
}


/**
 * Object类是所有类的父类
 *      toString()、hashCode()、getClass()、equals()、wait()、notify()、notifyAll()
 *      clone()、finalize()需要重写后才能用
 */
class ObjectDemo{
    String name;
    Integer age;
    public static void main(String[] args) throws InterruptedException {
        ObjectDemo objectDemo1 = new ObjectDemo();
        objectDemo1.name = "小明";
        objectDemo1.age = 18;
        //toString() 将对象转为字符串
        System.out.println(objectDemo1.toString());
        //hashCode() 获得变量的hash值
        System.out.println(objectDemo1.hashCode());
        //getClass() 获得变量的类名
        System.out.println(objectDemo1.getClass());
        //equals()  比较两个变量是否相等
        System.out.println(objectDemo1.equals(objectDemo1));
        //objectDemo11.wait();
        //objectDemo11.notify();
        //objectDemo11.notifyAll();
    }
}


/**
 * 分支 if 语句
 * 	if (Boolean) {}
 * 	else if (Boolean) {}
 * 	else {}
 * 	赋值语句中
 * 	    n=1 会返回int,
 * 	    n=true,会返回boolean
 * 	    所以 条件为 n=0会报错,n=true则不报错
 */
class IfDemo{
    public static void main(String[] args){
        int cnt = 2;
        if (cnt > 10){
            System.out.println("if语句：cnt 大于 10");
        }else if (cnt == 10){
            System.out.println("if语句：cnt 小于 10");
        }else {
            System.out.println("if语句：cnt 小于 10");
        }
    }
}


/**
 * 分支 switch 语句
 *  switch(表达式)： 表达式返回值类型 byte，short，char，int，枚举(jdk1.5)，String(jdk1.7)
 *  case： 匹配值必须是常量，且不同，没有break则会执行后面所有的case
 *  default(可选)：都没匹配上，则执行default
 *  switch(表达式){
 *      case 匹配值:
 *      case 匹配值：
 *      break:
 *  }
 */
class SwitchDemo{
    public static void main(String[] args){
        int cnt = 3;
        switch(cnt){
            case 1:
                System.out.println("switch语句：cnt = 1");
                break;
            case 2:
                System.out.println("switch语句：cnt = 2");
                break;
            case 3:
                System.out.println("switch语句：cnt = 3");
                break;
            case 4:
                System.out.println("switch语句：cnt = 4");
                break;
            case 5:
                System.out.println("switch语句：cnt = 5");
                break;
            default:
                System.out.println("switch语句：cnt 不在 1-5 之间");
                break;
        }
    }
}


/**
 * 循环 for语句
 * 	先判断,true（执行语句，最后自增1），false（跳出循环）
 * 	 for(int i = 1; i <= 5; i++) {
 *   }
 *   continue:    跳出当次循环
 *   break:       跳出当前循环
 *   break 标记处：跳出多重嵌套循环
 */
class ForDemo {
    public static void main(String[] args){
        for(int i = 1; i <= 5; i++) {
            if (i==2){
                continue;
            }else if(i==4){
                System.out.println("");
                break;
            }
            System.out.println(i);
        }
        tag:
        for(int i = 1; i <= 5; i++){
            for (int j = 1; j <= 5; j++){
                if (j == 3){
                    break tag;
                }
                System.out.println(j);
            }
        }
    }
}


/**
 * 循环 foreach语句
 * 	 for (int number:numberList){
 *   }
 */
class ForEachDemo {
    public static void main(String[] args) {
        int[] numberList = {1,3,5,7,9};
        for (int number:numberList){
            System.out.println(number);
        }
    }
}


/**
 * 循环 while语句
 * 	while(cnt <= 5){
 *  }
 */
class WhileDemo {
    public static void main(String[] args) {
        int cnt = 1;
        while(cnt <= 5){
            System.out.println(cnt);
            cnt++;
        }
    }
}


/**
 * 	循环 do while语句
 * 	do{
 *  }while (cnt <= 5);
 */
class DoWhileDemo {
    public static void main(String[] args) {
        int cnt = 1;
        do{
            System.out.println(cnt);
            cnt++;
        }while (cnt <= 5);
    }
}


/**
 * 反射：可以在运行时加载使用编译期间完全未知的Class(但要知道类的名字)，同时获得类的方法和属性并调用
 * 	很多框架需要根据配置文件加载不同的对象和类，调用不同的方法，需要反射来动态的加载对象
 *  会破坏面向对象的封装特性
 */
class ReflexDemo {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        String str = "hello";
        //获得类,方式1
        Class c1 = str.getClass();
        //获得类,方式2
        Class c2 = String.class;
        //获得类,方式3
        Class c3 = Class.forName("java.lang.String");
        //获得类中的方法
        Method m = c1.getMethod("toUpperCase");
        //调用获得的方法
        System.out.println(m.invoke(str));
    }
}


