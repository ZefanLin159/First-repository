package myarray;

//寻找重复数
public class leetcode287 {
    public static void main(String[] args) {
        int[] nums = {1, 3,2, 4, 5, 2};
        leetcode287 lc287 = new leetcode287();
        System.out.println(lc287.findDuplicate_fastSlow(nums));
    }

    // Slow Fast Pointers
    public int findDuplicate_fastSlow(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

}
