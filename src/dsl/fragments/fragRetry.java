package dsl.fragments;

import dsl.errors.ErrDsl;
import dsl.errors.ErrVoid;
import dsl.transInfo.transInfo;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhou1 on 2018/11/1.
 */
public class fragRetry implements fragment {
    private int MaxTimes;
    private int MilliSecond;
    private fragment Fragment;
    //todo：如果error在这个列表当中则返回
    private ArrayList<ErrDsl> Errs;

    public fragRetry(int maxTime,int milliSecond,fragment fragment1){
        this.MaxTimes = maxTime;
        this.MilliSecond = milliSecond;
        this.Fragment = fragment1;
        this.Errs = new ArrayList<>();
    }

    @Override
    public void Exec(transInfo TransInfo) throws Exception{
        Exception err = new ErrVoid();
        for (int i = 0; i<this.MaxTimes; i++){
            err = new ErrVoid();
            try {
                this.Fragment.Exec(TransInfo);
            }catch (Exception e){
                err=e;
            }

            //如果没有错误就返回
            if (err.getClass()==ErrVoid.class){
                return;
            }
            TimeUnit.MILLISECONDS.sleep(this.MilliSecond);
        }
        //如果有其他错误就return
        if (err.getClass()!=ErrVoid.class){
            throw err;
        }
    }

}
