package com.dome;

public class DVD extends Item {

    private String directior;
    //super. 函数是调用父类的函数
    public DVD(String title, int playingTime, boolean gotIt, String comment, String directior) {
        super(title, playingTime, gotIt, comment);
        this.directior = directior;
    }

    public static void main(String[] args) {
        DVD dvd = new DVD("aaa",0,false,"BBB","zg");
        dvd.print();
    }
    public void print(){
        super.print();
        System.out.println("DVD");
    }




}
