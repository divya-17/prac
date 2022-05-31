package greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
Given value arr, weight arr and max weight, find the max profit that we can have.
We can choose items in fractions also.
Ex:
N = 3
W = 50
values = [60, 100, 120]
weight = [10, 20, 30]
Max Profit: 240
 */
public class FractionalKnapsackProblem {

    public static void main(String[] args) {

        int[] values = new int[] {100, 60, 120};
        int[] weights = new int[] {20, 10, 30};
        ItemValue[] itemValues = new ItemValue[weights.length];

        int totalWeight = 50;
        int totalProfit = 0;

        for(int i =0; i < weights.length; i++)
        {
            itemValues[i] = new ItemValue(weights[i],values[i]);
        }


        Arrays.sort(itemValues, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                if ( (int)o2.getCost()/o2.getWeight() < (int)o1.getCost()/o1.getWeight()){
                    return -1;
                }
                else if((int)o2.getCost()/o2.getWeight() == (int)o1.getCost()/o1.getWeight()){
                    return 0;
                }
                else{
                    return 1;
                }
            }
        });

        for(int  i =0; i < itemValues.length; i++){

            if(totalWeight - itemValues[i].getWeight() >= 0){
                System.out.println("Adding "+itemValues[i].getCost());
                totalProfit = totalProfit+itemValues[i].getCost();
                totalWeight = totalWeight-itemValues[i].getWeight();

            }
            else{
                int fractionWeight = totalWeight;
                int fractionCostPerUnit = itemValues[i].getCost()/itemValues[i].getWeight();
                System.out.println("Adding "+fractionWeight*fractionCostPerUnit);
                totalProfit = totalProfit + (fractionWeight*fractionCostPerUnit);
            }

        }

        System.out.println("Total Profit => "+totalProfit);

    }
}
class ItemValue{

    private Integer weight;
    private Integer cost;

    public ItemValue(Integer weight, Integer cost) {
        this.weight = weight;
        this.cost = cost;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ItemValue{" +
                "weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
