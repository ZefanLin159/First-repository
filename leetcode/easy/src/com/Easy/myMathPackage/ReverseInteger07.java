package com.Easy.myMathPackage;

public class ReverseInteger07 {
    public int reverse(int x) {
        //反转后会出现数据溢出问题，要看清题目提问
        //也就是数据不能超过整形的范围
        //用长整形来保存反转后的长度
        long reverseX = 0;
        if(x!=0) {
            do {
                reverseX = reverseX * 10 + x % 10;//每次将反转数据乘10就可以了
                x /= 10;
            } while (x != 0);
        }
        return reverseX > Integer.MAX_VALUE || reverseX < Integer.MIN_VALUE ? 0 : (int) reverseX;
    }

    public static void main(String[] args) {
        int x = 123;
        int i = reverse2(x);
        System.out.println(i);
    }
    //自己想的比最优解多1ms，因为计算了长度（是否有更好的方法？），不过没注意反转后数据范围的问题，这里一定要注意！要用long去定义翻转后的数据，返回时再增加判断语句。
    public static int reverse2(int x) {
        boolean isNegative = false;
        if(x<0){
            isNegative = true;
            x = -x;
        }
        int i = 0;
        long y = x;
        while(y>0){
            y/=10;
            i++;
        }
        int lowBit = 0;
        while(x>0){
            lowBit = x%10;
            x = x/10;
            y += lowBit*(long)Math.pow(10,i-1);
            i--;
        }
        if(isNegative == true){
            y = -y;
        }
        return y>Integer.MAX_VALUE || y<Integer.MIN_VALUE? 0:(int)y;
    }
}
