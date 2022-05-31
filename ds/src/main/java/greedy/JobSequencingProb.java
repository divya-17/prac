package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
 */
public class JobSequencingProb {

    public static void main(String[] args) {

        Job arr [] = new Job[] { new Job(1,4,20), new Job(2,1, 10),
        new Job(3,1,40), new Job(4,1 ,30)};


        int maxProfit = 0;
        Map<Integer,Boolean> deadlineToDoneMap = new HashMap();

        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return Integer.compare(o2.getProfit(),o1.getProfit());
            }
        });

        for(int i =0; i < arr.length; i++){

            int deadline = arr[i].getDeadline();


            if(!deadlineToDoneMap.containsKey(deadline))
            {
                maxProfit  = maxProfit + arr[i].getProfit();
                deadlineToDoneMap.put(deadline,true);
            }
            else{
                while(deadline > 0 && deadlineToDoneMap.containsKey(deadline))
                {
                    deadline = deadline-1;
                }
                if(deadline > 0)
                {
                    maxProfit  = maxProfit + arr[i].getProfit();
                    deadlineToDoneMap.put(deadline,true);
                }
            }


        }
        System.out.println("Num Jobs => "+deadlineToDoneMap.size());
        System.out.println("Max Profit => "+maxProfit);
    }

}


class Job{

    private int jobId;
    private int deadline;
    private int profit;

    public Job(int jobId, int deadline, int profit){

        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }

    public int getJobId(){
        return jobId;
    }
    public int getDeadline(){
        return deadline;
    }
    public int getProfit(){
        return profit;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", deadline=" + deadline +
                ", profit=" + profit +
                '}';
    }
}