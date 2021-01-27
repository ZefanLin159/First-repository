package com.dome;

public class CD extends Item {

    private int numofTracks;
    private String artist;

    //如果没有super去继承，就默认找父类中的无参构造器；如果有super，就继承父类中构造函数的参数
    public CD(String title, String artist, int numofTracks, int playingTime, String comment) {
        super(title, playingTime, false, comment);
        this.artist = artist;
        this.numofTracks = numofTracks;
    }

    //    public void print() {
//        System.out.println(title + ":" + artist);
//    }
    public static void main(String[] args) {

    }


}
