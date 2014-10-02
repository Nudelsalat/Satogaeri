package Solver;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Cloud on 01.09.2014.
 */
public class Shuffler {
    private Puzzle puzzle;
    private int width;
    private int height;

    public Shuffler(Puzzle puzzle, int width, int height){
        this.puzzle = puzzle;
        this.width = width;
        this.height = height;
        boolean only_one_solution = false;
        int circle_trace;

        Pair[] circle_id_init_pos = getAllCircles();
        Pair[] new_circle_pos = new Pair[circle_id_init_pos.length];
        // important! otherwise the check_only_one_solution-string  is wrong after the first reset.
        reset(circle_id_init_pos);

        // (assert (or (not (= f0-0 1)) (not (= f1-0 1)) (not (= f2-0 2)) (not (= f0-1 2)) (not (= f1-1 2)) (not (= f2-1 2))))
        StringBuilder check_only_one_solution = new StringBuilder();
        check_only_one_solution.append("(assert (or");
        for(Pair init_pos : circle_id_init_pos){
            circle_trace = puzzle.getCircle_trace(init_pos.getElement0(),init_pos.getElement1());
            check_only_one_solution.append(" (not (= f"+init_pos.getElement0()+"-"+init_pos.getElement1()+" "+circle_trace+"))");
        }
        check_only_one_solution.append("))");

        while(!only_one_solution) {
            for (int i = 0; i < circle_id_init_pos.length; i++) {
                new_circle_pos[i] = move_circles(circle_id_init_pos[i]);
            }
            setEmptyCirclesV2(new_circle_pos, circle_id_init_pos);

            puzzle.print();

            only_one_solution = puzzle.checkOnlyOneSolution(check_only_one_solution.toString());
            if(!only_one_solution){
                // reset the puzzle, so that there are no traces or values around
                reset(circle_id_init_pos);
            }
        }
    }

    public void reset(Pair[] circle_id_init_pos){
        // remove ALL traces and values
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                puzzle.setCircle(new Pair(x,y),-1,-1);
            }
        }
        // add all the initPositions of the circles.
        for(int i = 0; i<circle_id_init_pos.length;i++){
            puzzle.setCircle_trace(circle_id_init_pos[i],i+1);
        }
    }

    public Puzzle getShuffledPuzzle(){
        return puzzle;
    }

    //TODO: delete this!
    public void setEmptyCircles(Pair[] circle_pos){
        int max_empty_circles = circle_pos.length/5; // <= 20% of all circles
        int counter = 0;
        Random rand = new Random();

        for(int i = 0; i<circle_pos.length && counter<max_empty_circles; i++){
            // 10% chance foreach Circle to become a 0-Circle
            if(rand.nextInt(9)==0){
                puzzle.setCircle(circle_pos[i],-2,puzzle.getCircle_trace(circle_pos[i].getElement0(),circle_pos[i].getElement1()));
                counter++;
            }
        }
    }

    public void setEmptyCirclesV2(Pair[] new_circle_pos, Pair[]circle_id_init_pos){

        for(Pair pair : circle_id_init_pos){
            boolean direction_found = false;
            int x = pair.getElement0();
            int y = pair.getElement1();
            int circle_trace = puzzle.getCircle_trace(x,y);
            //up
            if(y>0 && circle_trace == puzzle.getCircle_trace(x,y-1)){
                direction_found = true;
                // To the moving direction there must be a different country, and to der opposite direction there must
                // be a blockade, like a circle-trace, a circle, a different country or the end of the board
                if(puzzle.getCountry(x,y) != puzzle.getCountry(x,y-1) && (y==height-1 || puzzle.getCircle_trace(x,y+1) != -1 || puzzle.getCountry(x,y+1) != puzzle.getCountry(x,y))){
                    Pair set_to_zero = puzzle.findCircle(circle_trace);
                    puzzle.setCircle(set_to_zero,-2,circle_trace);
                }
            }
            //down
            if(!direction_found && y<height-1 && circle_trace == puzzle.getCircle_trace(x,y+1)){
                direction_found = true;
                if(puzzle.getCountry(x,y) != puzzle.getCountry(x,y+1) && (y==0 || puzzle.getCircle_trace(x,y-1) != -1 || puzzle.getCountry(x,y-1) != puzzle.getCountry(x,y))){
                    Pair set_to_zero = puzzle.findCircle(circle_trace);
                    puzzle.setCircle(set_to_zero,-2,circle_trace);
                }
            }
            //left
            if(!direction_found && x>0 && circle_trace == puzzle.getCircle_trace(x-1,y)){
                direction_found = true;
                if(puzzle.getCountry(x,y) != puzzle.getCountry(x-1,y) && (x==width-1 || puzzle.getCircle_trace(x+1,y) != -1 || puzzle.getCountry(x+1,y) != puzzle.getCountry(x,y))){
                    Pair set_to_zero = puzzle.findCircle(circle_trace);
                    puzzle.setCircle(set_to_zero,-2,circle_trace);
                }
            }
            //right
            if(!direction_found && x<width-1 && circle_trace == puzzle.getCircle_trace(x+1,y)){
                direction_found = true;
                if(puzzle.getCountry(x,y) != puzzle.getCountry(x+1,y) && (x==0 || puzzle.getCircle_trace(x-1,y) != -1 || puzzle.getCountry(x-1,y) != puzzle.getCountry(x,y))){
                    Pair set_to_zero = puzzle.findCircle(circle_trace);
                    puzzle.setCircle(set_to_zero,-2,circle_trace);
                }
            }

            if(!direction_found){
                System.out.println("!#!#!#! no Direction found... is zero circle?"+circle_trace);
            }

        }
    }


    public Pair move_circles(Pair circle_id_init_pos){
        Random rand = new Random();
        int x = circle_id_init_pos.getElement0();
        int y = circle_id_init_pos.getElement1();
        int circleID = puzzle.getCircle_trace(x,y);
        int direction = rand.nextInt(4); // number between 0-3 up=0 down=1 left=2 right=3

        System.out.println("Circle position: "+x+" "+y);
        // delete old circle-position. -1 is equivalent to "no-circle". also the Circle_trace is set to -1 because later
        // later on we will check if on the fields are any traces (for they are not to be crossed)
        puzzle.setCircle(circle_id_init_pos,-1,-1);
        //up
        if(direction==0){
            int movement;
            if(y==0) {
                movement = 0;
            }else{
                movement = rand.nextInt(y); // number between 0 and y. where y is the distance to the top boarder of the puzzle.
                if(movement==0){
                    movement=y;
                }
            }
            for(int i = 0; i<=movement; i++){
                if(puzzle.getCircle_trace(x,y-i)==-1) {
                    puzzle.setCircle_trace(new Pair(x, y - i), circleID);
                } else{
                    puzzle.setCircle(new Pair(x,y-i+1),i-1,circleID);
                    // if an obstacle is hit set the circle and return the new position
                    return new Pair(x,y-i+1);
                }
            }
            puzzle.setCircle(new Pair(x,y-movement),movement,circleID);
            // if no obstacle is hit set the circle and return the new position
            return new Pair(x,y-movement);

        }
        //down
        else if(direction == 1){
            int movement;
            if((height - y) - 1==0) {
                movement = 0;
            }else {
                movement = rand.nextInt((height - y) - 1); // number between 0 and the distance to the bottom boarder of the puzzle.
                if(movement==0){
                    movement=(height-y)-1;
                }
            }
            for(int i = 0; i<=movement; i++){
                if(puzzle.getCircle_trace(x,y+i)==-1) {
                    puzzle.setCircle_trace(new Pair(x, y + i), circleID);
                } else{
                    puzzle.setCircle(new Pair(x,y+i-1),i-1,circleID);
                    return new Pair(x,y+i-1);
                }
            }
            puzzle.setCircle(new Pair(x,y+movement),movement,circleID);
            return new Pair(x,y+movement);
        }
        //left
        else if(direction == 2){
            int movement;
            if(x==0) {
                movement = 0;
            }else {
                movement = rand.nextInt(x); // number between 0 and x. where x is the distance to the left boarder of the puzzle.
                if(movement==0){
                    movement=x;
                }
            }
            for(int i = 0; i<=movement;i++){
                if(puzzle.getCircle_trace(x-i,y)==-1) {
                    puzzle.setCircle_trace(new Pair(x-i, y), circleID);
                } else{
                    puzzle.setCircle(new Pair(x-i+1,y),i-1,circleID);
                    return new Pair(x-i+1,y);
                }
            }
            puzzle.setCircle(new Pair(x-movement,y),movement,circleID);
            return new Pair(x-movement,y);
        }
        //right
        else if(direction == 3){
            int movement;
            if((width - x) - 1==0) {
                movement = 0;
            }else {
                movement = rand.nextInt((width - x) - 1); // number between 0 and the distance to the right boarder of the puzzle.
                if(movement==0){
                    movement=(width-x)-1;
                }
            }
            for(int i = 0; i<=movement;i++){
                if(puzzle.getCircle_trace(x+i,y)==-1) {
                    puzzle.setCircle_trace(new Pair(x+i, y), circleID);
                } else{
                    puzzle.setCircle(new Pair(x+i-1,y),i-1,circleID);
                    return new Pair(x+i-1,y);
                }
            }
            puzzle.setCircle(new Pair(x+movement,y),movement,circleID);
            return new Pair(x+movement,y);
        } else {
            // should not be possible to reach!
            return new Pair(-1,-1);
        }
    }

    /**
     * Goes through the whole Puzzle and saves the positions of all Circle_Ids
     *
     * returns: Pair[] with the Circle_Id positions
     */
    public Pair[] getAllCircles(){

        List<Pair> allCircles = new LinkedList<Pair>();

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if(puzzle.getCircle_trace(x,y) >= 0){
                    allCircles.add(new Pair(x,y));
                }
            }
        }
        Pair[] allCirclesArray = new Pair[allCircles.size()];
        int i = 0;
        for(Pair countryPair : allCircles){
            allCirclesArray[i]=countryPair;
            i++;
        }
        return allCirclesArray;
    }
}
