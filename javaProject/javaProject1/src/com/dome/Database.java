package com.dome;

import java.util.ArrayList;

public class Database {
//    private ArrayList<CD>  listCD = new ArrayList<CD>();
    private ArrayList<Item> listItem = new ArrayList<Item>();
//    public void add(CD cd){
//        listCD.add(cd);
//    }

    public void add(Item item){
        listItem.add(item);
    }
    public void list(){
        for(Item item : listItem){
            item.print();
        }
    }
    public static void main(String[] args) {
        Item item = new Item("aaa",0,false,"zg");
        CD cd =new CD("bbb","bbc",0,1,"zf");
        Database db = new Database();
        db.list();

    }
}
