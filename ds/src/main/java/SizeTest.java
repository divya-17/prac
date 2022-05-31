
//import objectexplorer.ObjectGraphMeasurer;

import com.javamex.classmexer.MemoryUtil;

import java.util.HashMap;
import java.util.Map;

public class SizeTest {


    public static void main(String[] args) {

        Map<Integer,Integer> intMap = new HashMap<>();

        intMap.put(1,100);
        intMap.put(2,200);
        intMap.put(3,300);
        intMap.put(4,400);

        Long noBytes = MemoryUtil.memoryUsageOf(intMap);

        System.out.println("Size of value "+intMap+" is "+noBytes);
    }
}
