package heaps;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/*
Given an array sorted in ascending order and a number x, find the k numbers from this array which is closest to x.

The result should also be sorted in ascending order.

 */
public class KClosestElem {

    private static int[] inputArr;
    private static List<HeapObject> diffPairs = new ArrayList<>();
    private static List<Integer> finalResult = new ArrayList<>();

//    private static int x = 4921;
//    private static int k = 9444;
    private static int x = 3;
    private static  int k = 4;
    private static int kClosestElemArr[] = new int[k];

    public static void main(String[] args) {

        //initializeLargeData();
        initializeArr();

        List<Integer> diffResult = findClosestElements(inputArr,k,x);

        System.out.println("Final result "+diffResult);
    }

    private static void initializeLargeData() {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("/home/divya/demo-projects/prac/ds/src/main/resources/data.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String data  = properties.getProperty("data");

        String[] string = data.split(",");

        inputArr  = new int[string.length];
        for (int i = 0; i < string.length; i++) {
            inputArr[i] = Integer.valueOf(string[i]);
        }
    }



    private static List<Integer> findClosestElements(int[] inputArr, int k, int x) {

        List<Integer> closedKElemList = new ArrayList();
        PriorityQueue<HeapObject> maxHeap = new PriorityQueue(new HeapObjectComparator());


        for(int i =0; i < inputArr.length; i++){

            HeapObject heapObj = new HeapObject(inputArr[i],Math.abs(inputArr[i]-x));

            maxHeap.add(heapObj);

            if(maxHeap.size() > k){
                maxHeap.poll();
            }

        }
        while(!maxHeap.isEmpty()){
            closedKElemList.add(maxHeap.poll().getArrObj());
        }


       Collections.sort(closedKElemList);
        return closedKElemList;
    }

    private static void initializeArr() {

        inputArr = new int[] {1,2,3,4,5};
    }

}

class HeapObjectComparator implements Comparator<HeapObject>{

    @Override
    public int compare(HeapObject o1, HeapObject o2) {

        if(o1.absDiff == o2.absDiff){
            if(o1.arrObj <o2.arrObj){
                return 1;
            }
            else if(o1.arrObj > o2.arrObj){
                return -1;
            }
            return 0;
        }
        else if(o1.absDiff < o2.absDiff){
            return 1;
        }
        else if(o1.absDiff > o2.absDiff){
            return -1;
        }
        return 0;
    }
}
class HeapObject implements Comparable {

    Integer arrObj;
    Integer absDiff;

    public HeapObject(Integer arrObj, Integer absDiff){

        this.arrObj = arrObj;
        this.absDiff = absDiff;
    }

    public Integer getArrObj() {
        return arrObj;
    }

    public Integer getAbsDiff() {
        return absDiff;
    }

    @Override
    public int compareTo(Object o) {
        if (((HeapObject)o).absDiff > this.absDiff){
            return -1;
        }
        else  if (this.absDiff > ((HeapObject)o).absDiff){
            return 1;
        }
        else {
           return 0;
        }

    }

    @Override
    public String toString() {
        return "HeapObject{" +
                "arrObj=" + arrObj +
                ", absDiff=" + absDiff +
                '}';
    }
}