package heaps;

import java.util.*;

/*
Given an array of integers, find top k integers with highest frequency.
arr = [1, 1, 1, 3, 2, 2, 4]

 */
public class TopkFreqNumbers {

    private static int[] inputArr;
    private static int k;
    private static Map<Integer,Integer> freqMap;
    private static PriorityQueue<FrequencyTracker> minHeap;

    public static void main(String[] args) {

        inputArr = new int[] {1, 1, 1, 3, 2, 2, 4};
        k = 2;
        freqMap = new HashMap<>();
        List<Integer> topKElem = findTopKFreqElem();

        System.out.println("TopK elems are "+topKElem);
    }

    private static List<Integer> findTopKFreqElem()
    {

        List<Integer> topKFreqNums = new ArrayList<>();

        minHeap = new PriorityQueue<>(new FrequencyTrackerComparator());

        for(int i=0; i < inputArr.length; i++){

            if(freqMap.containsKey(inputArr[i])){
                freqMap.put(inputArr[i],freqMap.get(inputArr[i])+1);
            }
            else {
                freqMap.put(inputArr[i],1);
            }
        }

        for(Map.Entry<Integer,Integer> elem: freqMap.entrySet()){

            minHeap.add(new FrequencyTracker(elem.getKey(),elem.getValue()));

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        while (!minHeap.isEmpty()){
            topKFreqNums.add(minHeap.poll().number);
        }
        return topKFreqNums;
    }

    private static void initializeArr(int[] inputArr) {


    }
}
class FrequencyTracker {

    int number;
    int frequency;


    public FrequencyTracker(int number, int frequency){
        this.number = number;
        this.frequency = frequency;
    }

    public int getNumber() {
        return number;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "FrequencyTracker{" +
                "number=" + number +
                ", frequency=" + frequency +
                '}';
    }
}
class FrequencyTrackerComparator implements Comparator<FrequencyTracker>{

    @Override
    public int compare(FrequencyTracker o1, FrequencyTracker o2) {
        if(o1.frequency < o2.frequency){
            return -1;
        }
        else if(o1.frequency > o2.frequency){
            return 1;
        }
        return 0;
    }
}
