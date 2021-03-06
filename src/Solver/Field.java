package Solver;

import java.io.Serializable;

/**
 * Created by Cloud on 27.05.2014.
 */
public class Field implements Serializable {
    private Pair[] neighbors;
    private int country = -1;
    private boolean inhabited = false;
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private boolean has_moved = false;
    private boolean is_origin = false;
    private boolean is_try_mode = false;
    // id of the circle
    private int circle_trace = -1;
    // allowed movement value of the circle
    private int circle_value = -1;


    public Field(){
    }

    public void setCountry(int c, Pair[] neighbors){
        this.neighbors = neighbors;
        country = c;
    }

    public boolean getTry(){
        return is_try_mode;
    }

    public void setTry(boolean bool){
        is_try_mode = bool;
    }

    public int getCountry(){
        return country;
    }

    public void setIs_origin(boolean bool){
        is_origin = bool;
    }

    public boolean getIs_origin(){
        return is_origin;
    }

    public Pair[] getNeighbors(){
        return neighbors;
    }

    public void setNeighbors(Pair[] pair){
        neighbors = pair;
    }

    public boolean getInhabited(){
        return inhabited;
    }

    public void setInhabited(Boolean bool){
        inhabited = bool;
    }

    public void setLeft(Boolean bool){
        left = bool;
    }

    public boolean getRight(){
        return right;
    }

    public void setRight(Boolean bool){
        right = bool;
    }

    public boolean getLeft(){
        return left;
    }

    public void setUp(Boolean bool){
        up = bool;
    }

    public boolean getUp(){
        return up;
    }

    public void setDown(Boolean bool){
        down = bool;
    }

    public boolean getDown(){
        return down;
    }

    public void setHas_moved(Boolean bool){
        has_moved = bool;
    }

    public Boolean getHas_moved(){
        return has_moved;
    }

    public int getCircle_trace(){
        return circle_trace;
    }

    public void setCircle_trace(int circle){
        circle_trace = circle;
    }

    public void setCircle(int value, int id_trace){
        circle_trace = id_trace;
        circle_value = value;
    }

    public int getCircle_value(){
        return circle_value;
    }

    public void setCircle_value(int circle){
        circle_value = circle;
    }


    public String toString(){
        if(10 > circle_value && circle_value >= 0){
            return  " "+String.valueOf(circle_value)+" ";
        }else if(10 <= circle_value){
            return  " "+String.valueOf(circle_value);
        }else if(circle_value == -2) {
            return " # ";
        }else if (left){
            return " < ";
        }else if (right){
            return " > ";
        }else if (up){
            return " ^ ";
        }else if (down){
            return " v ";
        }else if(circle_trace >= 0){
            return " * ";
        }
        return "   ";
    }
}
