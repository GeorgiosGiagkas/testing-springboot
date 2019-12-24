package com.gg.unittesting.unittesting.model;


import lombok.Getter;

@Getter
public class Item {

    private int id;
    private String name;
    private int price;
    private int quantity;

    private Item(){};

    public static class ItemBuilder{
        private int id;
        private String name;
        private int price;
        private int quantity;

        public ItemBuilder(int id){
            this.id= id;
        }
        public ItemBuilder createName(String name){
            this.name = name;
            return  this;
        }
        public ItemBuilder definePrice(int price){
            this.price = price;
            return this;
        }

        public ItemBuilder defineQuantity(int quantity){
            this.quantity = quantity;
            return  this;
        }

        public Item build(){
            Item item = new Item();
            item.id=this.id;
            item.name=this.name;
            item.price=this.price;
            item.quantity= this.quantity;
            return  item;
        }

    }
}
