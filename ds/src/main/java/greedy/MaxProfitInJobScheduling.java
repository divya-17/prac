package greedy;

import java.util.*;

public class MaxProfitInJobScheduling {

    static List<Job> jobList = new ArrayList();
    static TreeMap<Integer,Integer> timeToMaxProfitMap = new TreeMap<>();

    public static void main(String[] args) {

        int[] startTime = new int[] {6,24,45,27,13,43,47,36,14,11,11,12};
        int[] endTime = new int[] {31,27,48,46,44,46,50,49,24,42,13,27};
        int[] profit = new int[] {14,4,16,12,20,3,18,6,9,1,2,8};

        Integer finalMaxProfit = 0;

        timeToMaxProfitMap.put(0,0);

        for(int i = 0; i < startTime.length; i ++){
            jobList.add(new Job(startTime[i],endTime[i],profit[i]));
        }


        Collections.sort(jobList, new Comparator<Job>(){

            @Override
            public int compare(Job o1, Job o2){
                return Integer.compare(o1.getEndTime(),o2.getEndTime());
            }
        });


        System.out.println(jobList);
        for(int i = 0; i < jobList.size(); i++){

            Integer currentProfit = jobList.get(i).getProfit()+
                    timeToMaxProfitMap.floorEntry(jobList.get(i).getStartTime()).getValue();

            if((!timeToMaxProfitMap.containsKey(jobList.get(i).getEndTime())  ||
                    timeToMaxProfitMap.get(jobList.get(i).getEndTime()) < currentProfit) &&
                    (currentProfit > timeToMaxProfitMap.lastKey())) {
                timeToMaxProfitMap.put(jobList.get(i).getEndTime(), currentProfit);
            }
            if(currentProfit >finalMaxProfit){
                finalMaxProfit = currentProfit;
            }

        }
        System.out.println(finalMaxProfit);
    }

    static class Job{

        private int startTime;
        private int endTime;
        private int profit;

        public Job(int startTime,int endTime, int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        public int getStartTime(){
            return startTime;
        }

        public int getEndTime(){
            return endTime;
        }

        public int getProfit(){
            return profit;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    ", profit=" + profit +
                    '}';
        }
    }
}
