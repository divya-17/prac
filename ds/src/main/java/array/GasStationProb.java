package array;
/*
https://leetcode.com/problems/gas-station/
 */
public class GasStationProb {

    public static void main(String[] args) {

        int[] gas = new int[] {6, 7, 4, 10, 6, 5};
        int[] cost = new int[] {5, 6, 7, 8, 6, 4};

        GasStationProb obj = new GasStationProb();

        int resultIndex = obj.canCompleCircuit(gas, cost);

        System.out.println("Result index is "+resultIndex);
    }

    private int canCompleCircuit(int[] gas, int[] cost) {

        int totalBalance = 0;
        int currentBalance = 0;

        int frontPointer = 0;
        int rearPointer = 0;

        while (rearPointer < gas.length) {

            currentBalance = currentBalance + (gas[rearPointer] - cost[rearPointer]);
            totalBalance = totalBalance + (gas[rearPointer] - cost[rearPointer]);

            if (currentBalance < 0) {
                frontPointer = rearPointer + 1;
                currentBalance = 0;

            }

            rearPointer++;
        }

        if (totalBalance >= 0) {
            return frontPointer;
        } else {
            return -1;
        }
    }

}
