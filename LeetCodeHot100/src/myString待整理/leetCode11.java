package myString待整理;

public class leetCode11 {
    public static void main(String[] args) {
        leetCode11 lc11 = new leetCode11();
        System.out.println(lc11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(lc11.maxArea(new int[]{1, 1}));
    }

    //    双指针
    public int maxArea(int[] height) {
        //        int i = 0, j = 1;
        int i = 0, j = height.length - 1;
        int currentWater = 0;
        int maxWater = 0;

        while (i < j) {
            currentWater = (j - i) * Math.min(height[i], height[j]);
            maxWater = Math.max(maxWater, currentWater);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;

    }
}
