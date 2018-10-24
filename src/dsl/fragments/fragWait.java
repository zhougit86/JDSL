package dsl.fragments;

import dsl.transInfo.transInfo;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class fragWait implements fragment {
    public String EventId;
    public int MilliSecond;
    public fragment fragment;

    public fragWait(String eventId,int milliSecond,fragment fragment1){
        this.EventId = eventId;
        this.MilliSecond = milliSecond;
        this.fragment = fragment1;
    }

    public void Exec(transInfo TransInfo) throws Exception{
        TransInfo.EventId = this.EventId;

    }
}
