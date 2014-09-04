package Solver;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * Created by Cloud on 04.09.2014.
 */
public class Scribbling {
        public static void main(String args[]) {
            List<Pair> activeFields = new LinkedList<Pair>();
            Pair pair1 = new Pair(1,3);
            Pair pair2 = new Pair(2,3);
            Pair pair3 = new Pair(3,3);
            Pair pair4 = new Pair(4,3);
            activeFields.add(pair1);
            activeFields.add(pair2);
            activeFields.remove(new Pair(1,3));

            activeFields.remove(pair1);

            ListIterator<Pair> addIterator = activeFields.listIterator();
            while(addIterator.hasNext()) {
                System.out.println(addIterator.next());
                addIterator.remove();
            }
        }
}
