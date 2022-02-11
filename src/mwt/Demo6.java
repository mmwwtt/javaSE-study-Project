package mwt;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 线程部分
 *  生命周期：新建、就绪、运行、阻塞、死亡（就绪态和运行态是双向的，其他都是按照顺序单向的）
 *  创建线程的方式
 * 	 继承Thread类
 * 	 实现runnable接口
 * 	 实现Callable接口
 * 	 使用线程池
 */
public class Demo6 {
}


/**
 * 继承Thread类创建线程
 */
class ExtendsThread extends Thread{
    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("继承Thread类的线程输出：" + i);
        }
    }
    public static void main(String[] args){
        ExtendsThread thread1 = new ExtendsThread();
        ExtendsThread thread2 = new ExtendsThread();
        thread1.start();
        thread2.start();
    }
}


/**
 * 实现Runnable接口创建线程 (推荐使用)
 */
class ImplementsRunnable implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("实现Runnable接口的线程输出：" + i);
        }
    }
    public static void main(String[] args){
        ImplementsRunnable implementsRunnable = new ImplementsRunnable();
        Thread thread1 = new Thread(implementsRunnable, "继承Runnable接口的线程1");
        Thread thread2 = new Thread(implementsRunnable, "继承Runnable接口的线程2");
        thread1.start();
        thread2.start();
    }
}


/**
 * 实现Callable接口创建线程（jdk1.5）
 */
class ImplementsCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for(int i = 0; i < 5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("实现Runnable接口的线程输出：" + i);
        }
        return "hello world";
    }

    public static void main(String[] args){
        Callable<String> callable = new ImplementsCallable();
        FutureTask<String> futureTask1 = new FutureTask<>(callable);
        FutureTask<String> futureTask2 = new FutureTask<>(callable);
        Thread thread1 = new Thread(futureTask1);
        Thread thread2 = new Thread(futureTask2);
        thread1.start();
        thread2.start();
    }
}


/**
 * 使用线程池创建线程
 */
class UseThreadPool{
    public static void main(String[] args){
        ExecutorService ex= Executors.newFixedThreadPool(5);
        ex.submit(new Runnable() {
            @Override
            public void run() {
                for(int j=0;j<10;j++) {
                    System.out.println(Thread.currentThread().getName()+j);
                }

            }
        });
        ex.shutdown();
    }
}
