package LLD.snakeAndLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayGame {

    public static void main(String[] args) {

        Player player1 = new Player(1,"Alice");
        Player player2 = new Player(2,"Rob");


        List<Jumper> snakeJumpers =new ArrayList<>();
        List<Jumper> ladderJumpers = new ArrayList<>();

        int boardSize = 20;

        Dice dice = new Dice(1);

        player1.setCurrLocation(0);
        player2.setCurrLocation(0);

        List<Player> playerList = new ArrayList(Arrays.asList(player1,player2));

        Jumper sj1= new Jumper(10,5);
        Jumper sj2 = new Jumper(19,9);
        Jumper sj3 = new Jumper(15,12);

        snakeJumpers.add(sj1);
        snakeJumpers.add(sj2);
        snakeJumpers.add(sj3);


        Jumper lj1 = new Jumper(4,17);
        Jumper lj2 = new Jumper(8,18);
        Jumper lj3 = new Jumper(12,17);

        ladderJumpers.add(lj1);
        ladderJumpers.add(lj2);
        ladderJumpers.add(lj3);


        SnakeLadderGame snakeLadderGame = new SnakeLadderGame(boardSize,
                    playerList,snakeJumpers,ladderJumpers,dice);

        snakeLadderGame.startGame();

    }
}
