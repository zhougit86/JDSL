package dsl.transaction;

import dsl.fragments.fragProc;
import dsl.fragments.fragRetry;
import dsl.fragments.fragWait;
import dsl.fragments.fragment;
import dsl.transInfo.transInfo;
import dsl.errors.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class transaction extends Thread {
    public fragProc frag;
    public transInfo TransInfo;
    private String name;

    public transaction(fragProc frag, String name){
        this.name = name;
        this.frag = frag;
        this.TransInfo = new transInfo("");
    }

    public synchronized void run() {
        System.out.println("Transaction "+this.name+" has Started");
        try{
            frag.Exec(this.TransInfo);
        }catch (ErrDsl e){
            System.err.println("got a DSL error:\n"+e);
//            frag.backEachFragments(this.TransInfo,e.getId());
        }catch (Exception e){
            System.out.println("other unexpected failure");
            e.printStackTrace();
        }
    }

    public void HandleEvent(String EventId)
        throws Exception{

        if (!EventId.equals(this.TransInfo.getEventId())
                || EventId.length()==0){

            throw new ErrUnexepectedEvent(EventId);
        }
        this.TransInfo.notifyEvent();
        this.TransInfo.setEventId("");
        return;
    }

    public transaction WithObject(Object appInfo){
        this.TransInfo.setAppInfo(appInfo);
        return this;
    }
}
