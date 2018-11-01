package dsl.errors;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class ErrDsl extends Exception{
    private int index;
    private Exception e;

    public final static int inValidIdx = -1;
    public ErrDsl(){
        index=inValidIdx;
        e = null;
    }

    public void setId(int i){index=i;}
    public int getId(){return index;}

    public void setInnerError(Exception e){
        this.e = e;
    }

    public String toString(){
        String eee = "Layer# idx:" + index + "\n";
        eee += this.e;
        return eee;
    }
}
