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

        // (assert (or (and (not (= f0-0 1)) (not (= f1-0 1))) (and (not (= f2-0 2)) (not (= f0-1 2)) (not (= f1-1 2)) (not (= f2-1 2)))))
        StringBuilder check_only_one_solution = new StringBuilder();
        check_only_one_solution.append("(assert (or");
        for(Pair init_pos : circle_id_init_pos){
            circle_trace = puzzle.getCircle_trace(init_pos.getElement0(),init_pos.getElement1());
            Pair[] neighbors = puzzle.getNeighbors(init_pos);
            check_only_one_solution.append(" (and");
            for(Pair neighbor : neighbors){
                check_only_one_solution.append(" (not (= f"+neighbor.getElement0()+"-"+neighbor.getElement1()+" "+circle_trace+"))");
            }
            check_only_one_solution.append(")");
        }
        check_only_one_solution.append("))");

        while(!only_one_solution) {
            for (int i = 0; i < circle_id_init_pos.length; i++) {
                new_circle_pos[i] = move_circles(circle_id_init_pos[i]);
            }
            setEmptyCircles(new_circle_pos);

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
            puzzle.setCircle_trace(circle_id_init_pos[i],i);
        }
    }

    public Puzzle getShuffledPuzzle(){
        return puzzle;
    }

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
