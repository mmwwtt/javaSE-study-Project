package mwt;

import java.io.IOException;

public class Demo5 {
}

/**
 * 异常处理(处理完异常后，代码继续执行)
 *  printStackTrace()  打印程序出错位置及原因
 *  try{} 中的运行结果会被暂存起来，return的依旧是暂存的结果,和之后finally对结果的修改无关
 *  catch异常时，子类异常放在前面捕获，父类放在后面
 *  finally 在return完成之前执行，如果finally使用了return语句，会使try/catch中的return失效
 *  可以不用catch,一定要finally
 */
class ExceptionDemo{
    public String fun() throws Exception {
        try{
            throw new Exception();
        }catch(Exception e){
            e.printStackTrace();
            return "helloCatch";
        }finally{
            System.out.println(" Exception 所有异常的父类");
            return "helloFinally";
        }
    }
    public static void main(String[] args) throws Exception {
        ExceptionDemo exceptionDemo = new ExceptionDemo();
        System.out.println(exceptionDemo.fun());
        System.out.println("ll");
    }

}
