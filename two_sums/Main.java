package two_sums;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 6, 7, 8};
        int target = 15;
        int left = 0, right = nums.length - 1;
        boolean found = false;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                System.out.println(nums[left] + "+" + nums[right] + " = " + target);
                found = true;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        if (!found) {
            System.out.println("NO");
        }
    }
}