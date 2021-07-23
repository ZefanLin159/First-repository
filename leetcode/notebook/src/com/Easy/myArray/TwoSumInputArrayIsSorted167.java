package com.Easy.myArray;

public class TwoSumInputArrayIsSorted167 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4};
        int target = 6;
        TwoSumInputArrayIsSorted167 twoSumTest = new TwoSumInputArrayIsSorted167();

    }
}
class Solution167{
    //超出时间限制的写法，暴力破解，但不知道为什么那么慢
    public int[] twoSum(int[] numbers, int target) {
        boolean isFindOut = false;
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    index1 = i + 1;
                    index2 = j + 1;
                    //这里的break只是跳出一层循环，要注意
                    if(index1 != index2){
                        isFindOut = true;
                        break;
                    }
                }
            }
            if (isFindOut) {
                break;
            } else {
                isFindOut = false;
            }
        }
        return new int[]{Math.min(index1,index2), Math.max(index2,index1)};
    }

}