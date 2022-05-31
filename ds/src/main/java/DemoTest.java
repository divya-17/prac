import java.util.*;

public class DemoTest {


    private Map<String, Map<Long,String>> hashMap = new HashMap<>();

    public static void main(String[] args) {

        Map<String,Integer> testMap = new HashMap<>();
        Map<String,Integer> duplicateMap = new HashMap<>();
        testMap.put("a",1);
        testMap.put("b",2);
        testMap.put("c",3);

        duplicateMap.putAll(testMap);
        System.out.println(testMap);
        System.out.println(duplicateMap);
        System.out.println(testMap == duplicateMap);

    }

//    public String get(String key, Long time){
//
//        if(hashMap.get(key) != null){
//
//            Map<Long,String> valueMap = hashMap.get(key);
//
//            if(valueMap.containsKey(time)){
//                return valueMap.get(time);
//            }
//            else{
//
//                long[] timestampArr = new long[valueMap.entrySet().size()];
//
//                int index = 0;
//                for(Map.Entry<Long,String> entry: valueMap.entrySet()){
//                    timestampArr[index] = entry.getKey();
//                    index++;
//                }
//                Long resultTime=searchForLastUpdated(timestampArr,time);
//                valueMap.keySet()
//                return valueMap.get(resultTime);
//
//            }
//
//        }
//        return null;
//    }
//
//    private Long searchForLastUpdated(long[] timestampArr, Long time) {
//
//        int startIndex = 0;
//        int endIndex = timestampArr.length-1;
//
//        while (startIndex < endIndex){
//
//            int midIndex = startIndex+(endIndex-startIndex)/2;
//
//            if(timestampArr[midIndex]  > time){
//                endIndex = midIndex;
//            }
//            else{
//                startIndex = midIndex;
//            }
//
//        }
//
//        long mostUpdateTime = timestampArr[startIndex];
//
//        if(startIndex > 0) {
//            if (timestampArr[startIndex - 1] < time) {
//                mostUpdateTime = timestampArr[startIndex - 1];
//            }
//        }
//        if(startIndex < timestampArr.length-1) {
//            if (timestampArr[startIndex + 1] < time) {
//                mostUpdateTime = timestampArr[startIndex - 1];
//
//            }
//        }
//        return mostUpdateTime;
//    }
//
//    public void put(String key, String value){
//
//        if(hashMap.containsKey(key)){
//            Map<Long,String> valueMap = hashMap.get(key);
//            valueMap.put(time(),value);
//        }
//        else{
//            Map<Long,String> valueMap = new TreeMap<>();
//            valueMap.put(time(),value);
//        }
//
//    }
}
