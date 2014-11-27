package Solver;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Cloud on 27.05.2014.
 */
public class MainMediumZ_H {
    public static void main(String[] args) throws Exception{
        //System.setOut(new PrintStream(new FileOutputStream("../CVC4/cvc4-1.3-win32-opt.txt")));

        // Satogaeri: Medium; Author: Z_H
        Puzzle puzzle = new Puzzle(10,10,"C:\\Users\\Cloud\\Studium\\SS 2014\\Bachelor thesis\\Satogaeri\\cvc4\\cvc4-1.3-win32-opt.exe --lang smt -m --statistics");

        puzzle.setCountryBlock(new Pair(0,0), new Pair(0,2), 1);
        puzzle.setCountryBlock(new Pair(1,0), new Pair(3,1), 2);
        puzzle.setCountryBlock(new Pair(4,0), new Pair(4,2), 3);
        puzzle.setCountryBlock(new Pair(5,0), new Pair(6,1), 4);
        puzzle.setCountryBlock(new Pair(7,0), new Pair(9,0), 5);
        Pair[] country6 = new Pair[1];
        country6[0] = new Pair(7,1);
        puzzle.setCountry(country6 ,6);
        puzzle.setCountryBlock(new Pair(8,1), new Pair(9,3), 7);
        Pair[] country8 = new Pair[1];
        country8[0] = new Pair(1,2);
        puzzle.setCountry(country8 ,8);
        puzzle.setCountryBlock(new Pair(2,2), new Pair(3,4), 9);
        puzzle.setCountryBlock(new Pair(5,2), new Pair(7,3), 10);
        puzzle.setCountryBlock(new Pair(0,3), new Pair(1,4), 11);
        Pair[] country12 = new Pair[1];
        country12[0] = new Pair(4,3);
        puzzle.setCountry(country12 ,12);
        puzzle.setCountryBlock(new Pair(4,4), new Pair(5,5), 13);
        Pair[] country14 = new Pair[1];
        country14[0] = new Pair(6,4);
        puzzle.setCountry(country14 ,14);
        puzzle.setCountryBlock(new Pair(7,4), new Pair(9,4), 15);
        puzzle.setCountryBlock(new Pair(0,5), new Pair(2,5), 16);
        Pair[] country17 = new Pair[1];
        country17[0] = new Pair(3,5);
        puzzle.setCountry(country17 ,17);
        puzzle.setCountryBlock(new Pair(6,5), new Pair(7,7), 18);
        puzzle.setCountryBlock(new Pair(8,5), new Pair(9,6), 19);
        puzzle.setCountryBlock(new Pair(0,6), new Pair(1,8), 20);
        puzzle.setCountryBlock(new Pair(2,6), new Pair(4,7), 21);
        Pair[] country22 = new Pair[1];
        country22[0] = new Pair(5,6);
        puzzle.setCountry(country22 ,22);
        puzzle.setCountryBlock(new Pair(5,7), new Pair(5,9), 23);
        Pair[] country24 = new Pair[1];
        country24[0] = new Pair(8,7);
        puzzle.setCountry(country24 ,24);
        puzzle.setCountryBlock(new Pair(9,7), new Pair(9,9), 25);
        Pair[] country26 = new Pair[1];
        country26[0] = new Pair(2,8);
        puzzle.setCountry(country26 ,26);
        puzzle.setCountryBlock(new Pair(3,8), new Pair(4,9), 27);
        puzzle.setCountryBlock(new Pair(6,8), new Pair(8,9), 28);
        puzzle.setCountryBlock(new Pair(0,9), new Pair(2,9), 29);

        puzzle.setCircle(new Pair(4,0), 1, 1);
        puzzle.setCircle(new Pair(7,0), 1, 2);
        puzzle.setCircle(new Pair(5,1), 2, 3);
        puzzle.setCircle(new Pair(6,1), 1, 4);
        puzzle.setCircle(new Pair(9,1), 2, 5);
        puzzle.setCircle(new Pair(3,2), 2, 6);
        puzzle.setCircle(new Pair(6,2), 2, 7);
        puzzle.setCircle(new Pair(8,2), -2, 8);
        puzzle.setCircle(new Pair(2,3), 1, 9);
        puzzle.setCircle(new Pair(1,4), 0, 10);
        puzzle.setCircle(new Pair(2,4), 1, 11);
        puzzle.setCircle(new Pair(4,4), -2, 12);
        puzzle.setCircle(new Pair(5,4), -2, 13);
        puzzle.setCircle(new Pair(7,4), 2, 14);
        puzzle.setCircle(new Pair(9,4), 2, 15);
        puzzle.setCircle(new Pair(0,5), 3, 16);
        puzzle.setCircle(new Pair(4,5), -2, 17);
        puzzle.setCircle(new Pair(5,5), -2, 18);
        puzzle.setCircle(new Pair(3,6), 2, 19);
        puzzle.setCircle(new Pair(8,6), -2, 20);
        puzzle.setCircle(new Pair(5,7), 1, 21);
        puzzle.setCircle(new Pair(4,8), 2, 22);
        puzzle.setCircle(new Pair(5,8), 1, 23);
        puzzle.setCircle(new Pair(7,8), 2, 24);
        puzzle.setCircle(new Pair(1,9), 2, 25);
        puzzle.setCircle(new Pair(2,9), -2, 26);
        puzzle.setCircle(new Pair(4,9), 1, 27);
        puzzle.setCircle(new Pair(5,9), -2, 28);
        puzzle.setCircle(new Pair(7,9), -2, 29);


        puzzle.savePuzzle("z_h");
        puzzle.generateSMT_QF_UF_Piping();
        puzzle.generateSMTPiping();

    }
}
