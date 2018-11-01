package dsl.fragments;

import dsl.errors.ErrDsl;
import dsl.transInfo.transInfo;
import dsl.transaction.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhou1 on 2018/10/25.
 */
public class fragProc implements fragment {
    private fragments fragment;

    public fragProc(fragments frags){
        this.fragment = frags;
    }

    public fragProc(fragment... fs){
        this.fragment = new fragments(
                new ArrayList<>(
                        Arrays.asList(
                            fs
                        )
                )
        );
    }

    public void Exec(transInfo TransInfo) throws Exception {
        try{
            int idx = fragment.forEachFragments(TransInfo);
        }catch (ErrDsl e){
            throw e;
        }
        System.out.println("Procedure Succeed");
    }
}
