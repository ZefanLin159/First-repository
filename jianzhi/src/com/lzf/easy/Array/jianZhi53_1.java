package com.lzf.easy.Array;

public class jianZhi53_1 {

    public static void main(String[] args) {
        jianZhi53_1 jianZhi53_1 = new jianZhi53_1();
//        System.out.println(jianZhi53_2.missingNumber(new int[]{0, 1, 3}));
//        System.out.println(jianZhi53_1.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(jianZhi53_1.search(new int[]{5, 7, 7, 7, 7, 10}, 8));

    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        //初始左右指针位置
        int i = 0;
        int j = nums.length - 1;
        //第一次二分：找right边界
        //这边是“小于等于”，因此当循环结束后，ij不重合，且如果存在target值的话，i的位置就是右边界（target值序列右边第一个大于target值的位置），因为最后一次循环一定是i=mid+1；且此时j指向target
        while (i <= j) {
            int mid = (i + j) >> 1;
            //这里是“小于等于”，目的是为了确定右边界，就是说当mid等于target时，因为不确定后面还有没有target，所以同样需要左边收缩范围
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        //在更新right边界值之前，需要判断这个数组中是否存在target，如果不存在（看j指向的位置是不是target，为什么看的是j指针？i>j）
        if (j >= 0 && nums[j] != target) {
            return 0;
        }
        int right = i;    //更新right边界
        //重置指针
        i = 0;
        j = nums.length - 1;
        //第二次二分：找left边界
        //结束之后，j指向target序列左边第一个小于它的位置，i指向target（经过上面判断，target一定存在）
        while (i <= j) {
            int mid = (i + j) >> 1;
            //这里是“大于等于”，目的是确定左边界，因为就算当mid等于target的时候，因为不确定左边还有没有target，所以同样需要收缩右边界
            if (nums[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        //更新左指针
        int left = j;
        return right - left - 1;


    }
}
