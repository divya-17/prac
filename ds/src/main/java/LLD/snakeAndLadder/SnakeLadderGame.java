package LLD.snakeAndLadder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeLadderGame {


    private int boardSize;
    private List<Player> players;
    private List<Jumper> snakeJumper;
    private List<Jumper> ladderJumper;
    private Dice dice;

    public SnakeLadderGame(int boardSize,
                           List<Player> playerList,
                           List<Jumper> snakeJumper,
                           List<Jumper> ladderJumper,
                           Dice dice){

        this.boardSize = boardSize;
        this.players = playerList;
        this.snakeJumper = snakeJumper;
        this.ladderJumper = ladderJumper;
        this.dice = dice;
    }


    public void startGame(){

        Queue<Player> playerQueue = new LinkedList<>();
        for(Player player : players){
            playerQueue.add(player);
        }

        while (playerQueue.size() > 1){

            Player player = playerQueue.poll();
            int number = dice.rollDice();

            System.out.println("Player "+player.getName()+" curr location "+player.getCurrLocation()+" got "+number);

            if(player.getCurrLocation()+number > boardSize){
                playerQueue.add(player);
            }
            else if(player.getCurrLocation()+number == boardSize){
                System.out.println("Player "+player.getName()+" won the game !");

            }
            else{
                int currLoc = player.getCurrLocation()+number;

                for(Jumper jumper: snakeJumper){
                    if(currLoc == jumper.getStartLocation()){
                        System.out.println("Player "+player.getName()+" was bitten by snake and descended from "+currLoc+" to "+jumper.getEndLocation());
                        currLoc = jumper.getEndLocation();

                    }
                }

                for(Jumper jumper: ladderJumper){
                    if(currLoc == jumper.getStartLocation()){
                        System.out.println("Player "+player.getName()+" got ladder and climbed from "+currLoc+" to "+jumper.getEndLocation());
                        currLoc = jumper.getEndLocation();
                    }
                }

                player.setCurrLocation(currLoc);
                playerQueue.add(player);

            }
        }

    }
}
