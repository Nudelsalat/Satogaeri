package Solver;

/**
 * Created by Cloud on 28.05.2014.
 */
public class MainMediumCasty {
        public static void main(String[] args) {
            // Satogaeri: Medium; Author: Alkaline
            Puzzle puzzle = new Puzzle(18, 10);


            puzzle.setCountryBlock(new Pair(0,0), new Pair(1,1), 1);

            Pair[] country2 = new Pair[4];
            country2[0] = new Pair(2,0);
            country2[1] = new Pair(2,1);
            country2[2] = new Pair(2,2);
            country2[3] = new Pair(1,2);
            puzzle.setCountry(country2, 2);

            Pair[] country3 = new Pair[5];
            country3[0] = new Pair(3,0);
            country3[1] = new Pair(4,0);
            country3[2] = new Pair(5,0);
            country3[3] = new Pair(3,1);
            country3[4] = new Pair(3,2);
            puzzle.setCountry(country3, 3);

            Pair[] country4 = new Pair[4];
            country4[0] = new Pair(6,0);
            country4[1] = new Pair(6,1);
            country4[2] = new Pair(5,1);
            country4[3] = new Pair(4,1);
            puzzle.setCountry(country4, 4);

            Pair[] country5 = new Pair[6];
            country5[0] = new Pair(7,0);
            country5[1] = new Pair(7,1);
            country5[2] = new Pair(7,2);
            country5[3] = new Pair(6,2);
            country5[4] = new Pair(5,2);
            country5[5] = new Pair(4,2);
            puzzle.setCountry(country5, 5);

            puzzle.setCountryBlock(new Pair(8,0), new Pair(12,0), 6);

            Pair[] country7 = new Pair[6];
            country7[0] = new Pair(13,0);
            country7[1] = new Pair(14,0);
            country7[2] = new Pair(15,0);
            country7[3] = new Pair(13,1);
            country7[4] = new Pair(13,2);
            country7[5] = new Pair(13,3);
            puzzle.setCountry(country7, 7);


            Pair[] country8 = new Pair[4];
            country8[0] = new Pair(16,0);
            country8[1] = new Pair(17,0);
            country8[2] = new Pair(17,1);
            country8[3] = new Pair(17,2);
            puzzle.setCountry(country8, 8);

            puzzle.setCountryBlock(new Pair(8,1), new Pair(9,2), 9);

            Pair[] country10 = new Pair[5];
            country10[0] = new Pair(10,1);
            country10[1] = new Pair(11,1);
            country10[2] = new Pair(12,1);
            country10[3] = new Pair(12,2);
            country10[4] = new Pair(12,3);
            puzzle.setCountry(country10, 10);

            puzzle.setCountryBlock(new Pair(14,1), new Pair(15,3),11);


            Pair[] country12 = new Pair[5];
            country12[0] = new Pair(16,1);
            country12[1] = new Pair(16,2);
            country12[2] = new Pair(16,3);
            country12[3] = new Pair(16,4);
            country12[4] = new Pair(15,4);
            puzzle.setCountry(country12, 12);


            Pair[] country13 = new Pair[5];
            country13[0] = new Pair(0,2);
            country13[1] = new Pair(0,3);
            country13[2] = new Pair(1,3);
            country13[3] = new Pair(2,3);
            country13[4] = new Pair(2,4);
            puzzle.setCountry(country13, 13);

            puzzle.setCountryBlock(new Pair(10,2), new Pair(11,4),14);
            puzzle.setCountryBlock(new Pair(3,3), new Pair(4,5),15);


            Pair[] country16 = new Pair[5];
            country16[0] = new Pair(5,3);
            country16[1] = new Pair(6,3);
            country16[2] = new Pair(7,3);
            country16[3] = new Pair(5,4);
            country16[4] = new Pair(5,5);
            puzzle.setCountry(country16, 16);

            Pair[] country17 = new Pair[6];
            country17[0] = new Pair(8,3);
            country17[1] = new Pair(8,4);
            country17[2] = new Pair(8,5);
            country17[3] = new Pair(8,6);
            country17[4] = new Pair(7,4);
            country17[5] = new Pair(6,4);
            puzzle.setCountry(country17,17);

            Pair[] country18 = new Pair[6];
            country18[0] = new Pair(9,3);
            country18[1] = new Pair(9,4);
            country18[2] = new Pair(9,5);
            country18[3] = new Pair(9,6);
            country18[4] = new Pair(10,5);
            country18[5] = new Pair(11,5);
            puzzle.setCountry(country18,18);

            Pair[] country19 = new Pair[4];
            country19[0] = new Pair(17,3);
            country19[1] = new Pair(17,4);
            country19[2] = new Pair(17,5);
            country19[3] = new Pair(16,5);
            puzzle.setCountry(country19, 19);

            Pair[] country20 = new Pair[4];
            country20[0] = new Pair(0,4);
            country20[1] = new Pair(0,5);
            country20[2] = new Pair(0,6);
            country20[3] = new Pair(1,4);
            puzzle.setCountry(country20, 20);

            Pair[] country21 = new Pair[5];
            country21[0] = new Pair(12,4);
            country21[1] = new Pair(12,5);
            country21[2] = new Pair(12,6);
            country21[3] = new Pair(11,6);
            country21[4] = new Pair(10,6);
            puzzle.setCountry(country21,21);

            puzzle.setCountryBlock(new Pair(13,4), new Pair(14,6), 22);

            Pair[] country22 = new Pair[5];
            country22[0] = new Pair(1,5);
            country22[1] = new Pair(1,6);
            country22[2] = new Pair(1,7);
            country22[3] = new Pair(1,8);
            country22[4] = new Pair(2,5);
            puzzle.setCountry(country22,37);

            puzzle.setCountryBlock(new Pair(6,5), new Pair(7,7),23);


            Pair[] country24 = new Pair[5];
            country24[0] = new Pair(15,5);
            country24[1] = new Pair(15,6);
            country24[2] = new Pair(16,6);
            country24[3] = new Pair(17,6);
            country24[4] = new Pair(17,7);
            puzzle.setCountry(country24,24);

            puzzle.setCountryBlock(new Pair(2,6), new Pair(3,8),25);


            Pair[] country26 = new Pair[6];
            country26[0] = new Pair(4,6);
            country26[1] = new Pair(4,7);
            country26[2] = new Pair(4,8);
            country26[3] = new Pair(4,9);
            country26[4] = new Pair(3,9);
            country26[5] = new Pair(2,9);
            puzzle.setCountry(country26,26);

            Pair[] country27 = new Pair[5];
            country27[0] = new Pair(5,6);
            country27[1] = new Pair(5,7);
            country27[2] = new Pair(5,8);
            country27[3] = new Pair(6,8);
            country27[4] = new Pair(7,8);
            puzzle.setCountry(country27,27);

            Pair[] country28 = new Pair[4];
            country28[0] = new Pair(0,7);
            country28[1] = new Pair(0,8);
            country28[2] = new Pair(0,9);
            country28[3] = new Pair(1,9);
            puzzle.setCountry(country28,28);

            puzzle.setCountryBlock(new Pair(8,7), new Pair(9,8), 30);

            Pair[] country29 = new Pair[5];
            country29[0] = new Pair(15,5);
            country29[1] = new Pair(15,6);
            country29[2] = new Pair(16,6);
            country29[3] = new Pair(17,6);
            country29[4] = new Pair(17,7);
            puzzle.setCountry(country29,29);


            Pair[] country31 = new Pair[6];
            country31[0] = new Pair(10,7);
            country31[1] = new Pair(11,7);
            country31[2] = new Pair(12,7);
            country31[3] = new Pair(13,7);
            country31[4] = new Pair(10,8);
            country31[5] = new Pair(10,9);
            puzzle.setCountry(country31,31);

            Pair[] country32 = new Pair[5];
            country32[0] = new Pair(14,7);
            country32[1] = new Pair(14,8);
            country32[2] = new Pair(14,9);
            country32[3] = new Pair(13,9);
            country32[4] = new Pair(12,9);
            puzzle.setCountry(country32,32);

            Pair[] country33 = new Pair[4];
            country33[0] = new Pair(15,7);
            country33[1] = new Pair(15,8);
            country33[2] = new Pair(15,9);
            country33[3] = new Pair(16,7);
            puzzle.setCountry(country33,33);

            puzzle.setCountryBlock(new Pair(16,8), new Pair(17,9), 34);

            Pair[] country36 = new Pair[4];
            country36[0] = new Pair(11,9);
            country36[1] = new Pair(11,8);
            country36[2] = new Pair(12,8);
            country36[3] = new Pair(13,8);
            puzzle.setCountry(country36,36);

            puzzle.setCountryBlock(new Pair(5,9), new Pair(9,9), 35);

            puzzle.setCircle(new Pair(1,0), 0, 1);
            puzzle.setCircle(new Pair(6,0), 2, 2);
            puzzle.setCircle(new Pair(9,0), -2, 3);
            puzzle.setCircle(new Pair(15,0), 2, 4);
            puzzle.setCircle(new Pair(17,0), 3, 5);
            puzzle.setCircle(new Pair( 0,1), 1, 6);
            puzzle.setCircle(new Pair( 3,1), 1, 7);
            puzzle.setCircle(new Pair(11,1), 1, 8);
            puzzle.setCircle(new Pair(14,1),-2, 9);
            puzzle.setCircle(new Pair( 2,2), 3, 10);
            puzzle.setCircle(new Pair( 6,2), 1, 11);
            puzzle.setCircle(new Pair(9,2), 2, 12);
            puzzle.setCircle(new Pair(16,2),-2, 13);
            puzzle.setCircle(new Pair(7,3), 3, 14);
            puzzle.setCircle(new Pair(0,4), 2, 15);
            puzzle.setCircle(new Pair(4,4), 1, 16);
            puzzle.setCircle(new Pair(6,4), 3, 17);
            puzzle.setCircle(new Pair(9,4), 2, 18);
            puzzle.setCircle(new Pair(11,4), 2, 19);
            puzzle.setCircle(new Pair(14,4), 1, 20);
            puzzle.setCircle(new Pair(17,4), 1, 21);
            puzzle.setCircle(new Pair(7,5), 2, 22);
            puzzle.setCircle(new Pair(12,5),-2, 23);
            puzzle.setCircle(new Pair(9,6), 2, 24);
            puzzle.setCircle(new Pair(17,6), 3, 25);
            puzzle.setCircle(new Pair(2,7),-2, 26);
            puzzle.setCircle(new Pair(0,8), 2, 27);
            puzzle.setCircle(new Pair(7,8),-2, 28);
            puzzle.setCircle(new Pair(9,8), 2, 29);
            puzzle.setCircle(new Pair(14,8), 1, 30);
            puzzle.setCircle(new Pair(3,9), 2, 31);
            puzzle.setCircle(new Pair(6,9), 1, 32);
            puzzle.setCircle(new Pair(10,9), 1, 33);
            puzzle.setCircle(new Pair(12,9), 1, 34);
            puzzle.setCircle(new Pair(15,9),-2, 35);
            puzzle.setCircle(new Pair(17,9),-2, 36);

            puzzle.print();

            puzzle.generateSMTPiping();

            puzzle.print();
        }
}
