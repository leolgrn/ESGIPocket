package interfaces;

import java.util.ArrayList;

public interface ArrayListMapping<T, Y> {

    public ArrayList<T> map(ArrayList<Y> arrayList);

}