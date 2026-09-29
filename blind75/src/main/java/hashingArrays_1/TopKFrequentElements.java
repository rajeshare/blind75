package hashingArrays_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {

       int[] nums = {1,1,1,2,2,3}; int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums,k)));

    }
    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));

        for(Integer key : map.keySet()){
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = minHeap.poll();
        }

        return res;
    }
}
