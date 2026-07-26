package com.rajesh.hard;

/*
Explanation: The smallest positive integer 1 is missing./*


Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.


Solution:

1 Clean the array  -> number <=0 and num> number.lenth  mark as number+1

2  mark the presence ==>   mark number postion as negitve

3  First postive number is the answer

 */
public class firstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >nums.length || nums[i]<=0) {
                nums[i] = nums.length+1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int number = Math.abs(nums[i]);
            if (number > nums.length) {
                continue;
            }
            if (nums[number-1]>0) {
                nums[number-1] = -nums[number-1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]> 0) {
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static  void main(String[] args){
        firstMissingPositive firstMissingPositive = new firstMissingPositive();
        int i = firstMissingPositive.firstMissingPositive(new int[]{1,2,0});
        System.out.println(i);
    }

}
