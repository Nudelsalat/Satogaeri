package Solver;

/**
 * Created by Cloud on 28.05.2014.
 */
public class MainHardBayWolfJR {
        public static void main(String[] args) {
            // Satogaeri: Hard; Author: Aiko
            Puzzle puzzle = new Puzzle(36, 20,"C:\\Users\\Cloud\\Studium\\SS 2014\\Bachelor thesis\\Satogaeri\\cvc4\\cvc4-1.3-win32-opt.exe --lang smt -m --statistics");

            puzzle.setCountryBlock(new Pair(0,0), new Pair(2,0), 1);
            puzzle.setCountryBlock(new Pair(0,1), new Pair(2,1), 2);

            Pair[] country3 = new Pair[7];
            country3[0] = new Pair(0,2);
            country3[1] = new Pair(1,2);
            country3[2] = new Pair(2,2);
            country3[3] = new Pair(3,2);
            country3[4] = new Pair(3,1);
            country3[5] = new Pair(3,3);
            country3[6] = new Pair(1,3);
            puzzle.setCountry(country3,3);

            puzzle.setCountryBlock(new Pair(0,6), new Pair(1,8), 4);
            puzzle.setCountryBlock(new Pair(0,8), new Pair(1,10), 5);
            puzzle.setCountryBlock(new Pair(0,11), new Pair(1,14), 6);


            Pair[] country7 = new Pair[9];
            country7[0] = new Pair(0,15);
            country7[1] = new Pair(1,15);
            country7[2] = new Pair(2,15);
            country7[3] = new Pair(2,16);
            country7[4] = new Pair(2,14);
            country7[5] = new Pair(2,13);
            country7[6] = new Pair(2,12);
            country7[7] = new Pair(2,11);
            country7[8] = new Pair(3,15);
            puzzle.setCountry(country7,7);

            Pair[] country8 = new Pair[5];
            country8[0] = new Pair(0,16);
            country8[1] = new Pair(1,16);
            country8[2] = new Pair(0,17);
            country8[3] = new Pair(0,18);
            country8[4] = new Pair(0,19);
            puzzle.setCountry(country8,8);

            puzzle.setCountryBlock(new Pair(1,17), new Pair(3,17), 9);
            puzzle.setCountryBlock(new Pair(1,18), new Pair(3,19), 10);


            puzzle.setCountryBlock(new Pair(6,0), new Pair(8,1), 3);
            puzzle.setCountryBlock(new Pair(9,0), new Pair(11,1), 4);
            puzzle.setCircle(new Pair(29,19), 1, 120);


            puzzle.savePuzzle("aiko");
            puzzle.generateSMT_QF_UF_Piping();
            puzzle.generateSMTPiping();

        }
}
