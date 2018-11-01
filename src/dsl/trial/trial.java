package dsl.trial;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhou1 on 2018/10/31.
 */
//this is a trial for the condition, nothing to do with the transdsl
public class trial {
    public static void main(String[] args){
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        another runnable = new another(lock, condition);
        new Thread(runnable, "thread—1").start();

        lock.lock();
        try {
            boolean b = condition.await(1, TimeUnit.SECONDS);//主线程5秒等待
            System.out.println(b);
        } catch (InterruptedException e) {
            System.out.println("time out");
        }
        lock.unlock();

        System.out.println("Condition met");

    }
}

class another extends Thread {
    Lock lock;
    Condition condition;

    public another(Lock lock1,Condition condition1){
        this.lock= lock1;
        this.condition = condition1;
    }

    public void run() {
        //阻塞代码 read节点 读取数据到mReply
//        try {
//            TimeUnit.SECONDS.sleep(6);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        lock.lock();//持锁发那个字阻塞代码之后
        condition.signalAll();
        lock.unlock();
    }
}
