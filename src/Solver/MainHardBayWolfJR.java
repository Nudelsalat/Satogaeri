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

            Pair[] country4 = new Pair[6];
            country4[0] = new Pair(0,3);
            country4[1] = new Pair(0,4);
            country4[2] = new Pair(1,4);
            country4[3] = new Pair(0,5);
            country4[4] = new Pair(1,5);
            country4[5] = new Pair(2,5);
            puzzle.setCountry(country4,333);

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

            Pair[] country11 = new Pair[9];
            country11[0] = new Pair(2, 3);
            country11[1] = new Pair(2, 4);
            country11[2] = new Pair(3, 4);
            country11[3] = new Pair(4, 4);
            country11[4] = new Pair(4, 3);
            country11[5] = new Pair(4, 2);
            country11[6] = new Pair(5, 2);
            country11[7] = new Pair(6, 2);
            country11[8] = new Pair(7, 2);
            puzzle.setCountry(country11,11);

            Pair[] country12 = new Pair[10];
            country12[0] = new Pair(2, 7);
            country12[1] = new Pair(2, 6);
            country12[2] = new Pair(3, 6);
            country12[3] = new Pair(3, 5);
            country12[4] = new Pair(4, 5);
            country12[5] = new Pair(5, 5);
            country12[6] = new Pair(5, 4);
            country12[7] = new Pair(6, 4);
            country12[8] = new Pair(5, 3);
            country12[9] = new Pair(6, 3);
            puzzle.setCountry(country12,12);

            Pair[] country13 = new Pair[4];
            country13[0] = new Pair(3, 8);
            country13[1] = new Pair(2, 8);
            country13[2] = new Pair(2, 9);
            country13[3] = new Pair(2,10);
            puzzle.setCountry(country13,13);

            Pair[] country14 = new Pair[6];
            country14[0] = new Pair(3, 0);
            country14[1] = new Pair(4, 0);
            country14[2] = new Pair(4, 1);
            country14[3] = new Pair(5, 0);
            country14[4] = new Pair(6, 0);
            country14[5] = new Pair(7, 0);
            puzzle.setCountry(country14,14);

            Pair[] country15 = new Pair[5];
            country15[0] = new Pair(3, 7);
            country15[1] = new Pair(4, 6);
            country15[2] = new Pair(4, 7);
            country15[3] = new Pair(4, 8);
            country15[4] = new Pair(4, 9);
            puzzle.setCountry(country15,15);

            Pair[] country16 = new Pair[6];
            country16[0] = new Pair(3, 9);
            country16[1] = new Pair(3,10);
            country16[2] = new Pair(3,11);
            country16[3] = new Pair(3,12);
            country16[4] = new Pair(3,13);
            country16[5] = new Pair(4,10);
            puzzle.setCountry(country16,16);

            Pair[] country17 = new Pair[7];
            country17[0] = new Pair(3,14);
            country17[1] = new Pair(4,14);
            country17[2] = new Pair(5,14);
            country17[3] = new Pair(6,14);
            country17[4] = new Pair(6,15);
            country17[5] = new Pair(6,16);
            country17[6] = new Pair(5,16);
            puzzle.setCountry(country17,17);

            Pair[] country18 = new Pair[7];
            country18[0] = new Pair(3,16);
            country18[1] = new Pair(4,16);
            country18[2] = new Pair(4,17);
            country18[3] = new Pair(5,17);
            country18[4] = new Pair(4,18);
            country18[5] = new Pair(5,18);
            country18[6] = new Pair(4,19);
            puzzle.setCountry(country18,18);

            Pair[] country19 = new Pair[12];
            country19[0] = new Pair(4 ,11);
            country19[1] = new Pair(4 ,12);
            country19[2] = new Pair(4 ,13);
            country19[3] = new Pair(5 ,11);
            country19[4] = new Pair(5 ,13);
            country19[5] = new Pair(6 ,11);
            country19[6] = new Pair(6 ,13);
            country19[7] = new Pair(7 ,11);
            country19[8] = new Pair(7 ,12);
            country19[9] = new Pair(7 ,13);
            country19[10] = new Pair(7 ,14);
            country19[11] = new Pair(8 ,13);
            puzzle.setCountry(country19,19);

            puzzle.setCountryBlock(new Pair(5,12), new Pair(6,12), 20);

            Pair[] country21 = new Pair[9];
            country21[0] = new Pair(5 , 1);
            country21[1] = new Pair(6 , 1);
            country21[2] = new Pair(7 , 1);
            country21[3] = new Pair(8 , 0);
            country21[4] = new Pair(8 , 1);
            country21[5] = new Pair(8 , 2);
            country21[6] = new Pair(9 , 2);
            country21[7] = new Pair(10, 2);
            country21[8] = new Pair(10, 1);
            puzzle.setCountry(country21,21);

            Pair[] country22 = new Pair[13];
            country22[0] = new Pair(5 , 6);
            country22[1] = new Pair(5 , 7);
            country22[2] = new Pair(5 , 8);
            country22[3] = new Pair(5 , 9);
            country22[4] = new Pair(6 , 6);
            country22[5] = new Pair(6 , 7);
            country22[6] = new Pair(6 , 9);
            country22[7] = new Pair(7 , 6);
            country22[8] = new Pair(7 , 9);
            country22[9] = new Pair(8 , 6);
            country22[10] = new Pair(8 , 7);
            country22[11] = new Pair(8 , 8);
            country22[12] = new Pair(8 , 9);
            puzzle.setCountry(country22,22);

            puzzle.setCountryBlock(new Pair(5,10), new Pair(7,10), 23);
            puzzle.setCountryBlock(new Pair(5,12), new Pair(6,12), 24);
            puzzle.setCountryBlock(new Pair(5,19), new Pair(6,19), 25);

            Pair[] country26 = new Pair[7];
            country26[0] = new Pair(6 , 5);
            country26[1] = new Pair(7 , 5);
            country26[2] = new Pair(8 , 5);
            country26[3] = new Pair(9 , 5);
            country26[4] = new Pair(9 , 6);
            country26[5] = new Pair(9 , 7);
            country26[6] = new Pair(9 , 8);
            puzzle.setCountry(country26,26);

            Pair[] country27 = new Pair[3];
            country27[0] = new Pair(6 , 8);
            country27[1] = new Pair(7 , 7);
            country27[2] = new Pair(7 , 8);
            puzzle.setCountry(country27,27);

            Pair[] country28 = new Pair[6];
            country28[0] = new Pair(6 ,17);
            country28[1] = new Pair(6 ,18);
            country28[2] = new Pair(7 ,18);
            country28[3] = new Pair(7 ,19);
            country28[4] = new Pair(8 ,18);
            country28[5] = new Pair(9 ,18);
            puzzle.setCountry(country28,28);

            Pair[] country29 = new Pair[9];
            country29[0] = new Pair(7 , 3);
            country29[1] = new Pair(7 , 4);
            country29[2] = new Pair(8 , 3);
            country29[3] = new Pair(8 , 4);
            country29[4] = new Pair(9 , 4);
            country29[5] = new Pair(10, 4);
            country29[6] = new Pair(11, 4);
            country29[7] = new Pair(12, 4);
            country29[8] = new Pair(12, 3);
            puzzle.setCountry(country29,29);

            Pair[] country30 = new Pair[6];
            country30[0] = new Pair(7 ,16);
            country30[1] = new Pair(7 ,15);
            country30[2] = new Pair(8 ,15);
            country30[3] = new Pair(8 ,14);
            country30[4] = new Pair(9 ,15);
            country30[5] = new Pair(10,15);
            puzzle.setCountry(country30,30);

            Pair[] country31 = new Pair[7];
            country31[0] = new Pair(7 ,17);
            country31[1] = new Pair(8 ,17);
            country31[2] = new Pair(8 ,16);
            country31[3] = new Pair(9 ,17);
            country31[4] = new Pair(9 ,16);
            country31[5] = new Pair(10,17);
            country31[6] = new Pair(10,16);
            puzzle.setCountry(country31,31);


            puzzle.setCountryBlock(new Pair(6,0), new Pair(8,1), 3);
            puzzle.setCountryBlock(new Pair(9,0), new Pair(11,1), 4);
            puzzle.setCircle(new Pair(29,19), 1, 120);


            puzzle.savePuzzle("BayWolfJR");
            puzzle.generateSMT_QF_UF_Piping();
            puzzle.generateSMTPiping();

        }
}
