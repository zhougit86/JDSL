package dsl.transaction;

import dsl.fragments.fragment;
import dsl.transInfo.*;
import java.util.*;
import dsl.errors.*;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class fragments{
    private ArrayList<fragment> fragList;

    public fragments(ArrayList<fragment> fl){
        this.fragList = fl;
    }

    public int forEachFragments(transInfo TransInfo)
            throws Exception{
        for (int i = 0; i < fragList.size(); i++){
            try{
                fragList.get(i).Exec(TransInfo);
            }catch (ErrSucc e){
                System.out.printf("transaction %s success!\n",TransInfo);
                return 0;
            }catch (Exception e){
                ErrDsl eDsl = new ErrDsl();
                eDsl.setId(i);
                eDsl.setInnerError(e);

                throw eDsl;
            }
        }
        return 0;
    }

    public void backEachFragments(transInfo TransInfo, int idx){
        if (idx<=0){
            return;
        }
        //todo:rollback
//        for(int i =idx;i>0;)
    }
}

