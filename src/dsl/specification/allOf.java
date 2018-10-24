package dsl.specification;

import dsl.transInfo.transInfo;
import java.util.*;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class allOf implements spec {
    public ArrayList<spec> Specs;

    public allOf(ArrayList<spec> Specs){
        this.Specs = Specs;
    }

    public boolean OK(transInfo tI){
        for (spec s:this.Specs){
            if (!s.OK(tI)){
                return false;
            }
        }
        return true;
    }
}
