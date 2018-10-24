package dsl.transaction;

import dsl.fragments.fragment;
import dsl.transInfo.*;
import java.util.*;
import dsl.errors.*;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class fragments{
//    public ;
//    public
//
//    public fragments(){
//        fragList = new ArrayList<>();
//        TransInfo = new transInfo();
//    }
//
//    public fragments(ArrayList<fragment> frag, transInfo trans){
//        fragList = frag;
//        TransInfo = trans;
//    }
    public ArrayList<fragment> fragList;
    public int forEachFragments(transInfo TransInfo)
            throws Exception{
        for (int i = 0; i < fragList.size(); i++){
            try{
                fragList.get(i).Exec(TransInfo);
            }catch (ErrSucc e){
                System.out.printf("transaction %s success!\n",TransInfo);
                return 0;
            }catch (ErrDsl e){
                e.setId(i);
                throw e;
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

