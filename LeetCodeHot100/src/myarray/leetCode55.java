package myarray;

public class leetCode55 {

    public static void main(String[] args) {
        leetCode55 lc55 = new leetCode55();
        System.out.println(lc55.canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int rightmost = 0;
        for (int i = 0; i < len; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
            }
            if (rightmost >= len) return true;
        }
        return false;
    }

}
