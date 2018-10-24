package dsl.fragments;

import dsl.transInfo.transInfo;

/**
 * Created by zhou1 on 2018/10/24.
 */
public interface fragment {
    void Exec(transInfo TransInfo) throws Exception;
//    void Rollback(transInfo TransInfo);
}