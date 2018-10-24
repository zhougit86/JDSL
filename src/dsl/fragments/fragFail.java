package dsl.fragments;

import dsl.transInfo.transInfo;
import dsl.errors.*;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class fragFail implements fragment{
    private Exception e;
    public fragFail(Exception e){
        this.e = e;
    }
    @Override
    public void Exec(transInfo TransInfo) throws Exception{
        throw e;
    }

    public void Rollback(transInfo TransInfo){
        return;
    }
}
