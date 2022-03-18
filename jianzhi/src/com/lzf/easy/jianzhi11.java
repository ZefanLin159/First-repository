package com.lzf.easy;

public class jianzhi11 {
    public int minArray(int[] numbers) {
//        O(N)复杂度
//        int res = numbers[0];
//        for (int i = 1; i < numbers.length; i++) {
//            if (numbers[i] < res) {
//                res = numbers[i];
//            }
//        }
//        return res;
//        二分法
        int index1 = 0;
        int index2 = numbers.length - 1;
        int indexMid = index1;
        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            if (numbers[index1] == numbers[index2] && numbers[indexMid] == numbers[index1]) {
                for (int i = index1 + 1; i < index2; i++) {
                    if (numbers[indexMid] < numbers[i]) {
                        numbers[indexMid] = numbers[i];
                    }
                }
            }
            if (numbers[indexMid] >= numbers[index1]) {
                index1 = indexMid;
            } else if (numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }
        }
        return numbers[indexMid];
    }

}
