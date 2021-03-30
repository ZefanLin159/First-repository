package com.myMathPackage;

public class SqrtX69 {
    public static void main(String[] args) {
        SqrtX69 sqrtX69 = new SqrtX69();
        System.out.println(sqrtX69.mySqrt1(Integer.MAX_VALUE));
        System.out.println(Integer.MAX_VALUE);
    }

    //NewtonSolution
    public int mySqrt(int x) {
        if (x == 0) return 0;
        //初值是任取的，所以我们不要取x，因为在第一次循环的时候时候很容易导致溢出
        //我们可以取保证t^2不溢出且t^2不小于x的值
        int t = Integer.MAX_VALUE / 2;
        //寄存器存储可以减少一次计算
        //考虑数据溢出，这里的小技巧是让x/t减小数据量避免溢出
        //或者可以将t改成long保证数据不会溢出，那么在最后迭代的时候用cast重铸成int型即可
        int temp = (x / t);
        while (t > temp) {
            //牛顿法公式 t(k+1) = t(k)-f[t(k)]/f'[t(k)]
            //f(t*) = t*^2 - x = 0 构造最优解不等式很重要
            t = (t + temp) / 2;
            temp = (x / t);
        }
        return t;
    }

    //二分法技巧
    public int mySqrt1(int x) {
        if (x == 0) return 0;
        long left = 1, right = x;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid == x) {
                return (int) mid;
            }//因为这里是返回int，所以要增加这组判断，很重要
            else if (mid * mid > x && (mid - 1) * (mid - 1) < x) {
                return (int) mid - 1;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
