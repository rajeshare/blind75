package hashingArrays_1;

import java.util.HashSet;

public class LongestCOnseSubsequene {

    public static void main(String[] args) {
        int[] numbs={100,4,200,1,3,2};

        int res=longestCongSubseq(numbs);

    }
    public static int longestCongSubseq(int[] nums) {

        HashSet<Integer> set1=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set1.add(nums[i]);
        }
       Integer max=1;
        for(int j=0;j<nums.length;j++){
            int x=nums[j];
            int count=0;
            while(set1.contains(x)){
                count++;
                x=x-1;
            }
            max=Math.max(count,max);
        }
        return max;
    }
}
