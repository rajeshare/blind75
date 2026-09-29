package hashingArrays_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        int[] array={2,7,11,15};
        int target=9;

        System.out.println(Arrays.toString(twoSum(array, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){

            int comp=target-nums[i];
            if(map.containsKey(comp)){
                res[1]=i;
                res[0]=map.get(comp);
                return res;
            }

            map.put(nums[i],i);


        }



        return res;
    }
}
