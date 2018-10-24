package dsl.specification;

import dsl.transInfo.transInfo;
import java.util.*;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class anyOf implements spec {
    public ArrayList<spec> Specs;

    public anyOf(ArrayList<spec> Specs){
        this.Specs = Specs;
    }

    public boolean OK(transInfo tI){
        for (spec s:this.Specs){
            if (s.OK(tI)){
                return true;
            }
        }
        return false;
    }
}
