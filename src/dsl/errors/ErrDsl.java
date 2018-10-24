package dsl.errors;

/**
 * Created by zhou1 on 2018/10/24.
 */
public class ErrDsl extends Exception{
    public int index;
    public final static int inValidIdx = -1;
    public ErrDsl(){index=inValidIdx;}
    public void setId(int i){index=i;}
}
