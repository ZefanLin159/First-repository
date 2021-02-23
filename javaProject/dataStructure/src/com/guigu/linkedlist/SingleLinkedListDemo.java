package com.guigu.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入这些节点数据
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        singleLinkedList.list();

    }
}

class HeroNode {
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    int no;
    String name;
    String nickName;
    HeroNode next;

    //重写toString（建议所有函数都重写）
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                '}';
    }
}

//创建单链表管理我们的英雄
class SingleLinkedList {
    //先定义一个头结点，头节点不要动，不存放数据
    private HeroNode headNode = new HeroNode(0, "", "");

    //显示链表
    public void list() {
        if (headNode.next == null) {
            System.out.println("LinkedList is Empty");
        }else {
            //若非空，则创建一个辅助变量来遍历输出
            HeroNode tempNode = headNode.next;
            while (true) {
                if (tempNode == null) {
                    break;
                }
                System.out.println(tempNode);
                tempNode = tempNode.next;
            }
        }
    }

    //添加节点到单向链表
    //不考虑编号顺序时
    //1，找到当前链表的最后节点；2，将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //创建一个辅助节点,没有初始数据时则为头结点
        HeroNode tempNode = headNode;
        //遍历链表
        while (true) {
            //找到链表的最后
            if (tempNode.next == null) {
                break;
            }
            //如果没有找到最后
            tempNode = tempNode.next;
        }
        //当退出while循环时，则temp指向链表的最后
        tempNode.next = heroNode;
    }
}
