package dsl.transaction;

import dsl.transInfo.transInfo;
import dsl.errors.*;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class transaction {
    public fragments frag;

    public transaction(fragments frag){
        this.frag = frag;
    }

    public void Start(transInfo TransInfo)
            throws Exception{
        try{
            frag.forEachFragments(TransInfo);
        }catch (ErrDsl e){
            System.out.println("got a DSL error:"+e);
            frag.backEachFragments(TransInfo,e.index);
        }
    }

    public void HandleEvent(String EventId,transInfo TransInfo)
        throws Exception{
        if (EventId.equals(TransInfo.EventId)
                || EventId.length()==0){
            throw new ErrUnexepectedEvent();
        }
        //todo:notify the channel
        TransInfo.EventId = "";
        return;
    }
}
