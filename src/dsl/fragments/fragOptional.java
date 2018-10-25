package dsl.fragments;

import dsl.specification.spec;
import dsl.transInfo.transInfo;

/**
 * Created by zhou1 on 2018/10/25.
 */
public class fragOptional {
    private spec Specification;
    private fragment IfFrag;
    private fragment ElseFrag;
    private boolean IfFlag;
    private boolean ElseFlag;

    public fragOptional(spec specification,
                        fragment ifFrag, fragment elseFrag){
//                        boolean ifFlag, boolean elseFlag){
        this.Specification = specification;
        this.IfFrag = ifFrag;
        this.ElseFrag = elseFrag;
//        this.IfFlag = ifFlag;
//        this.ElseFlag = elseFlag;
    }

    public void Exec(transInfo TransInfo) throws Exception{
        if (this.Specification.OK(TransInfo)){
            this.IfFlag = true;
            this.IfFrag.Exec(TransInfo);
            return;
        }
        if (this.ElseFrag !=null){
            this.ElseFlag = true;
            this.ElseFrag.Exec(TransInfo);
            return;
        }
        return;
    }
}
