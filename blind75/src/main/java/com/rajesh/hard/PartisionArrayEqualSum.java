package com.rajesh.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PartisionArrayEqualSum {

    public static void main(String[] args) {
        int[] nums = new int[] {4,2,3,1,3,2,5};
        int k=4;

        partionsSum(nums,k);


    }

    private static void partionsSum(int[] nums, int k) {
        int sum = IntStream.of(nums).sum();
        int target = sum/k;
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> groups = new ArrayList<>();
        for(int i=0;i<k;i++){
            groups.add(new ArrayList<>());
        }
        if(backtrack(nums,used,k,0,target,groups)){
            System.out.println(groups.toString());
        }else{
            System.out.println("Not match");
        }

      //  partionsSum(nums,target);
    }

    private static boolean backtrack(int[] nums, boolean[] used, int k, int groupIndex,  int target, List<List<Integer>> groups)
    {
        if(k==groupIndex){
            return true;
        }
        int cursum = groups.get(groupIndex).stream().mapToInt(Integer::intValue).sum();

        if(cursum == target){
            return backtrack(nums,used,k,groupIndex+1,target,groups);
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            if(cursum+nums[i]>target){
                continue;
            }
            used[i] = true;
            groups.get(groupIndex).add(nums[i]);
            if(backtrack(nums,used,k,groupIndex,target,groups)){
                return true;
            }
            groups.get(groupIndex).remove(groups.get(groupIndex).size()-1);
            used[i] = false;
        }

    return false;
    }
}
