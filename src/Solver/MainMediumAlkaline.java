package Solver;

/**
 * Created by Cloud on 28.05.2014.
 */
public class MainMediumAlkaline {
        public static void main(String[] args) {
            // Satogaeri: Medium; Author: Alkaline
            Puzzle puzzle = new Puzzle(18, 10);


            puzzle.setCountryBlock(new Pair(0,0), new Pair(1,3), 1);
            puzzle.setCountryBlock(new Pair(2,0), new Pair(8,0), 2);
            puzzle.setCountryBlock(new Pair(9,0), new Pair(11,2), 3);
            puzzle.setCountryBlock(new Pair(12,0), new Pair(13,2), 4);
            puzzle.setCountryBlock(new Pair(14,0), new Pair(16,1), 5);
            puzzle.setCountryBlock(new Pair(17,0), new Pair(17,2), 6);
            puzzle.setCountryBlock(new Pair(2,1), new Pair(4,2), 7);
            puzzle.setCountryBlock(new Pair(5,1), new Pair(5,6), 8);
            puzzle.setCountryBlock(new Pair(6,1), new Pair(8,3), 9);
            puzzle.setCountryBlock(new Pair(14,2), new Pair(16,2), 10);
            puzzle.setCountryBlock(new Pair(2,3), new Pair(4,3), 11);
            puzzle.setCountryBlock(new Pair(9,3), new Pair(10,5), 12);
            puzzle.setCountryBlock(new Pair(11,3), new Pair(11,5), 13);
            puzzle.setCountryBlock(new Pair(12,3), new Pair(12,8), 14);
            puzzle.setCountryBlock(new Pair(13,3), new Pair(15,5), 15);
            puzzle.setCountryBlock(new Pair(16,3), new Pair(17,5), 16);
            puzzle.setCountryBlock(new Pair(0,4), new Pair(1,6), 17);
            puzzle.setCountryBlock(new Pair(2,4), new Pair(4,6), 18);
            puzzle.setCountryBlock(new Pair(6,4), new Pair(6,6), 19);
            puzzle.setCountryBlock(new Pair(7,4), new Pair(8,6), 20);
            puzzle.setCountryBlock(new Pair(9,6), new Pair(11,8), 21);
            puzzle.setCountryBlock(new Pair(16,6), new Pair(17,9), 22);
            puzzle.setCountryBlock(new Pair(0,7), new Pair(0,9), 23);
            puzzle.setCountryBlock(new Pair(1,7), new Pair(3,7), 24);
            puzzle.setCountryBlock(new Pair(4,7), new Pair(5,9), 25);
            puzzle.setCountryBlock(new Pair(6,7), new Pair(8,9), 26);
            puzzle.setCountryBlock(new Pair(13,7), new Pair(15,8), 27);
            puzzle.setCountryBlock(new Pair(1,8), new Pair(3,9), 28);
            puzzle.setCountryBlock(new Pair(9,9), new Pair(15,9), 29);
            puzzle.setCountryBlock(new Pair(13,6), new Pair(15,6), 30);


            puzzle.setCircle(new Pair(0,0), 1, 1);
            puzzle.setCircle(new Pair(6,0), 4, 2);
            puzzle.setCircle(new Pair(13,0), -2, 3);
            puzzle.setCircle(new Pair(0,1), 2, 4);
            puzzle.setCircle(new Pair(6,1), 3, 5);
            puzzle.setCircle(new Pair(12,1), 2, 6);
            puzzle.setCircle(new Pair(16,1), 5, 7);
            puzzle.setCircle(new Pair(0,2), 3, 8);
            puzzle.setCircle(new Pair(6,2), 2, 9);
            puzzle.setCircle(new Pair(11,2), 2, 10);
            puzzle.setCircle(new Pair(10,3), 2, 11);
            puzzle.setCircle(new Pair(9,4), 0, 12);
            puzzle.setCircle(new Pair(2,4), 3, 13);
            puzzle.setCircle(new Pair(3,4), 2, 14);
            puzzle.setCircle(new Pair(4,4), 1, 15);
            puzzle.setCircle(new Pair(8,5), 3, 16);
            puzzle.setCircle(new Pair(13,5), 1, 17);
            puzzle.setCircle(new Pair(14,5), 2, 18);
            puzzle.setCircle(new Pair(15,5), 3, 19);
            puzzle.setCircle(new Pair(7,6), 0, 20);
            puzzle.setCircle(new Pair(6,7), 3, 21);
            puzzle.setCircle(new Pair(11,7), 3, 22);
            puzzle.setCircle(new Pair(17,7), 2, 23);
            puzzle.setCircle(new Pair(1,8),-2, 24);
            puzzle.setCircle(new Pair(5,8), 3, 25);
            puzzle.setCircle(new Pair(11,8), 4, 26);
            puzzle.setCircle(new Pair(17,8), 3, 27);
            puzzle.setCircle(new Pair(4,9), 3, 28);
            puzzle.setCircle(new Pair(11,9),-2, 29);
            puzzle.setCircle(new Pair(17,9), 4, 30);

            puzzle.print();
            puzzle.savePuzzle("alkaline");
            puzzle.generateSMTPiping();

            puzzle.print();
        }
}
