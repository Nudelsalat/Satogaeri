package Solver;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Cloud on 04.09.2014.
 */
public class OwnList {
    List<Pair> ownList = new LinkedList<Pair>();

    public OwnList(){
    }

    public void add(Pair pair){
        ownList.add(pair);
    }

    public int size(){
        return ownList.size();
    }

    public ListIterator listIterator(){
        return ownList.listIterator();
    }

    public void remove(Pair pair){
        ownList.remove(pair);
    }

    public boolean contains(Pair pair){
        List<Pair> tempList = new LinkedList<Pair>();
        tempList.addAll(ownList);
        ListIterator<Pair> addIterator = tempList.listIterator();
        Pair containedPair;
        while(addIterator.hasNext()) {
            containedPair = addIterator.next();
            if(containedPair.getElement0()==pair.getElement0() && containedPair.getElement1() == pair.getElement1()){
                return true;
            }
            addIterator.remove();
        }
        return false;
    }

    public boolean isEmpty(){
        return ownList.isEmpty();
    }

    public void clear(){
        ownList.clear();
    }

    public Pair[] toArray(){
        Pair[] pair = new Pair[ownList.size()];
        int i = 0;
        for(Pair containedPairs : ownList){
            pair[i]=containedPairs;
            i++;
        }
        return pair;
    }

}
