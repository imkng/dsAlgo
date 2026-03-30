package com.company.leetCode;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class FoodItem{
    String foodName;
    String cusinesName;
    int rating;

    public FoodItem(String foodName, String cusinesName, int rating) {
        this.foodName = foodName;
        this.cusinesName = cusinesName;
        this.rating = rating;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCusinesName() {
        return cusinesName;
    }

    public void setCusinesName(String cusinesName) {
        this.cusinesName = cusinesName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
public class FoodRatings {
    List<FoodItem> foodItemList;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodItemList = new ArrayList<>();
        for (int i = 0; i < foods.length; i++) {
            foodItemList.add(new FoodItem(foods[i], cuisines[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        for (FoodItem foodItem: foodItemList){
            if (foodItem.getFoodName().equals(food)){
                foodItem.setRating(newRating);
            }
        }
    }

    public String highestRated(String cuisine) {
        PriorityQueue<FoodItem> foodItemPriorityQueue = new PriorityQueue<>((a,b)->{
            if (a.rating > b.rating){
                return a.rating-b.rating;
            }else {
                return a.getFoodName().compareTo(b.getFoodName());
            }
        });
        for (FoodItem foodItem: foodItemList){
            if (foodItem.cusinesName.equals(cuisine)){
                foodItemPriorityQueue.offer(foodItem);
            }
        }
        return foodItemPriorityQueue.poll().foodName;
    }
}
