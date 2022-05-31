package companyInterviewQues;

import java.util.*;

/*
// SPINNY INTERVIEW QUES

https://leetcode.com/problems/best-team-with-no-conflicts/

You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the highest overall score. The score of the team is the sum of scores of all the players in the team.
However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player has a strictly higher score than an older player. A conflict does not occur between players of the same age.
Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player, respectively, return the highest overall score of all possible basketball teams.


scores = [1,3,5,10,15], ages = [1,2,3,4,5]
ans: 34

scores = [4,5,6,5], ages = [2,1,2,1]
ans: 16

scores [1,2,3,5], ages = [8,9,10,1]
ans: 6

 */
public class BestTeamWithNoConflicts {

    private static int maxScore = Integer.MIN_VALUE;

    public static void main(String[] args) {



//        int[] scores= new int[] {1, 3, 5, 10, 15};
//        int[] ages = new int[] { 1, 2, 3, 4, 5};

//        int[] scores = new int[] {4, 5, 6, 5};
//        int[] ages = new int[] {2, 1, 2, 1};

        int[] scores = new int[]{1, 2, 3, 5};
        int[] ages = new int[] {8, 9, 10 ,1};

        PlayerDetail [] playerArr = new PlayerDetail[scores.length];

        for(int i =0; i < scores.length; i++){
            playerArr[i] = new PlayerDetail(scores[i],ages[i]);
        }

        Arrays.sort(playerArr, new Comparator<PlayerDetail>() {
            @Override
            public int compare(PlayerDetail o1, PlayerDetail o2) {
                if (o1.getAge() > o2.getAge()) return 1;
                else if (o1.getAge() < o2.getAge()) return -1;
                else if (o1.getAge() == o2.getAge()){
                    Integer.compare(o1.getScore(),o2.getScore());
                }
                return 0;
            }
        });

        printArr(playerArr);

        getMaxScore(playerArr,Integer.MIN_VALUE,0);
        System.out.println();
        System.out.println("Max Score: "+maxScore);
    }

    private static void printArr(PlayerDetail[] playerArr) {

        for(int i =0; i < playerArr.length; i++){
            System.out.print(playerArr[i]+" , ");
        }
    }

    private static void getMaxScore(PlayerDetail[] playerArr, int prevValue, int currentSum) {

        if(playerArr.length == 0){
            if(currentSum > maxScore){
                maxScore = currentSum;
            }
            return;
        }

        if(playerArr[0].getScore() >= prevValue){
            getMaxScore(Arrays.copyOfRange(playerArr,1,playerArr.length),playerArr[0].getScore(),currentSum+playerArr[0].getScore());
        }
        getMaxScore(Arrays.copyOfRange(playerArr,1,playerArr.length),prevValue,currentSum);
    }

}

class PlayerDetail{

    private int score;
    private int age;

    public PlayerDetail(int score, int age){

        this.score = score;
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PlayerDetail{" +
                "score=" + score +
                ", age=" + age +
                '}';
    }
}