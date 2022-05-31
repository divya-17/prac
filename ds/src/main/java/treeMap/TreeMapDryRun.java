package treeMap;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDryRun {

    public static void main(String[] args) {

        TreeMap<Integer,String> salaryMap = new TreeMap<>();

        salaryMap.put(1000,"Tom");
        salaryMap.put(8000,"Deck");
        salaryMap.put(1400,"Harry");
        salaryMap.put(2000,"Rosy");
        salaryMap.put(500,"Ellana");

        System.out.println(salaryMap);

        // First sorted key
        System.out.println("First Sorted Key "+salaryMap.firstKey());
        System.out.println("First Sorted Value "+salaryMap.firstEntry().getValue());

        //Last sorted key and value
        System.out.println("Last Sorted Key  "+salaryMap.lastKey());
        System.out.println("Last Sorted Value  "+salaryMap.lastEntry().getValue());

        // Keys less than 3000
        System.out.println("Key < 3k  "+salaryMap.headMap(3000));

        // Keys equal to or greater than 3000
        System.out.println("Key >= 3k  "+salaryMap.tailMap(3000));

        // Floor entry
        System.out.println("Last value <= 1500  "+ salaryMap.floorEntry(1500));
        }
}
