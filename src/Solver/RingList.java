package Solver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Cloud on 28.10.2014.
 */
public class RingList<T> implements Serializable {

    private T element;
    private ArrayList<T> linkedList;
    private int counterCurrentPos;
    final private int maxElements;

    public RingList(int numberElements){
        linkedList = new ArrayList<T>(numberElements);
        counterCurrentPos = 0;
        maxElements = numberElements;
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    public void add(T element){
        linkedList.add(counterCurrentPos, element);
        if(counterCurrentPos == maxElements-1){
            counterCurrentPos = 0;
        }else {
            counterCurrentPos++;
        }
    }

    public T get(){
        if(counterCurrentPos == 0){
            counterCurrentPos = maxElements-1;
            return linkedList.remove(maxElements-1);
        }else{
            counterCurrentPos = counterCurrentPos-1;
            return linkedList.remove(counterCurrentPos);
        }
    }

    public void clear(){
        counterCurrentPos = 0;
        linkedList.clear();
    }
}
