package dsl.specification;

import dsl.transInfo.transInfo;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class not implements spec {
    public spec Spec;

    public not(spec spec){
        this.Spec = spec;
    }

    public boolean OK(transInfo tI){
        return !this.Spec.OK(tI);
    }
}
