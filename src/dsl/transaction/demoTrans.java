package dsl.transaction;

import dsl.fragments.fragProc;
import dsl.fragments.fragRetry;
import dsl.fragments.fragWait;
import dsl.fragments.fragment;
import dsl.transInfo.transInfo;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhou1 on 2018/11/1.
 */
public class demoTrans {
    public static void main(String[] args){
        fragProc procedure = new fragProc(
                new fragWait("simpleWait",10000,new fragSimple()),
                new fragRetry(5,1000,new fragFail())
        );

        transaction ts = new transaction(procedure,"simpleTrans").WithObject(new myObj());
        ts.start();


        try{
            TimeUnit.SECONDS.sleep(1);
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

class fragFail implements fragment {
    private static int timeToSucc = 3;
    private int timeNow = 0;

    public void Exec(transInfo TransInfo) throws Exception{
        Object appInfo = TransInfo.getAppInfo();
        try{
            myObj m = (myObj) appInfo;
            m.sayHi();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("fail in :"+timeNow++);
        if (timeNow<3){
            throw new Exception("not ready");
        }
    }
}

class myObj{
    public void sayHi(){
        System.out.println("hello: "+this);
    }
}