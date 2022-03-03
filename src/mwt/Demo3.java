package mwt;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 常见集合类
 * 	  Collection接口的子接口包括：Set接口和List接口
 * 		Set接口的实现类主要有：   HashSet、TreeSet、LinkedHashSet
 * 		List接口的实现类主要有：  ArrayList、LinkedList、Vector
 *    Map接口的实现类主要有：     HashMap、TreeMap、Hashtable、ConcurrentHashMap
 * 线程安全的容器(同步)：         Vector、Stack(继承了Vector)、Hashtable、ConcurrentHashMap、enumeration、properties
 *
 * Threadlocal使用开放定址法解决hash冲突，HashMap使用链地址法解决hash冲突
 */
public class Demo3 { }


/**
 * Set接口实现类有
 *   HashSet：      顺序可能变，非同步的，允许null值
 *   TreeSet：      对元素进行排序，顺序不变，非同步，不允许null值
 *   LinkedHashSet：用链表来维护元素的次序，顺序不变，非同步，允许null值
 *  重复的元素不会添加,通过重写equals()方法和hashCode()方法
 *
 *  add(),remove(),contains(),isEmpty(),size()
 */
class SetDemo{
    public static void main(String[] args){
        HashSet<String> hashSet = new HashSet<String>();
        TreeSet<String> treeSet = new TreeSet<String>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        //添加元素
        hashSet.add("holle");
        hashSet.add("baidu");
        hashSet.add(null);
        //删除元素
        hashSet.remove("hello");
        //判断元素是否存在
        System.out.println("hashSet是否包含hello元素：" + hashSet.contains("hello"));
        //判断是否为空
        System.out.println("hashSet是否为空：" + hashSet.isEmpty());
        //返回集合元素个数
        System.out.println("hashSet中元素个数为：" + hashSet.size());
        //迭代set
        for(String item : hashSet){
            System.out.println(item);
        }
    }
}


/**
 * 数组
 *   array:     大小固定,效率最高,可以包含基本类型和对象类型,length(获得数组长度)
 * List接口实现类有
 *   ArrayList: 容量动态增长,数组结构,访问快,线程不安全,只能包含对象类型
 *              默认数组大小是10,1.5倍扩容,最大值为Integer的最大值
 *   LinkedList:双向列表结构,通过移动指针来访问(迭代器),增删快,线程不安全,只能包含对象类型
 *   Vector:    是线程安全的ArrayList,同一时刻只有一个线程可以写入,只能包含对象类型
 *
 *  add(),indexOf(),isEmpty(),size(),get(),remove()
 */
class ListDemo{
    public static void main(String[] args){
        //array
        int[] numberList = new int[3];
        int numberList1[] = new int[3];
        numberList1[1] = 10;
        int numberList2[] = {1,3,5,7};
        //获得array数组长度
        System.out.println(numberList1.length);

        //ArrayList、LinkedList、Vector
        ArrayList<String> arrayList = new ArrayList<String>();
        LinkedList<String> linkedList = new LinkedList<String>();
        Vector<String> vector = new Vector<String>();
        //添加元素到末尾
        arrayList.add("hello");
        arrayList.add("baidu");
        arrayList.add("华为");
        //获得元素索引(-1表示 无)
        System.out.println("arrayList中hello元素的索引：" + arrayList.indexOf("hello"));
        //判断是否为空
        System.out.println("arrayList是否为空：" + arrayList.isEmpty());
        //获得列表元素个数
        System.out.println("arrayList的元素个数为："  + arrayList.size());
        //获得指定索引的元素
        System.out.println("arrayList中索引为1的元素：" + arrayList.get(1));
        //移除元素 remove(索引|第一次找到的元素)
        arrayList.remove(0);
        arrayList.remove("baidu");
        //遍历元素
        for(String item : arrayList){
            System.out.println(item);
        }

    }
}


/**
 * map字典
 * 	HashMap(使用的多),通过链地址法解决冲突
 * 	    允许一个K/多个V为null
 * 		重写了HashCode()和equals(),先通过HashCode获得hash值(数组下标)，在通过equals()获得正确的键值对(数组对应的链表中找)
 * 		使用数组+链表+红黑树实现，提升在hash冲突严重时（链表过长）的查找性能,链表O(n),红黑树是O(logn)
 * 		链表长度大于8的时候转为红黑树,达到6时转为链表
 * 		HashMap默认初始大小是16，扩容一定是2的指数,遍历速度和容量有关
 * 		非线程安全，不支持线程同步
 * 	Hashtable
 * 		数组结构,直接使用HashCode()
 * 		不允许键/值为Null
 * 		使用了synchronized关键字，同步，线程安全，所以速度慢
 * 	ConcurrentHashMap(多线程下使用的多,使用分段和管理锁,不使用synchronized关键字来保证同步)
 * 		同步，线程安全，引入分段锁概念，把map拆分成N个HashTable
 * 	LinkedHashMap
 * 		HashMap+双向链表 结构
 * 		HashMap的子类，iterator按照插入顺序遍历/在构造时带参数，按照访问次数排序遍历
 * 		遍历速度和实际数据有关, 和容量无关
 * 	TreeMap
 * 		实现SortMap接口，数据根据key排序(默认键值升序/指定排序比较器)，iterator按排序遍历
 *
 *  put(),get(),size(),keySet(),values(),remove(),clear()
 */
class MapDemo{
    public static void main(String[] args){
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        Hashtable<Integer, String> hashtable = new Hashtable<Integer, String> ();
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<Integer, String>();
        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<Integer, String>();
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        //添加键值对(k ,v)
        hashMap.put(3,"honor");
        hashMap.put(4,"huawei");
        //访问键值对
        System.out.println("hashMap中key为3的value是：" + hashMap.get(3));
        //获得键值对个数
        System.out.println("hashMap中键值对个数为：" + hashMap.size());
        //迭代(遍历key)
        for(Integer item : hashMap.keySet()){
            System.out.println(hashMap.get(item));
        }
        //迭代(遍历value)
        for(String item : hashMap.values()){
            System.out.println(item);
        }
        //删除键值对
        hashMap.remove(4);
        //删除所有键值对
        hashMap.clear();
    }
}
