package dsl.fragments;

import dsl.transInfo.transInfo;
import dsl.errors.*;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class fragSucc implements fragment{
    @Override
    public void Exec(transInfo TransInfo) throws Exception{
        throw new ErrSucc();
    }

    public void Rollback(transInfo TransInfo){
        return;
    }
}

