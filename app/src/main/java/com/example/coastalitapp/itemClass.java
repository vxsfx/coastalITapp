package com.example.coastalitapp;

public class itemClass {
    //can add values to button class
        public String name;

        public int cost;

        public int weight;

        public int total;

        public int profit;

    public itemClass(String name, int itemQuantity ,int itemWeight, int itemCost, int itemProfit){   //need to load user save items for method arguments
        total = itemQuantity;
        weight = itemWeight;
        cost = itemCost;
        profit = itemProfit;
    }
}

