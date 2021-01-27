package com.dome;

public class Item {
    //private 修饰的成员变量可以被继承，但不可能被子类直接访问
    private String title;
    private int playingTime;
    private boolean gotIt = false;
    private String comment;

    public Item(String title, int playingTime, boolean gotIt, String comment) {
        this.title = title;
        this.playingTime = playingTime;
        this.gotIt = gotIt;
        this.comment = comment;
    }

    public void print(){
        System.out.println("I am Item");
    }
    public static void main(String[] args) {

    }
}
