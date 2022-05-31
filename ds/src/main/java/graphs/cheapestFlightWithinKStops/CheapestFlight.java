package graphs.cheapestFlightWithinKStops;

import javafx.util.Pair;

import java.util.*;

/*

Given routes from one stop to another and flight fare between each stop, find the minimum price incur to reach
from src to destination when only k possible stops are allowed.

Ex:
Stop and Fare details:
0 -> [(1,100),(3,300)] => [Cost from station 0 to station 1 is 100 and from station 0 to station 3 is 300]
1 -> [(3,300)]
2 -> [(4,10)]
3 -> [(2,10)]
4 -> [(1,100)]

If k=2  minCost = 320 (0 -> 3 -> 2 -> 4)
If k=3 minCost = 220 (0 -> 1 -> 3 -> 2 -> 4)

Approach used here is DFS with pruning.
 */
public class CheapestFlight {

    private static int currMinPrice = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Map<Integer, List<Pair>> routeDetail = new HashMap<>();

        routeDetail.put(0,new ArrayList<>(Arrays.asList(new Pair(1,100),new Pair(3,300))));
        routeDetail.put(1,new ArrayList<>(Arrays.asList(new Pair(3,100))));
        routeDetail.put(2,new ArrayList<>(Arrays.asList(new Pair(4,10))));
        routeDetail.put(3,new ArrayList<>(Arrays.asList(new Pair(2,10))));
        routeDetail.put(4,new ArrayList<>(Arrays.asList(new Pair(1,100))));

        int k = 3;
        Integer src=0;
        Integer dest = 4;

        int cheapestPrice = getCheapestFlight(src,dest,routeDetail,0,k);

        System.out.println("Cheapest fare to reach from "+src+" ->"+dest+" is "+cheapestPrice);
    }

    private static int getCheapestFlight(Integer src, Integer dest, Map<Integer, List<Pair>> routeDetail, int price, int k) {

        if(src == dest){
            return price;
        }
        if(k < 0){
            return Integer.MAX_VALUE;
        }

        for(Pair conn: routeDetail.get(src)){

            int nextStop = Integer.parseInt(conn.getKey().toString());
            int cost = Integer.parseInt(conn.getValue().toString());
            currMinPrice = Math.min(currMinPrice, getCheapestFlight(nextStop, dest, routeDetail, price + cost, k - 1));
        }
        return currMinPrice;
    }
}
