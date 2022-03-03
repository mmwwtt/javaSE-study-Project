package mwt;


import java.util.TreeSet;

public class Test
{
    private int a=10;
    int b=20;
    static int c=1;
    public static void main(String arg[])
    {
        Test t = new Test();
    }
}


class Test1 {
    public static void main(String[] args) {
        Object o = new Object() {
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }
}


//finally代码块在return中间执行。return的值会被放入临时空间，然后执行finally代码块，如果finally中有return，会刷新临时空间的值，方法结束返回临时空间值。
class Test3 {
    public static void main(String[] args) {
        System.out.println(test());

    }
    private static int test() {
        int temp = 1;
        try {
            System.out.println(temp);
            return ++temp;
        } catch (Exception e) {
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.println(temp);
        }
    }
}

class Demo{
    public static void main(String[] args) throws Exception {

        String str = "abc";

        System.out.println(str);  // abc

        str = test2(str);

        System.out.println(str);  // cba

    }

    private  static String test2(String str) {

        return "cba";

    }
}

class Test4{
    public static void main(String[] args){
        TreeSet<Integer> set = new TreeSet<Integer>();
        TreeSet<Integer> subSet = new TreeSet<Integer>();
        for(int i=606;i<613;i++){
            if(i%2==0){
                set.add(i);
            }
        }
        subSet = (TreeSet)set.subSet(608,true,611,true);
        set.add(609);
        System.out.println(set+" "+subSet);
    }
}


class Test5{
    public static void main(String[] args){
        System.out.println(2 << 3);
    }
}
