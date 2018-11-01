package dsl.errors;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class ErrUnexepectedEvent extends ErrDsl {
    private String eventId;
    public ErrUnexepectedEvent(String id){
        eventId = id;
    }
    @Override
    public String toString(){
        return "Event " + eventId + " not Expected for now!";
    }
}
