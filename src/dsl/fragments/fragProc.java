package dsl.fragments;

import dsl.transInfo.transInfo;
import dsl.transaction.fragments;

/**
 * Created by zhou1 on 2018/10/25.
 */
public class fragProc implements fragment {
    private fragments fragment;

    public fragProc(fragments frag){
        this.fragment = frag;
    }

    public void Exec(transInfo TransInfo) throws Exception {

    }
}
