package com.vendingmachine;

public class VendingMachine {
    //成员变量的生存期是对象的生存期，作用域是类内部的成员函数，
    //JAVA有自动回收机制，不用担心对象的生存期
    private int price = 0;
    private int balance = 0;
    private int total = 0;

    void setPrice(int price) {
        this.price = price;  //将局部（本地）变量赋值给成员变量
    }

    //没有返回值的称为构造函数
    //创建对象的时候给出不同的参数值，就会自动调用不同的构造函数
    //通过this()还可以调用其他构造函数
    //一个类里的同名但参数表不同的函数构成了重载关系
    VendingMachine() {
        total = 0;
    }

    //重载
    VendingMachine(int price) {
        this.price = price;
    }

    public void showPrompt() {
        System.out.println("welcome");
    }

    void insertMoney(int amount) {
        balance = balance + amount;
    }

    void showBalance() {
        System.out.println("balance = " + balance);
    }

    void getFood() {
        if (balance >= price) {
            System.out.println("Here you are");
            balance = balance - price;
            total = total + price;
        }
    }


    public static void main(String args[]) {
        VendingMachine vm = new VendingMachine();
        vm.showPrompt();
        vm.showBalance();
        vm.insertMoney(100);
        vm.getFood();
        vm.showBalance();

    }
}
