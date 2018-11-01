package dsl.fragments;

import dsl.errors.ErrTimeout;
import dsl.transInfo.transInfo;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class fragWait implements fragment {
    private String EventId;
    private int MilliSecond;
    private fragment fragment;

    public fragWait(String eventId,int milliSecond,fragment fragment1){
        this.EventId = eventId;
        this.MilliSecond = milliSecond;
        this.fragment = fragment1;
    }

    @Override
    public void Exec(transInfo TransInfo) throws Exception{
        TransInfo.setEventId(this.EventId);
        System.out.println("begin wait");
        if (TransInfo.timeOut(MilliSecond)){
            TransInfo.setEventId("");
            this.fragment.Exec(TransInfo);
        }else{
            TransInfo.setEventId("");
            throw new ErrTimeout(this.EventId);
        }
    }
}
