package com.company.leetCode;

import java.util.*;
public class TaskManager {

    PriorityQueue<int[]> pq;
    Map<Integer, Integer> taskOwner;
    Map<Integer, Integer> taskWithPriority;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a,b)->{
            if (a[0] != b[0]){
                return b[0] - b[1];
            }else {
                return b[1] - a[1];
            }
        });
        taskOwner = new HashMap<>();
        taskWithPriority = new HashMap<>();

        for (List<Integer> list : tasks){
            add(list.get(0), list.get(1), list.get(2));
        }

    }

    public void add(int userId, int taskId, int priority) {
        pq.offer(new int[]{priority, taskId});
        taskWithPriority.put(taskId, priority);
        taskOwner.put(taskId, userId);
    }

    public void edit(int taskId, int newPriority) {
        pq.add(new int[]{newPriority, taskId});
        taskWithPriority.put(taskId, newPriority);
    }

    public void rmv(int taskId) {
        taskWithPriority.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()){
            int[] t = pq.poll();
            if (taskWithPriority.get(t[1]) != null){
                taskWithPriority.remove(t[1]);
                return taskOwner.get(t[1]);
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */