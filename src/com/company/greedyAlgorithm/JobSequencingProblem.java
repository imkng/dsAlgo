package com.company.greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

class Job{
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencingProblem {

//    Given two arrays: deadline[] and profit[], where the index of deadline[] represents a job ID,
//    and deadline[i] denotes the deadline for that job and profit[i] represents profit of doing ith job.
//    Each job takes exactly one unit of time to complete, and only one job can be scheduled at a time.
//    A job earns its corresponding profit only if it is completed within its deadline.
//
//    The objective is to determine:
//
//    The maximum profit that can be obtained by scheduling the jobs optimally.
//    The total number of jobs completed to achieve this maximum profit.
//    Examples:
//
//    Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
//    Output: 2 60
//    Explanation: We select 1st and 3rd jobs. All jobs except first job have a deadline of 1,
//    thus only one of these can be selected along with the first job with the total profit gain of 20 + 40 = 60.
//
//    Input: deadline[] = [2, 1, 2, 1, 1], profit[] = [100, 19, 27, 25, 15]
//    Output: 2 127
//    Explanation: The first and third job have a deadline of 2, thus both of them can be completed and
//    other jobs have a deadline of 1, thus any one of them can be completed. Both the jobs with a
//    deadline of 2 is having the maximum associated profit, so these two will be completed,
//    with the total profit gain of 100 + 27 = 127.
    public static void main(String[] args) {
        int deadline[] = {4, 1, 1, 1}, profit[] = {20, 10, 40, 30};
        int maxProfit = jobSequencing(deadline, profit);
        System.out.println(maxProfit);
    }

    private static int jobSequencing(int[] deadline, int[] profit) {
        List<Job> jobList = new ArrayList<>();
        for (int i = 0; i < deadline.length; i++) {
            jobList.add(new Job(i, deadline[i], profit[i]));
        }
        jobList.sort((e1, e2) -> e1.profit - e2.profit);
        int maxDeadLine = Integer.MIN_VALUE;
        for (int i = 0; i < deadline.length; i++) {
            maxDeadLine = Math.max(maxDeadLine, deadline[i]);
        }
        int[] hash = new int[maxDeadLine + 1];
        for (int i = 0; i < maxDeadLine +1; i++) {
            hash[i] = -1;
        }
        int maProfit = 0;
        for (Job j: jobList){
            for (int i = j.deadline; i >= 0; i++) {
                if (hash[i] == -1){
                    hash[i] = j.id;
                    maProfit += j.profit;
                    break;
                }
            }
        }

        return maProfit;
    }

}
