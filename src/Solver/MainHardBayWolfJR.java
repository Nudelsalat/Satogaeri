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
            puzzle.setCountryBlock(new Pair(0,9), new Pair(1,10), 5);
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

            puzzle.setCountryBlock(new Pair(4,15), new Pair(5,15), 20);

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

            Pair[] country32 = new Pair[8];
            country32[0] = new Pair(8 ,10);
            country32[1] = new Pair(9 ,10);
            country32[2] = new Pair(9 , 9);
            country32[3] = new Pair(10, 9);
            country32[4] = new Pair(10, 8);
            country32[5] = new Pair(11, 8);
            country32[6] = new Pair(11, 7);
            country32[7] = new Pair(11, 6);
            puzzle.setCountry(country32,32);

            Pair[] country33 = new Pair[7];
            country33[0] = new Pair(8 ,11);
            country33[1] = new Pair(8 ,12);
            country33[2] = new Pair(9 ,11);
            country33[3] = new Pair(9 ,12);
            country33[4] = new Pair(10,10);
            country33[5] = new Pair(10,11);
            country33[6] = new Pair(10,12);
            puzzle.setCountry(country33,33);

            Pair[] country34 = new Pair[8];
            country34[0] = new Pair(8 ,19);
            country34[1] = new Pair(9 ,19);
            country34[2] = new Pair(10,19);
            country34[3] = new Pair(10,18);
            country34[4] = new Pair(11,18);
            country34[5] = new Pair(11,17);
            country34[6] = new Pair(12,17);
            country34[7] = new Pair(13,17);
            puzzle.setCountry(country34,34);

            Pair[] country35 = new Pair[18];
            country35[0] = new Pair(9 , 0);
            country35[1] = new Pair(9 , 1);
            country35[2] = new Pair(9 , 3);
            country35[3] = new Pair(10, 0);
            country35[4] = new Pair(10, 3);
            country35[5] = new Pair(11, 0);
            country35[6] = new Pair(11, 1);
            country35[7] = new Pair(11, 2);
            country35[8] = new Pair(11, 3);
            country35[9] = new Pair(12, 0);
            country35[10] = new Pair(13, 0);
            country35[11] = new Pair(14, 0);
            country35[12] = new Pair(14, 1);
            country35[13] = new Pair(14, 2);
            country35[14] = new Pair(14, 3);
            country35[15] = new Pair(15, 3);
            country35[16] = new Pair(15, 4);
            country35[17] = new Pair(16, 4);
            puzzle.setCountry(country35,35);

            Pair[] country36 = new Pair[6];
            country36[0] = new Pair(9 ,13);
            country36[1] = new Pair(9 ,14);
            country36[2] = new Pair(10,13);
            country36[3] = new Pair(10,14);
            country36[4] = new Pair(11,13);
            country36[5] = new Pair(12,13);
            puzzle.setCountry(country36,36);

            puzzle.setCountryBlock(new Pair(10,5), new Pair(10,7), 37);

            Pair[] country38 = new Pair[5];
            country38[0] = new Pair(11, 5);
            country38[1] = new Pair(12, 5);
            country38[2] = new Pair(13, 5);
            country38[3] = new Pair(14, 5);
            country38[4] = new Pair(14, 4);
            puzzle.setCountry(country38,38);

            Pair[] country39 = new Pair[4];
            country39[0] = new Pair(11, 9);
            country39[1] = new Pair(11,10);
            country39[2] = new Pair(11,11);
            country39[3] = new Pair(12,11);
            puzzle.setCountry(country39,39);

            Pair[] country40 = new Pair[11];
            country40[0] = new Pair(11,12);
            country40[1] = new Pair(12,12);
            country40[2] = new Pair(13,12);
            country40[3] = new Pair(13,13);
            country40[4] = new Pair(13,11);
            country40[5] = new Pair(13,10);
            country40[6] = new Pair(13, 9);
            country40[7] = new Pair(12, 9);
            country40[8] = new Pair(12,10);
            country40[9] = new Pair(14, 9);
            country40[10] = new Pair(14,10);
            puzzle.setCountry(country40,40);

            Pair[] country41 = new Pair[10];
            country41[0] = new Pair(11,14);
            country41[1] = new Pair(11,15);
            country41[2] = new Pair(11,16);
            country41[3] = new Pair(12,14);
            country41[4] = new Pair(12,15);
            country41[5] = new Pair(12,16);
            country41[6] = new Pair(13,14);
            country41[7] = new Pair(13,16);
            country41[8] = new Pair(14,14);
            country41[9] = new Pair(14,16);
            puzzle.setCountry(country41,41);

            Pair[] country42 = new Pair[8];
            country42[0] = new Pair(11,19);
            country42[1] = new Pair(12,19);
            country42[2] = new Pair(12,18);
            country42[3] = new Pair(13,19);
            country42[4] = new Pair(13,18);
            country42[5] = new Pair(14,19);
            country42[6] = new Pair(14,18);
            country42[7] = new Pair(14,17);
            puzzle.setCountry(country42,42);

            Pair[] country43 = new Pair[6];
            country43[0] = new Pair(12, 1);
            country43[1] = new Pair(12, 2);
            country43[2] = new Pair(13, 1);
            country43[3] = new Pair(13, 2);
            country43[4] = new Pair(13, 3);
            country43[5] = new Pair(13, 4);
            puzzle.setCountry(country43,43);

            Pair[] country44 = new Pair[9];
            country44[0] = new Pair(12, 6);
            country44[1] = new Pair(12, 7);
            country44[2] = new Pair(12, 8);
            country44[3] = new Pair(13, 6);
            country44[4] = new Pair(13, 7);
            country44[5] = new Pair(13, 8);
            country44[6] = new Pair(14, 6);
            country44[7] = new Pair(14, 7);
            country44[8] = new Pair(14, 8);
            puzzle.setCountry(country44,44);

            Pair[] country45 = new Pair[10];
            country45[0] = new Pair(13,15);
            country45[1] = new Pair(14,15);
            country45[2] = new Pair(15,15);
            country45[3] = new Pair(15,16);
            country45[4] = new Pair(15,17);
            country45[5] = new Pair(15,18);
            country45[6] = new Pair(15,19);
            country45[7] = new Pair(16,19);
            country45[8] = new Pair(17,19);
            country45[9] = new Pair(17,18);
            puzzle.setCountry(country45,45);

            puzzle.setCountryBlock(new Pair(14,11), new Pair(15,13), 46);
            puzzle.setCountryBlock(new Pair(15,0), new Pair(15,2), 47);
            puzzle.setCountryBlock(new Pair(15,5), new Pair(16,6), 48);
            puzzle.setCountryBlock(new Pair(15,7), new Pair(15,9), 49);

            Pair[] country50 = new Pair[10];
            country50[0] = new Pair(15,10);
            country50[1] = new Pair(16,10);
            country50[2] = new Pair(16,11);
            country50[3] = new Pair(16,12);
            country50[4] = new Pair(17,12);
            country50[5] = new Pair(16,13);
            country50[6] = new Pair(15,14);
            country50[7] = new Pair(16,14);
            country50[8] = new Pair(17,14);
            country50[9] = new Pair(16,15);
            puzzle.setCountry(country50,50);

            puzzle.setCountryBlock(new Pair(16,0), new Pair(19,1), 51);
            puzzle.setCountryBlock(new Pair(16,8), new Pair(18,9), 52);

            Pair[] country53 = new Pair[7];
            country53[0] = new Pair(16, 2);
            country53[1] = new Pair(16, 3);
            country53[2] = new Pair(17, 2);
            country53[3] = new Pair(17, 3);
            country53[4] = new Pair(18, 2);
            country53[5] = new Pair(18, 3);
            country53[6] = new Pair(19, 2);
            puzzle.setCountry(country53,53);

            Pair[] country54 = new Pair[8];
            country54[0] = new Pair(16, 7);
            country54[1] = new Pair(17, 6);
            country54[2] = new Pair(17, 7);
            country54[3] = new Pair(18, 6);
            country54[4] = new Pair(18, 7);
            country54[5] = new Pair(19, 6);
            country54[6] = new Pair(19, 7);
            country54[7] = new Pair(19, 8);
            puzzle.setCountry(country54,54);

            Pair[] country55 = new Pair[9];
            country55[0] = new Pair(16,18);
            country55[1] = new Pair(16,17);
            country55[2] = new Pair(16,16);
            country55[3] = new Pair(17,16);
            country55[4] = new Pair(18,16);
            country55[5] = new Pair(19,16);
            country55[6] = new Pair(19,17);
            country55[7] = new Pair(19,18);
            country55[8] = new Pair(19,19);
            puzzle.setCountry(country55,55);

            Pair[] country56 = new Pair[10];
            country56[0] = new Pair(17, 4);
            country56[1] = new Pair(17, 5);
            country56[2] = new Pair(18, 4);
            country56[3] = new Pair(18, 5);
            country56[4] = new Pair(19, 3);
            country56[5] = new Pair(19, 4);
            country56[6] = new Pair(19, 5);
            country56[7] = new Pair(20, 3);
            country56[8] = new Pair(20, 4);
            country56[9] = new Pair(20, 5);
            puzzle.setCountry(country56,56);

            puzzle.setCountryBlock(new Pair(17,10), new Pair(17,11), 57);
            puzzle.setCountryBlock(new Pair(18,10), new Pair(18,11), 58);

            Pair[] country59 = new Pair[17];
            country59[0] = new Pair(17,13);
            country59[1] = new Pair(17,15);
            country59[2] = new Pair(18,12);
            country59[3] = new Pair(18,13);
            country59[4] = new Pair(18,14);
            country59[5] = new Pair(18,15);
            country59[6] = new Pair(19,15);
            country59[7] = new Pair(19,12);
            country59[8] = new Pair(19,11);
            country59[9] = new Pair(19,10);
            country59[10] = new Pair(19, 9);
            country59[11] = new Pair(20, 9);
            country59[12] = new Pair(20,10);
            country59[13] = new Pair(20,11);
            country59[14] = new Pair(21, 9);
            country59[15] = new Pair(21,10);
            country59[16] = new Pair(21,11);
            puzzle.setCountry(country59,59);

            Pair[] country60 = new Pair[4];
            country60[0] = new Pair(17,17);
            country60[1] = new Pair(18,17);
            country60[2] = new Pair(18,18);
            country60[3] = new Pair(18,19);
            puzzle.setCountry(country60,60);

            Pair[] country61 = new Pair[9];
            country61[0] = new Pair(19,13);
            country61[1] = new Pair(19,14);
            country61[2] = new Pair(20,14);
            country61[3] = new Pair(20,15);
            country61[4] = new Pair(20,16);
            country61[5] = new Pair(21,16);
            country61[6] = new Pair(22,16);
            country61[7] = new Pair(22,15);
            country61[8] = new Pair(22,14);
            puzzle.setCountry(country61,61);

            Pair[] country62 = new Pair[10];
            country62[0] = new Pair(20, 2);
            country62[1] = new Pair(20, 1);
            country62[2] = new Pair(20, 0);
            country62[3] = new Pair(21, 2);
            country62[4] = new Pair(21, 1);
            country62[5] = new Pair(21, 0);
            country62[6] = new Pair(22, 2);
            country62[7] = new Pair(22, 1);
            country62[8] = new Pair(22, 0);
            country62[9] = new Pair(23, 0);
            puzzle.setCountry(country62,62);

            Pair[] country63 = new Pair[8];
            country63[0] = new Pair(21, 3);
            country63[1] = new Pair(21, 4);
            country63[2] = new Pair(21, 5);
            country63[3] = new Pair(22, 3);
            country63[4] = new Pair(22, 4);
            country63[5] = new Pair(22, 5);
            country63[6] = new Pair(23, 4);
            country63[7] = new Pair(23, 5);
            puzzle.setCountry(country63,63);

            Pair[] country64 = new Pair[9];
            country64[0] = new Pair(20, 6);
            country64[1] = new Pair(20, 7);
            country64[2] = new Pair(20, 8);
            country64[3] = new Pair(21, 6);
            country64[4] = new Pair(21, 7);
            country64[5] = new Pair(21, 8);
            country64[6] = new Pair(22, 6);
            country64[7] = new Pair(22, 7);
            country64[8] = new Pair(22, 8);
            puzzle.setCountry(country64,64);

            Pair[] country65 = new Pair[1];
            country65[0] = new Pair(20,12);
            puzzle.setCountry(country65,65);

            Pair[] country66 = new Pair[8];
            country66[0] = new Pair(20,13);
            country66[1] = new Pair(21,13);
            country66[2] = new Pair(21,14);
            country66[3] = new Pair(21,15);
            country66[4] = new Pair(22,13);
            country66[5] = new Pair(23,13);
            country66[6] = new Pair(24,13);
            country66[7] = new Pair(25,13);
            puzzle.setCountry(country66,66);

            puzzle.setCountryBlock(new Pair(20,17), new Pair(22,19), 67);

            Pair[] country68 = new Pair[10];
            country68[0] = new Pair(21,12);
            country68[1] = new Pair(22,12);
            country68[2] = new Pair(23,12);
            country68[3] = new Pair(24,12);
            country68[4] = new Pair(25,12);
            country68[5] = new Pair(25,11);
            country68[6] = new Pair(25,10);
            country68[7] = new Pair(25, 9);
            country68[8] = new Pair(26, 9);
            country68[9] = new Pair(27, 9);
            puzzle.setCountry(country68,68);

            puzzle.setCountryBlock(new Pair(22,9), new Pair(24,11), 69);

            Pair[] country70 = new Pair[9];
            country70[0] = new Pair(23, 1);
            country70[1] = new Pair(23, 2);
            country70[2] = new Pair(23, 3);
            country70[3] = new Pair(24, 3);
            country70[4] = new Pair(25, 3);
            country70[5] = new Pair(26, 3);
            country70[6] = new Pair(26, 2);
            country70[7] = new Pair(26, 1);
            country70[8] = new Pair(26, 0);
            puzzle.setCountry(country70,70);

            Pair[] country71 = new Pair[13];
            country71[0] = new Pair(23, 6);
            country71[1] = new Pair(23, 7);
            country71[2] = new Pair(23, 8);
            country71[3] = new Pair(24, 4);
            country71[4] = new Pair(24, 5);
            country71[5] = new Pair(24, 6);
            country71[6] = new Pair(24, 7);
            country71[7] = new Pair(24, 8);
            country71[8] = new Pair(25, 4);
            country71[9] = new Pair(25, 5);
            country71[10] = new Pair(25, 6);
            country71[11] = new Pair(25, 7);
            country71[12] = new Pair(25, 8);
            puzzle.setCountry(country71,71);

            Pair[] country72 = new Pair[13];
            country72[0] = new Pair(23,15);
            country72[1] = new Pair(23,14);
            country72[2] = new Pair(24,14);
            country72[3] = new Pair(25,14);
            country72[4] = new Pair(26,14);
            country72[5] = new Pair(27,14);
            country72[6] = new Pair(28,14);
            country72[7] = new Pair(29,14);
            country72[8] = new Pair(30,14);
            country72[9] = new Pair(30,13);
            country72[10] = new Pair(30,12);
            country72[11] = new Pair(29,12);
            country72[12] = new Pair(28,12);
            puzzle.setCountry(country72,72);

            Pair[] country73 = new Pair[7];
            country73[0] = new Pair(23,18);
            country73[1] = new Pair(23,17);
            country73[2] = new Pair(23,16);
            country73[3] = new Pair(24,18);
            country73[4] = new Pair(24,17);
            country73[5] = new Pair(24,16);
            country73[6] = new Pair(24,15);
            puzzle.setCountry(country73,73);

            Pair[] country74 = new Pair[10];
            country74[0] = new Pair(23,19);
            country74[1] = new Pair(24,19);
            country74[2] = new Pair(25,19);
            country74[3] = new Pair(26,19);
            country74[4] = new Pair(27,19);
            country74[5] = new Pair(27,18);
            country74[6] = new Pair(27,17);
            country74[7] = new Pair(28,18);
            country74[8] = new Pair(28,17);
            country74[9] = new Pair(28,16);
            puzzle.setCountry(country74,74);

            puzzle.setCountryBlock(new Pair(24,0), new Pair(25,2), 75);

            Pair[] country76 = new Pair[7];
            country76[0] = new Pair(25,15);
            country76[1] = new Pair(25,16);
            country76[2] = new Pair(25,17);
            country76[3] = new Pair(25,18);
            country76[4] = new Pair(26,15);
            country76[5] = new Pair(26,17);
            country76[6] = new Pair(26,18);
            puzzle.setCountry(country76,76);

            Pair[] country77 = new Pair[10];
            country77[0] = new Pair(26, 4);
            country77[1] = new Pair(26, 5);
            country77[2] = new Pair(27, 4);
            country77[3] = new Pair(27, 5);
            country77[4] = new Pair(28, 4);
            country77[5] = new Pair(28, 5);
            country77[6] = new Pair(28, 6);
            country77[7] = new Pair(29, 6);
            country77[8] = new Pair(29, 7);
            country77[9] = new Pair(29, 8);
            puzzle.setCountry(country77,77);

            puzzle.setCountryBlock(new Pair(26,6), new Pair(27,8), 78);

            Pair[] country79 = new Pair[7];
            country79[0] = new Pair(26, 10);
            country79[1] = new Pair(26, 11);
            country79[2] = new Pair(26,12);
            country79[3] = new Pair(26,13);
            country79[4] = new Pair(27,10);
            country79[5] = new Pair(28,10);
            country79[6] = new Pair(29,10);
            puzzle.setCountry(country79,79);

            Pair[] country80 = new Pair[7];
            country80[0] = new Pair(26,16);
            country80[1] = new Pair(27,16);
            country80[2] = new Pair(27,15);
            country80[3] = new Pair(28,15);
            country80[4] = new Pair(29,15);
            country80[5] = new Pair(29,16);
            country80[6] = new Pair(29,17);
            puzzle.setCountry(country80,80);

            puzzle.setCountryBlock(new Pair(27,0), new Pair(28,3), 81);

            Pair[] country82 = new Pair[6];
            country82[0] = new Pair(27,11);
            country82[1] = new Pair(27,12);
            country82[2] = new Pair(27,13);
            country82[3] = new Pair(28,11);
            country82[4] = new Pair(28,13);
            country82[5] = new Pair(29,13);
            puzzle.setCountry(country82,82);

            Pair[] country83 = new Pair[12];
            country83[0] = new Pair(28, 7);
            country83[1] = new Pair(28, 8);
            country83[2] = new Pair(28, 9);
            country83[3] = new Pair(29, 9);
            country83[4] = new Pair(30, 9);
            country83[5] = new Pair(30, 8);
            country83[6] = new Pair(30, 7);
            country83[7] = new Pair(30, 6);
            country83[8] = new Pair(31, 6);
            country83[9] = new Pair(31, 7);
            country83[10] = new Pair(31, 8);
            country83[11] = new Pair(32, 6);
            puzzle.setCountry(country83,83);

            Pair[] country84 = new Pair[10];
            country84[0] = new Pair(28,19);
            country84[1] = new Pair(29,18);
            country84[2] = new Pair(29,19);
            country84[3] = new Pair(30,19);
            country84[4] = new Pair(30,18);
            country84[5] = new Pair(30,17);
            country84[6] = new Pair(30,16);
            country84[7] = new Pair(30,15);
            country84[8] = new Pair(31,18);
            country84[9] = new Pair(31,19);
            puzzle.setCountry(country84,84);

            puzzle.setCountryBlock(new Pair(29,0), new Pair(30,3), 85);

            Pair[] country86 = new Pair[12];
            country86[0] = new Pair(29, 4);
            country86[1] = new Pair(29, 5);
            country86[2] = new Pair(30, 4);
            country86[3] = new Pair(30, 5);
            country86[4] = new Pair(31, 0);
            country86[5] = new Pair(31, 1);
            country86[6] = new Pair(31, 2);
            country86[7] = new Pair(31, 3);
            country86[8] = new Pair(31, 4);
            country86[9] = new Pair(31, 5);
            country86[10] = new Pair(32, 5);
            country86[11] = new Pair(33, 5);
            puzzle.setCountry(country86,86);

            Pair[] country87 = new Pair[6];
            country87[0] = new Pair(29,11);
            country87[1] = new Pair(30,10);
            country87[2] = new Pair(30,11);
            country87[3] = new Pair(31,11);
            country87[4] = new Pair(31,10);
            country87[5] = new Pair(32,11);
            puzzle.setCountry(country87,87);

            Pair[] country88 = new Pair[13];
            country88[0] = new Pair(31, 9);
            country88[1] = new Pair(32, 9);
            country88[2] = new Pair(32, 8);
            country88[3] = new Pair(32, 7);
            country88[4] = new Pair(33, 9);
            country88[5] = new Pair(34, 9);
            country88[6] = new Pair(34, 6);
            country88[7] = new Pair(34, 5);
            country88[8] = new Pair(35, 9);
            country88[9] = new Pair(35, 8);
            country88[10] = new Pair(35, 7);
            country88[11] = new Pair(35, 6);
            country88[12] = new Pair(35, 5);
            puzzle.setCountry(country88,88);

            Pair[] country89 = new Pair[14];
            country89[0] = new Pair(31,17);
            country89[1] = new Pair(31,16);
            country89[2] = new Pair(31,15);
            country89[3] = new Pair(31,14);
            country89[4] = new Pair(31,13);
            country89[5] = new Pair(31,12);
            country89[6] = new Pair(32,17);
            country89[7] = new Pair(32,14);
            country89[8] = new Pair(32,12);
            country89[9] = new Pair(33,12);
            country89[10] = new Pair(34,12);
            country89[11] = new Pair(34,13);
            country89[12] = new Pair(34,14);
            country89[13] = new Pair(34,15);
            puzzle.setCountry(country89,89);

            Pair[] country90 = new Pair[15];
            country90[0] = new Pair(32, 0);
            country90[1] = new Pair(32, 1);
            country90[2] = new Pair(32, 2);
            country90[3] = new Pair(32, 3);
            country90[4] = new Pair(32, 4);
            country90[5] = new Pair(33, 0);
            country90[6] = new Pair(33, 4);
            country90[7] = new Pair(34, 0);
            country90[8] = new Pair(34, 3);
            country90[9] = new Pair(34, 4);
            country90[10] = new Pair(35, 0);
            country90[11] = new Pair(35, 1);
            country90[12] = new Pair(35, 2);
            country90[13] = new Pair(35, 3);
            country90[14] = new Pair(35, 4);
            puzzle.setCountry(country90,90);

            puzzle.setCountryBlock(new Pair(32,10), new Pair(35,10), 91);

            Pair[] country92 = new Pair[5];
            country92[0] = new Pair(32,15);
            country92[1] = new Pair(32,13);
            country92[2] = new Pair(33,15);
            country92[3] = new Pair(33,14);
            country92[4] = new Pair(33,13);
            puzzle.setCountry(country92,92);

            Pair[] country93 = new Pair[6];
            country93[0] = new Pair(32,16);
            country93[1] = new Pair(33,16);
            country93[2] = new Pair(34,16);
            country93[3] = new Pair(35,16);
            country93[4] = new Pair(35,15);
            country93[5] = new Pair(35,14);
            puzzle.setCountry(country93,93);

            puzzle.setCountryBlock(new Pair(32,18), new Pair(32,19), 94);
            puzzle.setCountryBlock(new Pair(33,19), new Pair(35,19), 95);
            puzzle.setCountryBlock(new Pair(33,17), new Pair(35,18), 96);

            Pair[] country97 = new Pair[5];
            country97[0] = new Pair(33, 1);
            country97[1] = new Pair(33, 2);
            country97[2] = new Pair(33, 3);
            country97[3] = new Pair(34, 1);
            country97[4] = new Pair(34, 2);
            puzzle.setCountry(country97,97);

            Pair[] country98 = new Pair[5];
            country98[0] = new Pair(33, 6);
            country98[1] = new Pair(33, 7);
            country98[2] = new Pair(33, 8);
            country98[3] = new Pair(34, 7);
            country98[4] = new Pair(34, 8);
            puzzle.setCountry(country98,98);

            Pair[] country99 = new Pair[5];
            country99[0] = new Pair(33,11);
            country99[1] = new Pair(34,11);
            country99[2] = new Pair(35,11);
            country99[3] = new Pair(35,12);
            country99[4] = new Pair(35,13);
            puzzle.setCountry(country99,99);


            puzzle.setCircle(new Pair( 0, 3),-2, 1);
            puzzle.setCircle(new Pair( 0, 4), 4, 2);
            puzzle.setCircle(new Pair( 0,11), 2, 3);
            puzzle.setCircle(new Pair( 1, 1), 2, 4);
            puzzle.setCircle(new Pair( 1, 6), 1, 5);
            puzzle.setCircle(new Pair( 1,11), 3, 6);
            puzzle.setCircle(new Pair( 1,16), 1, 7);
            puzzle.setCircle(new Pair( 2, 3), 3, 8);
            puzzle.setCircle(new Pair( 2, 8), 5, 9);
            puzzle.setCircle(new Pair( 2,17), 2, 10);
            puzzle.setCircle(new Pair( 2,19), 2, 11);
            puzzle.setCircle(new Pair( 3, 7),-2, 12);
            puzzle.setCircle(new Pair( 3,11), 3, 13);
            puzzle.setCircle(new Pair( 4, 0), 5, 14);
            puzzle.setCircle(new Pair( 4,15),4, 15);
            puzzle.setCircle(new Pair( 4,18), 3, 16);
            puzzle.setCircle(new Pair( 5, 2), 2, 17);
            puzzle.setCircle(new Pair( 5, 6), 3, 18);
            puzzle.setCircle(new Pair( 5,12), 2, 19);
            puzzle.setCircle(new Pair( 5,17),-2, 20);
            puzzle.setCircle(new Pair( 6,10),-2, 21);
            puzzle.setCircle(new Pair( 6,14), 2, 22);
            puzzle.setCircle(new Pair( 6,19), 2, 23);
            puzzle.setCircle(new Pair( 7, 1), 2, 24);
            puzzle.setCircle(new Pair( 7, 7), 1, 25);
            puzzle.setCircle(new Pair( 7, 9),-2, 26);
            puzzle.setCircle(new Pair( 7,10),-2, 27);
            puzzle.setCircle(new Pair( 7,18), 1, 28);
            puzzle.setCircle(new Pair( 8, 0), 5, 29);
            puzzle.setCircle(new Pair( 8,11),-2, 30);
            puzzle.setCircle(new Pair( 8,17), 4, 31);
            puzzle.setCircle(new Pair( 9, 1), 3, 32);
            puzzle.setCircle(new Pair( 9,12),-2, 33);
            puzzle.setCircle(new Pair(10,13), 2, 34);
            puzzle.setCircle(new Pair(10,15),-2, 35);
            puzzle.setCircle(new Pair(11, 0),-2, 36);
            puzzle.setCircle(new Pair(11, 5), 4, 37);
            puzzle.setCircle(new Pair(11,10), 3, 38);
            puzzle.setCircle(new Pair(12, 3), 3, 39);
            puzzle.setCircle(new Pair(12, 8),-2, 40);
            puzzle.setCircle(new Pair(12,16), 3, 41);
            puzzle.setCircle(new Pair(13, 6), 3, 42);
            puzzle.setCircle(new Pair(13,14), 4, 43);
            puzzle.setCircle(new Pair(14, 2),-2, 44);
            puzzle.setCircle(new Pair(14, 9), 3, 45);
            puzzle.setCircle(new Pair(14,18), 2, 46);
            puzzle.setCircle(new Pair(15,11), 2, 47);
            puzzle.setCircle(new Pair(15,13), 4, 48);
            puzzle.setCircle(new Pair(16,15), 2, 49);
            puzzle.setCircle(new Pair(16,19), 3, 50);
            puzzle.setCircle(new Pair(17, 3), 3, 51);
            puzzle.setCircle(new Pair(17, 6), 3, 52);
            puzzle.setCircle(new Pair(17,12), 3, 53);
            puzzle.setCircle(new Pair(17,17), 4, 54);
            puzzle.setCircle(new Pair(18, 7), 3, 55);
            puzzle.setCircle(new Pair(19, 4), 4, 56);
            puzzle.setCircle(new Pair(19,18),-2, 57);
            puzzle.setCircle(new Pair(20, 3), 2, 58);
            puzzle.setCircle(new Pair(20, 5), 1, 59);
            puzzle.setCircle(new Pair(20, 9), 3, 60);
            puzzle.setCircle(new Pair(21, 2), 2, 61);
            puzzle.setCircle(new Pair(21,10),-2, 62);
            puzzle.setCircle(new Pair(21,15), 2, 63);
            puzzle.setCircle(new Pair(21,19), 2, 64);
            puzzle.setCircle(new Pair(22, 0), 4, 65);
            puzzle.setCircle(new Pair(22, 1), 4, 66);
            puzzle.setCircle(new Pair(22,10),-2, 67);
            puzzle.setCircle(new Pair(23, 6), 3, 68);
            puzzle.setCircle(new Pair(23,12), 3, 69);
            puzzle.setCircle(new Pair(23,14),-2, 70);
            puzzle.setCircle(new Pair(23,16), 4, 71);
            puzzle.setCircle(new Pair(24, 2), 3, 72);
            puzzle.setCircle(new Pair(24,15), 1, 73);
            puzzle.setCircle(new Pair(25, 4), 2, 74);
            puzzle.setCircle(new Pair(25,10), 4, 75);
            puzzle.setCircle(new Pair(26, 9), 3, 76);
            puzzle.setCircle(new Pair(26,14), 3, 77);
            puzzle.setCircle(new Pair(27, 2), 2, 78);
            puzzle.setCircle(new Pair(27, 7), 4, 79);
            puzzle.setCircle(new Pair(27,18),-2, 80);
            puzzle.setCircle(new Pair(28, 0), 4, 81);
            puzzle.setCircle(new Pair(28,19), 4, 82);
            puzzle.setCircle(new Pair(29, 5),-2, 83);
            puzzle.setCircle(new Pair(29,17), 2, 84);
            puzzle.setCircle(new Pair(30, 0), 3, 85);
            puzzle.setCircle(new Pair(30, 7), 2, 86);
            puzzle.setCircle(new Pair(30,13), 3, 87);
            puzzle.setCircle(new Pair(30,19), 4, 88);
            puzzle.setCircle(new Pair(31, 5), 5, 89);
            puzzle.setCircle(new Pair(31,14), 3, 90);
            puzzle.setCircle(new Pair(31,17), 3, 91);
            puzzle.setCircle(new Pair(32,11), 2, 92);
            puzzle.setCircle(new Pair(33, 3),-2, 93);
            puzzle.setCircle(new Pair(33,12),-2, 94);
            puzzle.setCircle(new Pair(34, 2), 3, 95);
            puzzle.setCircle(new Pair(35, 5), 1, 96);
            puzzle.setCircle(new Pair(35, 7), 3, 97);
            puzzle.setCircle(new Pair(35, 9), 1, 98);
            puzzle.setCircle(new Pair(35,13), 2, 99);
            puzzle.setCircle(new Pair(35,18), 2,100);



            puzzle.print();
            puzzle.savePuzzle("BayWolfJR");
            puzzle.generateSMT_QF_UF_Piping();
            puzzle.generateSMTPiping();

        }
}
