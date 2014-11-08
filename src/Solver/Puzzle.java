package Solver;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Cloud on 27.05.2014.
 */
public class Puzzle implements Serializable {
    private Field[][] puzzle;
    private int width;
    private int height;
    private RingList<Pair[]> log_list = new RingList(25);

    public Puzzle(int width, int height){
        this.width = width;
        this.height = height;

        puzzle = new Field[width][height];
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                puzzle[x][y] = new Field();
            }
        }
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public int getCountry(int x, int y){
        return puzzle[x][y].getCountry();
    }

    public void setCountry(Pair[] pair, int value){
        for(Pair pos : pair){
            puzzle[pos.getElement0()][pos.getElement1()].setCountry(value, pair);
        }
    }

    public Boolean getInhabited(int x, int y){
        return puzzle[x][y].getInhabited();
    }
    // To set in a rectangular pattern. often used, and easier to write.
    // creates the pair array (representing the neighbors-list) and passes it t setCountry.
    public void setCountryBlock(Pair start, Pair end, int value){
        int size = (end.getElement0()-start.getElement0()+1) * (end.getElement1()-start.getElement1()+1);
        Pair[] pair = new Pair[size];
        for(int k=0,y = start.getElement1(); y <= end.getElement1(); y++){
            for(int x = start.getElement0(); x <= end.getElement0(); x++){
                pair[k] = new Pair(x,y);
                k++;
            }
        }
        setCountry(pair, value);
    }

    public void setIs_origin(int x, int y, boolean bool){
        puzzle[x][y].setIs_origin(bool);
    }

    public void setCircle(Pair pos, int value, int id_trace){
        puzzle[pos.getElement0()][pos.getElement1()].setCircle(value, id_trace);
        puzzle[pos.getElement0()][pos.getElement1()].setIs_origin(true);
    }

    public void setCircle_trace(Pair pos, int circleID){
        puzzle[pos.getElement0()][pos.getElement1()].setCircle_trace(circleID);
    }

    public int getCircle_trace(int x, int y){
        return puzzle[x][y].getCircle_trace();
    }

    public int getCircle_value(int x, int y){
        return puzzle[x][y].getCircle_value();
    }

    public Pair[] getNeighbors(Pair pair){
        return puzzle[pair.getElement0()][pair.getElement1()].getNeighbors();
    }

    public void setNeighbors(Pair[] pair, int x , int y){
        puzzle[x][y].setNeighbors(pair);
    }


    public String getCircleToString(int x, int y){
        return puzzle[x][y].toString();
    }

    public boolean getHas_moved(int x, int y){
        return puzzle[x][y].getHas_moved();
    }

    public Pair findCircle(int circle){
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                // && puzzle[x][y].getCircle_value()!=-1 important for shuffled-puzzle. because the trace is not the pos
                // of the circle! for there are multiple ids on the field of the same circle.
                if(puzzle[x][y].getCircle_trace() == circle && puzzle[x][y].getCircle_value()!=-1){
                    return new Pair(x,y);
                }
            }
        }
        System.out.println("###Circle: "+circle+" not found!");
        return null;
    }


    public void move(String[] strings){
        int circleID = Integer.parseInt(strings[2]);
        Pair posCircle = findCircle(circleID);
        Pair endPos = new Pair(Integer.parseInt(strings[0]),Integer.parseInt(strings[1]));
        puzzle[endPos.getElement0()][endPos.getElement1()].setCircle(puzzle[posCircle.getElement0()][posCircle.getElement1()].getCircle_value(),circleID);
        int circleValue = puzzle[posCircle.getElement0()][posCircle.getElement1()].getCircle_value();
        if(circleValue!=0 && !(endPos.getElement0()==posCircle.getElement0() && endPos.getElement1()==posCircle.getElement1())){
            puzzle[posCircle.getElement0()][posCircle.getElement1()].setCircle_value(-1);
        }
        if(posCircle.getElement0()<endPos.getElement0()){
            for(int x=posCircle.getElement0(),y=posCircle.getElement1();x<=endPos.getElement0();x++){
                puzzle[x][y].setCircle_trace(circleID);
                puzzle[x][y].setRight(true);
            }
        } else if(posCircle.getElement0()>endPos.getElement0()){
            for(int x=endPos.getElement0(),y=posCircle.getElement1();x<=posCircle.getElement0();x++){
                puzzle[x][y].setCircle_trace(circleID);
                puzzle[x][y].setLeft(true);
            }
        } else if(posCircle.getElement1()<endPos.getElement1()){
            for(int x=posCircle.getElement0(),y=posCircle.getElement1();y<=endPos.getElement1();y++){
                puzzle[x][y].setCircle_trace(circleID);
                puzzle[x][y].setDown(true);
            }
        } else if(posCircle.getElement1()>endPos.getElement1()){
            for(int x=posCircle.getElement0(),y=endPos.getElement1();y<=posCircle.getElement1();y++){
                puzzle[x][y].setCircle_trace(circleID);
                puzzle[x][y].setUp(true);
            }
        }
    }

    public boolean allAreUninhabited(Pair[] neighbors){
        for (Pair pair : neighbors) {
            if(puzzle[pair.getElement0()][pair.getElement1()].getHas_moved()) {
                return false;
            }
        }
        return true;
    }

    public boolean move(int posCircleX, int posCircleY, int endPosX, int endPosY){
        int circleID = puzzle[posCircleX][posCircleY].getCircle_trace();
        int circleValue = puzzle[posCircleX][posCircleY].getCircle_value();

        if(puzzle[posCircleX][posCircleY].getHas_moved()){
            if(circleValue == -2 && (
                    (posCircleX!=0 && circleID == puzzle[posCircleX-1][posCircleY].getCircle_trace() && endPosY == posCircleY)
                    ||
                    (posCircleX!=width && circleID == puzzle[posCircleX+1][posCircleY].getCircle_trace() && endPosY == posCircleY)
                    ||
                    (posCircleY!=0 && circleID == puzzle[posCircleX][posCircleY-1].getCircle_trace() && endPosX == posCircleX)
                    ||
                    (posCircleY!=height && circleID == puzzle[posCircleX][posCircleY+1].getCircle_trace() && endPosX == posCircleX)
                    ||
                    (posCircleX==endPosX && posCircleY==endPosY))){

                puzzle[posCircleX][posCircleY].setHas_moved(false);
                if(allAreUninhabited(puzzle[posCircleX][posCircleY].getNeighbors())) {
                    for (Pair pair : puzzle[posCircleX][posCircleY].getNeighbors()) {
                        puzzle[pair.getElement0()][pair.getElement1()].setInhabited(false);
                    }
                }

                // override all arrows to non arrows
                if (posCircleX < endPosX) {
                    for (int x = posCircleX; x < endPosX; x++) {
                        if(puzzle[x][posCircleY].getCircle_trace()==circleID && !puzzle[x][posCircleY].getRight() && !puzzle[x][posCircleY].getIs_origin()) {
                            puzzle[x][posCircleY].setCircle_trace(-1);
                            puzzle[x][posCircleY].setLeft(false);
                        }else{
                            puzzle[x][posCircleY].setCircle_trace(circleID);
                            puzzle[x][posCircleY].setLeft(false);
                            puzzle[x][posCircleY].setRight(true);
                        }
                    }
                    if(puzzle[endPosX][endPosY].getCircle_trace()!=circleID){
                        puzzle[endPosX][endPosY].setRight(true);
                    }
                } else if (posCircleX > endPosX) {
                    for (int x = endPosX+1; x <= posCircleX; x++) {
                        if(puzzle[x][posCircleY].getCircle_trace()==circleID && !puzzle[x][posCircleY].getLeft() && !puzzle[x][posCircleY].getIs_origin()) {
                            puzzle[x][posCircleY].setCircle_trace(-1);
                            puzzle[x][posCircleY].setRight(false);
                        }else{
                            puzzle[x][posCircleY].setCircle_trace(circleID);
                            puzzle[x][posCircleY].setRight(false);
                            puzzle[x][posCircleY].setLeft(true);
                        }
                    }
                    if(puzzle[endPosX][endPosY].getCircle_trace()!=circleID){
                        puzzle[endPosX][endPosY].setLeft(true);
                    }
                } else if (posCircleY < endPosY) {
                    for (int y = posCircleY; y < endPosY; y++) {
                        if(puzzle[posCircleX][y].getCircle_trace()==circleID && !puzzle[posCircleX][y].getDown() && !puzzle[posCircleX][y].getIs_origin()) {
                            puzzle[posCircleX][y].setCircle_trace(-1);
                            puzzle[posCircleX][y].setUp(false);
                        }else{
                            puzzle[posCircleX][y].setCircle_trace(circleID);
                            puzzle[posCircleX][y].setUp(false);
                            puzzle[posCircleX][y].setDown(true);
                        }
                    }
                    if(puzzle[endPosX][endPosY].getCircle_trace()!=circleID){
                        puzzle[endPosX][endPosY].setDown(true);
                    }
                } else if (posCircleY > endPosY) {
                    for (int y = endPosY+1; y <= posCircleY; y++) {
                        if(puzzle[posCircleX][y].getCircle_trace()==circleID && !puzzle[posCircleX][y].getUp() && !puzzle[posCircleX][y].getIs_origin()) {
                            puzzle[posCircleX][y].setCircle_trace(-1);
                            puzzle[posCircleX][y].setDown(false);
                        }else{
                            puzzle[posCircleX][y].setCircle_trace(circleID);
                            puzzle[posCircleX][y].setDown(false);
                            puzzle[posCircleX][y].setUp(true);
                        }
                    }
                    if(puzzle[endPosX][endPosY].getCircle_trace()!=circleID){
                        puzzle[endPosX][endPosY].setUp(true);
                    }
                }
                if(puzzle[endPosX][endPosY].getIs_origin()){
                    puzzle[endPosX][endPosY].setRight(false);
                    puzzle[endPosX][endPosY].setLeft(false);
                    puzzle[endPosX][endPosY].setUp(false);
                    puzzle[endPosX][endPosY].setDown(false);
                }
                if (!(endPosX == posCircleX && endPosY == posCircleY)) {
                    puzzle[posCircleX][posCircleY].setCircle_value(-1);
                }
                puzzle[endPosX][endPosY].setCircle(circleValue, circleID);
                if((endPosX!=0 && puzzle[endPosX-1][endPosY].getCircle_trace()==circleID) ||
                        (endPosX!=width && puzzle[endPosX+1][endPosY].getCircle_trace()==circleID) ||
                        (endPosY!=0 && puzzle[endPosX][endPosY-1].getCircle_trace()==circleID) ||
                        (endPosX!=height && puzzle[endPosX][endPosY+1].getCircle_trace()==circleID)) {
                    puzzle[endPosX][endPosY].setHas_moved(true);
                    for(Pair pair : puzzle[endPosX][endPosY].getNeighbors()){
                        puzzle[pair.getElement0()][pair.getElement1()].setInhabited(true);
                    }
                }else{
                    puzzle[endPosX][endPosY].setHas_moved(false);
                }

                return true;
// #### End -2 Circles #####
            }else if(puzzle[posCircleX][posCircleY].getCircle_trace() == puzzle[endPosX][endPosY].getCircle_trace() &&
                    (circleValue == Math.abs(posCircleX - endPosX) || circleValue == Math.abs(posCircleY - endPosY))) {

                // remove inhabitation of all Fields in country. IF there is no other hasMoved circle in there.
                puzzle[posCircleX][posCircleY].setHas_moved(false);
                if(allAreUninhabited(puzzle[posCircleX][posCircleY].getNeighbors())) {
                    for (Pair pair : puzzle[posCircleX][posCircleY].getNeighbors()) {
                        puzzle[pair.getElement0()][pair.getElement1()].setInhabited(false);
                    }
                }
                // override all arrows to non arrows
                if (circleValue != 0 && !(endPosX == posCircleX && endPosY == posCircleY)) {
                    puzzle[posCircleX][posCircleY].setCircle_value(-1);
                    puzzle[posCircleX][posCircleY].setCircle_trace(-1);
                }
                if (posCircleX < endPosX) {
                    for (int x = posCircleX; x <= endPosX; x++) {
                        puzzle[x][posCircleY].setCircle_trace(-1);
                        puzzle[x][posCircleY].setLeft(false);
                    }
                } else if (posCircleX > endPosX) {
                    for (int x = endPosX; x <= posCircleX; x++) {
                        puzzle[x][posCircleY].setCircle_trace(-1);
                        puzzle[x][posCircleY].setRight(false);
                    }
                } else if (posCircleY < endPosY) {
                    for (int y = posCircleY; y <= endPosY; y++) {
                        puzzle[posCircleX][y].setCircle_trace(-1);
                        puzzle[posCircleX][y].setUp(false);
                    }
                } else if (posCircleY > endPosY) {
                    for (int y = endPosY; y <= posCircleY; y++) {
                        puzzle[posCircleX][y].setCircle_trace(-1);
                        puzzle[posCircleX][y].setDown(false);
                    }
                }
                puzzle[endPosX][endPosY].setCircle(circleValue, circleID);
                puzzle[endPosX][endPosY].setHas_moved(false);
                return true;
            }

            return false;
        } else {
// #### not moved yet region
            System.out.println("INSIDE MOVE BITCH!!!!!\n" + " pos: " + endPosX + " " + endPosY + " ursprunge: " + posCircleX + " " + posCircleY);

            if(circleValue == 0 && (posCircleX!=endPosX || posCircleY!=endPosY)){
                return false;
            }
            // movement diagonal not allowed! invalid move
            if (posCircleX != endPosX && posCircleY != endPosY) {
                System.out.println("Keine Gerade, bitch!!!");
                return false;
            }

            // if the distance between endPos and circlePos isNOT circle value --> invalid move
            if (circleValue != -2 && !(circleValue == Math.abs(posCircleX - endPosX) || circleValue == Math.abs(posCircleY - endPosY))) {
                System.out.println("Movementrange != Value, bitch!!!");
                return false;
            }

            if (puzzle[endPosX][endPosY].getCircle_trace() != -1 && puzzle[endPosX][endPosY].getCircle_trace() != circleID) {
                System.out.println("Field already occupied, bitch!!!");
                return false;
            }
            if (posCircleX < endPosX) {
                for (int x = posCircleX; x <= endPosX; x++) {
                    if (puzzle[x][posCircleY].getCircle_trace() != -1 && puzzle[x][posCircleY].getCircle_trace() != circleID) {
                        System.out.println("There is a blockade on your path.");
                        return false;
                    }
                }
            } else if (posCircleX > endPosX) {
                for (int x = endPosX; x <= posCircleX; x++) {
                    if (puzzle[x][posCircleY].getCircle_trace() != -1 && puzzle[x][posCircleY].getCircle_trace() != circleID) {
                        System.out.println("There is a blockade on your path.");
                        return false;
                    }
                }
            } else if (posCircleY < endPosY) {
                for (int y = posCircleY; y <= endPosY; y++) {
                    if (puzzle[posCircleX][y].getCircle_trace() != -1 && puzzle[posCircleX][y].getCircle_trace() != circleID) {
                        System.out.println("There is a blockade on your path.");
                        return false;
                    }
                }
            } else if (posCircleY > endPosY) {
                for (int y = endPosY; y <= posCircleY; y++) {
                    if (puzzle[posCircleX][y].getCircle_trace() != -1 && puzzle[posCircleX][y].getCircle_trace() != circleID) {
                        System.out.println("There is a blockade on your path.");
                        return false;
                    }
                }
            }

            puzzle[endPosX][endPosY].setCircle(puzzle[posCircleX][posCircleY].getCircle_value(), circleID);
            // set inhabitation to the Country
            for(Pair pair : puzzle[endPosX][endPosY].getNeighbors()){
                puzzle[pair.getElement0()][pair.getElement1()].setInhabited(true);
            }
            if (circleValue != 0 && !(endPosX == posCircleX && endPosY == posCircleY)) {
                puzzle[posCircleX][posCircleY].setCircle_value(-1);
            }
            if (posCircleX < endPosX) {
                for (int x = posCircleX; x <= endPosX; x++) {
                    puzzle[x][posCircleY].setCircle_trace(circleID);
                    puzzle[x][posCircleY].setRight(true);
                }
            } else if (posCircleX > endPosX) {
                for (int x = endPosX; x <= posCircleX; x++) {
                    puzzle[x][posCircleY].setCircle_trace(circleID);
                    puzzle[x][posCircleY].setLeft(true);
                }
            } else if (posCircleY < endPosY) {
                for (int y = posCircleY; y <= endPosY; y++) {
                    puzzle[posCircleX][y].setCircle_trace(circleID);
                    puzzle[posCircleX][y].setDown(true);
                }
            } else if (posCircleY > endPosY) {
                for (int y = endPosY; y <= posCircleY; y++) {
                    puzzle[posCircleX][y].setCircle_trace(circleID);
                    puzzle[posCircleX][y].setUp(true);
                }
            }
            puzzle[endPosX][endPosY].setHas_moved(true);
            print();
            return true;
        }
    }

    public void print(){
        int size = width*4 + 5;
        StringBuilder horizontal_line = new StringBuilder(size);
        StringBuilder fields = new StringBuilder(size);
        horizontal_line.append("+");
        fields.append("|");
        for(int i = 0; i < width; i++){
            horizontal_line.append("---+");
        }
        System.out.println(horizontal_line);
        horizontal_line.delete(1, size);

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                // Numbers and vertical lines
                fields.append(puzzle[x][y].toString());
                if(x==width-1 || puzzle[x][y].getCountry() != puzzle[x+1][y].getCountry()){
                    fields.append("|");
                } else{
                    fields.append(" ");
                }

                // Horizontal lines
                if(y!=height-1 && puzzle[x][y].getCountry() == puzzle[x][y+1].getCountry()){
                    horizontal_line.append("   +");
                }else{
                    horizontal_line.append("---+");
                }
            }
            System.out.println(fields + "\n" + horizontal_line);
            fields.delete(1, size);
            horizontal_line.delete(1, size);
        }
    }

    public void generateSMT() {
        System.out.println("(set-logic QF_LIA)");
        // declare all fields and circle-plains
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.println("(declare-fun f" + x + "-" + y + " () Int)");
                System.out.println("(declare-fun c" + x + "-" + y + " () Int)");
            }
        }

        // encode countries
        List countries = new LinkedList<Integer>();
        int temp;
        Pair[] pair;
        StringBuilder string_countries = new StringBuilder();
// Build up Circle initial position I
        StringBuilder string_circle_init = new StringBuilder();
        string_circle_init.append("(assert (and");
// \I
        List circle_pos = new LinkedList<Solver.Pair>();


        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
// Build up Circle initial position II
                if (puzzle[x][y].getCircle_trace() >= 0 && puzzle[x][y].getCircle_value()!=-1) {
                    string_circle_init.append(" (= c" + x + "-" + y + " " + puzzle[x][y].getCircle_trace() + ")");
                    // save the positions of the circles for later.
                    circle_pos.add(new Solver.Pair(x, y));
                }
// \II
                temp = puzzle[x][y].getCountry();
                if (!countries.contains(temp)) {
                    countries.add(temp);
                    pair = puzzle[x][y].getNeighbors();
                    // (assert (or (and (> f0-0 0) (< f0-1 0) (< f1-0 0) (< f1-1 0) (< f2-0 0) (< f2-1 0) (< f3-0 0) (< f3-1 0) (< f4-0 0) (< f4-1 0))
                    string_countries.append("(assert (or");
                    for (Pair greater : pair) {
                        string_countries.append(" (and");
                        for (Pair element : pair) {
                            if (greater.equals(element)) {
                                string_countries.append(" (> f").append(element.getElement0()).append("-").append(element.getElement1()).append(" 0)");
                            } else {
                                string_countries.append(" (< f").append(element.getElement0()).append("-").append(element.getElement1()).append(" 0)");
                            }
                        }
                        string_countries.append(")");
                    }
                    string_countries.append("))");
                    System.out.println(string_countries);
                    string_countries.delete(0, string_countries.length());
                }
            }
        }
// Build up Circle initial position III
        string_circle_init.append("))");
        System.out.println(string_circle_init);
// \III

        // encode Movement of circles
        int movement, x, y, k;
        Pair position;
        Iterator iterator = circle_pos.iterator();
        boolean reachable = true;

        // (assert (or (and (= c0-2 c0-1) (= c0-3 c0-1) (= f0-3 c0-1)) (and (= c1-1 c0-1) (= c2-1 c0-1) (= f2-1 c0-1))))
        while (iterator.hasNext()) {
            k = 0;
            string_circle_init.delete(0, string_circle_init.length());
            string_circle_init.append("(assert (or");
            position = (Pair) iterator.next();
            x = position.getElement0();
            y = position.getElement1();
            movement = puzzle[x][y].getCircle_value();
            // Circles with no number:
                if (movement == -2) {
                    if (width > height) {
                        k = width;
                    } else {
                        k = height;
                    }
                    movement = 0;

                }
                for (int u = 0; u <= k; u++, movement++) {
                    if(movement == 0) {
                        string_circle_init.append(" (= f" + x + "-" + y + " c" + x + "-" + y + ")");
                    } else {
// right
                    for (int i = 1; i <= movement; i++) {
                        if (!(x + i < width) || !(puzzle[x + i][y].getCircle_value() == -1)) {
                            reachable = false;
                        }
                    }
                    if (reachable) {
                        string_circle_init.append(" (and");
                        for (int i = 1; i <= movement; i++) {
                            string_circle_init.append(" (= c" + (x + i) + "-" + y + " c" + x + "-" + y + ")");
                        }
                        string_circle_init.append(" (= f" + (x + movement) + "-" + y + " c" + x + "-" + y + "))");
                    }
                    reachable = true;
// left
                    for (int i = 1; i <= movement; i++) {
                        if ((x - i < 0) || !(puzzle[x - i][y].getCircle_value() == -1)) {
                            reachable = false;
                        }
                    }
                    if (reachable) {
                        string_circle_init.append(" (and");
                        for (int i = 1; i <= movement; i++) {
                            string_circle_init.append(" (= c" + (x - i) + "-" + y + " c" + x + "-" + y + ")");
                        }
                        string_circle_init.append(" (= f" + (x - movement) + "-" + y + " c" + x + "-" + y + "))");
                    }
                    reachable = true;
// down
                    for (int i = 1; i <= movement; i++) {
                        if (!(y + i < height) || !(puzzle[x][y + i].getCircle_value() == -1)) {
                            reachable = false;
                        }
                    }
                    if (reachable) {
                        string_circle_init.append(" (and");
                        for (int i = 1; i <= movement; i++) {
                            string_circle_init.append(" (= c" + x + "-" + (y + i) + " c" + x + "-" + y + ")");
                        }
                        string_circle_init.append(" (= f" + x + "-" + (y + movement) + " c" + x + "-" + y + "))");
                    }
                    reachable = true;
// up
                    for (int i = 1; i <= movement; i++) {
                        if ((y - i < 0) || !(puzzle[x][y - i].getCircle_value() == -1)) {
                            reachable = false;
                        }
                    }
                    if (reachable) {
                        string_circle_init.append(" (and");
                        for (int i = 1; i <= movement; i++) {
                            string_circle_init.append(" (= c" + x + "-" + (y - i) + " c" + x + "-" + y + ")");
                        }
                        string_circle_init.append(" (= f" + x + "-" + (y - movement) + " c" + x + "-" + y + "))");
                    }
                    reachable = true;
                }
            }
            string_circle_init.append("))");
            System.out.println(string_circle_init);
        }

        System.out.println("(check-sat)");
        for (int y1 = 0; y1 < height; y1++) {
            for (int x1 = 0; x1 < width; x1++) {
                System.out.println("(get-value (f"+ x1 +"-"+ y1 +"))");
            }
        }

    }

    public void generateSMTPiping() {
        String[] command = {"CMD", "/C", "cvc4-1.3-win32-opt.exe --lang smt -m --statistics"};
        ProcessBuilder probuilder = new ProcessBuilder( command );
        //You can set up your work directory
        probuilder.directory(new File("C:\\Users\\Cloud\\Studium\\SS 2014\\Bachelor thesis\\CVC4"));
        probuilder.redirectErrorStream(true);

        try {
            Process process = probuilder.start();

        OutputStream outs = process.getOutputStream();


        //Read out dir output
        InputStream ins = process.getInputStream();

        final BufferedReader reader = new BufferedReader (new InputStreamReader(ins));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outs));


            Thread one = new Thread() {
                public void run() {
                    try {
                        String line = reader.readLine();
                        while(line != null){
                            //System.out.println("before line-output");
                            if(line.contains("((f")){
                                System.out.println(""+line);
                                String[] numbers = parseResult(line);
                                //- 1 in the 3rd position of numbers means no circle there
                                if(!numbers[2].contentEquals("- 1") && !numbers[2].contentEquals("0")){
                                    move(numbers);
                                }
                            }else if(line.contains("sat::") || line.contains("theory::arith::cd::unatePropagateCalls") || line.contains("theory::arith::cd::unatePropagateImplications") || line.contains("theory::arith::status::nontrivialSatChecks")){
                                System.out.println("" + line);
                            }
                            line = reader.readLine();
                        }
                    } catch(IOException e) {
                        System.out.println(e);
                    }
                }
            };
            one.start();


        System.out.println("(set-logic QF_LIA)");
        writer.write("(set-logic QF_LIA)" +"\n");
        //writer.flush();
        // declare all fields and circle-plains
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.println("(declare-fun f" + x + "-" + y + " () Int)");
                writer.write("(declare-fun f" + x + "-" + y + " () Int)" + "\n");
                //writer.flush();
                System.out.println("(declare-fun c" + x + "-" + y + " () Int)");
                writer.write("(declare-fun c" + x + "-" + y + " () Int)" +"\n");
                //writer.flush();
            }
        }

        // encode countries
        List countries = new LinkedList<Integer>();
        int temp;
        Pair[] pair;
        StringBuilder string_countries = new StringBuilder();
//  Build up Circle initial position I
        StringBuilder string_circle_init = new StringBuilder();
        string_circle_init.append("(assert (and");
//  \I
        List circle_pos = new LinkedList<Solver.Pair>();


        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
//  Build up Circle initial position II
                //added:"&& puzzle[x][y].getCircle_value()!=-1" so that traces-only not get added to the circle_pos
                if (puzzle[x][y].getCircle_trace() >= 0 && puzzle[x][y].getCircle_value()!=-1) {
                    string_circle_init.append(" (= c" + x + "-" + y + " " + puzzle[x][y].getCircle_trace() + ")");
                    // save the positions of the circles for later.
                    circle_pos.add(new Solver.Pair(x, y));
                }
//  \II
                temp = puzzle[x][y].getCountry();
                if (!countries.contains(temp)) {
                    countries.add(temp);
                    pair = puzzle[x][y].getNeighbors();
                    // (assert (or (and (> f0-0 0) (< f0-1 0) (< f1-0 0) (< f1-1 0) (< f2-0 0) (< f2-1 0) (< f3-0 0) (< f3-1 0) (< f4-0 0) (< f4-1 0))
                    string_countries.append("(assert (or");
                    for (Pair greater : pair) {
                        string_countries.append(" (and");
                        for (Pair element : pair) {
                            if (greater.equals(element)) {
                                string_countries.append(" (> f").append(element.getElement0()).append("-").append(element.getElement1()).append(" 0)");
                            } else {
                                string_countries.append(" (< f").append(element.getElement0()).append("-").append(element.getElement1()).append(" 0)");
                            }
                        }
                        string_countries.append(")");
                    }
                    string_countries.append("))");
                    System.out.println(string_countries);
                    writer.write(string_countries + "\n");
                    //writer.flush();
                    string_countries.delete(0, string_countries.length());
                }
            }
        }
//  Build up Circle initial position III
        string_circle_init.append("))");
        System.out.println(string_circle_init);
        writer.write(string_circle_init +"\n");
        //writer.flush();
//  \III

        // encode Movement of circles
        int movement, x, y, k;
        Pair position;
        Iterator iterator = circle_pos.iterator();
        boolean reachable = true;

        // (assert (or (and (= c0-2 c0-1) (= c0-3 c0-1) (= f0-3 c0-1)) (and (= c1-1 c0-1) (= c2-1 c0-1) (= f2-1 c0-1))))
        while (iterator.hasNext()) {
            k = 0;
            string_circle_init.delete(0, string_circle_init.length());
            string_circle_init.append("(assert (or");
            position = (Pair) iterator.next();
            x = position.getElement0();
            y = position.getElement1();
            movement = puzzle[x][y].getCircle_value();
            // Circles with no number:
            if (movement == -2) {
                if (width > height) {
                    k = width;
                } else {
                    k = height;
                }
                movement = 0;

            }
            for (int u = 0; u <= k; u++, movement++) {
                if(movement == 0) {
                    string_circle_init.append(" (= f" + x + "-" + y + " c" + x + "-" + y + ")");
                } else {
//  right
                    for (int i = 1; i <= movement; i++) {
                        if (!(x + i < width) || !(puzzle[x + i][y].getCircle_value() == -1)) {
                            reachable = false;
                        }
                    }
                    if (reachable) {
                        string_circle_init.append(" (and");
                        for (int i = 1; i <= movement; i++) {
                            string_circle_init.append(" (= c" + (x + i) + "-" + y + " c" + x + "-" + y + ")");
                        }
                        string_circle_init.append(" (= f" + (x + movement) + "-" + y + " c" + x + "-" + y + "))");
                    }
                    reachable = true;
//  left
                    for (int i = 1; i <= movement; i++) {
                        if ((x - i < 0) || !(puzzle[x - i][y].getCircle_value() == -1)) {
                            reachable = false;
                        }
                    }
                    if (reachable) {
                        string_circle_init.append(" (and");
                        for (int i = 1; i <= movement; i++) {
                            string_circle_init.append(" (= c" + (x - i) + "-" + y + " c" + x + "-" + y + ")");
                        }
                        string_circle_init.append(" (= f" + (x - movement) + "-" + y + " c" + x + "-" + y + "))");
                    }
                    reachable = true;
//  down
                    for (int i = 1; i <= movement; i++) {
                        if (!(y + i < height) || !(puzzle[x][y + i].getCircle_value() == -1)) {
                            reachable = false;
                        }
                    }
                    if (reachable) {
                        string_circle_init.append(" (and");
                        for (int i = 1; i <= movement; i++) {
                            string_circle_init.append(" (= c" + x + "-" + (y + i) + " c" + x + "-" + y + ")");
                        }
                        string_circle_init.append(" (= f" + x + "-" + (y + movement) + " c" + x + "-" + y + "))");
                    }
                    reachable = true;
//  up
                    for (int i = 1; i <= movement; i++) {
                        if ((y - i < 0) || !(puzzle[x][y - i].getCircle_value() == -1)) {
                            reachable = false;
                        }
                    }
                    if (reachable) {
                        string_circle_init.append(" (and");
                        for (int i = 1; i <= movement; i++) {
                            string_circle_init.append(" (= c" + x + "-" + (y - i) + " c" + x + "-" + y + ")");
                        }
                        string_circle_init.append(" (= f" + x + "-" + (y - movement) + " c" + x + "-" + y + "))");
                    }
                    reachable = true;
                }
            }
            string_circle_init.append("))");
            System.out.println(string_circle_init);
            writer.write(string_circle_init +"\n");
            //writer.flush();
        }

        System.out.println("(check-sat)");
        writer.write("(check-sat)" +"\n");
        writer.flush();
        for (int y1 = 0; y1 < height; y1++) {
            for (int x1 = 0; x1 < width; x1++) {
                System.out.println("(get-value (f"+ x1 +"-"+ y1 +"))");
                writer.write("(get-value (f" + x1 + "-" + y1 + "))" + "\n");
                writer.flush();

                //line = reader.readLine();
                //System.out.println("-------RESULT-------");
                //System.out.println(line);
            }
        }

        writer.write("(exit)\n");
        writer.close();
        try {
            one.join();
        } catch (InterruptedException e){
            System.exit(-1);
        }
        reader.close();

        } catch (IOException e){

            e.printStackTrace();
            System.err.println("IOFailed");
            System.exit(-1);
        }
    }


    public boolean checkOnlyOneSolution(String string) {
        boolean only_one_solution = false;
        String[] command = {"CMD", "/C", "cvc4-1.3-win32-opt.exe --lang smt -m"};
        ProcessBuilder probuilder = new ProcessBuilder( command );
        //You can set up your work directory
        probuilder.directory(new File("C:\\Users\\Cloud\\Studium\\SS 2014\\Bachelor thesis\\CVC4"));
        probuilder.redirectErrorStream(true);

        final ExecutorService service;
        final Future<String> task;

        service = Executors.newFixedThreadPool(1);

        try {
            Process process = probuilder.start();

            OutputStream outs = process.getOutputStream();


            //Read out dir output
            InputStream ins = process.getInputStream();

            final BufferedReader reader = new BufferedReader (new InputStreamReader(ins));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outs));

            task = service.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    try {
                        System.out.println("Now inside Callable!!!");
                        String line = reader.readLine();
                        while(line != null){
                            //System.out.println("before line-output");
                            //System.out.println ("THREAD: " + line);
                            if(line.contentEquals("sat")) {
                                //print the solutions
                                System.out.println("Should be sat --> "+line);
                                return "false";
                            } else if(line.contentEquals("unsat")){
                                System.out.println("Should be unsat --> "+line);
                                return "true";
                            }


                            line = reader.readLine();
                        }
                    } catch(IOException e) {
                        System.out.println(e);
                    }
                    System.out.println("Fuck it!!! solltesch nit erreichen");
                    return "false";
                }
            });

            System.out.println("(set-logic QF_LIA)");
            writer.write("(set-logic QF_LIA)" +"\n");
            //writer.flush();
            // declare all fields and circle-plains
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    System.out.println("(declare-fun f" + x + "-" + y + " () Int)");
                    writer.write("(declare-fun f" + x + "-" + y + " () Int)" + "\n");
                    //writer.flush();
                    System.out.println("(declare-fun c" + x + "-" + y + " () Int)");
                    writer.write("(declare-fun c" + x + "-" + y + " () Int)" +"\n");
                    //writer.flush();
                }
            }

            // the only difference to generateSMT.
            System.out.println(string);
            writer.write(string);

            // encode countries
            List countries = new LinkedList<Integer>();
            int temp;
            Pair[] pair;
            StringBuilder string_countries = new StringBuilder();
//  Build up Circle initial position I
            StringBuilder string_circle_init = new StringBuilder();
            string_circle_init.append("(assert (and");
//  \I
            List circle_pos = new LinkedList<Solver.Pair>();


            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
//  Build up Circle initial position II
                    //added:"&& puzzle[x][y].getCircle_value()!=-1" so that traces-only not get added to the circle_pos
                    if (puzzle[x][y].getCircle_trace() >= 0 && puzzle[x][y].getCircle_value()!=-1) {
                        string_circle_init.append(" (= c" + x + "-" + y + " " + puzzle[x][y].getCircle_trace() + ")");
                        // save the positions of the circles for later.
                        circle_pos.add(new Solver.Pair(x, y));
                    }
//  \II
                    temp = puzzle[x][y].getCountry();
                    if (!countries.contains(temp)) {
                        countries.add(temp);
                        pair = puzzle[x][y].getNeighbors();
                        // (assert (or (and (> f0-0 0) (< f0-1 0) (< f1-0 0) (< f1-1 0) (< f2-0 0) (< f2-1 0) (< f3-0 0) (< f3-1 0) (< f4-0 0) (< f4-1 0))
                        string_countries.append("(assert (or");
                        for (Pair greater : pair) {
                            string_countries.append(" (and");
                            for (Pair element : pair) {
                                if (greater.equals(element)) {
                                    string_countries.append(" (> f" + element.getElement0() + "-" + element.getElement1() + " 0)");
                                } else {
                                    string_countries.append(" (< f" + element.getElement0() + "-" + element.getElement1() + " 0)");
                                }
                            }
                            string_countries.append(")");
                        }
                        string_countries.append("))");
                        System.out.println(string_countries);
                        writer.write(string_countries + "\n");
                        //writer.flush();
                        string_countries.delete(0, string_countries.length());
                    }
                }
            }
//  Build up Circle initial position III
            string_circle_init.append("))");
            System.out.println(string_circle_init);
            writer.write(string_circle_init +"\n");
            //writer.flush();
//  \III

            // encode Movement of circles
            int movement, x, y, k;
            Pair position;
            Iterator iterator = circle_pos.iterator();
            boolean reachable = true;

            // (assert (or (and (= c0-2 c0-1) (= c0-3 c0-1) (= f0-3 c0-1)) (and (= c1-1 c0-1) (= c2-1 c0-1) (= f2-1 c0-1))))
            while (iterator.hasNext()) {
                k = 0;
                string_circle_init.delete(0, string_circle_init.length());
                string_circle_init.append("(assert (or");
                position = (Pair) iterator.next();
                x = position.getElement0();
                y = position.getElement1();
                movement = puzzle[x][y].getCircle_value();
                // Circles with no number:
                if (movement == -2) {
                    if (width > height) {
                        k = width;
                    } else {
                        k = height;
                    }
                    movement = 0;

                }
                for (int u = 0; u <= k; u++, movement++) {
                    if(movement == 0) {
                        string_circle_init.append(" (= f" + x + "-" + y + " c" + x + "-" + y + ")");
                    } else {
//  right
                        for (int i = 1; i <= movement; i++) {
                            if (!(x + i < width) || !(puzzle[x + i][y].getCircle_value() == -1)) {
                                reachable = false;
                            }
                        }
                        if (reachable) {
                            string_circle_init.append(" (and");
                            for (int i = 1; i <= movement; i++) {
                                string_circle_init.append(" (= c" + (x + i) + "-" + y + " c" + x + "-" + y + ")");
                            }
                            string_circle_init.append(" (= f" + (x + movement) + "-" + y + " c" + x + "-" + y + "))");
                        }
                        reachable = true;
//  left
                        for (int i = 1; i <= movement; i++) {
                            if ((x - i < 0) || !(puzzle[x - i][y].getCircle_value() == -1)) {
                                reachable = false;
                            }
                        }
                        if (reachable) {
                            string_circle_init.append(" (and");
                            for (int i = 1; i <= movement; i++) {
                                string_circle_init.append(" (= c" + (x - i) + "-" + y + " c" + x + "-" + y + ")");
                            }
                            string_circle_init.append(" (= f" + (x - movement) + "-" + y + " c" + x + "-" + y + "))");
                        }
                        reachable = true;
//  down
                        for (int i = 1; i <= movement; i++) {
                            if (!(y + i < height) || !(puzzle[x][y + i].getCircle_value() == -1)) {
                                reachable = false;
                            }
                        }
                        if (reachable) {
                            string_circle_init.append(" (and");
                            for (int i = 1; i <= movement; i++) {
                                string_circle_init.append(" (= c" + x + "-" + (y + i) + " c" + x + "-" + y + ")");
                            }
                            string_circle_init.append(" (= f" + x + "-" + (y + movement) + " c" + x + "-" + y + "))");
                        }
                        reachable = true;
//  up
                        for (int i = 1; i <= movement; i++) {
                            if ((y - i < 0) || !(puzzle[x][y - i].getCircle_value() == -1)) {
                                reachable = false;
                            }
                        }
                        if (reachable) {
                            string_circle_init.append(" (and");
                            for (int i = 1; i <= movement; i++) {
                                string_circle_init.append(" (= c" + x + "-" + (y - i) + " c" + x + "-" + y + ")");
                            }
                            string_circle_init.append(" (= f" + x + "-" + (y - movement) + " c" + x + "-" + y + "))");
                        }
                        reachable = true;
                    }
                }
                string_circle_init.append("))");
                System.out.println(string_circle_init);
                writer.write(string_circle_init +"\n");
                //writer.flush();
            }

            System.out.println("(check-sat)");
            writer.write("(check-sat)" +"\n");
            writer.flush();

            writer.write("(exit)\n");
            writer.close();
            try {
                String answer = task.get();
                service.shutdownNow();
                System.out.println("answer to only one sat = " + answer);
                if(answer.equals("true")){
                    only_one_solution = true;
                }else if(answer.equals("false")){
                    only_one_solution = false;
                }
            } catch (InterruptedException e){
                System.exit(-1);
            }
            catch(final ExecutionException ex)
            {
                ex.printStackTrace();
            }
            reader.close();

        } catch (IOException e){

            e.printStackTrace();
            System.err.println("IOFailed");
            System.exit(-1);
        }
        return only_one_solution;
    }

    private void setField(Field field, int x, int y){
        Field newField = new Field();

        newField.setCountry(field.getCountry(),field.getNeighbors());
        newField.setInhabited(field.getInhabited());
        newField.setLeft(field.getLeft());
        newField.setRight(field.getRight());
        newField.setUp(field.getUp());
        newField.setDown(field.getDown());
        newField.setHas_moved(field.getHas_moved());
        newField.setIs_origin(field.getIs_origin());
        newField.setCircle_value(field.getCircle_value());
        newField.setCircle_trace(field.getCircle_trace());

        puzzle[x][y]=newField;
    }

    private Field getField(int x, int y){
        return puzzle[x][y];
    }

    public Puzzle clonePuzzle(){
        Puzzle clonedPuzzle = new Puzzle(width,height);
        for(int i = 0; i <width;i++){
            for(int j = 0; j <height;j++){
                clonedPuzzle.setField(puzzle[i][j],i,j);
            }
        }
        return clonedPuzzle;
    }

    public boolean logListIsEmpty(){
        return log_list.isEmpty();
    }

    public void logListAdd(int endX, int endY, int startX, int startY){
        Pair[] pair = new Pair[2];
        pair[0] = new Pair(endX, endY);
        pair[1] = new Pair(startX, startY);
        log_list.add(pair);
    }

    public void logListGet(){
        Pair[] pair = log_list.get();
        if(pair != null) {
            move(pair[0].getElement0(), pair[0].getElement1(), pair[1].getElement0(), pair[1].getElement1());
        }
    }

    public void clearLog(){
        log_list.clear();
    }

    public void overwritePuzzle(Puzzle newPuzzle){
        Puzzle clone = newPuzzle.clonePuzzle();
        for(int i = 0; i <width;i++){
            for(int j = 0; j <height;j++){
                puzzle[i][j]=clone.getField(i,j);
            }
        }
    }

    public void savePuzzle(String string){
        try {
            FileOutputStream saveFile = new FileOutputStream(string+".pzl");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);

            Puzzle clonedPuzzle = new Puzzle(width,height);
            for(int i = 0; i <width;i++){
                for(int j = 0; j <height;j++){
                    clonedPuzzle.setField(puzzle[i][j],i,j);
                }
            }
            save.writeObject(clonedPuzzle);

            save.close();
        } catch (Exception exc) {
            exc.printStackTrace(); // If there was an error, print the info.
        }
    }

    public Puzzle loadPuzzle(String string){
        try{
            FileInputStream loadFile;
            if(string.contains(".pzl")){
                loadFile = new FileInputStream(string);
            } else {
                loadFile = new FileInputStream(string + ".pzl");
            }

            ObjectInputStream load = new ObjectInputStream(loadFile);

            Puzzle loadedPuzzle = (Puzzle) load.readObject();

            load.close();
            return loadedPuzzle;
        }
        catch(Exception exc){
            exc.printStackTrace(); // If there was an error, print the info.
        }
        return null;
    }

    public boolean check(){
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if(!puzzle[x][y].getInhabited()){
                    return false;
                }
            }
        }
        return true;
    }

    static public String[] parseResult(String string){
        String pattern;
        pattern = "(\\(\\(f)(\\d+)(-)(\\d+)( *\\(*)(-* *\\d+)(\\)+)";
        String pattern2 = ";";
        string = string.replaceAll(pattern, "$2;$4;$6");

        return string.split(pattern2);
    }
}
