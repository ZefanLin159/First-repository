package com.Recursion;

public class Hanoi {
    public static void main(String[] args) {
        Hanoi h1 = new Hanoi();
        h1.hanoi(3,'A','B','C');
    }

    /**
     *
     * @param n     汉诺塔个数
     * @param from  开始的柱子
     * @param in    过渡柱子
     * @param to    目标柱子
     */

    public void hanoi(int n,char from,char in,char to){
        //汉诺塔问题的技巧
        //不管有多少个，都理解为只有2个，其他细节都交给电脑去处理，不需要我们人为处理
        //n == 1时，我们只需要将盘子从第一个放到第三个
        if (n == 1) {
            System.out.println("第1个盘子从"+from+"移动到"+to);
        }else {
            //当盘子不止一个时（也看成2个），首先将第一个放到第二个，然后第二个放到第三个（输出），第二个再放到第三个（递归后会输出）
            hanoi(n-1,from,to,in);
            System.out.println("第"+n+"个盘子从"+from+"移动到"+to);
            hanoi(n-1,in,from,to);
        }
    }
}
