package com.example.coastalitapp;

public class itemClass {
    //can add values to button class
        protected int quantity;
        private int weight;

        protected int totalWeight;
        protected int cost;

        private int profit;
        protected int totalProfit;

    public itemClass(int itemQuantity ,int itemWeight, int itemCost, int itemProfit){   //need to load user save items for method arguments
        quantity = itemQuantity;
        weight = itemWeight;
        cost = itemCost;
        profit = itemProfit;
        Calculate();
    }

    protected void Calculate(){
        totalProfit = profit * quantity;
        totalWeight = weight * quantity;
    }
}

