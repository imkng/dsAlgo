package com.company.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomizedCollection {
    List<Integer> list;
    Random random;

    public RandomizedCollection() {
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (list.contains(val)) {
            list.add(val);
            return false;
        }
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!list.contains(val))
            return false;
        list.remove(Integer.valueOf(val));
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection randomizedSet = new RandomizedCollection();
        System.out.println("insert: " + 1 + " " + randomizedSet.insert(1));
//        System.out.println("remove: " + 2 + " " + randomizedSet.remove(2));
        System.out.println("insert: " + 1 + " " + randomizedSet.insert(1));
        System.out.println("insert: " + 2 + " " + randomizedSet.insert(2));
        System.out.println("getRandom: " + randomizedSet.getRandom());
        System.out.println("remove: " + 1 + " " + randomizedSet.remove(1));
        System.out.println("getRandom: " + randomizedSet.getRandom());
    }
}
