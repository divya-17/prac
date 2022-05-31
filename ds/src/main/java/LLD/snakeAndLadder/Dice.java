package LLD.snakeAndLadder;

import java.util.Random;

public class Dice {


    private Random random = new Random();
    private int num;

    public Dice(int num){
        this.num = num;
    }

    public int rollDice(){
        return random.nextInt((6*num)-(1*num)+1)+(1*num);
    }


}


