package dsl.transInfo;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class transInfo {
    public int Times;
    public int LoopIdx;
    private volatile String EventId;
//    public volatile

    public Object AppInfo;
    public volatile Thread tranThread;

    public transInfo(String eventId, Thread tranThread){
        this.EventId = eventId;
        this.tranThread = tranThread;
    }

    public void threadWait() throws InterruptedException{
        this.tranThread.wait();
    }

    public void setEventId(String eId){
        this.EventId = eId;
    }

    public String getEventId(){
        return this.EventId;
    }
}
