package Solver;

/**
 * Created by Cloud on 28.05.2014.
 */
public class MainEasySakamoto {
        public static void main(String[] args) {
            // Satogaeri: Easy; Author: Sakamoto Nobuyuki
            Puzzle puzzle = new Puzzle(10, 10);


            puzzle.setCountryBlock(new Pair(0,0), new Pair(1,4), 1);
            puzzle.setCountryBlock(new Pair(2,0), new Pair(4,1), 2);
            puzzle.setCountryBlock(new Pair(5,0), new Pair(5,2), 3);
            puzzle.setCountryBlock(new Pair(6,0), new Pair(9,2), 4);
            puzzle.setCountryBlock(new Pair(2,2), new Pair(4,4), 5);
            puzzle.setCountryBlock(new Pair(5,3), new Pair(9,5), 6);
            puzzle.setCountryBlock(new Pair(0,5), new Pair(4,6), 7);
            puzzle.setCountryBlock(new Pair(5,6), new Pair(7,9), 8);
            puzzle.setCountryBlock(new Pair(8,6), new Pair(9,9), 9);
            puzzle.setCountryBlock(new Pair(0,7), new Pair(2,9), 10);
            puzzle.setCountryBlock(new Pair(3,7), new Pair(4,9), 11);

            puzzle.setCircle(new Pair(0,0), 9, 1);
            puzzle.setCircle(new Pair(1,0), 2, 2);
            puzzle.setCircle(new Pair(3,2), -2, 3);
            puzzle.setCircle(new Pair(6,2), 3, 4);
            puzzle.setCircle(new Pair(2,3), 3, 5);
            puzzle.setCircle(new Pair(3,3), 5, 6);
            puzzle.setCircle(new Pair(8,4), 4, 7);
            puzzle.setCircle(new Pair(8,5), 7, 8);
            puzzle.setCircle(new Pair(4,6), 3, 9);
            puzzle.setCircle(new Pair(6,6), 3, 10);
            puzzle.setCircle(new Pair(8,6), 2, 11);

            puzzle.print();

            puzzle.generateSMTPiping();

            puzzle.print();
        }
}
