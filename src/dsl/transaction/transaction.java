package dsl.transaction;

import dsl.fragments.fragWait;
import dsl.fragments.fragment;
import dsl.transInfo.transInfo;
import dsl.errors.*;
import java.util.*;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class transaction extends Thread {
    public fragments frag;
    public transInfo TransInfo;
    private String name;

    public transaction(fragments frag, String name){
        this.name = name;
        this.frag = frag;
        this.TransInfo = new transInfo("",this);
    }

    public synchronized void run() {
        try{
            frag.forEachFragments(this.TransInfo);
        }catch (ErrDsl e){
            System.out.println("got a DSL error:"+e);
            frag.backEachFragments(this.TransInfo,e.index);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void HandleEvent(String EventId)
        throws Exception{
        if (EventId.equals(this.TransInfo.getEventId())
                || EventId.length()==0){
            throw new ErrUnexepectedEvent();
        }
        this.notifyAll();
        this.TransInfo.setEventId("");
        return;
    }

    public static void main(String[] args){
        ArrayList<fragment> fl = new ArrayList<>();
        fl.add(new fragWait("simpleWait",1000,new fragSimple()));

        fragments fs = new fragments(fl);
        transaction ts = new transaction(fs,"simpleTrans");
        ts.start();
        System.out.println("outside");

        try{
            ts.HandleEvent("simpleWait");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class fragSimple implements fragment {
    public void Exec(transInfo TransInfo) throws Exception{
        System.out.println("simple run");
    }
}
