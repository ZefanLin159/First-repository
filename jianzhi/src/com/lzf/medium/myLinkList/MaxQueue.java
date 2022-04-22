package com.lzf.medium.myLinkList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.push_back(1);
        int max1 = maxQueue.max_value();
        int pop = maxQueue.pop_front();
        int max2 = maxQueue.max_value();
        int i = 0;
    }
    Queue<Integer> queue;
    Deque<Integer> deque; //双端队列辅助
    public MaxQueue() {
        this.queue = new LinkedList<>();
        this.deque = new LinkedList<>();
    }
    public int max_value() {
        if (deque.isEmpty()) return -1;
        return deque.peekFirst();
    }
    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);

    }
    public int pop_front() {
        if(queue.isEmpty()) return -1;
        if(queue.peek().equals(deque.peekFirst())){
            deque.pollFirst();
        }
        return queue.poll();
    }
}
