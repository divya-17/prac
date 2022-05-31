package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/problems/coin-change/
 */
public class CoinChangeProb {

    public static void main(String[] args) {

        int [] coins = new int[] {1,2,5};
        int amount = 11;
        int totalCoins = 0;
        boolean possibleFlag = false;

        List<Integer> coinList = new ArrayList<>();

        for(int i=0; i < coins.length; i++){
            coinList.add(coins[i]);
        }

        System.out.println(coinList);
        Collections.sort(coinList,Collections.reverseOrder());

        if(amount == 0){
            totalCoins = 0;
        }

        for(int i =0; i < coinList.size(); i++)
        {
            while (amount >= coinList.get(i))
            {
                amount = amount-coinList.get(i);
                totalCoins++;
                if(amount == 0){
                    possibleFlag = true;
                    break;
                }
            }
        }

        if(!possibleFlag){
            totalCoins = -1;
        }
        System.out.println(totalCoins);
    }
}
