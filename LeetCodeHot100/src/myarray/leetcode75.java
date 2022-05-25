package myarray;

//颜色分类，桶排序
public class leetcode75 {

    public void sortColors(int[] nums) {
        int[] record = new int[3];
        for(int i = 0;i<nums.length;i++){
            switch(nums[i]){
                case 0:record[0]++;break;
                case 1:record[1]++;break;
                case 2:record[2]++;break;
            }
        }
        int i =0;
        while(record[0]-->0){
            nums[i] = 0;
            i++;
        }
        while(record[1]-->0){
            nums[i] = 1;
            i++;
        }
        while(record[2]-->0){
            nums[i] = 2;
            i++;
        }
    }
}
