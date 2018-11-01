package dsl.errors;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class ErrTimeout extends ErrDsl {
    private String eventId;
    public ErrTimeout(String id){
        eventId = id;
    }
    @Override
    public String toString(){
        return "Event " + eventId + " got Timeout";
    }
}
