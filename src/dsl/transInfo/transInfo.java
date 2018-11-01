package dsl.transInfo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class transInfo {
    public int Times;
    public int LoopIdx;
    private volatile String EventId;
    private waitChannel wc;

    public Object AppInfo;
    class waitChannel{
        Lock lock;
        Condition condition;

        public waitChannel(){
            this.lock= new ReentrantLock();
            this.condition = lock.newCondition();
//            Lock lock = new ReentrantLock();
//            Condition condition = lock.newCondition();
        }

        public void notifyEvent() {
            //阻塞代码 read节点 读取数据到mReply
            lock.lock();//持锁发那个字阻塞代码之后
            condition.signalAll();
            lock.unlock();
        }
    }

    public transInfo(String eventId){
        this.EventId = eventId;
        this.wc = new waitChannel();
    }

    //通知wait当前等待结束
    public void notifyEvent(){
        this.wc.notifyEvent();
    }

    //在wait当中阻塞，如果是通过Condition唤醒返回true，超时返回false
    public boolean timeOut(int MilliSecond) throws InterruptedException {
        wc.lock.lock();
        boolean b = wc.condition.await(MilliSecond, TimeUnit.MILLISECONDS);//主线程5秒等待
        wc.lock.unlock();
        return b;
    }

    public void setEventId(String eId){
        synchronized (this){
            this.EventId = eId;
        }
    }

    public String getEventId(){
        synchronized (this){
            return this.EventId;
        }
    }

    public void setAppInfo(Object appInfo){
        this.AppInfo = appInfo;
    }

    public Object getAppInfo(){
        return this.AppInfo;
    }
}
