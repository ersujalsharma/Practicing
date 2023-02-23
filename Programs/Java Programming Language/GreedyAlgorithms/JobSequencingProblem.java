package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencingProblem {
    static class Job{
        int deadline;
        int profit;
        int id;
        public Job(int i,int d,int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int[][] job = {{4,20},{1,10},{1,40},{1,30},{6,60}};
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < job.length; i++) {
            jobs.add(new Job(i, job[i][0], job[i][1]));
        }
        Collections.sort(jobs,(a,b)->b.profit-a.profit);
        ArrayList<Integer> list = new ArrayList<>();
        int time =0;
        for (int i = 0; i < jobs.size(); i++) {
            if(jobs.get(i).deadline>time){
                list.add(jobs.get(i).id);
                time++;
            }
        }
        System.out.println(list);
    }
}
